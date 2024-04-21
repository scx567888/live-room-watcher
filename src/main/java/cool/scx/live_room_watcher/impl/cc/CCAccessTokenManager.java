package cool.scx.live_room_watcher.impl.cc;

import cool.scx.common.http_client.ScxHttpClientHelper;
import cool.scx.common.http_client.ScxHttpClientRequest;
import cool.scx.common.http_client.request_body.JsonBody;
import cool.scx.live_room_watcher.AccessTokenManager;
import cool.scx.common.util.ObjectUtils;

import java.io.IOException;
import java.util.Map;

import static cool.scx.live_room_watcher.impl.cc.CCApi.*;
import static cool.scx.common.standard.HttpMethod.POST;

public class CCAccessTokenManager extends AccessTokenManager {
    
    private final String appID;
    private final String appSecret;
    private final CCLiveRoomWatcher ccLiveRoomWatcher;

    public CCAccessTokenManager(String appID, String appSecret, CCLiveRoomWatcher ccLiveRoomWatcher) {
        this.appID = appID;
        this.appSecret = appSecret;
        this.ccLiveRoomWatcher = ccLiveRoomWatcher;
    }

    @Override
    protected CCAccessTokenResult getAccessToken0() throws IOException, InterruptedException {
        var response = ScxHttpClientHelper.request(new ScxHttpClientRequest()
                .uri(ccLiveRoomWatcher.getTest() ? TEST_ACCESS_TOKEN_URL : ACCESS_TOKEN_URL)
                .method(POST)
                .body(new JsonBody(Map.of(
                        "appid", appID,
                        "secret", appSecret,
                        "grant_type", "client_credential"
                ))));
        var bodyStr = response.body().toString();
        var accessTokenResult = ObjectUtils.jsonMapper().readValue(bodyStr, CCAccessTokenResult.class);
        if (accessTokenResult.err_no() != 0) {
            throw new IllegalArgumentException(bodyStr);
        }
        return accessTokenResult;
    }
    
}
