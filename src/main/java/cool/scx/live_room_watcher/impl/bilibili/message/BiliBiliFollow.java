package cool.scx.live_room_watcher.impl.bilibili.message;

import cool.scx.live_room_watcher.message.Follow;
import cool.scx.live_room_watcher.message.User;

/**
 * 关注
 *
 * @author scx567888
 * @version 0.0.1
 */
public class BiliBiliFollow implements Follow {

    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return null;
    }

    @Override
    public String roomID() {
        return null;
    }

}
