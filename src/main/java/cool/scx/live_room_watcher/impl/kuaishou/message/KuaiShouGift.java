package cool.scx.live_room_watcher.impl.kuaishou.message;

import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

public class KuaiShouGift implements Gift {

    public String uniqueNo;
    public String giftId;
    public String giftName;
    public Integer giftCount;
    public Integer giftUnitPrice;
    public Integer giftTotalPrice;
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
    public String name() {
        return giftName;
    }

    @Override
    public long count() {
        return giftCount;
    }
}
