package cool.scx.live_room_watcher;

import cool.scx.functional.ScxHandlerA;
import cool.scx.util.ansi.Ansi;
import io.vertx.core.Vertx;

import java.util.Objects;

/**
 * <p>Abstract LiveRoomWatcher class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public abstract class LiveRoomWatcher {

    /**
     * Constant <code>vertx</code>
     */
    protected static final Vertx vertx;

    static {
        vertx = Vertx.vertx();
    }

    protected ScxHandlerA<Chat> onChatHandler;
    protected ScxHandlerA<User> onUserHandler;
    protected ScxHandlerA<Like> onLikeHandler;
    protected ScxHandlerA<Follow> onFollowHandler;
    protected ScxHandlerA<Gift> onGiftHandler;

    /**
     * <p>Constructor for LiveRoomWatcher.</p>
     */
    public LiveRoomWatcher() {
        this.onChatHandler = chat -> {
            Ansi.out().brightGreen("[消息] ").defaultColor(chat.user().nickName() + " : ").brightWhite(chat.content()).println();
        };
        this.onUserHandler = user -> {
            Ansi.out().brightMagenta("[来了] ").defaultColor(user.nickName()).println();
        };
        this.onLikeHandler = like -> {
            Ansi.out().brightYellow("[点赞] ").defaultColor(like.user().nickName()).println();
        };
        this.onFollowHandler = follow -> {
            Ansi.out().brightCyan("[关注] ").defaultColor(follow.user().nickName()).println();
        };
        this.onGiftHandler = gift -> {
            Ansi.out().brightBlue("[礼物] ").defaultColor(gift.user().nickName() + " : ").brightWhite(gift.name()).println();
        };
    }

    /**
     * 当获取到新弹幕时
     *
     * @param handler a
     * @return a
     */
    public final LiveRoomWatcher onChat(ScxHandlerA<Chat> handler) {
        Objects.requireNonNull(handler);
        this.onChatHandler = handler;
        return this;
    }

    /**
     * 当新用户进入直播间时
     *
     * @param handler a
     * @return a
     */
    public final LiveRoomWatcher onUser(ScxHandlerA<User> handler) {
        Objects.requireNonNull(handler);
        this.onUserHandler = handler;
        return this;
    }

    /**
     * 点赞
     *
     * @param handler a
     * @return a
     */
    public final LiveRoomWatcher onLike(ScxHandlerA<Like> handler) {
        Objects.requireNonNull(handler);
        this.onLikeHandler = handler;
        return this;
    }

    /**
     * 关注
     *
     * @param handler a
     * @return a
     */
    public final LiveRoomWatcher onFollow(ScxHandlerA<Follow> handler) {
        Objects.requireNonNull(handler);
        this.onFollowHandler = handler;
        return this;
    }

    /**
     * 礼物
     *
     * @param handler a
     * @return a
     */
    public final LiveRoomWatcher onGift(ScxHandlerA<Gift> handler) {
        Objects.requireNonNull(handler);
        this.onGiftHandler = handler;
        return this;
    }

    /**
     * <p>startWatch.</p>
     */
    public abstract void startWatch();

}
