package cool.scx.live_room_watcher_new;

/**
 * 主播信息
 */
public interface LiveRoomAnchor {

    /**
     * 主播昵称
     *
     * @return a
     */
    String anchorNickName();

    /**
     * 主播头像地址
     *
     * @return a
     */
    String anchorAvatar();

    /**
     * 主播 id
     *
     * @return id
     */
    String anchorID();

}
