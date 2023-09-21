package cool.scx.live_room_watcher.impl.douyin_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.GiftMessage;
import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

/**
 * <p>DouYinGift class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackGift implements Gift {

    GiftMessage giftMessage;
    User user;

    /**
     * <p>Constructor for DouYinGift.</p>
     *
     * @param giftMessage a {@link cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.GiftMessage} object
     */
    public DouYinHackGift(GiftMessage giftMessage) {
        this.giftMessage = giftMessage;
        this.user = new DouYinHackUser(giftMessage.getUser());
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
