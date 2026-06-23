package cool.scx.live_room_watcher.impl.douyin_hack.util;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import cool.scx.live_room_watcher.impl.douyin_hack.entity.DouYinAPP;
import dev.scx.http.headers.cookie.Cookie;
import dev.scx.node.ArrayNode;
import dev.scx.node.StringNode;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.HostAccess;
import org.jsoup.Jsoup;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static dev.scx.serialize.ScxSerialize.fromJson;
import static dev.scx.serialize.ScxSerialize.nodeToObject;

public final class DouYinHackHelper {

    public static final Engine ENGINE = Engine.newBuilder().option("engine.WarnInterpreterOnly", "false").build();
    public static final HostAccess HOST_ACCESS = HostAccess.newBuilder(HostAccess.EXPLICIT).allowListAccess(true).build();

    /// 从 body 中解析出 DouYinAPP
    public static DouYinAPP parseDouYinAPPByHtml(String htmlStr) {
        System.out.println();
        var context = Context.newBuilder().allowHostAccess(HOST_ACCESS).engine(ENGINE).build();
        try (context) {
            var parse = Jsoup.parse(htmlStr);
            var scripts = parse.select("script");
            // 重写 self.
            context.eval("js", """
                var self = { __pace_f : []};
                """);
            // 执行 脚本中的 方法, 我们主要是为了获得 self.__pace_f
            for (var script : scripts) {
                var html = script.html();
                if (html.startsWith("self.__pace_f")) {
                    context.eval("js", html);
                }
            }
            // 获取 self.__pace_f
            var value = context.eval("js", """
                JSON.stringify(self.__pace_f)
                """);
            var self__pace_f = (ArrayNode) fromJson(value.asString());
            // 取最后一组
            var node1 = (ArrayNode) self__pace_f.get(self__pace_f.size() - 1);
            // 取 第二个值
            var node2 = (StringNode) node1.get(1);
            var str1 = node2.value();
            // 移除前面的 "c:"
            var str2 = node2.value().substring(str1.indexOf(":") + 1);
            // 这里其实也是数组 我们取最后一个值
            var node3 = (ArrayNode) fromJson(str2);
            // 这才是最终的值
            var node4 = node3.get(node3.size() - 1);
            // 转换成结构化对象
            return nodeToObject(node4, DouYinAPP.class);
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
