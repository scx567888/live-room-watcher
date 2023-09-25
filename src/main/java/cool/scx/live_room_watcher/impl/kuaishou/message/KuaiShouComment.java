package cool.scx.live_room_watcher.impl.kuaishou.message;

import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;

public class KuaiShouComment implements Chat {

    public String content;
    public KuaiShouUser userInfo;
    public String roomID;

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
