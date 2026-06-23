package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.message.*;

import java.util.function.Consumer;

/// LiveRoomWatcher
public interface LiveRoomWatcher {

    /// 当获取到新弹幕时
    LiveRoomWatcher onChat(Consumer<Chat> onChat);

    /// 当获取到点赞时
    LiveRoomWatcher onLike(Consumer<Like> onLike);

    /// 当收到礼物时
    LiveRoomWatcher onGift(Consumer<Gift> onGift);

    /// 当用户关注的时候
    LiveRoomWatcher onFollow(Consumer<Follow> onFollow);

    /// 当新用户进入直播间时
    LiveRoomWatcher onUser(Consumer<User> onUser);

}
