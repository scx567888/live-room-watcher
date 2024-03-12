package cool.scx.live_room_watcher.impl.meme.message;

import cool.scx.live_room_watcher.message.Like;
import cool.scx.live_room_watcher.message.User;

public class MEMELike implements Like {

    public Integer count;

    public MEMEUser userInfo;

    public String roomID;

    @Override
    public User user() {
        return userInfo;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public String roomID() {
        return roomID;
    }

}
