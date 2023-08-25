package cool.scx.live_room_watcher.douyin_hack;

import cool.scx.live_room_watcher.Like;
import cool.scx.live_room_watcher.User;
import cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.LikeMessage;


/**
 * <p>DouYinLike class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackLike implements Like {

    LikeMessage likeMessage;
    User user;

    /**
     * <p>Constructor for DouYinLike.</p>
     *
     * @param likeMessage a {@link cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.LikeMessage} object
     */
    public DouYinHackLike(LikeMessage likeMessage) {
        this.likeMessage = likeMessage;
        this.user = new DouYinHackUser(likeMessage.getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        return likeMessage.getCount();
    }

    @Override
    public String roomID() {
        return null;
    }

}
