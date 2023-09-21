package cool.scx.live_room_watcher.message;

public interface Message {

    /**
     * 消息对应的用户
     *
     * @return 用户
     */
    User user();

    /**
     * 消息所属的房间号
     *
     * @return 房间号
     */
    String roomID();

}
