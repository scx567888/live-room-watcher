package cool.scx.live_room_watcher.impl.douyin_hack.util;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import cool.scx.live_room_watcher.impl.douyin_hack.entity.DouYinAPP;
import dev.scx.http.headers.cookie.Cookie;
import org.graalvm.polyglot.Context;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static cool.scx.live_room_watcher.impl.douyin_hack.util.GraalvmJSHelper.ENGINE;
import static cool.scx.live_room_watcher.impl.douyin_hack.util.GraalvmJSHelper.HOST_ACCESS;
import static dev.scx.serialize.ScxSerialize.fromJson;

public final class DouYinHackHelper {

    /**
     * 从 body 中解析出 liveRoomInfo
     *
     * @param htmlStr a
     * @return a
     */
    public static DouYinAPP parseBody(String htmlStr) {
        Context context = Context.newBuilder().allowHostAccess(HOST_ACCESS).engine(ENGINE).build();
        try (context) {
            Document parse = Jsoup.parse(htmlStr);
            Elements scripts = parse.select("script");
            context.eval("js", """
                var window= {};
                var self= window;
                var document={
                        scripts:[{
                            parentNode:{removeChild(e){}}
                        }]};
                """);
            for (Element script : scripts) {
                String html = script.html();
                if (html.startsWith("self.__pace_f") || html.startsWith("(self.__pace_f")) {
                    context.eval("js", html);
                }
            }
            var value = context.eval("js", """
                var r;
                function m(e) {
                   if (0 === e[0])
                       r = [];
                   else {
                       if (r){
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
        } catch (Exception e) {
            throw new IllegalArgumentException("解析直播间错误", e);
        }
    }

    /**
     * 这里用 Playwright 来处理 获取 websocket 的问题 (todo 有点重)
     *
     * @param path d
     * @return d
     */
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
                //什么也不做
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
