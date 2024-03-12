package cool.scx.live_room_watcher.impl.cc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.BaseLiveRoomWatcher;
import cool.scx.live_room_watcher.MsgType;
import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.cc.message.CCComment;
import cool.scx.live_room_watcher.impl.cc.message.CCGift;
import cool.scx.live_room_watcher.impl.cc.message.CCLike;
import cool.scx.standard.HttpMethod;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;

import java.io.IOException;
import java.util.Map;

import static cool.scx.http_client.ScxHttpClientHelper.request;
import static cool.scx.live_room_watcher.MsgType.*;
import static cool.scx.live_room_watcher.impl.cc.CCApi.*;
import static cool.scx.live_room_watcher.impl.cc.CCHelper.*;
import static cool.scx.standard.HttpMethod.GET;
import static cool.scx.standard.HttpMethod.POST;

/**
 * 网易 CC 官方的获取方式 需要在 CC 进行回调时手动调用 {@link CCLiveRoomWatcher#call(String, Map, MsgType)}
 *
 * @author scx567888
 * @version 0.0.1
 */
public class CCLiveRoomWatcher extends OfficialPassiveLiveRoomWatcher {

    private final String appID;
    private final String appSecret;
    private final String commentDataSecret;
    private final String giftDataSecret;
    private final String likeDataSecret;
    private final Map<String, String> giftAndNameMap;
    private final CCAccessTokenManager accessTokenManager;

    private boolean test = false;

    public CCLiveRoomWatcher(String appID, String appSecret, String commentDataSecret, String giftDataSecret, String likeDataSecret) {
        this(appID, appSecret, commentDataSecret, giftDataSecret, likeDataSecret, DEFAULT_CC_GIFT_AND_NAME_MAP);
    }

    public CCLiveRoomWatcher(String appID, String appSecret, String commentDataSecret, String giftDataSecret, String likeDataSecret, Map<String, String> giftAndNameMap) {
        this.appID = appID;
        this.appSecret = appSecret;
        this.commentDataSecret = commentDataSecret;
        this.giftDataSecret = giftDataSecret;
        this.likeDataSecret = likeDataSecret;
        this.giftAndNameMap = giftAndNameMap;
        if (appID == null || appSecret == null || commentDataSecret == null || giftDataSecret == null || likeDataSecret == null || giftAndNameMap == null) {
            throw new RuntimeException();
        }
        this.accessTokenManager = new CCAccessTokenManager(appID, appSecret, this);
    }


    /**
     * 获取直播信息
     *
     * @param roomID token
     */
    @Override
    public CCLiveInfo liveInfo(String roomID) throws IOException, InterruptedException {
        var uri = URIBuilder.of(test ? TEST_LIVE_INFO_URL : LIVE_INFO_URL)
                .addParam("roomid", roomID)
                .addParam("appid", appID).build();
        var response = request(
                new ScxHttpClientRequest()
                        .uri(uri)
                        .method(GET)
                        .setHeader("access-token", accessTokenManager.getAccessToken())
        );
        var bodyStr = response.body().toString();
        var jsonNode = ObjectUtils.jsonMapper().readTree(bodyStr);
        var data = jsonNode.get("data");
        if (data == null) {
            throw new RuntimeException("webcastMateInfo 读取数据有误, 错误的 返回值 : " + bodyStr);
        }
        return ObjectUtils.jsonMapper().convertValue(data, CCLiveInfo.class);
    }

