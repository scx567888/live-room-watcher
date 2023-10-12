package cool.scx.live_room_watcher.impl.kuaishou;

import cool.scx.live_room_watcher.AccessToken;

record KuaiShouAccessTokenResult(Integer result, String access_token, Long expires_in,
                                 String token_type) implements AccessToken {
    @Override
    public String accessToken() {
        return access_token;
    }

    @Override
    public Long expiresIn() {
        return expires_in;
    }
    
}
