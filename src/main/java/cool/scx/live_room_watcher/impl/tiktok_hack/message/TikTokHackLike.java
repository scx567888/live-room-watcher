package cool.scx.live_room_watcher.impl.tiktok_hack.message;

import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.LikeMessage;
import cool.scx.live_room_watcher.message.Like;
import cool.scx.live_room_watcher.message.User;

public class TikTokHackLike implements Like {

    public final LikeMessage likeMessage;
    public final TikTokHackUser user;

    public TikTokHackLike(LikeMessage likeMessage) {
        this.likeMessage = likeMessage;
        this.user = new TikTokHackUser(likeMessage.getUser());
    }

    @Override
    public long count() {
        return likeMessage.getCount();
    }

    @Override
    public User user() {
        return user;
    }

    @Override
    public String roomID() {
        return "";
    }

}