    @Override
    public String taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(test ? TEST_TASK_START_URL : TASK_START_URL)
                .method(POST)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomID,
                        "appid", appID,
                        "msg_type", getMsgTypeValue(msgType)
                ))));
        return response.body().toString();
    }

    @Override
    public String taskStop(String roomCode, MsgType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(test ? TEST_TASK_STOP_URL : TASK_STOP_URL)
                .method(POST)
                .setHeader("access-token", accessTokenManager.getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomCode,
                        "appid", appID,
                        "msg_type", getMsgTypeValue(msgType)
                ))));
        return response.body().toString();
    }

    @Override
    public String taskStatus(String roomCode, MsgType msgType) throws IOException, InterruptedException {
        var uri = URIBuilder.of(test ? TEST_TASK_STATUS_URL : TASK_STATUS_URL)
                .addParam("roomid", roomCode)
                .addParam("appid", appID)
                .addParam("msg_type", getMsgTypeValue(msgType))
                .build();

        var response = request(new ScxHttpClientRequest()
                .uri(uri)
                .method(HttpMethod.GET)
                .setHeader("access-token", accessTokenManager.getAccessToken()));
        return response.body().toString();
    }

    @Override
    public String failDataGet(String roomCode, MsgType msgType, Integer page_num, Integer page_size) throws IOException, InterruptedException {
        var uri = URIBuilder.of(test ? TEST_FAIL_DATA_GET_URL : FAIL_DATA_GET_URL)
                .addParam("roomid", roomCode)
                .addParam("appid", appID)
                .addParam("msg_type", getMsgTypeValue(msgType))
                .addParam("page_num", page_num)
                .addParam("page_size", page_size)
                .build();

        var response = request(new ScxHttpClientRequest()
                .uri(uri)
                .method(HttpMethod.GET)
                .setHeader("access-token", accessTokenManager.getAccessToken()));
        return response.body().toString();
    }


    @Override
    public String topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(test ? TEST_TOP_GIFT_URL : TOP_GIFT_URL)
                .method(POST)
                .setHeader("x-token", accessTokenManager.getAccessToken())
                .body(new JsonBody(Map.of(
                        "room_id", roomCode,
                        "app_id", appID,
                        "sec_gift_id_list", secGiftIDList
                ))));
        return response.body().toString();
    }

    public void startWatch(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, LIVE_COMMENT);
        taskStart(roomID, LIVE_GIFT);
        taskStart(roomID, LIVE_LIKE);
    }
    
    public void stopWatch(String roomID) throws IOException, InterruptedException {
        taskStop(roomID, LIVE_COMMENT);
        taskStop(roomID, LIVE_GIFT);
        taskStop(roomID, LIVE_LIKE);
    }

    /**
     * 当收到回调时请调用 此方法
     *
     * @param bodyStr body
     * @param header  请求头
     * @param msgType 类型
     */
    @Override
    public void call(String bodyStr, Map<String, String> header, MsgType msgType) throws JsonProcessingException {
        switch (msgType) {
            case LIVE_GIFT -> _callGift(bodyStr, header);
            case LIVE_LIKE -> _callLike(bodyStr, header);
            case LIVE_COMMENT -> _callComment(bodyStr, header);
            case LIVE_FANS_CLUB -> {
            }
        }
    }

    private void _callComment(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        checkCCData(bodyStr, header, commentDataSecret);
        var roomID = header.get("x-roomid");
        var commentList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<CCComment[]>() {});
        for (var comment : commentList) {
            comment.roomID = roomID;
            this._callOnChat(comment);
        }
    }

    private void _callLike(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        checkCCData(bodyStr, header, likeDataSecret);
        var roomID = header.get("x-roomid");
        var likeList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<CCLike[]>() {});
        for (var like : likeList) {
            like.roomID = roomID;
            this._callOnLike(like);
        }
    }

    private void _callGift(String bodyStr, Map<String, String> header) throws JsonProcessingException {
        checkCCData(bodyStr, header, giftDataSecret);
        var roomID = header.get("x-roomid");
        var giftList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<CCGift[]>() {});
        for (var gift : giftList) {
            gift.giftName = getGiftName(gift.sec_gift_id);
            gift.roomID = roomID;
            this._callOnGift(gift);
        }
    }

    public boolean getTest() {
        return this.test;
    }

    public CCLiveRoomWatcher setTest(boolean t) {
        this.test = t;
        return this;
    }

    private String getGiftName(String secGiftId) {
        return giftAndNameMap.get(secGiftId);
    }

}
