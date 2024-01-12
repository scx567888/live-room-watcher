package cool.scx.live_room_watcher.impl._560game.message;

import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

public class _560GameGift extends _560GameUser implements Gift {

    public Integer GiftId;
    public Integer GiftNum;
    public Long GiftPrice;
    public String GiftName;
    public String GiftImage;

    @Override
    public String name() {
        return GiftName;
    }

    @Override
    public long count() {
        return GiftNum;
    }

}
