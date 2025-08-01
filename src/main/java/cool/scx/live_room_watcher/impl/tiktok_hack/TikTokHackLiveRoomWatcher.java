package cool.scx.live_room_watcher.impl.tiktok_hack;

import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.function.ConsumerX;
import cool.scx.http.ScxHttpClientResponse;
import cool.scx.http.headers.cookie.Cookie;
import cool.scx.http.headers.cookie.Cookies;
import cool.scx.http.x.proxy.Proxy;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.tiktok_hack.message.TikTokHackChat;
import cool.scx.live_room_watcher.impl.tiktok_hack.message.TikTokHackGift;
import cool.scx.live_room_watcher.impl.tiktok_hack.message.TikTokHackLike;
import cool.scx.live_room_watcher.impl.tiktok_hack.message.TikTokHackUser;
import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.*;
import cool.scx.live_room_watcher.util.Browser;
import cool.scx.websocket.ScxClientWebSocketHandshakeRequest;
import cool.scx.websocket.ScxWebSocket;
import cool.scx.websocket.event.ScxEventWebSocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cool.scx.http.method.HttpMethod.GET;
import static cool.scx.live_room_watcher.impl.tiktok_hack.TikTokHackHelper.*;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * 利用模拟网页 websocket 的方式获取直播间信息
 *
 * @author scx567888
 * @version 0.0.1
 */
public class TikTokHackLiveRoomWatcher extends AbstractLiveRoomWatcher {


    private final String liveRoomURI;
    private final Browser browser;
    private final Map<String, ConsumerX<byte[], ?>> handlerMap;
    private ScxEventWebSocket webSocket;
    private boolean useGzip;
    private Thread ping;
    private TikTokHackLiveRoomInfo liveRoomInfo;

    public TikTokHackLiveRoomWatcher(String uri) {
        this(uri, null);
    }

    public TikTokHackLiveRoomWatcher(String uri, Proxy proxy) {
        this.liveRoomURI = initLiveRoomURI(uri);
        this.browser = new Browser(proxy).addCookie(Cookie.of("__ac_nonce", "063b51155007d27728929"));
        this.handlerMap = initHandlerMap();
    }

    public Map<String, ConsumerX<byte[], ?>> initHandlerMap() {
        var map = new HashMap<String, ConsumerX<byte[], ?>>();
        map.put("WebcastChatMessage", this::WebcastChatMessage);
        map.put("WebcastMemberMessage", this::WebcastMemberMessage);
        map.put("WebcastLikeMessage", this::WebcastLikeMessage);
        map.put("WebcastGiftMessage", this::WebcastGiftMessage);
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
    public TikTokHackLiveRoomInfo getLiveRoomInfo() throws IOException, InterruptedException {
        var indexHtml = getIndexHtml(this.liveRoomURI);
        Cookies cookies = indexHtml.headers().setCookies();
        browser.addCookies(cookies);
        return new TikTokHackLiveRoomInfo(indexHtml.body().asString());
    }

    /**
     * {@inheritDoc}
     */
    public void startWatch() {
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
        var webSocketOptions = getWebSocketOptions();
        var ws = webSocketOptions.webSocket();
        var c = ScxEventWebSocket.of(ws);
        try {
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
            webSocket.start();
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

    private void callHandler(Message message) throws Throwable {
        var payload = message.getPayload().toByteArray();
        var method = message.getMethod();
        var handler = this.handlerMap.getOrDefault(method, this::DefaultHandler);
        handler.accept(payload);
    }

    private void DefaultHandler(byte[] bytes) {
        // System.err.println("DouYin -> 未处理 Message :" + message);
    }

    public void WebcastSocialMessage(byte[] payload) throws InvalidProtocolBufferException {
//        var socialMessage = SocialMessage.parseFrom(payload);
//        var douYinFollow = new DouYinHackFollow(socialMessage);
//        this._callOnFollow(douYinFollow);
    }

    public void WebcastChatMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 消息
        var chatMessage = ChatMessage.parseFrom(payload);
        var douYinChat = new TikTokHackChat(chatMessage);
        this._callOnChat(douYinChat);
    }

    public void WebcastMemberMessage(byte[] payload) throws InvalidProtocolBufferException {
        // 来了
        var memberMessage = MemberMessage.parseFrom(payload);
        var douYinUser = new TikTokHackUser(memberMessage);
        this._callOnUser(douYinUser);
    }

    public void WebcastLikeMessage(byte[] payload) throws InvalidProtocolBufferException {
        //点赞
        var likeMessage = LikeMessage.parseFrom(payload);
        var douYinLike = new TikTokHackLike(likeMessage);
        this._callOnLike(douYinLike);
    }

    public void WebcastGiftMessage(byte[] payload) throws InvalidProtocolBufferException {
        //礼物
        var giftMessage = GiftMessage.parseFrom(payload);
        var douYinGift = new TikTokHackGift(giftMessage);
        this._callOnGift(douYinGift);
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
                    for (var message : response.getMessagesListList()) {
                        Thread.ofVirtual().start(() -> {
                            try {
                                callHandler(message);
                            } catch (Throwable e) {
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

    public ScxClientWebSocketHandshakeRequest getWebSocketOptions() {
        var uri = getWebSocketURI(liveRoomInfo.roomID(), useGzip);
        uri.host("webcast16-ws-alisg.tiktok.com").scheme("wss");
        return browser.webSocketHandshakeRequest().uri(uri);
    }

}
