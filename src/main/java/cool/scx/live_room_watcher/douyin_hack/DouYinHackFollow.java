package cool.scx.live_room_watcher.douyin_hack;

import cool.scx.live_room_watcher.Follow;
import cool.scx.live_room_watcher.User;
import cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.SocialMessage;

/**
 * <p>DouYinFollow class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackFollow implements Follow {
    private final DouYinHackUser user;
    SocialMessage socialMessage;

    /**
     * <p>Constructor for DouYinFollow.</p>
     *
     * @param socialMessage a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.SocialMessage} object
     */
    public DouYinHackFollow(SocialMessage socialMessage) {
        this.socialMessage = socialMessage;
        this.user = new DouYinHackUser(this.socialMessage.getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return user;
    }

}
