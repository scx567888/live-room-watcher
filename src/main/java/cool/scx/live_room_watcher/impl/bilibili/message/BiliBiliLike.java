package cool.scx.live_room_watcher.impl.bilibili.message;

import cool.scx.live_room_watcher.message.Like;
import cool.scx.live_room_watcher.message.User;

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
