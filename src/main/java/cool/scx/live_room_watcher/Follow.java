package cool.scx.live_room_watcher;

/**
 * 关注
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface Follow {

    /**
     * <p>user.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.User} object
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
