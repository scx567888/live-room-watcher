package cool.scx.live_room_watcher.impl.kuaishou;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.common.util.ObjectUtils;
import cool.scx.http.method.HttpMethod;
import cool.scx.http.x.ScxHttpClientHelper;
import cool.scx.http.uri.ScxURI;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouChat;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouGift;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouLike;

import java.io.IOException;
import java.util.HashMap;

import static cool.scx.http.method.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.*;

/**
 * 快手官方
 */
public class KuaiShouLiveRoomWatcher extends AbstractLiveRoomWatcher {

    private final String appID;
    private final String appSecret;
    private final KuaiShouAccessTokenManager accessTokenManager;

    public KuaiShouLiveRoomWatcher(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
        if (appID == null || appSecret == null) {
            throw new NullPointerException();
        }
        this.accessTokenManager = new KuaiShouAccessTokenManager(appID, appSecret);
    }

    public KuaiShouTaskStartResult taskStart(String roomID, String roundId) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        map.put("roundId", roundId);
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = ScxURI.of(TASK_START_URL)
                .addQuery("app_id", appID)
                .addQuery("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.request().method(POST).uri(url).send(map);
        var bodyStr = response.body().asString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouTaskStartResult.class);
    }

    public KuaiShouResponseBody taskStop(String roomID, String roundId) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        map.put("roundId", roundId);
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = ScxURI.of(TASK_STOP_URL)
                .addQuery("app_id", appID)
                .addQuery("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.request().method(POST).uri(url).send(map);
        var bodyStr = response.body().asString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    public KuaiShouResponseBody taskStatus(String roomID) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = ScxURI.of(TASK_STATUS_URL)
                .addQuery("app_id", appID)
                .addQuery("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.request().uri(url).method(POST).send(map);
        var bodyStr = response.body().asString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    public KuaiShouResponseBody topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomCode);
        map.put("timestamp", System.currentTimeMillis());
        map.put("giftList", String.join(",", secGiftIDList));
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = ScxURI.of(GIFT_TOP_URL)
                .addQuery("app_id", appID)
                .addQuery("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.request().uri(url).method(POST).send(map);
        var bodyStr = response.body().asString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    public void callGift(String bodyStr) throws JsonProcessingException {
        var ksMessage = ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouMessage.class);
        var gifts = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouGift[]>() {});
        for (var gift : gifts) {
            gift.message_id = ksMessage.message_id;
            gift.timestamp = ksMessage.timestamp;
            gift.roomID = ksMessage.data.room_code;
            gift.userInfo.roomID = ksMessage.data.room_code;
            this._callOnGift(gift);
        }
    }

    public void callChat(String bodyStr) throws JsonProcessingException {
        var ksMessage = ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouMessage.class);
        var comments = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouChat[]>() {});
        for (var comment : comments) {
            comment.message_id = ksMessage.message_id;
            comment.timestamp = ksMessage.timestamp;
            comment.roomID = ksMessage.data.room_code;
            comment.userInfo.roomID = ksMessage.data.room_code;
            this._callOnChat(comment);
        }
    }

    public void callLike(String bodyStr) throws JsonProcessingException {
        var ksMessage = ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouMessage.class);
        var likes = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouLike[]>() {});
        for (var like : likes) {
            like.message_id = ksMessage.message_id;
            like.timestamp = ksMessage.timestamp;
            like.roomID = ksMessage.data.room_code;
            like.userInfo.roomID = ksMessage.data.room_code;
            this._callOnLike(like);
        }
    }

    public String interactiveStart(String roomID, String roundId, String data) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        map.put("roundId", roundId);
        map.put("type", "1");
        map.put("data", data);
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = ScxURI.of(INTERACTIVE_START_URL)
                .addQuery("app_id", appID)
                .addQuery("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.request().uri(url).method(POST).send(map);
        return response.body().asString();
    }

}
