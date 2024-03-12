package cool.scx.live_room_watcher.impl.douyin;

import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.body.JsonBody;
import cool.scx.live_room_watcher.AccessTokenManager;
import cool.scx.util.ObjectUtils;

import java.io.IOException;
import java.util.Map;

import static cool.scx.live_room_watcher.impl.douyin.DouYinApi.ACCESS_TOKEN_URL;
import static cool.scx.standard.HttpMethod.POST;

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
