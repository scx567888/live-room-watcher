package cool.scx.live_room_watcher.douyin;

import cool.scx.live_room_watcher.AccessToken;

record AccessTokenResult(Integer err_no, String err_tips, AccessTokenResultData data) implements AccessToken {

    @Override
    public String accessToken() {
        return data.access_token();
    }

    @Override
    public Integer expiresIn() {
        return data.expires_in();
    }

    record AccessTokenResultData(String access_token, Integer expires_in) {

    }
    
}
