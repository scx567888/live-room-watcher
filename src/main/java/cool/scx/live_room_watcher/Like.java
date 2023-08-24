package cool.scx.live_room_watcher;

/**
 * <p>Like interface.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface Like {

    /**
     * 点赞的用户
     *
     * @return a
     */
    User user();

    /**
     * 点赞可能是连击的
     *
     * @return a
     */
    long count();

    /**
     * 房间号
     * @return a
     */
    default String roomID(){
        return null;
    }

}
