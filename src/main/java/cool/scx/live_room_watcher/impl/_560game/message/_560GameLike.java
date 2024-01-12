package cool.scx.live_room_watcher.impl._560game.message;

import cool.scx.live_room_watcher.message.Like;
import cool.scx.live_room_watcher.message.User;

public class _560GameLike implements Like, User {

    public Integer MsgType;
    public Long Count;
    public Long Total;
    public Integer GameId;
    public String HeadImage;
    public String Username;

    public String roomID;

    @Override
    public long count() {
        return Count;
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
