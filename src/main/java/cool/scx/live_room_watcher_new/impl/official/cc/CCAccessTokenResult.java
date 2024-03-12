package cool.scx.live_room_watcher_new.impl.official.cc;

import cool.scx.live_room_watcher.AccessToken;

public record CCAccessTokenResult(Integer err_no, String err_tips,
                                  CCAccessTokenResultData data) implements AccessToken {

    @Override
    public String accessToken() {
        return data().access_token();
    }

    @Override
    public Long expiresIn() {
        return data().expires_in();
    }

    record CCAccessTokenResultData(String access_token, Long expires_in) {

    }

}
