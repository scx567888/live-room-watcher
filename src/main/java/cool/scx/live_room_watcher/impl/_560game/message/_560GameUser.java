package cool.scx.live_room_watcher.impl._560game.message;

import cool.scx.live_room_watcher.message.User;

public class _560GameUser implements User {

    public Integer MsgType;
    public Integer GameId;
    public String HeadImage;
    public String Username;

    public String roomID;
    
    @Override
    public String roomID() {
        return roomID;
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

}
