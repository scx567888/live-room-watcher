package cool.scx.live_room_watcher;

/// 直播间信息
///
/// @author scx567888
/// @version 0.0.1
public interface LiveRoomInfo {

    /// 获取直播源地址
    String[] webStreamURLs();

    /// 获取直播间标题
    String title();

    /// 直播间 ID
    String roomID();

    /// 主播信息
    LiveRoomAnchor anchor();

}
