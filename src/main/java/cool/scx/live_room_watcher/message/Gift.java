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
     * @return 礼物名称
     */
    String name();

    /**
     * 礼物数量
     *
     * @return 礼物数量
     */
    long count();

}
