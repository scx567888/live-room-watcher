package cool.scx.live_room_watcher.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.douyin.entity.DouYinApplication;
import cool.scx.live_room_watcher.douyin.enumeration.ControlMessageAction;
import cool.scx.live_room_watcher.douyin.enumeration.MemberMessageAction;
import cool.scx.live_room_watcher.douyin.proto_entity.pushproto.PushFrame;
import cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.*;
import cool.scx.live_room_watcher.util.Browser;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import io.netty.util.concurrent.ScheduledFuture;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketConnectOptions;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static cool.scx.enumeration.HttpMethod.GET;
import static cool.scx.live_room_watcher.douyin.DouYinHelper.*;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * <p>DouYinLiveRoomWatcher class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcher extends AbstractLiveRoomWatcher {

    private final String liveRoomURI;
    private final Browser browser;
    private DouYinApplication douYinApplication;
    private WebSocket webSocket;
    private boolean useGzip;
    private boolean isClosed;
    private ScheduledFuture<?> ping;

    /**
     * <p>Constructor for DouYinLiveRoomWatcher.</p>
     *
     * @param uri a {@link java.lang.String} object
     */
    public DouYinLiveRoomWatcher(String uri) {
        this.liveRoomURI = initLiveRoomURI(uri);
        this.browser = new Browser(vertx).addCookie(new DefaultCookie("__ac_nonce", "063b51155007d27728929"));
    }

    /**
     * 发送心跳包
     *
     * @param ws a
     * @return
     */
    private ScheduledFuture<?> ping(WebSocket ws) {
        return vertx.nettyEventLoopGroup().scheduleAtFixedRate(() -> {
            var ping = PushFrame.newBuilder()
                    .setPayloadType("hb")
                    .build().toByteArray();
            ws.writeBinaryMessage(Buffer.buffer(ping));
        }, 0, 10, TimeUnit.SECONDS);
    }

    /**
     * <p>getIndexHtml.</p>
     *
     * @param liveRoomURI a {@link java.lang.String} object
     * @return a HttpResponse object
     * @throws java.io.IOException            if any.
     * @throws java.lang.InterruptedException if any.
     */
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
     * @throws java.io.IOException            if any.
     * @throws java.lang.InterruptedException if any.
     */
    public void parseByLiveRoomURI() throws IOException, InterruptedException {
        var indexHtml = getIndexHtml(this.liveRoomURI);
        this.douYinApplication = parseBody(indexHtml.body().toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startWatch() {
        try {
            System.out.println("解析中...");
            parseByLiveRoomURI();
            System.out.println("解析完成 -> " + liveRoomTitle() + " (ID : " + liveRoomID() + ")");
        } catch (Exception e) {
            throw new RuntimeException("解析 直播间错误 !!!", e);
        }
        //尝试关闭上一次的 webSocket 连接
        clear();
        System.out.println("连接中...");
        var webSocketFuture = browser.webSocket(getWebSocketOptions());
        webSocketFuture.onSuccess(c -> {
            webSocket = c;
            ping = ping(c);
            c.binaryMessageHandler(b -> {
                var v = parseFrame(b.getBytes());
                if (v.response.getNeedAck()) {
                    sendAck(c, v.pushFrame(), v.response());
                }
            });
            c.textMessageHandler(System.out::println);
            c.exceptionHandler(e -> {
                e.printStackTrace();
                if (!isClosed) {
                    startWatch();
                }
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
        isClosed = true;
        if (webSocket != null) {
            webSocket.close();
            webSocket = null;
        }
        if (ping != null) {
            ping.cancel(true);
            ping = null;
        }
        vertx.close();
    }

    private void clear() {
        if (webSocket != null) {
            webSocket.close();
            webSocket = null;
        }
        if (ping != null) {
            ping.cancel(true);
            ping = null;
        }
        isClosed = false;
    }

    /**
     * <p>getWebSocketOptions.</p>
     *
     * @return a {@link io.vertx.core.http.WebSocketConnectOptions} object
     */
    public WebSocketConnectOptions getWebSocketOptions() {
        return new WebSocketConnectOptions()
                .setURI(getWebSocketURI(liveRoomID(), useGzip).toString())
                .setSsl(true)
                .setHost("webcast3-ws-web-lf.douyin.com")
                .setPort(443);
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
                // System.err.println("DouYin -> 未处理 Message :" + message);
            }
        }

    }

    @Override
    public String liveRoomID() {
        return this.douYinApplication.app.initialState.roomStore.roomInfo.roomId;
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

    @Override
    public String liveRoomTitle() {
        return this.douYinApplication.app.initialState.roomStore.roomInfo.room.title;
    }

    public String ttwid() {
        var ttwid = browser.getCookie("ttwid");
        return ttwid != null ? ttwid.value() : null;
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

    /**
     * a
     *
     * @param bytes a
     * @return needAck
     */
    private PushFrameAndResponse parseFrame(byte[] bytes) {
        try {
            var pushFrame = PushFrame.parseFrom(bytes);
            var response = getResponse(pushFrame);
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
            return new PushFrameAndResponse(pushFrame, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private record PushFrameAndResponse(PushFrame pushFrame, Response response) {

    }

}
