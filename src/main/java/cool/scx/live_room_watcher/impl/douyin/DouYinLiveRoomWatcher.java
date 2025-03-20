package cool.scx.live_room_watcher.impl.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.common.util.ObjectUtils;
import cool.scx.http.media_type.ScxMediaType;
import cool.scx.http.method.HttpMethod;
import cool.scx.http.uri.ScxURI;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinChat;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinGift;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinLike;

import java.io.IOException;
import java.util.Map;

import static cool.scx.common.util.ObjectUtils.toJson;
import static cool.scx.http.method.HttpMethod.GET;
import static cool.scx.http.method.HttpMethod.POST;
import static cool.scx.http.media_type.MediaType.APPLICATION_JSON;
import static cool.scx.http.x.ScxHttpClientHelper.request;
import static cool.scx.live_room_watcher.impl.douyin.DouYinApi.*;
import static cool.scx.live_room_watcher.impl.douyin.DouYinHelper.checkDouYinData;
import static cool.scx.live_room_watcher.impl.douyin.DouYinMsgType.*;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 官方的获取方式 需要在抖音进行回调时手动调用 call xxx }
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
        var response = request()
                        .uri(WEBCAST_MATE_INFO_URL)
                        .method(POST)
                        .setHeader("X-Token", accessTokenManager.getAccessToken())
                        .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
                        .send(toJson(Map.of("token", token)));
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

    public DouYinResponseBody taskStart(String roomID, DouYinMsgType msgType) throws IOException, InterruptedException {
        var response = request()
                .uri(TASK_START_URL)
                .method(POST)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .send(Map.of(
                        "roomid", roomID,
                        "appid", appID,
                        "msg_type", msgType.value()
                ));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    public DouYinResponseBody taskStop(String roomCode, DouYinMsgType msgType) throws IOException, InterruptedException {
        var response = request()
                .uri(TASK_STOP_URL)
                .method(POST)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .send(Map.of(
                        "roomid", roomCode,
                        "appid", appID,
                        "msg_type", msgType.value()
                ));
        return response.body().asObject(DouYinResponseBody.class);
    }

    public DouYinResponseBody taskStatus(String roomCode, DouYinMsgType msgType) throws IOException, InterruptedException {
        var uri = ScxURI.of(TASK_STATUS_URL)
                .addQuery("roomid", roomCode)
                .addQuery("appid", appID)
                .addQuery("msg_type", msgType.value());

        var response = request()
                .uri(uri)
                .method(GET)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .send();
        return response.body().asObject(DouYinResponseBody.class);
    }

    public DouYinResponseBody failDataGet(String roomCode, DouYinMsgType msg_type, Integer page_num, Integer page_size) throws IOException, InterruptedException {
        var uri = ScxURI.of(FAIL_DATA_GET_URL)
                .addQuery("roomid", roomCode)
                .addQuery("appid", appID)
                .addQuery("msg_type", msg_type.value())
                .addQuery("page_num", page_num)
                .addQuery("page_size", page_size);

        var response = request()
                .uri(uri)
                .method(GET)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .send();
        
        return response.body().asObject(DouYinResponseBody.class);
    }

    public DouYinResponseBody topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var response = request()
                .uri(TOP_GIFT_URL)
                .method(POST)
                .setHeader("x-token", accessTokenManager.getAccessToken())
                .send(Map.of(
                        "room_id", roomCode,
                        "app_id", appID,
                        "sec_gift_id_list", secGiftIDList
                ));
        return response.body().asObject(DouYinResponseBody.class);
    }

    public DouYinResponseBody fansClubGetInfo(String roomCode, String anchor_openid, String[] user_openids) throws IOException, InterruptedException {
        var uri = ScxURI.of(FANS_CLUB_GET_INFO_URL)
                .addQuery("roomid", roomCode)
                .addQuery("anchor_openid", anchor_openid)
                .addQuery("user_openids", String.join(",", user_openids));
        
        var response = request()
                        .uri(uri)
                        .method(GET)
                        .setHeader("access-token", accessTokenManager.getAccessToken())
                        .send();
        return response.body().asObject(DouYinResponseBody.class);
    }

    public void taskStartAll(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, LIVE_COMMENT);
        taskStart(roomID, LIVE_GIFT);
        taskStart(roomID, LIVE_LIKE);
        taskStart(roomID, LIVE_FANSCLUB);
    }

    public void taskStopAll(String roomID) throws IOException, InterruptedException {
        taskStop(roomID, LIVE_COMMENT);
        taskStop(roomID, LIVE_GIFT);
        taskStop(roomID, LIVE_LIKE);
        taskStop(roomID, LIVE_FANSCLUB);
    }

    /**
     * 当收到回调时请调用 此方法
     *
     * @param bodyStr body
     * @param header  请求头
     */
    public void callChat(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, commentDataSecret);
        var commentList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinChat[]>() {});
        for (var comment : commentList) {
            comment.roomID = roomID;
            this._callOnChat(comment);
        }
    }

    /**
     * 当收到回调时请调用 此方法
     *
     * @param bodyStr body
     * @param header  请求头
     */
    public void callLike(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, likeDataSecret);
        var likeList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinLike[]>() {});
        for (var like : likeList) {
            like.roomID = roomID;
            this._callOnLike(like);
        }
    }

    /**
     * 当收到回调时请调用 此方法
     *
     * @param bodyStr body
     * @param header  请求头
     */
    public void callGift(String bodyStr, Map<String, String> header) throws JsonProcessingException {
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
