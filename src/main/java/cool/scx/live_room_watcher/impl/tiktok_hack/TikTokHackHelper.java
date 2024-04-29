package cool.scx.live_room_watcher.impl.tiktok_hack;

import com.google.protobuf.ByteString;
import cool.scx.common.util.URIBuilder;
import cool.scx.common.zip.GunzipBuilder;
import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.PushFrame;
import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.Response;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocket;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import static cool.scx.live_room_watcher.util.Navigator.navigator;

public class TikTokHackHelper {

    /**
     * 标准化 直播间 URI
     *
     * @param uri a {@link java.lang.String} object
     * @return a {@link java.lang.String} object
     */
    public static String initLiveRoomURI(String uri) {
        var liveRoomURI = URIBuilder.of(uri).removeAllParams().build();
        //检查是否为抖音直播间地址
        if (!"www.tiktok.com".equals(liveRoomURI.getHost())) {
            throw new IllegalArgumentException("不是合法 TikTok 直播间 url : " + uri);
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
    public static void sendAck(WebSocket webSocket, PushFrame pushFrame, Response response) {
        var ack = PushFrame.newBuilder()
                .setPayloadType("ack")
                .setLogid(pushFrame.getLogid())
                .setPayload(ByteString.copyFromUtf8(response.getInternalExt()))
                .build().toByteArray();
        webSocket.writeBinaryMessage(Buffer.buffer(ack));
    }

    /**
     * <p>getWebSocketURI.</p>
     *
     * @return a {@link java.net.URI} object
     */
    public static URI getWebSocketURI(String liveRoomID, boolean useGzip) {
        var internalExtMap = new LinkedHashMap<>();
        internalExtMap.put("fetch_time", System.currentTimeMillis());
        internalExtMap.put("start_time", System.currentTimeMillis()+12091);
        internalExtMap.put("ack_ids", ",,7362851733002865425_c0a,7362851741336914695_c0e,7362851741627042578_c0e,7362851731929221906_c10,7362851744441256705_c10,7362851752600095496_c14,7362851751710018320_c14,7362851750296144656_c14,7362851762753096449_c18,7362851767975594769_c1a,7362851782941117191_c20,7362851782731549457_c22,7362851783590726416_c22,7362851784442628871_c22,7362851789353306896_c24,7362851792784345874_c24,7362851786530835201_c26,7362851792713566983_c26,7362851767849601809_c26");
        internalExtMap.put("flag", "1");
        internalExtMap.put("seq", "1");
        internalExtMap.put("next_cursor", "1714359236756_7363116852240471587_1_1_1714359236473_0");
        internalExtMap.put("wss_info", "0-1714297524165-0-0");

        var internalExt = internalExtMap.entrySet().stream().map(c -> c.getKey() + ":" + c.getValue()).collect(Collectors.joining("|"));

        var builder = URIBuilder.of("/webcast/im/ws_proxy/ws_reuse_supplement/")
                .addParam("aid", "1988")
                .addParam("app_language", "zh-Hans")
                .addParam("app_name", "tiktok_web")
                .addParam("browser_language", navigator().language())
                .addParam("browser_name", navigator().appCodeName())
                .addParam("browser_online", navigator().onLine())
                .addParam("browser_platform", navigator().appCodeName())
                .addParam("browser_version", navigator().appVersion())
                .addParam("cookie_enabled", navigator().cookieEnabled())
                .addParam("cursor", "1714298809032_7362857315956243108_1_1_1714298808837_0")
                .addParam("debug", "false")
                .addParam("device_platform", "web")
                .addParam("heartbeatDuration", "0")
                .addParam("host", "https://webcast.tiktok.com")
                .addParam("identity", "audience")
                .addParam("imprp", "")
                .addParam("internal_ext", internalExt)
                .addParam("live_id", "12")
                .addParam("room_id", liveRoomID)
                .addParam("screen_height", 691)
                .addParam("screen_width", 1228)
                .addParam("update_version_code", "1.3.0")
                .addParam("version_code", "270000")
                .addParam("webcast_sdk_version", "1.3.0")
                .addParam("tz_name", "Asia/Shanghai")
                //todo 这里抖音目前只校验是否为空 后期可能会校验具体值 届时需要逆向抖音加密规则
                .addParam("wrss", "00000000");
        if (useGzip) {
            builder.addParam("compress", "gzip");
        }
        return builder.build();
    }

    /**
     * 处理 PushFrame 中的 gzip 压缩
     *
     * @param pushFrame a
     * @return a
     * @throws java.lang.Exception a
     */
    public static Response getResponse(PushFrame pushFrame) throws Exception {
        var gzip = pushFrame.getHeadersListList().stream().anyMatch(pushHeader -> "compress_type".equals(pushHeader.getKey()) && "gzip".equals(pushHeader.getValue()));
        var bytes = gzip ? new GunzipBuilder(pushFrame.getPayload().toByteArray()).toBytes() : pushFrame.getPayload().toByteArray();
        return Response.parseFrom(bytes);
    }
    
}
