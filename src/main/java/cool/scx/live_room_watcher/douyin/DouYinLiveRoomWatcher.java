package cool.scx.live_room_watcher.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.live_room_watcher.LiveRoomWatcher;
import cool.scx.live_room_watcher.douyin.entity.DouYinApplication;
import cool.scx.live_room_watcher.douyin.proto_entity.pushproto.PushFrame;
import cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.RoomStats;
import cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.*;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;
import cool.scx.util.http.HttpClientHelper;
import cool.scx.util.http.Options;
import io.netty.handler.codec.http.cookie.ClientCookieDecoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketConnectOptions;

import java.net.URI;
import java.net.URLDecoder;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * <p>DouYinLiveRoomWatcher class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcher extends LiveRoomWatcher {

    /**
     * Constant <code>RENDER_DATA_PATTERN</code>
     */
    private static final Pattern RENDER_DATA_PATTERN = Pattern.compile("<script id=\"RENDER_DATA\" type=\"application/json\">(.*?)</script>");
    private final String liveRoomURI;
    private String ttwid;
    private String liveRoomID;
    private String liveRoomTitle;
    private DouYinApplication douYinApplication;
    private HttpClient httpClient;

    /**
     * <p>Constructor for DouYinLiveRoomWatcher.</p>
     *
     * @param uri a {@link java.lang.String} object
     */
    public DouYinLiveRoomWatcher(String uri) {
        this.liveRoomURI = initLiveRoomURI(uri);
        this.httpClient = initHttpClient();
    }

    /**
     * <p>initHttpClient.</p>
     *
     * @return a {@link io.vertx.core.http.HttpClient} object
     */
    private static HttpClient initHttpClient() {
        var options = new HttpClientOptions();
        //调大一些
        options.setMaxWebSocketFrameSize(65536 * 10);
//                .setTrustOptions(new KeyStoreOptions()
//                        .setPath("keystore.jks")
//                        .setPassword("123456")
//                        .setType("jks")
//                )
//                .setProxyOptions(
//                        new ProxyOptions()
//                                .setHost("127.0.0.1")
//                                .setPort(8888)
////                                .setUsername()
//                );
        return vertx.createHttpClient(options);
    }

    /**
     * <p>getIndexHtml.</p>
     *
     * @param liveRoomURI a {@link java.lang.String} object
     * @return a HttpResponse object
     */
    private static HttpResponse<String> getIndexHtml(String liveRoomURI) {
        //模拟浏览器发送请求
        return HttpClientHelper.get(liveRoomURI, new Options()
                .setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36 Edg/108.0.1462.54")
                .setHeader("cookie", "__ac_nonce=063b51155007d27728929; ")
        );
    }

    /**
     * 从响应的 set-cookie 中读取 ttwid 后面会用到
     *
     * @param headers a
     * @return a
     */
    private static String parseHeaders(HttpHeaders headers) {
        var setCookieList = headers.allValues("set-cookie");
        for (var s : setCookieList) {
            var cookie = ClientCookieDecoder.LAX.decode(s);
            if (cookie != null && "ttwid".equals(cookie.name())) {
                return cookie.value();
            }
        }
        return null;
    }

    /**
     * 从 body 中解析出 liveRoomInfo
     *
     * @param htmlStr a
     * @return a
     * @throws com.fasterxml.jackson.core.JsonProcessingException a
     */
    private static DouYinApplication parseBody(String htmlStr) throws JsonProcessingException {
        var matcher = RENDER_DATA_PATTERN.matcher(htmlStr);
        if (matcher.find()) {
            var urlData = matcher.group(1);
            var jsonData = URLDecoder.decode(urlData, StandardCharsets.UTF_8);
            return ObjectUtils.jsonMapper().readValue(jsonData, DouYinApplication.class);
        }
        throw new RuntimeException("解析 RENDER_DATA 错误");
    }

    /**
     * <p>initLiveRoomURI.</p>
     *
     * @param uri a {@link java.lang.String} object
     * @return a {@link java.lang.String} object
     */
    private static String initLiveRoomURI(String uri) {
        var liveRoomURI = URIBuilder.of(uri).removeAllParams().build();
        //检查是否为抖音直播间地址
        if (!"live.douyin.com".equals(liveRoomURI.getHost())) {
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
    private static void sendAck(WebSocket webSocket, PushFrame pushFrame, Response response) {
        var ack = PushFrame.newBuilder()
                .setPayloadType("ack")
                .setLogid(pushFrame.getLogid())
                .setPayload(ByteString.copyFromUtf8(response.getInternalExt()))
                .build().toByteArray();
        webSocket.writeBinaryMessage(Buffer.buffer(ack));
    }

    /**
     * 发送心跳包
     *
     * @param ws a
     */
    private static void ping(WebSocket ws) {
        new Thread(() -> {
            while (true) {
                var ping = PushFrame.newBuilder()
                        .setPayloadType("hb")
                        .build().toByteArray();
                ws.writeBinaryMessage(Buffer.buffer(ping));
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    /**
     * 根据直播间 uri 解析 直播间的信息
     *
     * @throws com.fasterxml.jackson.core.JsonProcessingException if any.
     */
    private void parseByLiveRoomURI() throws JsonProcessingException {
        var indexHtml = getIndexHtml(this.liveRoomURI);
        this.ttwid = parseHeaders(indexHtml.headers());
        this.douYinApplication = parseBody(indexHtml.body());
        this.liveRoomID = this.douYinApplication.app.initialState.roomStore.roomInfo.roomId;
        this.liveRoomTitle = this.douYinApplication.app.initialState.roomStore.roomInfo.room.title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startWatch() {
        try {
            parseByLiveRoomURI();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("解析 直播间错误 !!!", e);
        }

        var webSocketFuture = httpClient.webSocket(getWebSocketOptions());
        webSocketFuture.onSuccess(c -> {
            ping(c);
            c.binaryMessageHandler(b -> {
                try {
                    var pushFrame = PushFrame.parseFrom(b.getBytes());
                    var response = Response.parseFrom(pushFrame.getPayload().toByteArray());
                    var needAck = response.getNeedAck();
                    if (needAck) {
                        sendAck(c, pushFrame, response);
                    }
                    switch (pushFrame.getPayloadType()) {
                        case "msg" -> {
                            for (var message : response.getMessagesListList()) {
                                callHandler(message);
                            }
                        }
                        case "close" -> System.out.println("关闭");
                    }
                } catch (InvalidProtocolBufferException | JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
            c.textMessageHandler(System.out::println);
            c.exceptionHandler(Throwable::printStackTrace);
        }).onFailure(Throwable::printStackTrace);
    }

    /**
     * <p>getWebSocketOptions.</p>
     *
     * @return a {@link io.vertx.core.http.WebSocketConnectOptions} object
     */
    public WebSocketConnectOptions getWebSocketOptions() {
        return new WebSocketConnectOptions()
                .setURI(getWebSocketURI().toString())
                .setSsl(true)
                .setHost("webcast3-ws-web-lf.douyin.com")
                .setPort(443)
                .addHeader("Cookie", "ttwid=" + ttwid);
    }

    /**
     * <p>getWebSocketURI.</p>
     *
     * @return a {@link java.net.URI} object
     */
    public URI getWebSocketURI() {

        var internalExt = "internal_src:dim|wss_push_room_id:" + liveRoomID + "|wss_push_did:7184667748424615439|dim_log_id:202301041518458B50FA14C1692B20E226|fetch_time:1672816725842|seq:1|wss_info:0-1672816725842-0-0|wrds_kvs:WebcastRoomRankMessage-1672793739221591107_WebcastRoomStatsMessage-1672816721958290810";

        return URIBuilder.of("/webcast/im/push/v2/")
                .addParam("app_name", "douyin_web")
                .addParam("version_code", "180800")
                .addParam("webcast_sdk_version", "1.3.0")
                .addParam("update_version_code", "1.3.0")
                // .addParam("compress","gzip") // 注释掉方便解析
                .addParam("internal_ext", internalExt)
                .addParam("cursor", "u-1_h-1_t-1672732684536_r-1_d-1")
                .addParam("host", "https://live.douyin.com")
                .addParam("aid", "6383")
                .addParam("live_id", "1")
                .addParam("did_rule", "3")
                .addParam("debug", "false")
                .addParam("endpoint", "live_pc")
                .addParam("support_wrds", "1")
                .addParam("im_path", "/webcast/im/fetch/")
                .addParam("device_platform", "web")
                .addParam("cookie_enabled", "true")
                .addParam("screen_width", "1228")
                .addParam("screen_height", "691")
                .addParam("browser_language", "zh-CN")
                .addParam("browser_platform", "Win32")
                .addParam("browser_name", "Mozilla")
                .addParam("browser_version", "5.0 (Windows NT 10.0 Win64 x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36 Edg/108.0.1462.54")
                .addParam("browser_online", "true")
                .addParam("tz_name", "Asia/Shanghai")
                .addParam("identity", "audience")
                .addParam("room_id", liveRoomID)
                .addParam("heartbeatDuration", "0")
                .build();
    }

    /**
     * <p>callHandler.</p>
     *
     * @param message a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Message} object
     * @throws com.fasterxml.jackson.core.JsonProcessingException if any.
     * @throws com.google.protobuf.InvalidProtocolBufferException if any.
     */
    private void callHandler(Message message) throws JsonProcessingException, InvalidProtocolBufferException {
        var payload = message.getPayload().toByteArray();
        var method = message.getMethod();
        switch (method) {
            case "WebcastMemberMessage" -> {// 来了
                var memberMessage = MemberMessage.parseFrom(payload);
                var douYinUser = new DouYinUser(memberMessage);
                this.onUserHandler.handle(douYinUser);
            }
            case "WebcastChatMessage" -> {// 消息
                var chatMessage = ChatMessage.parseFrom(payload);
                var douYinChat = new DouYinChat(chatMessage);
                this.onChatHandler.handle(douYinChat);
            }
            case "WebcastLikeMessage" -> {//点赞
                var likeMessage = LikeMessage.parseFrom(payload);
                var douYinLike = new DouYinLike(likeMessage);
                this.onLikeHandler.handle(douYinLike);
            }
            case "WebcastSocialMessage" -> {//关注
                var socialMessage = SocialMessage.parseFrom(payload);
                var douYinFollow = new DouYinFollow(socialMessage);
                this.onFollowHandler.handle(douYinFollow);
            }
            case "WebcastGiftMessage" -> {//礼物
                var giftMessage = GiftMessage.parseFrom(payload);
                var douYinGift = new DouYinGift(giftMessage);
                this.onGiftHandler.handle(douYinGift);
            }
            case "WebcastRoomUserSeqMessage" -> {//直播间统计
                var roomUserSeqMessage = RoomUserSeqMessage.parseFrom(payload);
            }
            case "WebcastCommonTextMessage" -> {
                var commonTextMessage = CommonTextMessage.parseFrom(payload);
            }
            case "WebcastControlMessage" -> {//直播间状态变更
                var controlMessage = ControlMessage.parseFrom(payload);
            }
            case "WebcastFansclubMessage" -> {
                var fansclubMessage = FansclubMessage.parseFrom(payload);
            }
            case "WebcastInRoomBannerMessage" -> {
                System.out.println("WebcastInRoomBannerMessage");
            }
            case "WebcastRoomRankMessage" -> {
                System.out.println("WebcastRoomRankMessage");
            }
            case "WebcastUpdateFanTicketMessage" -> {
                System.out.println("WebcastUpdateFanTicketMessage");
            }
            case "WebcastRoomStatsMessage" -> {
                var roomStats = RoomStats.parseFrom(payload);
            }
            case "WebcastCommerceMessage" -> {
                System.out.println("WebcastCommerceMessage");
            }
            default -> {
                System.out.println("DouYin -> 未处理 Message :" + message);
            }
        }

    }

}
