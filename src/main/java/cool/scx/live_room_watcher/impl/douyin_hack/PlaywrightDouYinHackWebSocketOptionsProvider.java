package cool.scx.live_room_watcher.impl.douyin_hack;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import cool.scx.live_room_watcher.impl.douyin_hack.util.Browser;
import dev.scx.http.headers.cookie.Cookie;
import dev.scx.http.headers.cookie.Cookies;

public final class PlaywrightDouYinHackWebSocketOptionsProvider implements DouYinHackWebSocketOptionsProvider {

    private final String liveRoomURI;
    private final Cookies customCookies; // 如果 为 null 我们用 Playwright 的 cookie 否则用用户指定的 cookie

    public PlaywrightDouYinHackWebSocketOptionsProvider(String liveRoomURI) {
        this.liveRoomURI = liveRoomURI;
        this.customCookies = null;
    }

    public PlaywrightDouYinHackWebSocketOptionsProvider(String liveRoomURI, String cookiesStr) {
        this.liveRoomURI = liveRoomURI;
        this.customCookies = Cookies.parse(cookiesStr);
    }

    /// 这里用 Playwright 来处理 获取 websocket 的问题 (todo 有点重)
    public static DouYinHackWebSocketOptions getWebSocketOptions(String path) {
        try (
            var playwright = Playwright.create();
            var browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
            var context = browser.newContext();
            var page = context.newPage()
        ) {
            var webSocket = page.waitForWebSocket(() -> page.navigate(path));
            var url = webSocket.url();
            var cookies = Cookies.of();
            for (var cookie : context.cookies()) {
                cookies.add(Cookie.of(cookie.name, cookie.value));
            }
            return new DouYinHackWebSocketOptions(url, cookies);
        }
    }

    @Override
    public DouYinHackWebSocketOptions apply(Browser browser) throws Exception {
        var webSocketOptions = getWebSocketOptions(this.liveRoomURI);
        if (customCookies == null) {
            return webSocketOptions;
        } else {
            return new DouYinHackWebSocketOptions(webSocketOptions.uri(), customCookies);
        }
    }

}
