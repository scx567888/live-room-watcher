package cool.scx.live_room_watcher.message;

/**
 * 礼物
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface Gift extends Message {

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
