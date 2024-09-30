package cool.scx.live_room_watcher.impl.douyin;

import cool.scx.common.util.ObjectUtils;
import cool.scx.http.MediaType;
import cool.scx.http.ScxHttpClientRequest;
import cool.scx.http.content_type.ContentType;
import cool.scx.http.helidon.ScxHttpClientHelper;
import cool.scx.live_room_watcher.AccessTokenManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static cool.scx.common.util.ObjectUtils.toJson;
import static cool.scx.http.HttpMethod.POST;
import static cool.scx.http.MediaType.APPLICATION_JSON;
import static cool.scx.live_room_watcher.impl.douyin.DouYinApi.ACCESS_TOKEN_URL;
import static java.nio.charset.StandardCharsets.UTF_8;

public class DouYinAccessTokenManager extends AccessTokenManager {

    private final String appID;
    private final String appSecret;

    public DouYinAccessTokenManager(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
    }

    @Override
    public DouYinAccessToken getAccessToken0() throws IOException, InterruptedException {
        var response = ScxHttpClientHelper.request()
                .uri(ACCESS_TOKEN_URL)
                .method(POST)
                .contentType(ContentType.of(APPLICATION_JSON).charset(UTF_8))
                .send(toJson(Map.of(
                        "appid", appID,
                        "secret", appSecret,
                        "grant_type", "client_credential"
                )));
        var bodyStr = response.body().asString();
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, DouYinResponseBody.class);
        if (accessTokenResult.err_no() != 0) {
            throw new IllegalArgumentException(bodyStr);
        }
        return ObjectUtils.convertValue(accessTokenResult.data(), DouYinAccessToken.class);
    }

}
