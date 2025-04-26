package cool.scx.live_room_watcher.impl.douyin_hack;

import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.common.functional.ScxConsumer;
import cool.scx.common.util.$;
import cool.scx.http.ScxHttpClientResponse;
import cool.scx.http.headers.cookie.Cookie;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.douyin_hack.enumeration.ControlMessageAction;
import cool.scx.live_room_watcher.impl.douyin_hack.enumeration.MemberMessageAction;
import cool.scx.live_room_watcher.impl.douyin_hack.message.*;
import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.*;
import cool.scx.live_room_watcher.util.Browser;
import cool.scx.websocket.ScxWebSocket;
import cool.scx.websocket.handler.ScxEventWebSocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cool.scx.http.method.HttpMethod.GET;
import static cool.scx.live_room_watcher.impl.douyin_hack.DouYinHackHelper.*;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * 利用模拟网页 websocket 的方式获取直播间信息
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackLiveRoomWatcher extends AbstractLiveRoomWatcher {

    private final String liveRoomURI;
    private final Browser browser;
    private final Map<String, ScxConsumer<byte[], ?>> handlerMap;
    private ScxEventWebSocket webSocket;
    private boolean useGzip;
    private Thread ping;
    private DouYinHackLiveRoomInfo liveRoomInfo;

    /**
     * <p>Constructor for DouYinLiveRoomWatcher.</p>
     *
     * @param uri a {@link java.lang.String} object
     */
    public DouYinHackLiveRoomWatcher(String uri) {
        this.liveRoomURI = initLiveRoomURI(uri);
        this.browser = new Browser().addCookie(Cookie.of("__ac_nonce", "063b51155007d27728929"));
        this.handlerMap = initHandlerMap();
    }

    public Map<String, ScxConsumer<byte[], ?>> initHandlerMap() {
        var map = new HashMap<String, ScxConsumer<byte[], ?>>();
        map.put("WebcastSocialMessage", this::WebcastSocialMessage);
        map.put("WebcastChatMessage", this::WebcastChatMessage);
        map.put("WebcastMemberMessage", this::WebcastMemberMessage);
        map.put("WebcastLikeMessage", this::WebcastLikeMessage);
        map.put("WebcastGiftMessage", this::WebcastGiftMessage);
        map.put("WebcastControlMessage", this::WebcastControlMessage);
        map.put("WebcastRoomRankMessage", this::WebcastRoomRankMessage);
        map.put("WebcastRoomStatsMessage", this::WebcastRoomStatsMessage);
        return map;
    }

    /**
     * 发送心跳包
     *
     * @param ws a
     */
    private void startPing(ScxWebSocket ws) {
        //终止上一次的 ping 线程
        if (ping != null) {
            ping.interrupt();
        }
        ping = new Thread(() -> {
            while (true) {
                var ping = PushFrame.newBuilder()
                        .setPayloadType("hb")
                        .build().toByteArray();
                ws.send(ping);
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
        return browser.request()
                .method(GET)
                .uri(liveRoomURI)
                .setHeader("User-Agent", navigator().userAgent())
                .setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .send();
    }

    /**
     * 根据直播间 uri 解析 直播间的信息
     *
     * @return a
     * @throws java.io.IOException            if any.
     * @throws java.lang.InterruptedException if any.
     */
    public DouYinHackLiveRoomInfo getLiveRoomInfo() throws IOException, InterruptedException {
        var indexHtml = getIndexHtml(this.liveRoomURI);
        return new DouYinHackLiveRoomInfo(indexHtml.body().toString());
    }

    /**
     * {@inheritDoc}
     */
    public void startWatch() {
        //todo 防止线程退出
        new Thread(() -> {
            while (true) {
                $.sleep(99999);
            }
        }).start();
        //终止上一次的监听
        stopWatch();
        try {
            System.out.println("解析中...");
            this.liveRoomInfo = getLiveRoomInfo();
            System.out.println("解析完成 -> " + this.liveRoomInfo.title() + " (ID : " + this.liveRoomInfo.roomID() + ")");
        } catch (Exception e) {
            throw new RuntimeException("解析 直播间错误 !!!", e);
        }
        System.out.println("连接中...");
        var webSocketFuture = browser.webSocket(DouYinHackHelper.getWebSocketOptions(this.liveRoomURI)).webSocket();
        try {
            var c = ScxEventWebSocket.of(webSocketFuture);
            webSocket = c;
            startPing(c);
            c.onBinaryMessage((b, _) -> {
                var v = parseFrame(b);
                if (v.response().getNeedAck()) {
                    sendAck(c, v.pushFrame(), v.response());
                }
            });
            c.onTextMessage((s, _) -> System.out.println(s));
            c.onError(e -> {
                e.printStackTrace();
                startWatch();
            });
            System.out.println("连接成功 !!!");
            c.start();
        } catch (Exception e) {
            //todo 这里有时会 200 待研究
            e.printStackTrace();
            startWatch();
        }
    }

    public void stopWatch() {
        //尝试关闭上一次的 webSocket 连接
        if (webSocket != null) {
            //清空异常处理器 防止重连
            webSocket.onError(e -> {

            });
            webSocket.close();
            webSocket = null;
        }
        if (ping != null) {
            ping.interrupt();
        }
    }

    private void callHandler(Message message) throws Exception {
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
        var douYinFollow = new DouYinHackFollow(socialMessage);
        this._callOnFollow(douYinFollow);
    }

    public void WebcastChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 消息
        var chatMessage = ChatMessage.parseFrom(payload);
        var douYinChat = new DouYinHackChat(chatMessage);
        this._callOnChat(douYinChat);
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
        var douYinUser = new DouYinHackUser(memberMessage);
        this._callOnUser(douYinUser);
    }

    public void WebcastLikeMessage(byte[] payload) throws InvalidProtocolBufferException {
        //点赞
        var likeMessage = LikeMessage.parseFrom(payload);
        var douYinLike = new DouYinHackLike(likeMessage);
        this._callOnLike(douYinLike);
    }

    public void WebcastGiftMessage(byte[] payload) throws InvalidProtocolBufferException {
        //礼物
        var giftMessage = GiftMessage.parseFrom(payload);
        //todo 哪个是真正的总数 ???
        //todo 人气 Top 是拿不到 name 的
        String name = giftMessage.getGift().getName();
        var douYinGift = new DouYinHackGift(giftMessage);
        this._callOnGift(douYinGift);
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

    public void WebcastRoomRankMessage(byte[] payload) throws InvalidProtocolBufferException {
        //房间排行榜
        var roomRankMessage = RoomRankMessage.parseFrom(payload);
        var sb = new StringBuilder("房间排行榜更新 : \n");
        var index = 1;
        for (var roomRank : roomRankMessage.getRanksList()) {
            sb.append(index).append(" : ").append(roomRank.getUser().getNickname()).append("\n");
            index += 1;
        }
        System.out.print(sb);
    }

    public void WebcastRoomStatsMessage(byte[] payload) throws InvalidProtocolBufferException {
        //房间状态
        var roomStats = RoomStatsMessage.parseFrom(payload);
        System.out.println("房间状态更新 : " + roomStats.getDisplayLong() + " (" + roomStats.getDisplayValue() + ")");
    }

    /**
     * 连接 抖音 弹幕服务时是否传递 gip 压缩参数
     *
     * @param useGzip a boolean
     * @return a
     */
    public DouYinHackLiveRoomWatcher useGzip(boolean useGzip) {
        this.useGzip = useGzip;
        return this;
    }

    public String ttwid() {
        var ttwid = browser.getCookie("ttwid");
        return ttwid != null ? ttwid.value() : null;
    }

    public DouYinHackLiveRoomInfo liveRoomInfo() {
        return liveRoomInfo;
    }

    public List<String> liveRoomWebStreamURLs() {
        return List.of(liveRoomInfo.webStreamURLs());
    }

    /**
     * 解析帧
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
                    for (var message : response.getMessagesList()) {
                        Thread.ofVirtual().start(() -> {
                            try {
                                callHandler(message);
                            } catch (Exception e) {
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

}
