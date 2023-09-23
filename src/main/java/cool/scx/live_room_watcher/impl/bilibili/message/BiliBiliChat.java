package cool.scx.live_room_watcher.impl.bilibili.message;

import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;

/**
 * 弹幕
 *
 * @author scx567888
 * @version 0.0.1
 */
public class BiliBiliChat implements Chat {

    /**
     * {@inheritDoc}
     */
    @Override
    public String content() {
        return null;
    }

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
