package cool.scx.live_room_watcher.impl.douyin;

import cool.scx.live_room_watcher.AccessToken;

public record DouYinAccessTokenResult(Integer err_no, String err_tips,
                                      DouYinAccessTokenResultData data) implements AccessToken {

    @Override
    public String accessToken() {
        return data().access_token();
    }

    @Override
    public Long expiresIn() {
        return data().expires_in();
    }

}
