package cool.scx.live_room_watcher.impl.meme;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.enumeration.HttpMethod;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.BaseLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.meme.message.MEMEChat;
import cool.scx.live_room_watcher.impl.meme.message.MEMEEnterRoom;
import cool.scx.live_room_watcher.impl.meme.message.MEMEGift;
import cool.scx.live_room_watcher.impl.meme.message.MEMELike;
import cool.scx.util.ObjectUtils;
import cool.scx.util.RandomUtils;
import cool.scx.util.URIBuilder;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocketConnectOptions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static cool.scx.enumeration.HttpMethod.GET;
import static cool.scx.enumeration.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.meme.MEMEHelper.getSign;
import static cool.scx.util.ObjectUtils.toJson;

/**
 * 么么直播
 */
public class MEMELiveRoomWatcher extends BaseLiveRoomWatcher {

    private final String appID;
    private final String appSecret;
    final HttpClient httpClient;
    private final Map<String, WatchTask> watchTaskMap = new ConcurrentHashMap<>();

    public MEMELiveRoomWatcher(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
        if (appID == null || appSecret == null) {
            throw new NullPointerException("参数不全 !!!");
        }
        this.httpClient = vertx.createHttpClient();
    }

    public static WebSocketConnectOptions getWebsocketChannelOptions(String roomId) {
        var absoluteURI = "https://test-games-sock.memeyule.com:6211/websocket?roomId=" + roomId;
//        var absoluteURI= MEMEApi.WEBSOCKET_CHANNEL_URL + "/" + roomId;
        var options = new WebSocketConnectOptions();
        options.setAbsoluteURI(absoluteURI);
        return options;
    }

    public ScxHttpClientResponse request(HttpMethod method, String url, String body) throws IOException, InterruptedException {
        var nonce = RandomUtils.randomString(10);
        var timestamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(0)).toEpochMilli();
        var sign = getSign(body, appSecret, nonce, timestamp);
        return ScxHttpClientHelper.request(new ScxHttpClientRequest()
                .uri(url)
                .setHeader("appkey", appID)
                .setHeader("sign", sign)
                .setHeader("nonce", nonce)
                .setHeader("timestamp", timestamp + "")
                .method(method)
                .body(new JsonBody(body)));
    }

    public ScxHttpClientResponse request(HttpMethod method, String url) throws IOException, InterruptedException {
        return request(method, url, "");
    }

    public void bindRoomCode(String code) throws IOException, InterruptedException {
        var body = Map.of("code", code);
        ScxHttpClientResponse request = this.request(POST, MEMEApi.BIND_ROOM_CODE_URL, toJson(body));
        System.out.println(request.body().toString());
    }

    public void roomCodeStatus(String code) throws IOException, InterruptedException {
        var uri = URIBuilder.of(MEMEApi.ROOM_CODE_STATUS_URL).addParam("code", code).toString();
        ScxHttpClientResponse request = this.request(GET, uri);
        System.out.println(request.body().toString());
    }

    public void starInfo(String uid) throws IOException, InterruptedException {
        var uri = URIBuilder.of(MEMEApi.STAR_INFO_URL).addParam("uid", uid).toString();
        ScxHttpClientResponse request = this.request(GET, uri);
        System.out.println(request.body().toString());
    }

    public void gifts() throws IOException, InterruptedException {
        ScxHttpClientResponse request = this.request(GET, MEMEApi.STAR_INFO_URL);
        System.out.println(request.body().toString());
    }

    public void startCallBack(String roomID) throws IOException, InterruptedException {
        var body = Map.of("liveRoomId", roomID, "matchId", RandomUtils.randomUUID());
        ScxHttpClientResponse request = this.request(POST, MEMEApi.START_CALLBACK_URL, toJson(body));
        System.out.println(request.body().toString());
    }

    public void startWatchTask(String roomId) {
        if (watchTaskMap.get(roomId) == null) {
            var watchTask = new WatchTask(this, roomId);
            watchTaskMap.put(roomId, watchTask);
            watchTask.start();
        }
    }

    public void stopWatchTask(String roomId) {
        var watchTask = watchTaskMap.get(roomId);
        if (watchTask != null) {
            watchTask.stop();
            watchTaskMap.remove(roomId);
        }
    }

    public void callMessage(String jsonPayload) {
        try {
            var payload = ObjectUtils.jsonMapper().readValue(jsonPayload, MEMEWebSocketPayload.class);
            switch (payload.action) {
                case "enterRoom" -> callEnterRoom(payload);
                case "sendGift" -> callSendGift(payload);
                case "comment" -> callComment(payload);
                case "like" -> callLike(payload);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void callLike(MEMEWebSocketPayload payload) {
        var memeLike = ObjectUtils.convertValue(payload.data, MEMELike.class);
        memeLike.roomID = payload.roomId + "";
        this.likeHandler.accept(memeLike);
    }

    public void callEnterRoom(MEMEWebSocketPayload payload) {
        var memeEnterRoom = ObjectUtils.convertValue(payload.data, MEMEEnterRoom.class);
        memeEnterRoom.roomID = payload.roomId + "";
        this.userHandler.accept(memeEnterRoom);
    }

    public void callComment(MEMEWebSocketPayload payload) {
        var memeChat = ObjectUtils.convertValue(payload.data, MEMEChat.class);
        memeChat.roomID = payload.roomId + "";
        this.chatHandler.accept(memeChat);
    }

    public void callSendGift(MEMEWebSocketPayload payload) {
        var memeGift = ObjectUtils.convertValue(payload.data, MEMEGift.class);
        memeGift.roomID = payload.roomId + "";
        this.giftHandler.accept(memeGift);
    }

    @Override
    public void startWatch() {
        throw new UnsupportedOperationException("请使用 startWatch(String token, String roomID) !!!");
    }

    @Override
    public void stopWatch() {
        throw new UnsupportedOperationException("请使用 startWatch(String token, String roomID) !!!");
    }

    public void startWatch(String token, String roomID) throws IOException, InterruptedException {
        startWatchTask(roomID);
//        startCallBack(roomID);
//        bindRoomCode(token);
//        roomCodeStatus(roomID);
//        starInfo(roomID);
//        gifts();
    }

    public void stopWatch(String roomID) throws IOException, InterruptedException {
        stopWatchTask(roomID);
    }


}
