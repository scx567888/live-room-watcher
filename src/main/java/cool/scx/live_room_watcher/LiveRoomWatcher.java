package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.message.*;

import java.util.function.Consumer;

/**
 * <p>直播间观察者</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface LiveRoomWatcher {

    /**
     * 当获取到新弹幕时
     *
     * @param onChat handler
     * @return this
     */
    LiveRoomWatcher onChat(Consumer<Chat> onChat);

    /**
     * 当获取到点赞时
     *
     * @param onLike handler
     * @return this
     */
    LiveRoomWatcher onLike(Consumer<Like> onLike);

    /**
     * 礼物
     *
     * @param onGift handler
     * @return this
     */
    LiveRoomWatcher onGift(Consumer<Gift> onGift);

    /**
     * 当用户关注的时候
     *
     * @param onFollow handler
     * @return this
     */
    LiveRoomWatcher onFollow(Consumer<Follow> onFollow);

    /**
     * 当新用户进入直播间时
     *
     * @param onUser handler
     * @return this
     */
    LiveRoomWatcher onUser(Consumer<User> onUser);

    /**
     * 启动 监控
     */
    void start();

    /**
     * 停止 监控
     */
    void stop();

}
