package cool.scx.live_room_watcher.impl.meme;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.MsgType;
import cool.scx.live_room_watcher.OfficialLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.meme.message.MEMEChat;
import cool.scx.live_room_watcher.impl.meme.message.MEMEEnterRoom;
import cool.scx.live_room_watcher.impl.meme.message.MEMEGift;
import cool.scx.live_room_watcher.impl.meme.message.MEMELike;
import cool.scx.standard.HttpMethod;
import cool.scx.util.ObjectUtils;
import cool.scx.util.RandomUtils;
import cool.scx.util.URIBuilder;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocketClient;
import io.vertx.core.http.WebSocketConnectOptions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static cool.scx.live_room_watcher.impl.meme.MEMEHelper.getSign;
import static cool.scx.live_room_watcher.impl.meme.MEMEHelper.logger;
import static cool.scx.live_room_watcher.util.Helper.VERTX;
import static cool.scx.standard.HttpMethod.GET;
import static cool.scx.standard.HttpMethod.POST;
import static cool.scx.util.ObjectUtils.toJson;
import static java.lang.System.Logger.Level.DEBUG;

/**
 * 么么直播
 */
public class MEMELiveRoomWatcher extends AbstractLiveRoomWatcher implements OfficialLiveRoomWatcher {

    final HttpClient httpClient;
    final WebSocketClient webSocketClient;
    final MEMEApi memeApi;
    final String appID;
    final String appSecret;
    private final Map<String, MEMEWatchTask> watchTaskMap = new ConcurrentHashMap<>();
    private final MEMEAccessTokenManager accessTokenManager;

    public MEMELiveRoomWatcher(String appID, String appSecret, boolean isTest) {
        this.appID = appID;
        this.appSecret = appSecret;
        if (appID == null || appSecret == null) {
            throw new NullPointerException("参数不全 !!!");
        }
        this.httpClient = VERTX.createHttpClient();
        this.webSocketClient = VERTX.createWebSocketClient();
        this.memeApi = new MEMEApi(isTest);
        this.accessTokenManager = new MEMEAccessTokenManager(this);
    }

    public MEMELiveRoomWatcher(String appID, String appSecret) {
        this(appID, appSecret, false);
    }

    public WebSocketConnectOptions getWebsocketChannelOptions(String roomId) {
        var absoluteURI = memeApi.WEBSOCKET_CHANNEL_URL() + "?roomId=" + roomId + "&appkey=" + appID + "&accessToken=" + accessTokenManager.getAccessToken();
        logger.log(DEBUG, "获取连接地址 : {0}", absoluteURI);
        var options = new WebSocketConnectOptions();
        options.setAbsoluteURI(absoluteURI);
        return options;
    }


    @Override
    public MEMELiveRoomAnchor liveInfo(String tokenOrRoomID) throws IOException, InterruptedException {
        var uri = URIBuilder.of(memeApi.STAR_INFO_URL()).addParam("uid", tokenOrRoomID).toString();
        ScxHttpClientResponse request = this.request(GET, uri);
        var str = request.body().toString();
        var jsonNode = ObjectUtils.jsonMapper().readTree(str);
        if (!jsonNode.get("ok").asBoolean()) {
            throw new RuntimeException(str);
        }
        var starInfo = jsonNode.get("data");
        return ObjectUtils.convertValue(starInfo, MEMELiveRoomAnchor.class);
    }

    @Override
    public String failDataGet(String roomID, MsgType msgType, Integer pageNum, Integer pageSize) throws IOException, InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String topGift(String roomCode, String[] memeTopGifts) throws IOException, InterruptedException {
        throw new UnsupportedOperationException();
    }

    public String gifts() throws IOException, InterruptedException {
        var request = this.request(GET, memeApi.GIFTS_URL());
        return request.body().toString();
    }

