package cool.scx.live_room_watcher.impl.bilibili.message;

import cool.scx.live_room_watcher.message.Like;
import cool.scx.live_room_watcher.message.User;

/**
 * 点赞
 *
 * @author scx567888
 * @version 0.0.1
 */
public class BiliBiliLike implements Like {

    @Override
    public User user() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public String roomID() {
        return null;
    }

}
