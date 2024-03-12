package cool.scx.live_room_watcher_new;

import java.util.List;

/**
 * 直播间信息
 */
public interface LiveRoomInfo {

    /**
     * 获取直播源地址
     *
     * @return a
     */
    List<String> liveRoomWebStreamURLs();


    /**
     * 获取直播间标题
     *
     * @return a
     */
    String liveRoomTitle();

    /**
     * 直播间 ID
     *
     * @return a
     */
    String liveRoomID();

    /**
     * 主播信息
     *
     * @return a
     */
    LiveRoomAnchor liveRoomAnchor();

}
