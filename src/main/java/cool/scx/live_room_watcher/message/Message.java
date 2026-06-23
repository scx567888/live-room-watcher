package cool.scx.live_room_watcher.message;

/// 基本消息体
///
/// @author scx567888
/// @version 0.0.1
public interface Message {

    /// 消息对应的用户
    User user();

    /// 消息所属的房间号
    String roomID();

}
