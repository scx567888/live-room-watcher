package cool.scx.live_room_watcher.impl.cc;

import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.enumeration.HttpMethod;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.cc.message.CCComment;
import cool.scx.live_room_watcher.impl.cc.message.CCGift;
import cool.scx.live_room_watcher.impl.cc.message.CCLike;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;

import java.io.IOException;
import java.util.Map;

import static cool.scx.enumeration.HttpMethod.GET;
import static cool.scx.enumeration.HttpMethod.POST;
import static cool.scx.http_client.ScxHttpClientHelper.request;
import static cool.scx.live_room_watcher.OfficialLiveRoomWatcher.MsgType.*;
import static cool.scx.live_room_watcher.impl.cc.CCApi.*;
import static cool.scx.live_room_watcher.impl.cc.CCHelper.*;
import static cool.scx.util.ScxExceptionHelper.wrap;

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
    }

    @Override
    protected CCAccessTokenResult getAccessToken0() throws IOException, InterruptedException {
        var response = ScxHttpClientHelper.request(new ScxHttpClientRequest()
                .uri(test ? TEST_ACCESS_TOKEN_URL : ACCESS_TOKEN_URL)
                .method(POST)
                .body(new JsonBody(Map.of(
                        "appid", appID,
                        "secret", appSecret,
                        "grant_type", "client_credential"
                ))));
        var bodyStr = response.body().toString();
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, CCAccessTokenResult.class);
        if (accessTokenResult.err_no() != 0) {
            throw new IllegalArgumentException(bodyStr);
        }
        return accessTokenResult;
    }

    /**
     * 获取直播信息
     *
     * @param roomID token
     * @throws IOException          a
     * @throws InterruptedException a
     * @see <a href="https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo">https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo</a>
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
                        .setHeader("access-token", getAccessToken())
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
                .setHeader("access-token", getAccessToken())
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
                .setHeader("access-token", getAccessToken())
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
                .setHeader("access-token", getAccessToken()));
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
                .setHeader("access-token", getAccessToken()));
        return response.body().toString();
    }


    @Override
    public String topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(test ? TEST_TOP_GIFT_URL : TOP_GIFT_URL)
                .method(POST)
                .setHeader("x-token", getAccessToken())
                .body(new JsonBody(Map.of(
                        "room_id", roomCode,
                        "app_id", appID,
                        "sec_gift_id_list", secGiftIDList
                ))));
        return response.body().toString();
    }

    @Override
    public void startWatch(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, LIVE_COMMENT);
        taskStart(roomID, LIVE_GIFT);
        taskStart(roomID, LIVE_LIKE);
    }

    @Override
    public void stopWatch(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, LIVE_COMMENT);
        taskStart(roomID, LIVE_GIFT);
        taskStart(roomID, LIVE_LIKE);
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
        switch (msgType) {
            case LIVE_GIFT -> callGift(bodyStr, header);
            case LIVE_LIKE -> callLike(bodyStr, header);
            case LIVE_COMMENT -> callComment(bodyStr, header);
            case LIVE_FANS_CLUB -> {
            }
        }
    }

    private void callComment(String bodyStr, Map<String, String> header) {
        checkCCData(bodyStr, header, commentDataSecret);
        var roomID = header.get("x-roomid");
        var commentList = wrap(() -> ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<CCComment[]>() {}));
        for (var comment : commentList) {
            comment.roomID = roomID;
            Thread.ofVirtual().start(() -> this.chatHandler.accept(comment));
        }
    }

    private void callLike(String bodyStr, Map<String, String> header) {
        checkCCData(bodyStr, header, likeDataSecret);
        var roomID = header.get("x-roomid");
        var likeList = wrap(() -> ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<CCLike[]>() {}));
        for (var like : likeList) {
            like.roomID = roomID;
            Thread.ofVirtual().start(() -> this.likeHandler.accept(like));
        }
    }

    private void callGift(String bodyStr, Map<String, String> header) {
        checkCCData(bodyStr, header, giftDataSecret);
        var roomID = header.get("x-roomid");
        var giftList = wrap(() -> ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<CCGift[]>() {}));
        for (var gift : giftList) {
            gift.giftName = getGiftName(gift.sec_gift_id);
            gift.roomID = roomID;
            Thread.ofVirtual().start(() -> this.giftHandler.accept(gift));
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

    public record CCAccessTokenResult(Integer err_no, String err_tips,
                                      AccessTokenResultData data) implements AccessToken {

        @Override
        public String accessToken() {
            return data().access_token();
        }

        @Override
        public Long expiresIn() {
            return data().expires_in();
        }

        record AccessTokenResultData(String access_token, Long expires_in) {

        }

    }

}
