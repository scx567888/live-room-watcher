package cool.scx.live_room_watcher;

/**
 * 礼物
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface Gift {
    /**
     * <p>user.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.User} object
     */
    User user();

    /**
     * 礼物名称
     *
     * @return a
     */
    String name();

    /**
     * <p>count.</p>
     *
     * @return a long
     */
    long count();
}
