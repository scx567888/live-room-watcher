package cool.scx.live_room_watcher.impl.tiktok_hack.message;

import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.User;
import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.MemberMessage;

public class TikTokHackUser implements cool.scx.live_room_watcher.message.User {

    private final User user;

    public TikTokHackUser(User user) {
        this.user = user;
    }

    public TikTokHackUser(MemberMessage memberMessage) {
        this.user=memberMessage.getUser();
    }

    @Override
    public String nickname() {
        return user.getNickname();
    }

    @Override
    public String avatar() {
        return user.getAvatarThumb().getUrlListList(0);
    }

    @Override
    public String userID() {
        return null;
    }

    @Override
    public String roomID() {
        return null;
    }
    
}
