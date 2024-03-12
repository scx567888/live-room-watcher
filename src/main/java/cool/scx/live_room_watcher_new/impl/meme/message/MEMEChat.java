package cool.scx.live_room_watcher_new.impl.meme.message;

import cool.scx.live_room_watcher_new.message.Chat;
import cool.scx.live_room_watcher_new.message.User;

public class MEMEChat implements Chat {

    public String roomID;

    public MEMEUser userInfo;

    public String content;

    @Override
    public String content() {
        return content;
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
