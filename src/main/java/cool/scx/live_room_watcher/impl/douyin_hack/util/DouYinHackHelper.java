package cool.scx.live_room_watcher.impl.douyin_hack.util;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import cool.scx.live_room_watcher.impl.douyin_hack.entity.DouYinAPP;
import dev.scx.http.headers.cookie.Cookie;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.HostAccess;
import org.jsoup.Jsoup;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static dev.scx.serialize.ScxSerialize.fromJson;

public final class DouYinHackHelper {

    public static final Engine ENGINE = Engine.newBuilder().option("engine.WarnInterpreterOnly", "false").build();
    public static final HostAccess HOST_ACCESS = HostAccess.newBuilder(HostAccess.EXPLICIT).allowListAccess(true).build();

    /// 从 body 中解析出 DouYinAPP
    public static DouYinAPP parseDouYinAPPByHtml(String htmlStr) {
        var context = Context.newBuilder().allowHostAccess(HOST_ACCESS).engine(ENGINE).build();
        try (context) {
            var parse = Jsoup.parse(htmlStr);
            var scripts = parse.select("script");
            // 重写 window, self 等, 让 removeChild 成为 nop 方法.
            context.eval("js", """
                var window = {};
                var self = window;
                var document = {
                    scripts: [
                        {
                            parentNode: {
                                removeChild(e) {

                                }
                            }
                        }
                    ]
                };
                """);
            // 执行 脚本中的 方法
            for (var script : scripts) {
                var html = script.html();
                if (html.startsWith("self.__pace_f") || html.startsWith("(self.__pace_f")) {
                    context.eval("js", html);
                }
            }
            // 解析 最终的 json
            var value = context.eval("js", """
                var r;

                function m(e) {
                    if (0 === e[0]) {
                        r = [];
                    } else {
                        if (r) {
                            r.push(e[1]);
                        }
                    }
                }

                self.__pace_f.forEach(m);
                let str = r[r.length - 1];
                let index = str.indexOf(":");
                let arr = JSON.parse(str.slice(index + 1));
                JSON.stringify(arr[arr.length - 1])
                """);
            return fromJson(value.asString(), DouYinAPP.class);
        }
    }

    /// 这里用 Playwright 来处理 获取 websocket 的问题 (todo 有点重)
    public static WebSocketOptions getWebSocketOptions(String path) {
        var future = new CompletableFuture<WebSocketOptions>();
        try (var playwright = Playwright.create();
             var browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
             var context = browser.newContext();
             var page = context.newPage()) {
            page.onWebSocket(c -> {

                var webSocketOptions = new WebSocketOptions(c.url(), context.cookies().stream().map(cookie -> Cookie.of(cookie.name, cookie.value)).toArray(Cookie[]::new));
                future.complete(webSocketOptions);

            });
            page.navigate(path);
            page.waitForWebSocket(() -> {
                // 什么也不做
            });
        }
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public record WebSocketOptions(String uri, Cookie... cookie) {

    }

}
