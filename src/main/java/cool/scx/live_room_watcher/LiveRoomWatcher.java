package cool.scx.live_room_watcher;

import java.util.List;
import java.util.function.Consumer;

/**
 * <p>直播间观察者</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public interface LiveRoomWatcher {

    /**
     * chatHandler 的别名
     *
     * @param handler handler
     * @return this
     */
    default LiveRoomWatcher onChat(Consumer<Chat> handler) {
        return this.chatHandler(handler);
    }

    /**
     * userHandler 的别名
     *
     * @param handler handler
     * @return this
     */
    default LiveRoomWatcher onUser(Consumer<User> handler) {
        return this.userHandler(handler);
    }

    /**
     * likeHandler 的别名
     *
     * @param handler handler
     * @return this
     */
    default LiveRoomWatcher onLike(Consumer<Like> handler) {
        return this.likeHandler(handler);
    }

    /**
     * followHandler 的别名
     *
     * @param handler handler
     * @return this
     */
    default LiveRoomWatcher onFollow(Consumer<Follow> handler) {
        return this.followHandler(handler);
    }

    /**
     * giftHandler 的别名
     *
     * @param handler handler
     * @return this
     */
    default LiveRoomWatcher onGift(Consumer<Gift> handler) {
        return this.giftHandler(handler);
    }

    /**
     * 当获取到新弹幕时
     *
     * @param handler handler
     * @return this
     */
    LiveRoomWatcher chatHandler(Consumer<Chat> handler);

    /**
     * 当新用户进入直播间时
     *
     * @param handler handler
     * @return this
     */
    LiveRoomWatcher userHandler(Consumer<User> handler);

    /**
     * 点赞
     *
     * @param handler handler
     * @return this
     */
    LiveRoomWatcher likeHandler(Consumer<Like> handler);

    /**
     * 关注
     *
     * @param handler handler
     * @return this
     */
    LiveRoomWatcher followHandler(Consumer<Follow> handler);

    /**
     * 礼物
     *
     * @param handler handler
     * @return this
     */
    LiveRoomWatcher giftHandler(Consumer<Gift> handler);

    /**
     * 获取 chatHandler
     *
     * @return chatHandler
     */
    Consumer<Chat> chatHandler();

    /**
     * 获取 userHandler
     *
     * @return userHandler
     */
    Consumer<User> userHandler();

    /**
     * 获取 likeHandler
     *
     * @return likeHandler
     */
    Consumer<Like> likeHandler();

    /**
     * 获取  followHandler
     *
     * @return followHandler
     */
    Consumer<Follow> followHandler();

    /**
     * 获取  giftHandler
     *
     * @return giftHandler
     */
    Consumer<Gift> giftHandler();

    /**
     * 获取直播源地址
     *
     * @return a
     */
    default List<String> liveRoomWebStreamURLs() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取直播间标题
     *
     * @return a
     */
    default String liveRoomTitle() {
        throw new UnsupportedOperationException();
    }

    /**
     * 启动 监控
     */
    void startWatch();

}
