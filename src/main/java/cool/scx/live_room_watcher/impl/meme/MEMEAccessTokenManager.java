package cool.scx.live_room_watcher.impl.meme;

import cool.scx.common.http_client.ScxHttpClientResponse;
import cool.scx.live_room_watcher.AccessToken;
import cool.scx.live_room_watcher.AccessTokenManager;
import cool.scx.common.util.ObjectUtils;
import cool.scx.common.util.URIBuilder;

import java.io.IOException;

import static cool.scx.common.standard.HttpMethod.GET;

public class MEMEAccessTokenManager extends AccessTokenManager {

    private final MEMELiveRoomWatcher liveRoomWatcher;

    public MEMEAccessTokenManager(MEMELiveRoomWatcher liveRoomWatcher) {
        this.liveRoomWatcher=liveRoomWatcher;
    }

    @Override
    protected AccessToken getAccessToken0() throws IOException, InterruptedException {
        var uri = URIBuilder.of(liveRoomWatcher.memeApi.ACCESS_TOKEN_URL()).addParam("appkey", liveRoomWatcher.appID).toString();
        ScxHttpClientResponse response = liveRoomWatcher.request(GET, uri);
        var json = response.body().toString();
        return ObjectUtils.jsonMapper().readValue(json, MEMEAccessToken.class);
    }
    
}
