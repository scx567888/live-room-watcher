package cool.scx.live_room_watcher.message;

/**
 * <p>Like interface.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface Like extends Message {

    /**
     * 点赞可能是连击的
     *
     * @return a
     */
    long count();

}
