package cool.scx.live_room_watcher.impl.kuaishou;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.body.FormData;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.douyin.DouYinLiveRoomWatcher;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import static cool.scx.enumeration.HttpMethod.POST;
import static cool.scx.http_client.ScxHttpClientHelper.request;
import static cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher.MsgType.LIVE_COMMENT;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.*;

// todo 未完成
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
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouAccessTokenResult.class);
        if (accessTokenResult.result != 1) {
            throw new IllegalArgumentException(bodyStr);
        }
        System.err.println("获取 accessToken 成功 : " + accessTokenResult.accessToken());
        return accessTokenResult;
    }

    @Override
    protected LiveRoomInfo liveInfo(String tokenOrRoomID) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public String taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException {
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
        var s = response.body().toString();
        System.out.println(s);
        return s;
    }

    @Override
    public String taskStop(String roomID, MsgType msgType) throws IOException, InterruptedException {
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
        var s = response.body().toString();
        System.out.println(s);
        return s;
    }

    @Override
    public String taskStatus(String roomID, MsgType msgType) throws IOException, InterruptedException {
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
        var s = response.body().toString();
        System.out.println(s);
        return s;
    }

    @Override
    public String failDataGet(String roomID, MsgType msgType, Integer pageNum, Integer pageSize) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public String topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public void call(String bodyStr, Map<String, String> header, MsgType msgType) {

    }

    @Override
    public void startWatch(String roomID) throws IOException, InterruptedException {
        taskStart(roomID, LIVE_COMMENT);
    }

    @Override
    public void stopWatch(String roomID) throws IOException, InterruptedException {
        taskStop(roomID, LIVE_COMMENT);
    }

    record KuaiShouAccessTokenResult(Integer result, String access_token, Integer expires_in,
                                     String token_type) implements AccessToken {
        @Override
        public String accessToken() {
            return access_token;
        }

        @Override
        public Integer expiresIn() {
            return expires_in;
        }
    }


}
