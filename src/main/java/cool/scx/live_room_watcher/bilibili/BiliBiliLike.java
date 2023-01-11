package cool.scx.live_room_watcher.bilibili;

import cool.scx.live_room_watcher.Like;
import cool.scx.live_room_watcher.User;

/**
 * <p>BiliBiliLike class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class BiliBiliLike implements Like {
    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
