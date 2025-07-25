package cool.scx.live_room_watcher.impl.douyin_hack;

import com.google.protobuf.ByteString;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import cool.scx.common.util.ObjectUtils;
import cool.scx.io.zip.GunzipBuilder;
import cool.scx.object.ScxObject;
import cool.scx.websocket.ScxWebSocket;
import cool.scx.http.headers.cookie.Cookie;
import cool.scx.http.uri.ScxURI;
import cool.scx.live_room_watcher.impl.douyin_hack.entity.DouYinAPP;
import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PushFrame;
import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.Response;
import org.graalvm.polyglot.Context;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static cool.scx.live_room_watcher.util.GraalvmJSHelper.ENGINE;
import static cool.scx.live_room_watcher.util.GraalvmJSHelper.HOST_ACCESS;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

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
            return ScxObject.fromJson(value.asString(), DouYinAPP.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("解析直播间错误", e);
        }
    }

    /**
     * 标准化 直播间 URI
     *
     * @param uri a {@link java.lang.String} object
     * @return a {@link java.lang.String} object
     */
    public static String initLiveRoomURI(String uri) {
        var liveRoomURI = ScxURI.of(uri).query("");
        //检查是否为抖音直播间地址
        if (!"live.douyin.com".equals(liveRoomURI.host())) {
            throw new IllegalArgumentException("不是合法抖音直播间 url : " + uri);
        }
        //清理掉所有的多余路径
        return liveRoomURI.toString();
    }


    /**
     * 发送 ack
     *
     * @param webSocket a
     * @param pushFrame a
     * @param response  a
     */
    public static void sendAck(ScxWebSocket webSocket, PushFrame pushFrame, Response response) {
        var ack = PushFrame.newBuilder()
                .setPayloadType("ack")
                .setLogID(pushFrame.getLogID())
                .setPayload(ByteString.copyFromUtf8(response.getInternalExt()))
                .build().toByteArray();
        webSocket.send(ack);
    }

    /**
     * <p>getWebSocketURI.</p>
     *
     * @return a {@link java.net.URI} object
     */
    @Deprecated
    public static ScxURI getWebSocketURI(String liveRoomID, boolean useGzip) {
        var internalExtMap = new LinkedHashMap<>();
        internalExtMap.put("internal_src", "dim");
        internalExtMap.put("wss_push_room_id", liveRoomID);
        internalExtMap.put("wss_push_did", "7184667748424615439");
        internalExtMap.put("dim_log_id", "2023011316221327ACACF0E44A2C0E8200");
        internalExtMap.put("fetch_time", "1673598133900");
        internalExtMap.put("seq", "1");
        internalExtMap.put("wss_info", "0-1673598133900-0-0");
        internalExtMap.put("wrds_kvs", "WebcastRoomRankMessage-1673597852921055645_WebcastRoomStatsMessage-1673598128993068211");

        var internalExt = internalExtMap.entrySet().stream().map(c -> c.getKey() + ":" + c.getValue()).collect(Collectors.joining("|"));

        var builder = ScxURI.of("/webcast/im/push/v2/")
                .addQuery("app_name", "douyin_web")
                .addQuery("version_code", "180800")
                .addQuery("webcast_sdk_version", "1.3.0")
                .addQuery("update_version_code", "1.3.0")
                .addQuery("internal_ext", internalExt)
                .addQuery("cursor", "u-1_h-1_t-1672732684536_r-1_d-1")
                .addQuery("host", "https://live.douyin.com")
                .addQuery("aid", "6383")
                .addQuery("live_id", "1")
                .addQuery("did_rule", "3")
                .addQuery("debug", "false")
                .addQuery("endpoint", "live_pc")
                .addQuery("support_wrds", "1")
                .addQuery("im_path", "/webcast/im/fetch/")
                .addQuery("device_platform", "web")
                .addQuery("cookie_enabled", navigator().cookieEnabled())
                .addQuery("screen_width", 1228)
                .addQuery("screen_height", 691)
                .addQuery("browser_language", navigator().language())
                .addQuery("browser_platform", navigator().appCodeName())
                .addQuery("browser_name", navigator().appCodeName())
                .addQuery("browser_version", navigator().appVersion())
                .addQuery("browser_online", navigator().onLine())
                .addQuery("tz_name", "Asia/Shanghai")
                .addQuery("identity", "audience")
                .addQuery("room_id", liveRoomID)
                .addQuery("heartbeatDuration", "0")
                //todo 这里抖音目前只校验是否为空 后期可能会校验具体值 届时需要逆向抖音加密规则
                .addQuery("signature", "00000000");
        if (useGzip) {
            builder.addQuery("compress", "gzip");
        }
        return builder;
    }


    /**
     * 处理 PushFrame 中的 gzip 压缩
     *
     * @param pushFrame a
     * @return a
     * @throws java.lang.Exception a
     */
    public static Response getResponse(PushFrame pushFrame) throws Exception {
        var gzip = pushFrame.getHeadersList().stream().anyMatch(pushHeader -> "compress_type".equals(pushHeader.getKey()) && "gzip".equals(pushHeader.getValue()));
        var bytes = gzip ? new GunzipBuilder(new ByteArrayInputStream(pushFrame.getPayload().toByteArray())).readAllBytes() : pushFrame.getPayload().toByteArray();
        return Response.parseFrom(bytes);
    }

    /**
     * 这里用 Playwright 来处理 获取 websocket 的问题 (todo 有点重)
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

    public record WebSocketOptions(String uri,Cookie... cookie) {
        
    }
    
}
