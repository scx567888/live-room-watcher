package cool.scx.live_room_watcher.impl.meme.message;

import cool.scx.live_room_watcher.message.User;

public class MEMEUser implements User {
    
    public String avatar;
    public String nickname;
    public String userId;
    
    @Override
    public String nickName() {
        return nickname;
    }

    @Override
    public String avatar() {
        return avatar;
    }

    @Override
    public String userID() {
        return userId;
    }

    @Override
    public String roomID() {
        return null;
    }
    
}
