package cool.scx.live_room_watcher.impl.douyin_hack;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.douyin_hack.entity.ControlMessageAction;
import cool.scx.live_room_watcher.impl.douyin_hack.entity.MemberMessageAction;
import cool.scx.live_room_watcher.impl.douyin_hack.message.*;
import cool.scx.live_room_watcher.impl.douyin_hack.proto.webcast.im.*;
import cool.scx.live_room_watcher.impl.douyin_hack.util.Browser;
import dev.scx.function.Function1Void;
import dev.scx.http.headers.cookie.Cookie;
import dev.scx.http.x.proxy.Proxy;
import dev.scx.io.ScxIO;
import dev.scx.scheduling.ScheduleHandle;
import dev.scx.scheduling.ScxScheduling;
import dev.scx.websocket.ScxWebSocket;
import dev.scx.websocket.event.ScxEventWebSocket;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cool.scx.live_room_watcher.impl.douyin_hack.util.DouYinHackHelper.*;
import static dev.scx.http.method.HttpMethod.GET;

/// 利用模拟网页 websocket 的方式获取直播间信息
///
/// @author scx567888
/// @version 0.0.1
public class DouYinHackLiveRoomWatcher extends AbstractLiveRoomWatcher {

    private final String liveRoomURI;
    private final Browser browser;
    private final Map<String, Function1Void<byte[], ?>> handlerMap;

    private ScxEventWebSocket webSocket;
    private ScheduleHandle ping;
    private DouYinHackLiveRoomInfo liveRoomInfo;

    public DouYinHackLiveRoomWatcher(String liveRoomURI) {
        this(liveRoomURI, null);
    }

    public DouYinHackLiveRoomWatcher(String liveRoomURI, Proxy proxy) {
        this.liveRoomURI = liveRoomURI;
        this.browser = new Browser(proxy).addCookie(Cookie.of("__ac_nonce", "063b51155007d27728929"));
        this.handlerMap = initHandlerMap();
    }

    private Map<String, Function1Void<byte[], ?>> initHandlerMap() {
        var map = new HashMap<String, Function1Void<byte[], ?>>();
        map.put("WebcastSocialMessage", this::WebcastSocialMessage);
        map.put("WebcastChatMessage", this::WebcastChatMessage);
        map.put("WebcastMemberMessage", this::WebcastMemberMessage);
        map.put("WebcastLikeMessage", this::WebcastLikeMessage);
        map.put("WebcastGiftMessage", this::WebcastGiftMessage);
        map.put("WebcastControlMessage", this::WebcastControlMessage);
        map.put("WebcastRoomRankMessage", this::WebcastRoomRankMessage);
        map.put("WebcastRoomStatsMessage", this::WebcastRoomStatsMessage);
        map.put("WebcastInRoomBannerMessage", this::WebcastInRoomBannerMessage);
        return map;
    }

