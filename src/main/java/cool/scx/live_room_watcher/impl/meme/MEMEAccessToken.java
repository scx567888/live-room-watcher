package cool.scx.live_room_watcher.impl.meme;

import cool.scx.live_room_watcher.AccessToken;

public record MEMEAccessToken(Integer code, String message, MEMEAccessTokenData data) implements AccessToken {

    @Override
    public String accessToken() {
        return data.accessToken();
    }

    @Override
    public Long expiresIn() {
        return (data.expireTime() - System.currentTimeMillis()) / 1000;
    }

    public record MEMEAccessTokenData(String accessToken, Long expireTime) {

    }

}
