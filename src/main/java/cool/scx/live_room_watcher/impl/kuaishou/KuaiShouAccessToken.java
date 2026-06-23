package cool.scx.live_room_watcher.impl.kuaishou;

public class KuaiShouAccessToken extends KuaiShouResponseBody {

    public String access_token;
    public Long expires_in;
    public String token_type;

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
