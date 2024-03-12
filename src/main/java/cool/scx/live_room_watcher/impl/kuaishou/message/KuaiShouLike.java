package cool.scx.live_room_watcher.impl.kuaishou.message;

import cool.scx.live_room_watcher.message.Like;
import cool.scx.live_room_watcher.message.User;

public class KuaiShouLike implements Like {

    public Integer count;
    public KuaiShouUser userInfo;
    public String roomID;

    public Long timestamp;
    public String message_id;

    @Override
    public long count() {
        return count;
    }

    @Override
    public User user() {
        return userInfo;
    }

    @Override
    public String roomID() {
        return roomID;
    }

}
