package cool.scx.live_room_watcher.impl.kuaishou;

import cool.scx.common.http_client.ScxHttpClientHelper;
import cool.scx.common.http_client.ScxHttpClientRequest;
import cool.scx.common.http_client.request_body.FormData;
import cool.scx.common.util.ObjectUtils;
import cool.scx.live_room_watcher.AccessToken;
import cool.scx.live_room_watcher.AccessTokenManager;

import java.io.IOException;

import static cool.scx.common.standard.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.ACCESS_TOKEN_URL;

class KuaiShouAccessTokenManager extends AccessTokenManager {

    private final String appID;
    private final String appSecret;

    public KuaiShouAccessTokenManager(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
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
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, KuaiShouAccessToken.class);
        if (accessTokenResult.result != 1) {
            throw new IllegalArgumentException(bodyStr);
        }
        return accessTokenResult;
    }

}
