package cool.scx.live_room_watcher.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import cool.scx.enumeration.HttpMethod;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.MsgType;
import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;

import java.io.IOException;
import java.util.Map;

import static cool.scx.enumeration.HttpMethod.POST;
import static cool.scx.http_client.ScxHttpClientHelper.request;
import static cool.scx.live_room_watcher.douyin.DouYinApi.*;
import static cool.scx.live_room_watcher.douyin.DouYinHelper.checkData;

/**
 * 官方的获取方式 需要在抖音进行回调时手动调用 {@link DouYinLiveRoomWatcher#call(String, Map, MsgType)}
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcher extends OfficialPassiveLiveRoomWatcher {

    private final String appID;
    private final String appSecret;
    private final String commentDataSecret;
    private final String giftDataSecret;
    private final String likeDataSecret;

    public DouYinLiveRoomWatcher(String appID, String appSecret, String commentDataSecret, String giftDataSecret, String likeDataSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
        this.commentDataSecret = commentDataSecret;
        this.giftDataSecret = giftDataSecret;
        this.likeDataSecret = likeDataSecret;
        if (appID == null || appSecret == null || commentDataSecret == null || giftDataSecret == null || likeDataSecret == null) {
            throw new RuntimeException();
        }
    }

    private static String getMsgTypeValue(MsgType msgType) {
        return switch (msgType) {
            case LIVE_COMMENT -> "live_comment";
            case LIVE_GIFT -> "live_gift";
            case LIVE_LIKE -> "live_like";
            case LIVE_FANS_CLUB -> "live_fansclub";
        };
    }

    @Override
    protected AccessTokenResult getAccessToken0() throws IOException, InterruptedException {
        var response = ScxHttpClientHelper.request(new ScxHttpClientRequest()
                .uri(ACCESS_TOKEN_URL)
                .method(POST)
                .body(new JsonBody(Map.of(
                        "appid", appID,
                        "secret", appSecret,
                        "grant_type", "client_credential"
                ))));
        var bodyStr = response.body().toString();
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, AccessTokenResult.class);
        if (accessTokenResult.err_no() != 0) {
            throw new IllegalArgumentException(bodyStr);
        }
        return accessTokenResult;
    }

    @Override
    public String taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TASK_START_URL)
                .method(POST)
                .setHeader("access-token", getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomID,
                        "appid", appID,
                        "msg_type",getMsgTypeValue(msgType)
                ))));
        return response.body().toString();
    }

    @Override
    public String taskStop(String roomCode, MsgType msgType) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TASK_STOP_URL)
                .method(POST)
                .setHeader("access-token", getAccessToken())
                .body(new JsonBody(Map.of(
                        "roomid", roomCode,
                        "appid", appID,
                        "msg_type", getMsgTypeValue(msgType)
                ))));
        return response.body().toString();
    }

    public String taskStatus(String roomCode, MsgType msgType) throws IOException, InterruptedException {
        var uri = URIBuilder.of(TASK_STATUS_URL)
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

    public String topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        var response = request(new ScxHttpClientRequest()
                .uri(TOP_GIFT_URL)
                .method(POST)
                .setHeader("x-token", getAccessToken())
                .body(new JsonBody(Map.of(
                        "room_id", roomCode,
                        "app_id", appID,
                        "sec_gift_id_list", secGiftIDList
                ))));
        return response.body().toString();
    }

    /**
     * 获取直播信息
     *
     * @param token token
     * @throws IOException          a
     * @throws InterruptedException a
     * @see <a href="https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo">https://developer.open-douyin.com/docs/resource/zh-CN/interaction/develop/server/live/webcastinfo</a>
     */
    public WebcastMateInfo webcastMateInfo(String token) throws IOException, InterruptedException {
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
        return ObjectUtils.jsonMapper().convertValue(info, WebcastMateInfo.class);
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
            case LIVE_GIFT -> {
                checkData(bodyStr, header, giftDataSecret);
                var roomID = header.get("x-roomid");
                var giftList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<GiftBody[]>() {});
                for (var gift : giftList) {
                    gift.roomID = roomID;
                    vertx.nettyEventLoopGroup().execute(() -> {
                        try {
                            this.giftHandler.accept(gift);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
            case LIVE_LIKE -> {
                checkData(bodyStr, header, likeDataSecret);
                var roomID = header.get("x-roomid");
                var likeList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<LikeBody[]>() {});
                for (var like : likeList) {
                    like.roomID = roomID;
                    vertx.nettyEventLoopGroup().execute(() -> {
                        try {
                            this.likeHandler.accept(like);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
            case LIVE_COMMENT -> {
                checkData(bodyStr, header, commentDataSecret);
                var roomID = header.get("x-roomid");
                var commentList = ObjectUtils.jsonMapper().readValue(bodyStr, new TypeReference<CommentBody[]>() {});
                for (var comment : commentList) {
                    comment.roomID = roomID;
                    vertx.nettyEventLoopGroup().execute(() -> {
                        try {
                            this.chatHandler.accept(comment);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
            case LIVE_FANS_CLUB -> {
            }
        }
    }

    /**
     * 推送失败数据获取
     *
     * @param roomCode  房间号
     * @param msg_type  消息类型
     * @param page_num  分页
     * @param page_size 分页
     * @return a
     * @throws IOException          a
     * @throws InterruptedException a
     */
    public String failDataGet(String roomCode, MsgType msg_type, Integer page_num, Integer page_size) throws IOException, InterruptedException {
        var uri = URIBuilder.of(FAIL_DATA_GET_URL)
                .addParam("roomid", roomCode)
                .addParam("appid", appID)
                .addParam("msg_type", getMsgTypeValue(msg_type) )
                .addParam("page_num", page_num)
                .addParam("page_size", page_size)
                .build();

        var response = request(new ScxHttpClientRequest()
                .uri(uri)
                .method(HttpMethod.GET)
                .setHeader("access-token", getAccessToken()));
        return response.body().toString();
    }

}
