package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.message.*;

import java.util.function.Consumer;

/**
 * AbstractLiveRoomWatcher
 */
public abstract class AbstractLiveRoomWatcher implements LiveRoomWatcher {

    protected Consumer<Chat> onChat;
    protected Consumer<Like> onLike;
    protected Consumer<Gift> onGift;
    protected Consumer<Follow> onFollow;
    protected Consumer<User> onUser;

    @Override
    public LiveRoomWatcher onChat(Consumer<Chat> onChat) {
        this.onChat = onChat;
        return this;
    }

    @Override
    public LiveRoomWatcher onLike(Consumer<Like> onLike) {
        this.onLike = onLike;
        return this;
    }

    @Override
    public LiveRoomWatcher onGift(Consumer<Gift> onGift) {
        this.onGift = onGift;
        return this;
    }

    @Override
    public LiveRoomWatcher onFollow(Consumer<Follow> onFollow) {
        this.onFollow = onFollow;
        return this;
    }

    @Override
    public LiveRoomWatcher onUser(Consumer<User> onUser) {
        this.onUser = onUser;
        return this;
    }

    protected void _callOnChat(Chat chat) {
        if (this.onChat != null) {
            this.onChat.accept(chat);
        }
    }

    protected void _callOnLike(Like like) {
        if (this.onLike != null) {
            this.onLike.accept(like);
        }
    }

    protected void _callOnGift(Gift gift) {
        if (this.onGift != null) {
            this.onGift.accept(gift);
        }
    }

    protected void _callOnFollow(Follow follow) {
        if (this.onFollow != null) {
            this.onFollow.accept(follow);
        }
    }

    protected void _callOnUser(User user) {
        if (this.onUser != null) {
            this.onUser.accept(user);
        }
    }

}
