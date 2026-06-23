package cool.scx.live_room_watcher;

/// 主播信息
public interface LiveRoomAnchor {

    /// 主播昵称
    String nickname();

    /// 主播头像地址
    String avatar();

    /// 主播 id
    String anchorID();

}
