package cool.scx.live_room_watcher.impl._560game.message;

import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;

public class _560GameChat implements Chat, User {

    public Integer MsgType;
    public Integer GameId;
    public String Content;
    public String HeadImage;
    public String Username;

    public String roomID;

    @Override
    public String content() {
        return Content;
    }

    @Override
    public String nickName() {
        return Username;
    }

    @Override
    public String avatar() {
        return HeadImage;
    }

    @Override
    public String userID() {
        return Username;
    }

    @Override
    public User user() {
        return this;
    }

    @Override
    public String roomID() {
        return roomID;
    }

}
