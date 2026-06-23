package cool.scx.live_room_watcher.impl.douyin_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto.webcast.im.SocialMessage;
import cool.scx.live_room_watcher.message.Follow;
import cool.scx.live_room_watcher.message.User;

/// DouYinFollow class.
///
/// @author scx567888
/// @version 0.0.1
public class DouYinHackFollow implements Follow {
    private final DouYinHackUser user;
    SocialMessage socialMessage;

    public DouYinHackFollow(SocialMessage socialMessage) {
        this.socialMessage = socialMessage;
        this.user = new DouYinHackUser(this.socialMessage.getUser());
    }

    @Override
    public User user() {
        return user;
    }

    @Override
    public String roomID() {
        return null;
    }

}
