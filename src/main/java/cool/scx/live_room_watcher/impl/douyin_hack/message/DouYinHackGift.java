package cool.scx.live_room_watcher.impl.douyin_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto.webcast.im.GiftMessage;
import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

/// DouYinGift.
///
/// @author scx567888
/// @version 0.0.1
public class DouYinHackGift implements Gift {

    GiftMessage giftMessage;
    User user;

    public DouYinHackGift(GiftMessage giftMessage) {
        this.giftMessage = giftMessage;
        this.user = new DouYinHackUser(giftMessage.getUser());
    }

    @Override
    public User user() {
        return user;
    }

    @Override
    public String name() {
        return this.giftMessage.getGift().getName();
    }

    @Override
    public long count() {
        return this.giftMessage.getTotalCount();
    }

    @Override
    public String roomID() {
        return null;
    }

}
