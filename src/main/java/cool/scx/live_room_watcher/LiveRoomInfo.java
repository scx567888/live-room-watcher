package cool.scx.live_room_watcher;

/**
 * 直播间信息
 */
public interface LiveRoomInfo {

    /**
     * 获取直播源地址
     *
     * @return a
     */
    String[] webStreamURLs();

    /**
     * 获取直播间标题
     *
     * @return a
     */
    String title();

    /**
     * 直播间 ID
     *
     * @return a
     */
    String roomID();

    /**
     * 主播信息
     *
     * @return a
     */
    LiveRoomAnchor anchor();

}
