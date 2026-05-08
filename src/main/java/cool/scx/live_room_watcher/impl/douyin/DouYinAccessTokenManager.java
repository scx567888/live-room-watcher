package cool.scx.live_room_watcher.impl.douyin;


import cool.scx.live_room_watcher.AccessTokenManager;
import cool.scx.live_room_watcher.util.ScxHttpClientHelper;
import dev.scx.http.media_type.ScxMediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static cool.scx.live_room_watcher.impl.douyin.DouYinApi.ACCESS_TOKEN_URL;
import static dev.scx.http.media_type.MediaType.APPLICATION_JSON;
import static dev.scx.http.method.HttpMethod.POST;
import static dev.scx.serialize.ScxSerialize.*;
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
       var reqBody= toJson(
           Map.of(
               "appid", appID,
               "secret", appSecret,
               "grant_type", "client_credential"
           )
       );

        var response = ScxHttpClientHelper.request()
                .method(POST)
                .uri(ACCESS_TOKEN_URL)
                .contentType(ScxMediaType.of(APPLICATION_JSON).charset(UTF_8))
                .send(reqBody);

        var resBody = response.asString();

        var accessTokenResult = fromJson(resBody,DouYinResponseBody.class);

        if (accessTokenResult.err_no() != 0) {
            throw new IllegalArgumentException(resBody);
        }
        return convertObject(accessTokenResult.data(), DouYinAccessToken.class);
    }

}
