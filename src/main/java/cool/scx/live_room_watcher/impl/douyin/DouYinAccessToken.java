package cool.scx.live_room_watcher.impl.douyin;

import cool.scx.live_room_watcher.AccessToken;

public record DouYinAccessToken(String access_token, Long expires_in) implements AccessToken {

    @Override
    public String accessToken() {
        return access_token;
    }

    @Override
    public Long expiresIn() {
        return expires_in;
    }

}
