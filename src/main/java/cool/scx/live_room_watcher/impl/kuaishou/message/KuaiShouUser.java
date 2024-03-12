package cool.scx.live_room_watcher.impl.kuaishou.message;

import cool.scx.live_room_watcher.message.User;

public class KuaiShouUser implements User {

    public String userId;
    public String userName;
    public String headUrl;
    public String roomID;

    @Override
    public String roomID() {
        return roomID;
    }

    @Override
    public String nickName() {
        return userName;
    }

    @Override
    public String avatar() {
        return headUrl;
    }

    @Override
    public String userID() {
        return userId;
    }

}
