package cool.scx.live_room_watcher.bilibili;

import cool.scx.live_room_watcher.Gift;
import cool.scx.live_room_watcher.User;

/**
 * <p>BiliBiliGift class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class BiliBiliGift implements Gift {
    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
