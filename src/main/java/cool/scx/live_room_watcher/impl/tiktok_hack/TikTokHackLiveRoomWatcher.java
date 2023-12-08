package cool.scx.live_room_watcher.impl.tiktok_hack;

import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.functional.ScxConsumer;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import cool.scx.live_room_watcher.BaseLiveRoomWatcher;
import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.pushproto.PushFrame;
import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.*;
import cool.scx.live_room_watcher.impl.tiktok_hack.enumeration.ControlMessageAction;
import cool.scx.live_room_watcher.impl.tiktok_hack.enumeration.MemberMessageAction;
import cool.scx.live_room_watcher.impl.tiktok_hack.message.*;
import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.pushproto.TPushFrame;
import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.TMessage;
import cool.scx.live_room_watcher.util.Browser;
import cool.scx.util.$;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketConnectOptions;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cool.scx.enumeration.HttpMethod.GET;
import static cool.scx.live_room_watcher.impl.tiktok_hack.TikTokHackHelper.*;
import static cool.scx.live_room_watcher.impl.tiktok_hack.TikTokHackHelper.initLiveRoomURI;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * 利用模拟网页 websocket 的方式获取直播间信息
 *
 * @author scx567888
 * @version 0.0.1
 */
public class TikTokHackLiveRoomWatcher extends BaseLiveRoomWatcher implements LiveRoomInfo {

    private final String liveRoomURI;
    private final Browser browser;
    private final Map<String, ScxConsumer<byte[], ?>> handlerMap;
    private WebSocket webSocket;
    private boolean useGzip;
    private Thread ping;
    private TikTokHackLiveRoomInfo liveRoomInfo;

    /**
     * <p>Constructor for DouYinLiveRoomWatcher.</p>
     *
     * @param uri a {@link java.lang.String} object
     */
    public TikTokHackLiveRoomWatcher(String uri) {
        this.liveRoomURI = initLiveRoomURI(uri);
        this.browser = new Browser(vertx).addCookie(new DefaultCookie("__ac_nonce", "063b51155007d27728929"));
        this.handlerMap = initHandlerMap();
    }

    public Map<String, ScxConsumer<byte[], ?>> initHandlerMap() {
        var map = new HashMap<String, ScxConsumer<byte[], ?>>();
        map.put("WebcastSocialMessage", this::WebcastSocialMessage);
        map.put("RoomMessage", this::RoomMessageOrWebcastRoomMessage);
        map.put("WebcastRoomMessage", this::RoomMessageOrWebcastRoomMessage);
        map.put("WebcastChatMessage", this::WebcastChatMessage);
        map.put("WebcastMemberMessage", this::WebcastMemberMessage);
        map.put("WebcastLikeMessage", this::WebcastLikeMessage);
        map.put("WebcastGiftMessage", this::WebcastGiftMessage);
        map.put("WebcastRoomUserSeqMessage", this::WebcastRoomUserSeqMessage);
        map.put("WebcastCommonTextMessage", this::WebcastCommonTextMessage);
        map.put("WebcastControlMessage", this::WebcastControlMessage);
        map.put("WebcastFansclubMessage", this::WebcastFansclubMessage);
        map.put("WebcastInRoomBannerMessage", this::WebcastInRoomBannerMessage);
        map.put("WebcastRoomRankMessage", this::WebcastRoomRankMessage);
        map.put("WebcastUpdateFanTicketMessage", this::WebcastUpdateFanTicketMessage);
        map.put("WebcastRoomStatsMessage", this::WebcastRoomStatsMessage);
        map.put("WebcastCommerceMessage", this::WebcastCommerceMessage);
        map.put("WebcastAudienceEntranceMessage", this::WebcastAudienceEntranceMessage);
        map.put("WebcastStampMessage", this::WebcastStampMessage);
        map.put("WebcastSyncStreamMessage", this::WebcastSyncStreamMessage);
        map.put("WebcastAudioChatMessage", this::WebcastAudioChatMessage);
        map.put("WebcastLinkMicArmiesMethod", this::WebcastLinkMicArmiesMethod);
        map.put("WebcastProfitInteractionScoreMessage", this::WebcastProfitInteractionScoreMessage);
        map.put("WebcastLinkMicMethod", this::WebcastLinkMicMethod);
        map.put("LinkMicMethod", this::LinkMicMethod);
        map.put("WebcastLinkMessage", this::WebcastLinkMessage);
        map.put("WebcastRoomDataSyncMessage", this::WebcastRoomDataSyncMessage);
        map.put("WebcastEmojiChatMessage", this::WebcastEmojiChatMessage);
        map.put("WebcastLinkerContributeMessage", this::WebcastLinkerContributeMessage);
        map.put("WebcastGameCPUserDownloadMessage", this::WebcastGameCPUserDownloadMessage);
        map.put("WebcastHotRoomMessage", this::WebcastHotRoomMessage);
        map.put("WebcastScreenChatMessage", this::WebcastScreenChatMessage);
        map.put("WebcastLuckyBoxMessage", this::WebcastLuckyBoxMessage);
        map.put("WebcastHotChatMessage", this::WebcastHotChatMessage);
        return map;
    }

