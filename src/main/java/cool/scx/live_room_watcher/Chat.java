package cool.scx.live_room_watcher;

/**
 * 聊天消息
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface Chat {

    /**
     * 消息内容
     *
     * @return a
     */
    String content();

    /**
     * 用户
     *
     * @return a
     */
    User user();

    /**
     * 房间号
     *
     * @return 房间号
     */
    default String roomID() {
        return null;
    }

}
