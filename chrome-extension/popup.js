// 获取各种 dom 对象
const statusElement = document.querySelector("#status");
const pageUrlElement = document.querySelector("#page-url");

const cookieTitleElement = document.querySelector("#cookie-title");
const cookieOutputElement = document.querySelector("#cookie-output");

const wsTitleElement = document.querySelector("#ws-title");
const wsOutputElement = document.querySelector("#ws-output");

const copyCookieButton = document.querySelector("#copy-cookie");
const copyWebSocketsButton = document.querySelector("#copy-websockets");

let currentCookieHeader = "";
let currentWebSocketAddresses = "";

function getErrorMessage(error) {
    if (error instanceof Error) {
        return error.message;
    }

    return String(error);
}

/**
 * 获取匹配当前 URL 的普通、非分区 Cookie，
 */
async function getCookieHeader(url) {
    return await chrome.cookies.getAll({
        url: url
    });
}

/**
 * 枚举当前主页面 JavaScript 上下文中仍存活的
 * WebSocket 对象。
 *
 * 只保留：
 * OPEN
 */
async function getCurrentWebSockets(tabId) {
    const target = {tabId: tabId};
    const objectGroup = "websocket-scan";

    await chrome.debugger.attach(target, "1.3");

    try {

        // 1. 获取当前主页面执行上下文中的 WebSocket.prototype 远程对象。
        const prototypeResponse = await chrome.debugger.sendCommand(
            target,
            "Runtime.evaluate",
            {
                expression: "WebSocket.prototype",
                objectGroup: objectGroup,
                returnByValue: false,
                silent: true
            }
        );

        if (prototypeResponse.exceptionDetails) {
            throw new Error(
                prototypeResponse.exceptionDetails.exception?.description ||
                prototypeResponse.exceptionDetails.text ||
                "无法获取 WebSocket.prototype"
            );
        }

        const prototypeObjectId = prototypeResponse.result?.objectId;

        if (!prototypeObjectId) {
            throw new Error("没有取得 WebSocket.prototype 的 objectId");
        }

        // 2. 从 V8 堆中查询所有以 WebSocket.prototype 为原型的现存对象。
        const queryResponse = await chrome.debugger.sendCommand(
            target,
            "Runtime.queryObjects",
            {
                prototypeObjectId: prototypeObjectId,
                objectGroup: objectGroup
            }
        );

        const socketsObjectId = queryResponse.objects?.objectId;

        if (!socketsObjectId) {
            return [];
        }

        // 3. 在远程 WebSocket 数组上执行函数， 只返回已经建立、状态为 OPEN 的连接。
        const resultResponse = await chrome.debugger.sendCommand(
            target,
            "Runtime.callFunctionOn",
            {
                objectId: socketsObjectId,
                functionDeclaration: `
                        function () {
                            return Array.from(this)
                                .filter(socket => socket.readyState === 1)
                                .map(socket => ({url : socket.url}));
                        }
                    `,

                returnByValue: true,
                silent: true
            }
        );

        if (resultResponse.exceptionDetails) {
            throw new Error(
                resultResponse.exceptionDetails.exception?.description ||
                resultResponse.exceptionDetails.text ||
                "读取 WebSocket 信息失败"
            );
        }

        const value = resultResponse.result?.value;

        return Array.isArray(value) ? value : [];
    } finally {
        try {
            await chrome.debugger.sendCommand(
                target,
                "Runtime.releaseObjectGroup",
                {
                    objectGroup: objectGroup
                }
            );
        } catch {
            // 忽略释放失败。
        }

        try {
            await chrome.debugger.detach(target);
        } catch {
            // 标签页可能已关闭或调试器已经断开。
        }
    }
}

async function copyText(text, button, originalText) {
    if (!text) {
        return;
    }

    try {
        await navigator.clipboard.writeText(text);

        button.textContent = "已复制";

        setTimeout(() => {
            button.textContent = originalText;
        }, 1000);
    } catch (error) {
        statusElement.className = "error";
        statusElement.textContent = `复制失败：${getErrorMessage(error)}`;
    }
}

async function main() {
    try {
        const [tab] = await chrome.tabs.query({
            active: true,
            currentWindow: true
        });

        if (!tab?.id || !tab.url) {
            throw new Error("无法取得当前标签页");
        }

        const url = new URL(tab.url);

        if (url.protocol !== "http:" && url.protocol !== "https:") {
            throw new Error(`不支持当前页面类型：${url.protocol}`);
        }

        pageUrlElement.textContent = tab.url;

        /*
         * Cookie 和 WebSocket 分开读取。
         * 其中一个失败时，另一个仍然可以显示。
         */
        try {
            const cookies = await getCookieHeader(tab.url);

            currentCookieHeader = cookies.map(cookie => `${cookie.name}=${cookie.value}`).join("; ");

            cookieTitleElement.textContent = `Cookie：${cookies.length} 个`;

            cookieOutputElement.textContent = currentCookieHeader || "当前 URL 没有匹配的 Cookie";
        } catch (error) {
            cookieTitleElement.textContent = "Cookie：读取失败";
            cookieOutputElement.className = "error";
            cookieOutputElement.textContent = getErrorMessage(error);
        }

        try {
            const sockets = await getCurrentWebSockets(tab.id);

            const result = sockets.find(s => s.url.includes("webcast/im/push"));

            if (result == null) {
                throw new Error("没找到符合的 WebSocket");
            }

            currentWebSocketAddresses = result.url;

            wsTitleElement.textContent = `WebSocket：获取成功`;

            wsOutputElement.textContent = result.url;
        } catch (error) {
            wsTitleElement.textContent = "WebSocket：读取失败";
            wsOutputElement.className = "error";
            wsOutputElement.textContent = getErrorMessage(error);
        }

        statusElement.className = "success";
        statusElement.textContent = "读取完成";
    } catch (error) {
        statusElement.className = "error";
        statusElement.textContent = `读取失败：${getErrorMessage(error)}`;

        pageUrlElement.textContent = "读取失败";
        cookieOutputElement.textContent = "读取失败";
        wsOutputElement.textContent = "读取失败";
    }
}

copyCookieButton.addEventListener("click", () => {
    copyText(
        currentCookieHeader,
        copyCookieButton,
        "复制 Cookie"
    );
});

copyWebSocketsButton.addEventListener("click", () => {
    copyText(
        currentWebSocketAddresses,
        copyWebSocketsButton,
        "复制 WebSocket 地址"
    );
});

main();
