package cool.scx.live_room_watcher.impl.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.standard.HttpMethod;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.MsgType;
import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinComment;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinGift;
import cool.scx.live_room_watcher.impl.douyin.message.DouYinLike;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;

import java.io.IOException;
import java.util.Map;

import static cool.scx.standard.HttpMethod.GET;
import static cool.scx.standard.HttpMethod.POST;
import static cool.scx.http_client.ScxHttpClientHelper.request;
import static cool.scx.live_room_watcher.MsgType.*;
import static cool.scx.live_room_watcher.impl.douyin.DouYinApi.*;
import static cool.scx.live_room_watcher.impl.douyin.DouYinHelper.checkDouYinData;
import static cool.scx.live_room_watcher.impl.douyin.DouYinHelper.getMsgTypeValue;

/**
 * 官方的获取方式 需要在抖音进行回调时手动调用 {@link DouYinLiveRoomWatcher#call(String, Map, MsgType)}
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcher extends OfficialPassiveLiveRoomWatcher {

    public final Map<String, String> giftNameMap;
    private final String appID;
    private final String appSecret;
    private final String commentDataSecret;
    private final String giftDataSecret;
    private final String likeDataSecret;

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
    }

    @Override
    public DouYinAccessToken getAccessToken0() throws IOException, InterruptedException {
        var response = ScxHttpClientHelper.request(new ScxHttpClientRequest()
                .uri(ACCESS_TOKEN_URL)
                .method(POST)
                .body(new JsonBody(Map.of(
                        "appid", appID,
                        "secret", appSecret,
                        "grant_type", "client_credential"
                ))));
        var bodyStr = response.body().toString();
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
        if (accessTokenResult.err_no() != 0) {
            throw new IllegalArgumentException(bodyStr);
        }
        return ObjectUtils.convertValue(accessTokenResult.data(), DouYinAccessToken.class);
    }

    /**
     * 获取直播信息
     *
     * @param token token
     * @throws IOException          a
     * @throws InterruptedException a
     * @see <a href="https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo">https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo</a>
     */
    @Override
    public DouYinWebcastMateInfo liveInfo(String token) throws IOException, InterruptedException {
        var response = request(
                new ScxHttpClientRequest()
                        .uri(WEBCAST_MATE_INFO_URL)
                        .method(POST)
                        .setHeader("X-Token", getAccessToken())
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

    @Override
    public DouYinResponseBody taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TASK_START_URL)
                .method(POST)
                .setHeader("access-token", getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomID,
                        "appid", appID,
                        "msg_type", getMsgTypeValue(msgType)
                ))));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    @Override
    public DouYinResponseBody taskStop(String roomCode, MsgType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TASK_STOP_URL)
                .method(POST)
                .setHeader("access-token", getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomCode,
                        "appid", appID,
                        "msg_type", getMsgTypeValue(msgType)
                ))));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    @Override
    public DouYinResponseBody taskStatus(String roomCode, MsgType msgType) throws IOException, InterruptedException {
        var uri = URIBuilder.of(TASK_STATUS_URL)
                .addParam("roomid", roomCode)
                .addParam("appid", appID)
                .addParam("msg_type", getMsgTypeValue(msgType))
                .build();

        var response = request(new ScxHttpClientRequest()
                .uri(uri)
                .method(HttpMethod.GET)
                .setHeader("access-token", getAccessToken()));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    @Override
    public DouYinResponseBody failDataGet(String roomCode, MsgType msg_type, Integer page_num, Integer page_size) throws IOException, InterruptedException {
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
                .setHeader("access-token", getAccessToken()));
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    @Override
    public DouYinResponseBody topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TOP_GIFT_URL)
                .method(POST)
                .setHeader("x-token", getAccessToken())
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
                        .setHeader("access-token", getAccessToken())
        );
        var bodyStr = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
    }

    @Override
    public void startWatch(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, LIVE_COMMENT);
        taskStart(roomID, LIVE_GIFT);
        taskStart(roomID, LIVE_LIKE);
        taskStart(roomID, LIVE_FANS_CLUB);
    }

    @Override
    public void stopWatch(String roomID) throws IOException, InterruptedException {
        taskStop(roomID, LIVE_COMMENT);
        taskStop(roomID, LIVE_GIFT);
        taskStop(roomID, LIVE_LIKE);
        taskStop(roomID, LIVE_FANS_CLUB);
    }

    /**
     * 当收到回调时请调用 此方法
     *
     * @param bodyStr body
     * @param header  请求头
     * @param msgType 类型
     */
    @Override
    public void call(String bodyStr, Map<String, String> header, MsgType msgType) {
        Thread.ofVirtual().start(() -> call0(bodyStr, header, msgType));
    }

    public void call0(String bodyStr, Map<String, String> header, MsgType msgType) {
        try {
            switch (msgType) {
                case LIVE_GIFT -> callGift(bodyStr, header);
                case LIVE_LIKE -> callLike(bodyStr, header);
                case LIVE_COMMENT -> callComment(bodyStr, header);
                case LIVE_FANS_CLUB -> {
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void callComment(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, commentDataSecret);
        var commentList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinComment[]>() {});
        for (var comment : commentList) {
            comment.roomID = roomID;
            Thread.ofVirtual().start(() -> this.chatHandler.accept(comment));
        }
    }

    private void callLike(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, likeDataSecret);
        var likeList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinLike[]>() {});
        for (var like : likeList) {
            like.roomID = roomID;
            Thread.ofVirtual().start(() -> this.likeHandler.accept(like));
        }
    }

    private void callGift(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        var roomID = header.get("x-roomid");
        checkDouYinData(bodyStr, header, giftDataSecret);
        var giftList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<DouYinGift[]>() {});
        for (var gift : giftList) {
            gift.gift_name = giftNameMap.get(gift.sec_gift_id);
            gift.roomID = roomID;
            Thread.ofVirtual().start(() -> this.giftHandler.accept(gift));
        }
    }

}
