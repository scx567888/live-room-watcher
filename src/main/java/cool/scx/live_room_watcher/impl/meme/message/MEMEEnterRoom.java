package cool.scx.live_room_watcher.impl.meme.message;

import cool.scx.live_room_watcher.message.User;

public class MEMEEnterRoom implements User {
    
    public MEMEUser userInfo;

    public String roomID;
    
    @Override
    public String nickName() {
        return userInfo.nickname;
    }

    @Override
    public String avatar() {
        return userInfo.avatar;
    }

    @Override
    public String userID() {
        return userInfo.userId;
    }

    @Override
    public String roomID() {
        return roomID;
    }
    
}
