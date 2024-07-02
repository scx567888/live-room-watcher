package cool.scx.live_room_watcher;

/**
 * 认证 Token
 */
public interface AccessToken {

    /**
     * 认证 Token
     *
     * @return 认证 Token
     */
    String accessToken();

    /**
     * 过期时间
     *
     * @return 过期时间
     */
    Long expiresIn();

}
