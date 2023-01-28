package cool.scx.live_room_watcher.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.douyin.entity.DouYinApplication;
import cool.scx.live_room_watcher.douyin.enumeration.ControlMessageAction;
import cool.scx.live_room_watcher.douyin.enumeration.MemberMessageAction;
import cool.scx.live_room_watcher.douyin.proto_entity.pushproto.PushFrame;
import cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.*;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;
import cool.scx.util.zip.GunzipBuilder;
import io.netty.handler.codec.http.cookie.ClientCookieDecoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketConnectOptions;

import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static cool.scx.enumeration.HttpMethod.GET;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * <p>DouYinLiveRoomWatcher class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcher extends AbstractLiveRoomWatcher {

    /**
     * 用来解析 RENDER_DATA
     */
    private static final Pattern RENDER_DATA_PATTERN = Pattern.compile("<script id=\"RENDER_DATA\" type=\"application/json\">(.*?)</script>");
    private final String liveRoomURI;
    private String ttwid;
    private String liveRoomID;
    private DouYinApplication douYinApplication;
    private final HttpClient httpClient;
    private WebSocket webSocket;
    private boolean useGzip;

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
//                );
        return vertx.createHttpClient(options);
    }

    /**
     * <p>getIndexHtml.</p>
     *
     * @param liveRoomURI a {@link java.lang.String} object
     * @return a HttpResponse object
     * @throws java.io.IOException            if any.
     * @throws java.lang.InterruptedException if any.
     */
    private static ScxHttpClientResponse getIndexHtml(String liveRoomURI) throws IOException, InterruptedException {
        //模拟浏览器发送请求
        return ScxHttpClientHelper.request(new ScxHttpClientRequest()
                .method(GET)
                .uri(URI.create(liveRoomURI))
                .setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36 Edg/108.0.1462.54")
                .setHeader("cookie", "__ac_nonce=063b51155007d27728929; "));
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
     * 标准化 直播间 URI
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
     * @throws java.io.IOException            if any.
     * @throws java.lang.InterruptedException if any.
     */
    private void parseByLiveRoomURI() throws IOException, InterruptedException {
        var indexHtml = getIndexHtml(this.liveRoomURI);
        this.ttwid = parseHeaders(indexHtml.headers());
        this.douYinApplication = parseBody(indexHtml.body().toString());
        this.liveRoomID = this.douYinApplication.app.initialState.roomStore.roomInfo.roomId;
    }

    /**
     * 处理 PushFrame 中的 gzip 压缩
     *
     * @param pushFrame a
     * @return a
     * @throws java.lang.Exception a
     */
    private static Response getResponse(PushFrame pushFrame) throws Exception {
        var gzip = pushFrame.getHeadersListList().stream().anyMatch(pushHeader -> "compress_type".equals(pushHeader.getKey()) && "gzip".equals(pushHeader.getValue()));
        var bytes = gzip ? new GunzipBuilder(pushFrame.getPayload().toByteArray()).toBytes() : pushFrame.getPayload().toByteArray();
        return Response.parseFrom(bytes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startWatch() {
        try {
            System.out.println("解析中...");
            parseByLiveRoomURI();
            System.out.println("解析完成 -> " + liveRoomTitle() + " (ID : " + liveRoomID + ")");
        } catch (Exception e) {
            throw new RuntimeException("解析 直播间错误 !!!", e);
        }
        //尝试关闭上一次的 webSocket 连接
        if (webSocket != null) {
            webSocket.close();
            webSocket = null;
        }
        System.out.println("连接中...");
        var webSocketFuture = httpClient.webSocket(getWebSocketOptions());
        webSocketFuture.onSuccess(c -> {
            webSocket = c;
            ping(c);
            c.binaryMessageHandler(b -> {
                try {
                    var pushFrame = PushFrame.parseFrom(b.getBytes());
                    var response = getResponse(pushFrame);
                    var needAck = response.getNeedAck();
                    if (needAck) {
                        sendAck(c, pushFrame, response);
                    }
                    switch (pushFrame.getPayloadType()) {
                        case "msg" -> {
                            for (var message : response.getMessagesListList()) {
                                vertx.nettyEventLoopGroup().execute(() -> {
                                    try {
                                        //防止线程阻塞
                                        callHandler(message);
                                    } catch (JsonProcessingException | InvalidProtocolBufferException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                            }
                        }
                        case "close" -> System.out.println("关闭");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            c.textMessageHandler(System.out::println);
            c.exceptionHandler(e -> {
                e.printStackTrace();
                startWatch();
            });
            System.out.println("连接成功 !!!");
        }).onFailure(e -> {
            //todo 这里有时会 200 待研究
            e.printStackTrace();
            startWatch();
        });
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
                .addHeader("Cookie", "ttwid=" + ttwid)
                .addHeader("User-Agent", navigator().userAgent());
    }

    /**
     * <p>getWebSocketURI.</p>
     *
     * @return a {@link java.net.URI} object
     */
    public URI getWebSocketURI() {
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

        var builder = URIBuilder.of("/webcast/im/push/v2/")
                .addParam("app_name", "douyin_web")
                .addParam("version_code", "180800")
                .addParam("webcast_sdk_version", "1.3.0")
                .addParam("update_version_code", "1.3.0")
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
                .addParam("cookie_enabled", navigator().cookieEnabled())
                .addParam("screen_width", 1228)
                .addParam("screen_height", 691)
                .addParam("browser_language", navigator().language())
                .addParam("browser_platform", navigator().appCodeName())
                .addParam("browser_name", navigator().appCodeName())
                .addParam("browser_version", navigator().appVersion())
                .addParam("browser_online", navigator().onLine())
                .addParam("tz_name", "Asia/Shanghai")
                .addParam("identity", "audience")
                .addParam("room_id", liveRoomID)
                .addParam("heartbeatDuration", "0");
        if (useGzip) {
            builder.addParam("compress", "gzip");
        }
        return builder.build();
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
            case "RoomMessage", "WebcastRoomMessage" -> {
                var roomMessage = RoomMessage.parseFrom(payload);
            }
            case "WebcastChatMessage" -> {// 消息
                var chatMessage = ChatMessage.parseFrom(payload);
                var douYinChat = new DouYinChat(chatMessage);
                this.chatHandler().accept(douYinChat);
            }
            case "WebcastMemberMessage" -> {// 来了
                var memberMessage = MemberMessage.parseFrom(payload);
                long actionCode = memberMessage.getAction();
                var action = MemberMessageAction.of(actionCode);
                switch (action) {
                    case SET_SILENCE, MANAGER_SET_SILENCE -> {
                        System.out.println("SET_SILENCE");
                    }
                    case CANCEL_SILENCE, MANAGER_CANCEL_SILENCE -> {
                        System.out.println("CANCEL_SILENCE");
                    }
                    case BLOCK -> {
                        System.out.println("BLOCK");
                    }
                    case KICK_OUT -> {
                        System.out.println("KICK_OUT");
                    }
                    case ENTER -> {
//                        System.out.println("ENTER");
                    }
                    case LEAVE -> {
                        System.out.println("LEAVE");
                    }
                    case SET_ADMIN -> {
                    }
                    case CANCEL_ADMIN -> {
                    }
                    case SHARE -> {
                    }
                    case FOLLOW -> {
                    }
                }
                var douYinUser = new DouYinUser(memberMessage);
                this.userHandler().accept(douYinUser);
            }
            case "WebcastLikeMessage" -> {//点赞
                var likeMessage = LikeMessage.parseFrom(payload);
                var douYinLike = new DouYinLike(likeMessage);
                this.likeHandler().accept(douYinLike);
            }
            case "WebcastSocialMessage" -> {//关注
                var socialMessage = SocialMessage.parseFrom(payload);
                var douYinFollow = new DouYinFollow(socialMessage);
                this.followHandler().accept(douYinFollow);
            }
            case "WebcastGiftMessage" -> {//礼物
                var giftMessage = GiftMessage.parseFrom(payload);
                long groupCount = giftMessage.getGroupCount();
                long groupId = giftMessage.getGroupId();
                long repeatCount = giftMessage.getRepeatCount();
                long repeatEnd = giftMessage.getRepeatEnd();
                long totalCount = giftMessage.getTotalCount();
                //todo 哪个是真正的总数 ???
                //todo 人气 Top 是拿不到 name 的
                String name = giftMessage.getGift().getName();
                var douYinGift = new DouYinGift(giftMessage);
                this.giftHandler().accept(douYinGift);
            }
            //************** 以下的暂时用不到 ****************
            case "WebcastRoomUserSeqMessage" -> {//直播间统计
                var roomUserSeqMessage = RoomUserSeqMessage.parseFrom(payload);
            }
            case "WebcastCommonTextMessage" -> {
                var commonTextMessage = CommonTextMessage.parseFrom(payload);
            }
            case "WebcastControlMessage" -> {//直播间状态变更 比如直播关闭
                var controlMessage = ControlMessage.parseFrom(payload);
                var actionCode = controlMessage.getAction();
                var action = ControlMessageAction.of(actionCode);
                switch (action) {
                    case FINISH, FINISH_BY_ADMIN, ROOM_FINISH_BY_SWITCH -> {
                        System.out.println("直播已结束 !!!");
                    }
                    case RESUME -> {
                        System.out.println("RESUME");
                    }
                    case PAUSE -> {
                        System.out.println("暂停");
                    }
                }
            }
            case "WebcastFansclubMessage" -> { //粉丝俱乐部 ???
                var fansclubMessage = FansclubMessage.parseFrom(payload);
            }
            case "WebcastInRoomBannerMessage" -> {//进房间后的 Banner
                var inRoomBannerMessage = InRoomBannerMessage.parseFrom(payload);
            }
            case "WebcastRoomRankMessage" -> {//房间排行榜
                var roomRankMessage = RoomRankMessage.parseFrom(payload);
                var sb = new StringBuilder("房间排行榜更新 : \n");
                var index = 1;
                for (var roomRank : roomRankMessage.getRanksListList()) {
                    sb.append(index).append(" : ").append(roomRank.getUser().getNickname()).append("\n");
                    index += 1;
                }
                System.out.print(sb);
            }
            case "WebcastUpdateFanTicketMessage" -> {//粉丝票计数 ??? 不玩抖音不太懂
                var updateFanTicketMessage = UpdateFanTicketMessage.parseFrom(payload);
            }
            case "WebcastRoomStatsMessage" -> {//房间状态
                var roomStats = RoomStatsMessage.parseFrom(payload);
                System.out.println("房间状态更新 : " + roomStats.getDisplayLong() + " (" + roomStats.getDisplayValue() + ")");
            }
            case "WebcastCommerceMessage" -> {
                //todo WebcastCommerceMessage
            }
            case "WebcastAudienceEntranceMessage" -> {//观众入场信息
                //todo WebcastAudienceEntranceMessage
            }
            case "WebcastStampMessage" -> {
                //todo WebcastStampMessage
            }
            case "WebcastSyncStreamMessage" -> {
                var syncStreamMessage = SyncStreamMessage.parseFrom(payload);
            }
            case "WebcastAudioChatMessage" -> {//音频弹幕 ??? 不玩抖音不太懂
                var audioChatMessage = AudioChatMessage.parseFrom(payload);
            }
            case "WebcastLinkMicArmiesMethod" -> {//连麦 ??
                //todo WebcastLinkMicArmiesMethod
            }
            case "WebcastProfitInteractionScoreMessage" -> {
                //todo WebcastProfitInteractionScoreMessage
            }
            case "WebcastLinkMicMethod" -> {
                //todo WebcastLinkMicMethod
            }
            case "LinkMicMethod" -> {
                //todo LinkMicMethod
            }
            case "WebcastLinkMessage" -> {//连麦 ???
                var linkMessage = LinkMessage.parseFrom(payload);
            }
            case "WebcastRoomDataSyncMessage" -> {
                //todo WebcastRoomDataSyncMessage
            }
            case "WebcastEmojiChatMessage" -> {//emoji 类型的消息 ???
                var emojiChatMessage = EmojiChatMessage.parseFrom(payload);
            }
            case "WebcastLinkerContributeMessage" -> {
                //todo  WebcastLinkerContributeMessage
            }
            case "WebcastGameCPUserDownloadMessage" -> {//不知道是啥
                var gameCPUserDownloadMessage = GameCPUserDownloadMessage.parseFrom(payload);
            }
            case "WebcastHotRoomMessage" -> {//热门直播间 ???
                var hotRoomMessage = HotRoomMessage.parseFrom(payload);
            }
            case "WebcastScreenChatMessage" -> {//为什么这么多种消息类型 🥺
                var screenChatMessage = ScreenChatMessage.parseFrom(payload);
                System.out.println("全屏消息? : " + screenChatMessage.getUser().getNickname() + " : " + screenChatMessage.getContent());
            }
            case "WebcastHotChatMessage" -> {
                var hotChatMessage = HotChatMessage.parseFrom(payload);
                System.out.println("热门消息 : " + hotChatMessage.getTitle() + " : " + hotChatMessage.getContent());
            }
            case "WebcastLuckyBoxMessage" -> {//幸运盒 ???
                //todo  WebcastLuckyBoxMessage
            }
            default -> {
                System.err.println("DouYin -> 未处理 Message :" + message);
            }
        }

    }

    /**
     * 连接 抖音 弹幕服务时是否传递 gip 压缩参数
     *
     * @param useGzip a boolean
     * @return a {@link cool.scx.live_room_watcher.douyin.DouYinLiveRoomWatcher} object
     */
    public DouYinLiveRoomWatcher useGzip(boolean useGzip) {
        this.useGzip = useGzip;
        return this;
    }

    //identity : "audience"
    //
    //last_rtt : "0"
    //
    //room_id : "7193510167019359033"
    //
    //
    //
    public static void fetchImServer(String[] args) {
        String a = "https://live.douyin.com/webcast/im/fetch/";
    }

    @Override
    public String liveRoomTitle() {
        return this.douYinApplication.app.initialState.roomStore.roomInfo.room.title;
    }

    @Override
    public List<String> liveRoomWebStreamURLs() {
        var webStreamUrl = this.douYinApplication.app.initialState.roomStore.roomInfo.web_stream_url;
        if (webStreamUrl == null) {
            return List.of();
        }
        var list = new ArrayList<String>();
        list.add(webStreamUrl.hls_pull_url_map.FULL_HD1);
        list.add(webStreamUrl.hls_pull_url_map.SD1);
        list.add(webStreamUrl.hls_pull_url_map.SD2);
        list.add(webStreamUrl.flv_pull_url.FULL_HD1);
        list.add(webStreamUrl.flv_pull_url.SD1);
        list.add(webStreamUrl.flv_pull_url.SD2);
        return list;
    }

}