    /**
     * 发送心跳包
     *
     * @param ws a
     */
    private void startPing(WebSocket ws) {
        //终止上一次的 ping 线程
        if (ping != null) {
            ping.interrupt();
        }
        ping = new Thread(() -> {
            while (true) {
                var ping = PushFrame.newBuilder()
                        .setPayloadType("hb")
                        .build().toByteArray();
                ws.writeBinaryMessage(Buffer.buffer(ping));
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        ping.start();
    }

    private ScxHttpClientResponse getIndexHtml(String liveRoomURI) throws IOException, InterruptedException {
        //模拟浏览器发送请求
        return browser.request(new ScxHttpClientRequest()
                .method(GET)
                .uri(URI.create(liveRoomURI))
                .setHeader("User-Agent", navigator().userAgent())
                .setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"));
    }

    /**
     * 根据直播间 uri 解析 直播间的信息
     *
     * @return a
     * @throws java.io.IOException            if any.
     * @throws java.lang.InterruptedException if any.
     */
    public TikTokHackLiveRoomInfo getLiveRoomInfo() throws IOException, InterruptedException {
        var indexHtml = getIndexHtml(this.liveRoomURI);
        return new TikTokHackLiveRoomInfo(indexHtml.body().toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startWatch() {
        //终止上一次的监听
        stopWatch();
        try {
            System.out.println("解析中...");
            this.liveRoomInfo = getLiveRoomInfo();
            System.out.println("解析完成 -> " + liveRoomTitle() + " (ID : " + liveRoomID() + ")");
        } catch (Exception e) {
            throw new RuntimeException("解析 直播间错误 !!!", e);
        }
        System.out.println("连接中...");
        var webSocketFuture = browser.webSocket(getWebSocketOptions());
        webSocketFuture.onSuccess(c -> {
            webSocket = c;
            startPing(c);
            c.binaryMessageHandler(b -> {
                var v = parseFrame(b.getBytes());
                if (v.response().getNeedAck()) {
                    sendAck(c, v.pushFrame(), v.response());
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

    @Override
    public void stopWatch() {
        //尝试关闭上一次的 webSocket 连接
        if (webSocket != null) {
            //清空异常处理器 防止重连
            webSocket.exceptionHandler(e -> {

            });
            webSocket.close();
            webSocket = null;
        }
        if (ping != null) {
            ping.interrupt();
        }
    }

    /**
     * <p>getWebSocketOptions.</p>
     *
     * @return a {@link io.vertx.core.http.WebSocketConnectOptions} object
     */
    public WebSocketConnectOptions getWebSocketOptions() {
//        var uri = getWebSocketURI(liveRoomID(), useGzip);
//        return new WebSocketConnectOptions()
//                .setURI(uri.toString())
//                .setSsl(true)
//                .setHost("webcast3-ws-web-lf.douyin.com")
//                .setPort(443);
        return new WebSocketConnectOptions().setAbsoluteURI("wss://webcast16-ws-alisg.tiktok.com/webcast/im/push/?aid=1988&app_language=zh-Hans&app_name=tiktok_web&browser_language=zh-CN&browser_name=Mozilla&browser_online=true&browser_platform=Win32&browser_version=5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F120.0.0.0%20Safari%2F537.36%20Edg%2F120.0.0.0&compress=gzip&cookie_enabled=true&cursor=1702032650109_7310174534114476040_1_1_0_0&debug=false&device_platform=web&heartbeatDuration=0&host=https%3A%2F%2Fwebcast.tiktok.com&identity=audience&imprp=u6UKO_b3cUUAAAkAAAAAAAAABliQQ&internal_ext=fetch_time%3A1702032650109%7Cstart_time%3A0%7Cack_ids%3A%2C%2C%7Cflag%3A0%7Cseq%3A1%7Cnext_cursor%3A1702032650109_7310174534114476040_1_1_0_0%7Cwss_info%3A0-1702032650109-0-0&live_id=12&room_id=7310174144086510344&screen_height=691&screen_width=1228&tz_name=Asia%2FShanghai&update_version_code=1.3.0&version_code=270000&webcast_sdk_version=1.3.0");
    }

    private void callHandler(TMessage message) throws Exception {
        var payload = message.getPayload().toByteArray();
        var method = message.getMethod();
        var handler = this.handlerMap.getOrDefault(method, this::DefaultHandler);
        handler.accept(payload);
    }

    private void DefaultHandler(byte[] bytes) {
        // System.err.println("DouYin -> 未处理 Message :" + message);
    }

    public void WebcastSocialMessage(byte[] payload) throws InvalidProtocolBufferException {
        var socialMessage = SocialMessage.parseFrom(payload);
        var douYinFollow = new TikTokHackFollow(socialMessage);
        this.followHandler().accept(douYinFollow);
    }

    public void RoomMessageOrWebcastRoomMessage(byte[] payload) throws InvalidProtocolBufferException {
        var roomMessage = RoomMessage.parseFrom(payload);
    }

    public void WebcastChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 消息
        var chatMessage = ChatMessage.parseFrom(payload);
        var douYinChat = new TikTokHackChat(chatMessage);
        this.chatHandler().accept(douYinChat);
    }

    public void WebcastMemberMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 来了
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
        var douYinUser = new TikTokHackUser(memberMessage);
        this.userHandler().accept(douYinUser);
    }

    public void WebcastLikeMessage(byte[] payload) throws InvalidProtocolBufferException {
        //点赞
        var likeMessage = LikeMessage.parseFrom(payload);
        var douYinLike = new TikTokHackLike(likeMessage);
        this.likeHandler().accept(douYinLike);
    }

    public void WebcastGiftMessage(byte[] payload) throws InvalidProtocolBufferException {
        //礼物
        var giftMessage = GiftMessage.parseFrom(payload);
        long groupCount = giftMessage.getGroupCount();
        long groupId = giftMessage.getGroupId();
        long repeatCount = giftMessage.getRepeatCount();
        long repeatEnd = giftMessage.getRepeatEnd();
        long totalCount = giftMessage.getTotalCount();
        //todo 哪个是真正的总数 ???
        //todo 人气 Top 是拿不到 name 的
        String name = giftMessage.getGift().getName();
        var douYinGift = new TikTokHackGift(giftMessage);
        this.giftHandler().accept(douYinGift);
    }

    public void WebcastRoomUserSeqMessage(byte[] payload) throws InvalidProtocolBufferException {
        //直播间统计
        var roomUserSeqMessage = RoomUserSeqMessage.parseFrom(payload);
    }

    public void WebcastCommonTextMessage(byte[] payload) throws InvalidProtocolBufferException {
        var commonTextMessage = CommonTextMessage.parseFrom(payload);
    }

    public void WebcastControlMessage(byte[] payload) throws InvalidProtocolBufferException {
        //直播间状态变更 比如直播关闭
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

    public void WebcastFansclubMessage(byte[] payload) throws InvalidProtocolBufferException {
        //粉丝俱乐部 ???
        var fansclubMessage = FansclubMessage.parseFrom(payload);
    }

    public void WebcastInRoomBannerMessage(byte[] payload) throws InvalidProtocolBufferException {
        //进房间后的 Banner
        var inRoomBannerMessage = InRoomBannerMessage.parseFrom(payload);
    }

    public void WebcastRoomRankMessage(byte[] payload) throws InvalidProtocolBufferException {
        //房间排行榜
        var roomRankMessage = RoomRankMessage.parseFrom(payload);
        var sb = new StringBuilder("房间排行榜更新 : \n");
        var index = 1;
        for (var roomRank : roomRankMessage.getRanksListList()) {
            sb.append(index).append(" : ").append(roomRank.getUser().getNickname()).append("\n");
            index += 1;
        }
        System.out.print(sb);
    }

    public void WebcastUpdateFanTicketMessage(byte[] payload) throws InvalidProtocolBufferException {
        //粉丝票计数 ??? 不玩抖音不太懂
        var updateFanTicketMessage = UpdateFanTicketMessage.parseFrom(payload);
    }

    public void WebcastRoomStatsMessage(byte[] payload) throws InvalidProtocolBufferException {
        //房间状态
        var roomStats = RoomStatsMessage.parseFrom(payload);
        System.out.println("房间状态更新 : " + roomStats.getDisplayLong() + " (" + roomStats.getDisplayValue() + ")");
    }

    public void WebcastCommerceMessage(byte[] payload) {
        //todo WebcastCommerceMessage
    }

    public void WebcastAudienceEntranceMessage(byte[] payload) {
        //观众入场信息
        //todo WebcastAudienceEntranceMessage
    }

    public void WebcastStampMessage(byte[] payload) {
        //todo WebcastStampMessage
    }

    public void WebcastSyncStreamMessage(byte[] payload) throws InvalidProtocolBufferException {
        var syncStreamMessage = SyncStreamMessage.parseFrom(payload);
    }

    public void WebcastAudioChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        //音频弹幕 ??? 不玩抖音不太懂
        var audioChatMessage = AudioChatMessage.parseFrom(payload);
    }

    public void WebcastLinkMicArmiesMethod(byte[] payload) {
        //连麦 ??
        //todo WebcastLinkMicArmiesMethod
    }

    public void WebcastProfitInteractionScoreMessage(byte[] payload) {
        //todo WebcastProfitInteractionScoreMessage
    }

    public void WebcastLinkMicMethod(byte[] payload) {
        //todo WebcastLinkMicMethod
    }

    public void LinkMicMethod(byte[] payload) {
        //todo LinkMicMethod
    }

    public void WebcastLinkMessage(byte[] payload) throws InvalidProtocolBufferException {
        //连麦 ???
        var linkMessage = LinkMessage.parseFrom(payload);
    }

    public void WebcastRoomDataSyncMessage(byte[] payload) {
        //todo WebcastRoomDataSyncMessage
    }

    public void WebcastEmojiChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        //emoji 类型的消息 ???
        var emojiChatMessage = EmojiChatMessage.parseFrom(payload);
    }

    public void WebcastLinkerContributeMessage(byte[] payload) {
        //todo  WebcastLinkerContributeMessage
    }

    public void WebcastGameCPUserDownloadMessage(byte[] payload) throws InvalidProtocolBufferException {
        //不知道是啥
        var gameCPUserDownloadMessage = GameCPUserDownloadMessage.parseFrom(payload);
    }

    public void WebcastHotRoomMessage(byte[] payload) throws InvalidProtocolBufferException {
        //热门直播间 ???
        var hotRoomMessage = HotRoomMessage.parseFrom(payload);
    }

    public void WebcastScreenChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        var screenChatMessage = ScreenChatMessage.parseFrom(payload);
        System.out.println("全屏消息? : " + screenChatMessage.getUser().getNickname() + " : " + screenChatMessage.getContent());
    }

    public void WebcastLuckyBoxMessage(byte[] bytes) {
        //幸运盒 ???
        //todo  WebcastLuckyBoxMessage
    }

    public void WebcastHotChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        var hotChatMessage = HotChatMessage.parseFrom(payload);
        System.out.println("热门消息 : " + hotChatMessage.getTitle() + " : " + hotChatMessage.getContent());
    }

    /**
     * 连接 抖音 弹幕服务时是否传递 gip 压缩参数
     *
     * @param useGzip a boolean
     * @return a
     */
    public TikTokHackLiveRoomWatcher useGzip(boolean useGzip) {
        this.useGzip = useGzip;
        return this;
    }

    public String ttwid() {
        var ttwid = browser.getCookie("ttwid");
        return ttwid != null ? ttwid.value() : null;
    }

    @Override
    public String liveRoomID() {
        return liveRoomInfo.liveRoomID();
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return liveRoomInfo.liveRoomAnchor();
    }

    @Override
    public String liveRoomTitle() {
        return liveRoomInfo.liveRoomTitle();
    }

    @Override
    public List<String> liveRoomWebStreamURLs() {
        return liveRoomInfo.liveRoomWebStreamURLs();
    }

    /**
     * 解析帧
     *
     * @param bytes a
     * @return needAck
     */
    private PushFrameAndResponse parseFrame(byte[] bytes) {
        try {
            var pushFrame = TPushFrame.parseFrom(bytes);
            var response = getResponse(pushFrame);
            switch (pushFrame.getPayloadType()) {
                case "msg" -> {
                    for (var message : response.getMessagesListList()) {
                        $.async(() -> callHandler(message));
                    }
                }
                case "close" -> System.out.println("关闭");
            }
            return new PushFrameAndResponse(pushFrame, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
