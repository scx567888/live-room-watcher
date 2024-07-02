package cool.scx.live_room_watcher.impl.douyin;

import cool.scx.common.http_client.ScxHttpClientHelper;
import cool.scx.common.http_client.ScxHttpClientRequest;
import cool.scx.common.http_client.request_body.JsonBody;
import cool.scx.common.util.ObjectUtils;
import cool.scx.live_room_watcher.AccessTokenManager;

import java.io.IOException;
import java.util.Map;

import static cool.scx.common.standard.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.douyin.DouYinApi.ACCESS_TOKEN_URL;

public class DouYinAccessTokenManager extends AccessTokenManager {

    private final String appID;
    private final String appSecret;

    public DouYinAccessTokenManager(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
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

}
