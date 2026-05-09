package cool.scx.live_room_watcher.impl.kuaishou;

import dev.scx.format.FormatToNodeException;
import dev.scx.http.media_type.ScxMediaType;
import dev.scx.http.uri.ScxURI;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouChat;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouGift;
import cool.scx.live_room_watcher.impl.kuaishou.message.KuaiShouLike;
import dev.scx.http.x.HttpClient;
import dev.scx.object.NodeToObjectException;

import java.io.IOException;
import java.util.HashMap;

import static dev.scx.http.media_type.MediaType.APPLICATION_JSON;
import static dev.scx.http.method.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.*;
import static dev.scx.serialize.ScxSerialize.*;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 快手官方
 */
public class KuaiShouLiveRoomWatcher extends AbstractLiveRoomWatcher {

    private final String appID;
    private final String appSecret;
    private final KuaiShouAccessTokenManager accessTokenManager;
    private final HttpClient httpClient;

    public KuaiShouLiveRoomWatcher(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
        if (appID == null || appSecret == null) {
            throw new NullPointerException();
        }
        this.accessTokenManager = new KuaiShouAccessTokenManager(appID, appSecret);
        this.httpClient=new HttpClient();
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

        var reqBody=toJson(map);

        var response = httpClient.request()
            .method(POST)
            .uri(url)
            .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
            .send(reqBody);

        var resBody = response.asString();

        return fromJson(resBody, KuaiShouTaskStartResult.class);
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

        var reqBody=toJson(map);

        var response = httpClient.request()
            .method(POST)
            .uri(url)
            .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
            .send(reqBody);

        var resBody = response.asString();

        return fromJson(resBody, KuaiShouResponseBody.class);
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

        var reqBody=toJson(map);

        var response = httpClient.request()
            .uri(url)
            .method(POST)
            .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
            .send(reqBody);

        var resBody = response.asString();

        return fromJson(resBody, KuaiShouResponseBody.class);
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

        var reqBody=toJson(map);

        var response = httpClient.request()
            .uri(url)
            .method(POST)
            .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
            .send(reqBody);

        var resBody = response.asString();

        return fromJson(resBody, KuaiShouResponseBody.class);
    }

    public void callGift(String bodyStr) throws FormatToNodeException, NodeToObjectException {
        var ksMessage = fromJson(bodyStr, KuaiShouMessage.class);
        var gifts = convertObject(ksMessage.data.payload, KuaiShouGift[].class);
        for (var gift : gifts) {
            gift.message_id = ksMessage.message_id;
            gift.timestamp = ksMessage.timestamp;
            gift.roomID = ksMessage.data.room_code;
            gift.userInfo.roomID = ksMessage.data.room_code;
            this._callOnGift(gift);
        }
    }

    public void callChat(String bodyStr) throws FormatToNodeException, NodeToObjectException {
        var ksMessage = fromJson(bodyStr, KuaiShouMessage.class);
        var comments = convertObject(ksMessage.data.payload, KuaiShouChat[].class);
        for (var comment : comments) {
            comment.message_id = ksMessage.message_id;
            comment.timestamp = ksMessage.timestamp;
            comment.roomID = ksMessage.data.room_code;
            comment.userInfo.roomID = ksMessage.data.room_code;
            this._callOnChat(comment);
        }
    }

    public void callLike(String bodyStr) throws FormatToNodeException, NodeToObjectException {
        var ksMessage = fromJson(bodyStr, KuaiShouMessage.class);
        var likes = convertObject(ksMessage.data.payload, KuaiShouLike[].class);
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

        var reqBody=toJson(map);

        var response = httpClient.request()
            .uri(url)
            .method(POST)
            .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
            .send(reqBody);

        return response.asString();
    }

}