    /// 开始监听, 会阻塞当前线程
    public void startWatch() {
        // 终止上一次的监听
        stopWatch();

        // 解析直播间信息
        try {
            System.out.println("解析 直播间 中...");
            this.liveRoomInfo = initLiveRoomInfo();
            System.out.println("解析 直播间 完成 -> " + this.liveRoomInfo.title() + " (ID : " + this.liveRoomInfo.roomID() + ")");
        } catch (Exception e) {
            throw new RuntimeException("解析 直播间错误 !!!", e);
        }

        // 解析 websocket
        WebSocketOptions webSocketOptions;
        try {
            System.out.println("解析 websocket 地址中...");
            webSocketOptions = getWebSocketOptions(this.liveRoomURI);
            System.out.println("解析 websocket 成功 : " + webSocketOptions);
        } catch (Exception e) {
            throw new RuntimeException("解析 websocket 地址错误 !!!", e);
        }

        // 连接 websocket
        ScxWebSocket ws;
        try {
            System.out.println("连接 websocket 中...");
            ws = browser.webSocketHandshakeRequest().uri(webSocketOptions.uri()).addCookie(webSocketOptions.cookie()).upgrade();
            System.out.println("连接 websocket 成功 !!!");
        } catch (Exception e) {
            throw new RuntimeException("连接 websocket 错误 !!!", e);
        }

        // 赋值 webSocket
        this.webSocket = ScxEventWebSocket.of(ws);

        // 启动 ping 调度
        startPing(this.webSocket);
        // 设置 Binary 回调
        this.webSocket.onBinary(b -> {
            try {
                handleFrame(b);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        });
        // 正常不会触发
        this.webSocket.onText(System.out::println);
        // 发生错误回调
        this.webSocket.onError(e -> {
            System.out.println("websocket onError");
        });
        this.webSocket.onClose(e -> {
            System.out.println("websocket onClose");
        });
        // 开启 websocket 处理
        webSocket.start();
    }

    /// 终止监听
    public void stopWatch() {
        // 尝试关闭上一次的 webSocket 连接
        if (webSocket != null) {
            webSocket.close();
            webSocket = null;
        }
        // 终止 ping 调度
        if (ping != null) {
            ping.cancel();
        }
    }

    /// 根据直播间 uri 解析 直播间的信息
    private DouYinHackLiveRoomInfo initLiveRoomInfo() {
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

    /// 启用 发送心跳包 调度
    private void startPing(ScxEventWebSocket ws) {
        // 终止上一次的 调度
        if (ping != null) {
            ping.cancel();
        }

        // 构建 ping 响应体
        var pingBytes = PushFrame.newBuilder()
            .setPayloadType("hb")
            .build().toByteArray();

        // 10 秒发送一次
        this.ping = ScxScheduling.fixedDelay()
            .interval(Duration.ofSeconds(10))
            .start((c) -> {
                ws.send(pingBytes);
            });
    }

    /// 解析帧
    private void handleFrame(byte[] bytes) throws InvalidProtocolBufferException {
        var pushFrame = PushFrame.parseFrom(bytes);

        // 判断是否用了 gzip
        var gzip = pushFrame.getHeadersList().stream().anyMatch(pushHeader -> "compress_type".equals(pushHeader.getKey()) && "gzip".equals(pushHeader.getValue()));
        var responseBytes = gzip ? ScxIO.ungzip(pushFrame.getPayload().toByteArray()) : pushFrame.getPayload().toByteArray();
        var response = Response.parseFrom(responseBytes);

        // 如果需要回 ack 先回 ack
        if (response.getNeedAck()) {
            var ack = PushFrame.newBuilder()
                .setPayloadType("ack")
                .setLogID(pushFrame.getLogID())
                .setPayload(ByteString.copyFromUtf8(response.getInternalExt()))
                .build().toByteArray();
            this.webSocket.send(ack);
        }

        switch (pushFrame.getPayloadType()) {
            case "msg" -> {
                for (var message : response.getMessagesList()) {
                    callHandler(message);
                }
            }
            case "close" -> System.out.println("PushFrame 关闭");
        }
    }

    /// 调用 handler
    private void callHandler(Message message) {
        var payload = message.getPayload().toByteArray();
        var method = message.getMethod();
        var handler = this.handlerMap.get(method);
        if (handler != null) {
            // 防止 handler 相互阻塞 我们用 调度器
            Thread.ofVirtual().start(() -> {
                try {
                    handler.apply(payload);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            this.DefaultHandler(method, payload);
        }
    }

    /// 默认 handler
    private void DefaultHandler(String method, byte[] bytes) {
        System.err.println("DouYinHack -> 未处理 Message : " + method);
    }

    //***************************** 具体 Handler **********************************

    private void WebcastSocialMessage(byte[] payload) throws InvalidProtocolBufferException {
        var socialMessage = SocialMessage.parseFrom(payload);
        var douYinFollow = new DouYinHackFollow(socialMessage);
        this._callOnFollow(douYinFollow);
    }

    private void WebcastChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 消息
        var chatMessage = ChatMessage.parseFrom(payload);
        var douYinChat = new DouYinHackChat(chatMessage);
        this._callOnChat(douYinChat);
    }

    private void WebcastMemberMessage(byte[] payload) throws InvalidProtocolBufferException {
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
//                System.out.println("ENTER");
            }
            case LEAVE -> {
                System.out.println("LEAVE");
            }
            case SET_ADMIN -> {
                System.out.println("SET_ADMIN");
            }
            case CANCEL_ADMIN -> {
                System.out.println("CANCEL_ADMIN");
            }
            case SHARE -> {
                System.out.println("SHARE");
            }
            case FOLLOW -> {
                System.out.println("FOLLOW");
            }
        }
        var douYinUser = new DouYinHackUser(memberMessage);
        this._callOnUser(douYinUser);
    }

    private void WebcastLikeMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 点赞
        var likeMessage = LikeMessage.parseFrom(payload);
        var douYinLike = new DouYinHackLike(likeMessage);
        this._callOnLike(douYinLike);
    }

    private void WebcastGiftMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 礼物
        var giftMessage = GiftMessage.parseFrom(payload);
        // todo 哪个是真正的总数 ???
        // todo 人气 Top 是拿不到 name 的
        var name = giftMessage.getGift().getName();
        var douYinGift = new DouYinHackGift(giftMessage);
        this._callOnGift(douYinGift);
    }

    private void WebcastControlMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 直播间状态变更 比如直播关闭
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

    private void WebcastRoomRankMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 房间排行榜
        var roomRankMessage = RoomRankMessage.parseFrom(payload);
        var sb = new StringBuilder("房间排行榜更新 : \n");
        var index = 1;
        for (var roomRank : roomRankMessage.getRanksList()) {
            sb.append(index).append(" : ").append(roomRank.getUser().getNickname()).append("\n");
            index = index + 1;
        }
        System.out.print(sb);
    }

    private void WebcastRoomStatsMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 房间状态
        var roomStats = RoomStatsMessage.parseFrom(payload);
        System.out.println("房间状态更新 : " + roomStats.getDisplayLong() + " (" + roomStats.getDisplayValue() + ")");
    }

    private void WebcastInRoomBannerMessage(byte[] payload) throws InvalidProtocolBufferException {
        System.err.println("WebcastInRoomBannerMessage");
    }

    //***************************** 其余方法 **********************************

    public String ttwid() {
        var ttwid = browser.getCookie("ttwid");
        return ttwid != null ? ttwid.value() : null;
    }

    public DouYinHackLiveRoomInfo liveRoomInfo() {
        return liveRoomInfo;
    }

    public List<String> liveRoomWebStreamURLs() {
        return liveRoomInfo.webStreamURLs();
    }

}
