package cool.scx.live_room_watcher.impl._560game.message;

import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

public class _560GameGift implements Gift, User {

    public Integer MsgType;
    public Integer GiftId;
    public Integer GiftNum;
    public Integer GameId;
    public Long GiftPrice;
    public String GiftName;
    public String HeadImage;
    public String Username;
    public String GiftImage;

    public String roomID;

    @Override
    public String name() {
        return GiftName;
    }

    @Override
    public long count() {
        return GiftNum;
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
