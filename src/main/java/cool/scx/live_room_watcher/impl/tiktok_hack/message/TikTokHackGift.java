package cool.scx.live_room_watcher.impl.tiktok_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.GiftMessage;
import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

/**
 * <p>DouYinGift class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class TikTokHackGift implements Gift {

    GiftMessage giftMessage;
    User user;


    public TikTokHackGift(GiftMessage giftMessage) {
        this.giftMessage = giftMessage;
        this.user = new TikTokHackUser(giftMessage.getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return this.giftMessage.getGift().getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        return this.giftMessage.getTotalCount();
    }

    @Override
    public String roomID() {
        return null;
    }

}
