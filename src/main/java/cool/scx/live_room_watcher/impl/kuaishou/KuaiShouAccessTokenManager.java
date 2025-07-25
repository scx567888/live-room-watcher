package cool.scx.live_room_watcher.impl.kuaishou;

import cool.scx.common.util.ObjectUtils;
import cool.scx.http.x.ScxHttpClientHelper;
import cool.scx.http.media.multi_part.MultiPart;
import cool.scx.live_room_watcher.AccessToken;
import cool.scx.live_room_watcher.AccessTokenManager;
import cool.scx.object.ScxObject;

import static cool.scx.http.method.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.ACCESS_TOKEN_URL;

class KuaiShouAccessTokenManager extends AccessTokenManager {

    private final String appID;
    private final String appSecret;

    public KuaiShouAccessTokenManager(String appID, String appSecret) {
        this.appID = appID;
        this.appSecret = appSecret;
    }

    @Override
    protected AccessToken getAccessToken0() {
        var response = ScxHttpClientHelper.request()
                .method(POST)
                .uri(ACCESS_TOKEN_URL)
                .send(MultiPart.of()
                        .add("app_id", appID)
                        .add("app_secret", appSecret)
                        .add("grant_type", "client_credentials")
                );
        var accessTokenResult = response.body().asObject(KuaiShouAccessToken.class);
        if (accessTokenResult.result != 1) {
            throw new IllegalArgumentException(ScxObject.toJson(accessTokenResult));
        }
        return accessTokenResult;
    }

}
