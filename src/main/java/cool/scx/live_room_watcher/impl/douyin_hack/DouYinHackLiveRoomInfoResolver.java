package cool.scx.live_room_watcher.impl.douyin_hack;

import cool.scx.live_room_watcher.impl.douyin_hack.entity.DouYinAPP;
import cool.scx.live_room_watcher.impl.douyin_hack.util.Browser;
import dev.scx.node.ArrayNode;
import dev.scx.node.StringNode;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.HostAccess;
import org.jsoup.Jsoup;

import static dev.scx.http.method.HttpMethod.GET;
import static dev.scx.serialize.ScxSerialize.fromJson;
import static dev.scx.serialize.ScxSerialize.nodeToObject;

public final class DouYinHackLiveRoomInfoResolver {

    private static final Engine ENGINE = Engine.newBuilder().option("engine.WarnInterpreterOnly", "false").build();
    private static final HostAccess HOST_ACCESS = HostAccess.newBuilder(HostAccess.EXPLICIT).allowListAccess(true).build();
    private static final Browser DEFAULT_BROWSER = new Browser(null);

    /// 从 body 中解析出 DouYinAPP
    private static DouYinAPP parseDouYinAPPByHtml(String htmlStr) {
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

    /// 根据直播间 uri 解析 直播间的信息
    public static DouYinHackLiveRoomInfo resolveLiveRoomInfo(String liveRoomURI, Browser browser) {
        // 模拟浏览器发送请求
        var response = browser.request()
            .method(GET)
            .uri(liveRoomURI)
            .send();
        // 获取页面
        var indexHtmlStr = response.asString();
        // 从中解析出 douYinAPP
        var douYinAPP = parseDouYinAPPByHtml(indexHtmlStr);
        // 创建 DouYinHackLiveRoomInfo
        return new DouYinHackLiveRoomInfo(douYinAPP);
    }

    public static DouYinHackLiveRoomInfo resolveLiveRoomInfo(String liveRoomURI) {
        return resolveLiveRoomInfo(liveRoomURI, DEFAULT_BROWSER);
    }

}
