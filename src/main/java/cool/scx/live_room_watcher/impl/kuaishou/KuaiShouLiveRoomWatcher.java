package cool.scx.live_room_watcher.impl.kuaishou;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.common.http_client.ScxHttpClientHelper;
import cool.scx.common.http_client.request_body.JsonBody;
import cool.scx.live_room_watcher.*;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouComment;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouGift;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouLike;
import cool.scx.common.util.ObjectUtils;
import cool.scx.common.util.URIBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.*;

/**
 * 快手官方
 */
public class KuaiShouLiveRoomWatcher extends  OfficialPassiveLiveRoomWatcher {

    private final String appID;
    private final String appSecret;
    private final KuaiShouAccessTokenManager accessTokenManager;

    public KuaiShouLiveRoomWatcher(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
        if (appID == null || appSecret == null) {
            throw new NullPointerException();
        }
        this.accessTokenManager=new KuaiShouAccessTokenManager(appID,appSecret);
    }


    @Override
    public LiveRoomInfo liveInfo(String tokenOrRoomID) throws IOException, InterruptedException {
        return null;
    }

    public KuaiShouTaskStartResult taskStart(String roomID, String roundId) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        map.put("roundId", roundId);
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(TASK_START_URL)
                .addParam("app_id", appID)
                .addParam("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouTaskStartResult.class);
    }

    public KuaiShouResponseBody taskStop(String roomID,  String roundId) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        map.put("roundId", roundId);
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(TASK_STOP_URL)
                .addParam("app_id", appID)
                .addParam("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    public KuaiShouResponseBody taskStatus(String roomID) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(TASK_STATUS_URL)
                .addParam("app_id", appID)
                .addParam("access_token", accessTokenManager.getAccessToken())
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
                .addParam("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouResponseBody.class);
    }

    @Override
    public void call(String bodyStr, Map<String, String> header, MsgType msgType) throws JsonProcessingException {
        var ksMessage = ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouMessage.class);
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
            this._callOnGift(gift);
        }
    }

    private void callComment(KuaiShouMessage ksMessage) {
        var comments = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouComment[]>() {});
        for (var comment : comments) {
            comment.message_id = ksMessage.message_id;
            comment.timestamp = ksMessage.timestamp;
            comment.roomID = ksMessage.data.room_code;
            comment.userInfo.roomID = ksMessage.data.room_code;
            this._callOnChat(comment);
        }
    }

    private void callLike(KuaiShouMessage ksMessage) {
        var likes = ObjectUtils.convertValue(ksMessage.data.payload, new TypeReference<KuaiShouLike[]>() {});
        for (var like : likes) {
            like.message_id = ksMessage.message_id;
            like.timestamp = ksMessage.timestamp;
            like.roomID = ksMessage.data.room_code;
            like.userInfo.roomID = ksMessage.data.room_code;
            this._callOnLike(like);
        }
    }

    public void startWatch(String roomID, String roundId) throws IOException, InterruptedException {
        taskStart(roomID, roundId);
    }

    public void stopWatch(String roomID, String roundId) throws IOException, InterruptedException {
        taskStop(roomID, roundId);
    }

    public String interactiveStart(String roomID,String roundId,String data) throws IOException, InterruptedException {
        var map = new HashMap<String, Object>();
        map.put("roomCode", roomID);
        map.put("timestamp", System.currentTimeMillis());
        map.put("roundId", roundId);
        map.put("type", "1");
        map.put("data", data);
        String sign = KuaiShouHelper.calcSign(map, appID, appSecret);
        map.put("callBackUrl", "");
        map.put("sign", sign);
        var url = URIBuilder.of(INTERACTIVE_START_URL)
                .addParam("app_id", appID)
                .addParam("access_token", accessTokenManager.getAccessToken())
                .toString();
        var response = ScxHttpClientHelper.post(url, new JsonBody(map));
        var bodyStr = response.body().toString();
        return bodyStr;
    }
    
}
