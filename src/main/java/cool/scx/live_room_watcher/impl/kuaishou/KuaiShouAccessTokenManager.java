package cool.scx.live_room_watcher.impl.kuaishou;

import dev.scx.http.media.multi_part.MultiPart;
import cool.scx.live_room_watcher.AccessToken;
import cool.scx.live_room_watcher.AccessTokenManager;
import dev.scx.http.x.HttpClient;

import static dev.scx.http.method.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.ACCESS_TOKEN_URL;
import static dev.scx.serialize.ScxSerialize.fromJson;

public class KuaiShouAccessTokenManager extends AccessTokenManager {

    protected final String appID;
    protected final String appSecret;
    private final HttpClient httpClient;

    public KuaiShouAccessTokenManager(String appID, String appSecret, HttpClient httpClient) {
        this.appID = appID;
        this.appSecret = appSecret;
        this.httpClient=httpClient;
    }

    @Override
    protected AccessToken getAccessToken0() {
        var response = httpClient.request()
                .method(POST)
                .uri(ACCESS_TOKEN_URL)
                .send(
                    MultiPart.of()
                        .add("app_id", appID)
                        .add("app_secret", appSecret)
                        .add("grant_type", "client_credentials")
                );

        var resBody= response.asString();

        var accessTokenResult = fromJson(resBody,KuaiShouAccessToken.class);

        if (accessTokenResult.result != 1) {
            throw new IllegalArgumentException(resBody);
        }

        return accessTokenResult;
    }

}
