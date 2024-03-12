package cool.scx.live_room_watcher_new;

import cool.scx.live_room_watcher_new.message.*;

import java.util.function.Consumer;

/**
 * LiveRoomWatcher
 */
public interface LiveRoomWatcher {

    /**
     * 当获取到新弹幕时
     *
     * @param onChat onChat
     * @return this
     */
    LiveRoomWatcher onChat(Consumer<Chat> onChat);

    /**
     * 当获取到点赞时
     *
     * @param onLike onLike
     * @return this
     */
    LiveRoomWatcher onLike(Consumer<Like> onLike);

    /**
     * 当收到礼物时
     *
     * @param onGift onGift
     * @return this
     */
    LiveRoomWatcher onGift(Consumer<Gift> onGift);

    /**
     * 当用户关注的时候
     *
     * @param onFollow onFollow
     * @return this
     */
    LiveRoomWatcher onFollow(Consumer<Follow> onFollow);

    /**
     * 当新用户进入直播间时
     *
     * @param onUser onUser
     * @return this
     */
    LiveRoomWatcher onUser(Consumer<User> onUser);

}
