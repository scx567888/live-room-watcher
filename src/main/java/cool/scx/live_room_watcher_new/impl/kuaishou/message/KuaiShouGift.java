package cool.scx.live_room_watcher_new.impl.kuaishou.message;

import cool.scx.live_room_watcher_new.message.Gift;
import cool.scx.live_room_watcher_new.message.User;

public class KuaiShouGift implements Gift {

    public String uniqueNo;
    public String giftId;
    public String giftName;
    public Integer giftCount;
    public Integer giftUnitPrice;
    public Integer giftTotalPrice;
    public KuaiShouUser userInfo;
    public String roomID;

    public Long timestamp;
    public String message_id;

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
