package cool.scx.live_room_watcher.impl.kuaishou;

import cool.scx.live_room_watcher.AccessToken;

final class KuaiShouAccessToken extends KuaiShouResponseBody implements AccessToken {

    public String access_token;
    public Long expires_in;
    public String token_type;

    @Override
    public String accessToken() {
        return access_token;
    }

    @Override
    public Long expiresIn() {
        return expires_in;
    }

}
