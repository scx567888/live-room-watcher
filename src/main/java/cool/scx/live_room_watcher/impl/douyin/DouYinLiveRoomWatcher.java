package cool.scx.live_room_watcher.impl.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.common.http_client.ScxHttpClientRequest;
import cool.scx.common.http_client.request_body.JsonBody;
import cool.scx.common.standard.HttpMethod;
import cool.scx.common.util.ObjectUtils;
import cool.scx.common.util.URIBuilder;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.MessageType;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinChat;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinGift;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinLike;

import java.io.IOException;
import java.util.Map;

import static cool.scx.common.http_client.ScxHttpClientHelper.request;
import static cool.scx.common.standard.HttpMethod.GET;
import static cool.scx.common.standard.HttpMethod.POST;
import static cool.scx.live_room_watcher.MessageType.*;
import static cool.scx.live_room_watcher.impl.douyin.DouYinApi.*;
import static cool.scx.live_room_watcher.impl.douyin.DouYinHelper.checkDouYinData;
import static cool.scx.live_room_watcher.impl.douyin.DouYinHelper.getMsgTypeValue;

/**
 * 官方的获取方式 需要在抖音进行回调时手动调用 {@link DouYinLiveRoomWatcher#call(String, Map, MessageType)}
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcher extends AbstractLiveRoomWatcher {

    public final Map<String, String> giftNameMap;
    private final String appID;
    private final String appSecret;
    private final String commentDataSecret;
    private final String giftDataSecret;
    private final String likeDataSecret;
    private final DouYinAccessTokenManager accessTokenManager;

    public DouYinLiveRoomWatcher(String appID, String appSecret, String commentDataSecret, String giftDataSecret, String likeDataSecret, Map<String, String> giftNameMap) {
        this.appID = appID;
        this.appSecret = appSecret;
        this.commentDataSecret = commentDataSecret;
        this.giftDataSecret = giftDataSecret;
        this.likeDataSecret = likeDataSecret;
        this.giftNameMap = giftNameMap;
        if (appID == null || appSecret == null || commentDataSecret == null || giftDataSecret == null || likeDataSecret == null || giftNameMap == null) {
            throw new RuntimeException();
        }
        this.accessTokenManager = new DouYinAccessTokenManager(appID, appSecret);
    }

    /**
     * 获取直播信息
     *
     * @param token token
     * @throws IOException          a
     * @throws InterruptedException a
     * @see <a href="https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo">https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo</a>
     */
    public DouYinWebcastMateInfo liveInfo(String token) throws IOException, InterruptedException {
        var response = request(
                new ScxHttpClientRequest()
                        .uri(WEBCAST_MATE_INFO_URL)
                        .method(POST)
                        .setHeader("X-Token", accessTokenManager.getAccessToken())
                        .body(new JsonBody(Map.of("token", token)))
        );
        var bodyStr = response.body().toString();
        var jsonNode = ObjectUtils.jsonMapper().readTree(bodyStr);
        var data = jsonNode.get("data");
        if (data == null) {
            throw new RuntimeException("webcastMateInfo 读取数据有误, 错误的 返回值 : " + bodyStr);
        }
        var info = data.get("info");
        if (info == null) {
            throw new RuntimeException("webcastMateInfo 读取数据有误, 错误的 返回值 : " + bodyStr);
        }
        return ObjectUtils.jsonMapper().convertValue(info, DouYinWebcastMateInfo.class);
    }

    public DouYinResponseBody taskStart(String roomID, MessageType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TASK_START_URL)
                .method(POST)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomID,
                        "appid", appID,
                        "msg_type", getMsgTypeValue(msgType)
                ))));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    public DouYinResponseBody taskStop(String roomCode, MessageType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TASK_STOP_URL)
                .method(POST)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomCode,
                        "appid", appID,
                        "msg_type", getMsgTypeValue(msgType)
                ))));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    public DouYinResponseBody taskStatus(String roomCode, MessageType msgType) throws IOException, InterruptedException {
        var uri = URIBuilder.of(TASK_STATUS_URL)
                .addParam("roomid", roomCode)
                .addParam("appid", appID)
                .addParam("msg_type", getMsgTypeValue(msgType))
                .build();

        var response = request(new ScxHttpClientRequest()
                .uri(uri)
                .method(HttpMethod.GET)
                .setHeader("access-token", accessTokenManager.getAccessToken()));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    public DouYinResponseBody failDataGet(String roomCode, MessageType msg_type, Integer page_num, Integer page_size) throws IOException, InterruptedException {
        var uri = URIBuilder.of(FAIL_DATA_GET_URL)
                .addParam("roomid", roomCode)
                .addParam("appid", appID)
                .addParam("msg_type", getMsgTypeValue(msg_type))
                .addParam("page_num", page_num)
                .addParam("page_size", page_size)
                .build();

        var response = request(new ScxHttpClientRequest()
                .uri(uri)
                .method(HttpMethod.GET)
                .setHeader("access-token", accessTokenManager.getAccessToken()));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    public DouYinResponseBody topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TOP_GIFT_URL)
                .method(POST)
                .setHeader("x-token", accessTokenManager.getAccessToken())
                .body(new JsonBody(Map.of(
                        "room_id", roomCode,
                        "app_id", appID,
                        "sec_gift_id_list", secGiftIDList
                ))));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    public DouYinResponseBody fansClubGetInfo(String roomCode, String anchor_openid, String[] user_openids) throws IOException, InterruptedException {
        var uri = URIBuilder.of(FANS_CLUB_GET_INFO_URL)
                .addParam("roomid", roomCode)
                .addParam("anchor_openid", anchor_openid)
                .addParam("user_openids", String.join(",", user_openids))
                .build();
        var response = request(
                new ScxHttpClientRequest()
                        .uri(uri)
                        .method(GET)
                        .setHeader("access-token", accessTokenManager.getAccessToken())
        );
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    public void taskStartAll(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, CHAT);
        taskStart(roomID, GIFT);
        taskStart(roomID, LIKE);
        taskStart(roomID, FANS_CLUB);
    }

    public void taskStopAll(String roomID) throws IOException, InterruptedException {
        taskStop(roomID, CHAT);
        taskStop(roomID, GIFT);
        taskStop(roomID, LIKE);
        taskStop(roomID, FANS_CLUB);
    }

    /**
     * 当收到回调时请调用 此方法
     *
     * @param bodyStr body
     * @param header  请求头
     * @param msgType 类型
     */
    public void call(String bodyStr, Map<String, String> header, MessageType msgType) throws JsonProcessingException {
        switch (msgType) {
            case GIFT -> _callGift(bodyStr, header);
            case LIKE -> _callLike(bodyStr, header);
            case CHAT -> _callChat(bodyStr, header);
            case FANS_CLUB -> {
            }
        }
    }

    private void _callChat(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, commentDataSecret);
        var commentList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinChat[]>() {});
        for (var comment : commentList) {
            comment.roomID = roomID;
            this._callOnChat(comment);
        }
    }

    private void _callLike(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, likeDataSecret);
        var likeList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinLike[]>() {});
        for (var like : likeList) {
            like.roomID = roomID;
            this._callOnLike(like);
        }
    }

    private void _callGift(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, giftDataSecret);
        var giftList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinGift[]>() {});
        for (var gift : giftList) {
            gift.gift_name = giftNameMap.get(gift.sec_gift_id);
            gift.roomID = roomID;
            this._callOnGift(gift);
        }
    }

}
