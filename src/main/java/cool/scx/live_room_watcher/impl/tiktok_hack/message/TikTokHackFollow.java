package cool.scx.live_room_watcher.impl.tiktok_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.SocialMessage;
import cool.scx.live_room_watcher.impl.tiktok_hack.message.TikTokHackUser;
import cool.scx.live_room_watcher.message.Follow;
import cool.scx.live_room_watcher.message.User;

/**
 * <p>DouYinFollow class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class TikTokHackFollow implements Follow {
    private final TikTokHackUser user;
    SocialMessage socialMessage;


    public TikTokHackFollow(SocialMessage socialMessage) {
        this.socialMessage = socialMessage;
        this.user = new TikTokHackUser(this.socialMessage.getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return user;
    }

    @Override
    public String roomID() {
        return null;
    }

}