    private ScxHttpClientResponse request(HttpMethod method, String url, String body) throws IOException, InterruptedException {
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

    ScxHttpClientResponse request(HttpMethod method, String url) throws IOException, InterruptedException {
        return request(method, url, "");
    }

    /**
     * 暂未用到
     *
     * @param code c
     * @return c
     * @throws IOException          c
     * @throws InterruptedException c
     */
    public MEMELiveRoomAnchor bindRoomCode(String code) throws IOException, InterruptedException {
        var body = Map.of("code", code);
        var bodyStr = toJson(body);
        ScxHttpClientResponse request = this.request(POST, memeApi.BIND_ROOM_CODE_URL(), bodyStr);
        var str = request.body().toString();
        var jsonNode = ObjectUtils.jsonMapper().readTree(str);
        if (!jsonNode.get("ok").asBoolean()) {
            throw new RuntimeException(str);
        }
        var starInfo = jsonNode.get("data").get("starInfo");
        return ObjectUtils.convertValue(starInfo, MEMELiveRoomAnchor.class);
    }

    /**
     * 暂未用到
     *
     * @param code c
     * @return c
     * @throws IOException          c
     * @throws InterruptedException c
     */
    public String roomCodeStatus(String code) throws IOException, InterruptedException {
        var uri = URIBuilder.of(memeApi.ROOM_CODE_STATUS_URL()).addParam("code", code).toString();
        ScxHttpClientResponse request = this.request(GET, uri);
        return request.body().toString();
    }

    public String startCallBack(String roomID, String matchId) throws IOException, InterruptedException {
        var body = Map.of("liveRoomId", roomID, "matchId", matchId);
        var request = this.request(POST, memeApi.START_CALLBACK_URL(), toJson(body));
        return request.body().toString();
    }

    public String endCallBack(String roomID, String matchId) throws IOException, InterruptedException {
        var body = Map.of(
                "liveRoomId", roomID,
                "matchId", matchId,
                "atypical", 0,
                "reason", "正常结束",
                "gameResult", new Object(),
                "playerResult", new Object()
        );
        var request = this.request(POST, memeApi.END_CALLBACK_URL(), toJson(body));
        return request.body().toString();
    }

    public void callMessage(String jsonPayload) throws JsonProcessingException {
        var payload = ObjectUtils.jsonMapper().readValue(jsonPayload, MEMEWebSocketPayload.class);
        switch (payload.action) {
            case "enterRoom" -> callEnterRoom(payload);
            case "sendGift" -> callSendGift(payload);
            case "comment" -> callComment(payload);
            case "like" -> callLike(payload);
        }
    }

    private void callLike(MEMEWebSocketPayload payload) {
        var memeLike = ObjectUtils.convertValue(payload.data, MEMELike.class);
        memeLike.roomID = payload.roomId + "";
        this._callOnLike(memeLike);
    }

    private void callEnterRoom(MEMEWebSocketPayload payload) {
        var memeEnterRoom = ObjectUtils.convertValue(payload.data, MEMEEnterRoom.class);
        memeEnterRoom.roomID = payload.roomId + "";
        this._callOnUser(memeEnterRoom);
    }

    private void callComment(MEMEWebSocketPayload payload) {
        var memeChat = ObjectUtils.convertValue(payload.data, MEMEChat.class);
        memeChat.roomID = payload.roomId + "";
        this._callOnChat(memeChat);
    }

    private void callSendGift(MEMEWebSocketPayload payload) {
        var memeGift = ObjectUtils.convertValue(payload.data, MEMEGift.class);
        memeGift.roomID = payload.roomId + "";
        this._callOnGift(memeGift);
    }
    
    public void startWatch(String roomID) throws IOException, InterruptedException {
        if (watchTaskMap.get(roomID) == null) {
            var watchTask = new MEMEWatchTask(this, roomID);
            watchTaskMap.put(roomID, watchTask);
            watchTask.start();
        }
    }

    public void stopWatch(String roomID) throws IOException, InterruptedException {
        var watchTask = watchTaskMap.get(roomID);
        if (watchTask != null) {
            watchTask.stop();
            watchTaskMap.remove(roomID);
        }
    }

    public MEMEApi getMemeApi() {
        return memeApi;
    }

}
