package cool.scx.live_room_watcher.message;

/**
 * 直播间用户
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface User extends Message {

    /**
     * 昵称
     *
     * @return 昵称
     */
    String nickname();

    /**
     * 头像
     *
     * @return 头像
     */
    String avatar();

    /**
     * 用户 ID
     *
     * @return 用户 ID
     */
    String userID();

    @Override
    default User user() {
        return this;
    }

}
