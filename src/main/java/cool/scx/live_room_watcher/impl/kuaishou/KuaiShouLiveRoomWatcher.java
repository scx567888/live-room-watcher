package cool.scx.live_room_watcher.impl.kuaishou;

import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.body.FormData;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.AccessToken;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.MsgType;
import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouComment;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouGift;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouLike;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cool.scx.enumeration.HttpMethod.POST;
import static cool.scx.live_room_watcher.MsgType.LIVE_COMMENT;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.*;
import static cool.scx.util.ScxExceptionHelper.wrap;

/**
 * 快手官方
 */
public class KuaiShouLiveRoomWatcher extends OfficialPassiveLiveRoomWatcher {

    private final String appID;
    private final String appSecret;

    public KuaiShouLiveRoomWatcher(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
        if (appID == null || appSecret == null) {
            throw new NullPointerException();
        }
    }

    @Override
    protected AccessToken getAccessToken0() throws IOException, InterruptedException {
        var response = ScxHttpClientHelper.request(new ScxHttpClientRequest()
                .uri(ACCESS_TOKEN_URL)
                .method(POST)
                .body(new FormData()
                        .attribute("app_id", appID)
                        .attribute("app_secret", appSecret)
                        .attribute("grant_type", "client_credentials")
                ));
        var bodyStr = response.body().toString();
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouAccessToken.class);
        if (accessTokenResult.result != 1) {
            throw new IllegalArgumentException(bodyStr);
        }
        System.err.println("获取 accessToken 成功 : " + accessTokenResult.accessToken());
        return accessTokenResult;
    }

    @Override
    public LiveRoomInfo liveInfo(String tokenOrRoomID) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public KuaiShouTaskStartResult taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(TASK_START_URL)
                .addParam("app_id", appID)
                .addParam("access_token", getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouTaskStartResult.class);
    }

    @Override
    public KuaiShouResponseBody taskStop(String roomID, MsgType msgType) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(TASK_STOP_URL)
                .addParam("app_id", appID)
                .addParam("access_token", getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    @Override
    public KuaiShouResponseBody taskStatus(String roomID, MsgType msgType) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(TASK_STATUS_URL)
                .addParam("app_id", appID)
                .addParam("access_token", getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    @Override
    public String failDataGet(String roomID, MsgType msgType, Integer pageNum, Integer pageSize) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public KuaiShouResponseBody topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomCode);
        map.put("timestamp", System.currentTimeMillis());
        map.put("giftList", String.join(",", secGiftIDList));
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(GIFT_TOP_URL)
                .addParam("app_id", appID)
                .addParam("access_token", getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    @Override
    public void call(String bodyStr, Map<String, String> header, MsgType msgType) {
        Thread.ofVirtual().start(() -> call0(bodyStr, header, msgType));
    }

    public void call0(String bodyStr, Map<String, String> header, MsgType msgType) {
        var ksMessage = wrap(() -> ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouMessage.class));
        switch (msgType) {
            case LIVE_LIKE -> callLike(ksMessage);
            case LIVE_COMMENT -> callComment(ksMessage);
            case LIVE_GIFT -> callGift(ksMessage);
        }
    }

    private void callGift(KuaiShouMessage ksMessage) {
        var gifts = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouGift[]>() {});
        for (var gift : gifts) {
            gift.message_id = ksMessage.message_id;
            gift.timestamp = ksMessage.timestamp;
            gift.roomID = ksMessage.data.room_code;
            gift.userInfo.roomID = ksMessage.data.room_code;
            Thread.ofVirtual().start(() -> this.giftHandler.accept(gift));
        }
    }

    private void callComment(KuaiShouMessage ksMessage) {
        var comments = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouComment[]>() {});
        for (var comment : comments) {
            comment.message_id = ksMessage.message_id;
            comment.timestamp = ksMessage.timestamp;
            comment.roomID = ksMessage.data.room_code;
            comment.userInfo.roomID = ksMessage.data.room_code;
            Thread.ofVirtual().start(() -> this.chatHandler.accept(comment));
        }
    }

    private void callLike(KuaiShouMessage ksMessage) {
        var likes = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouLike[]>() {});
        for (var like : likes) {
            like.message_id = ksMessage.message_id;
            like.timestamp = ksMessage.timestamp;
            like.roomID = ksMessage.data.room_code;
            like.userInfo.roomID = ksMessage.data.room_code;
            Thread.ofVirtual().start(() -> this.likeHandler.accept(like));
        }
    }

    @Override
    public void startWatch(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, LIVE_COMMENT);
    }

    @Override
    public void stopWatch(String roomID) throws IOException, InterruptedException {
        taskStop(roomID, LIVE_COMMENT);
    }

}
