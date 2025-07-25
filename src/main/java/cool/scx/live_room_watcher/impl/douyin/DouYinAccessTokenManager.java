package cool.scx.live_room_watcher.impl.douyin;

import cool.scx.common.util.ObjectUtils;
import cool.scx.http.media_type.MediaType;
import cool.scx.http.ScxHttpClientRequest;
import cool.scx.http.media_type.ScxMediaType;
import cool.scx.http.x.ScxHttpClientHelper;
import cool.scx.live_room_watcher.AccessTokenManager;
import cool.scx.object.ScxObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static cool.scx.http.media_type.MediaType.APPLICATION_JSON;
import static cool.scx.http.method.HttpMethod.POST;
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
    public DouYinAccessToken getAccessToken0() {
        var response = ScxHttpClientHelper.request()
                .method(POST)
                .uri(ACCESS_TOKEN_URL)
                .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
                .send(Map.of(
                        "appid", appID,
                        "secret", appSecret,
                        "grant_type", "client_credential"
                ));
        var accessTokenResult = response.body().asObject(DouYinResponseBody.class);
        if (accessTokenResult.err_no() != 0) {
            throw new IllegalArgumentException(ScxObject.toJson(accessTokenResult));
        }
        return ScxObject.convertValue(accessTokenResult.data(), DouYinAccessToken.class);
    }

}
