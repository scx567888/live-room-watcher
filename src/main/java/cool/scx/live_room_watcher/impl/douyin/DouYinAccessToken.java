package cool.scx.live_room_watcher.impl.douyin;

public record DouYinAccessToken(String access_token, Long expires_in) {

    /**
     * 认证 Token
     *
     * @return 认证 Token
     */
    public String accessToken() {
        return access_token;
    }

    /**
     * 过期时间
     *
     * @return 过期时间
     */
    public Long expiresIn() {
        return expires_in;
    }

}
