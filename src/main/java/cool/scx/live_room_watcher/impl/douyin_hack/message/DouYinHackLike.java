package cool.scx.live_room_watcher.impl.douyin_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LikeMessage;
import cool.scx.live_room_watcher.message.Like;
import cool.scx.live_room_watcher.message.User;


/**
 * <p>DouYinLike class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackLike implements Like {

    LikeMessage likeMessage;
    User user;

    
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
