package cool.scx.live_room_watcher_new.impl.meme.message;

import cool.scx.live_room_watcher_new.message.Gift;
import cool.scx.live_room_watcher_new.message.User;

public class MEMEGift implements Gift {

    public Integer giftCount;
    public Integer giftId;
    public String giftName;
    public Integer giftTotalPrice;
    public Integer giftUnitPrice;
    public MEMEUser userInfo;
    public String roomID;

    @Override
    public User user() {
        return userInfo;
    }

    @Override
    public String name() {
        return giftName;
    }

    @Override
    public long count() {
        return giftCount;
    }

    @Override
    public String roomID() {
        return roomID;
    }

}
