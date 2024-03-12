package cool.scx.live_room_watcher_new.message;

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
     * @return a
     */
    String nickName();

    /**
     * 头像
     *
     * @return a
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
