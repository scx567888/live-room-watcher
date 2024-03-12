package cool.scx.live_room_watcher_new.impl.kuaishou.message;

import cool.scx.live_room_watcher_new.message.Chat;
import cool.scx.live_room_watcher_new.message.User;

public class KuaiShouComment implements Chat {

    public String content;
    public KuaiShouUser userInfo;
    public String roomID;

    public Long timestamp;
    public String message_id;

    @Override
    public User user() {
        return userInfo;
    }

    @Override
    public String roomID() {
        return roomID;
    }

    @Override
    public String content() {
        return content;
    }
}
