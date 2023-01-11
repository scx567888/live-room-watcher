package cool.scx.live_room_watcher.douyin;

import cool.scx.live_room_watcher.Gift;
import cool.scx.live_room_watcher.User;
import cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.GiftMessage;

/**
 * <p>DouYinGift class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinGift implements Gift {

    GiftMessage giftMessage;
    User user;

    /**
     * <p>Constructor for DouYinGift.</p>
     *
     * @param giftMessage a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.GiftMessage} object
     */
    public DouYinGift(GiftMessage giftMessage) {
        this.giftMessage = giftMessage;
        this.user = new DouYinUser(giftMessage.getUser());
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

    @Override
    public long count() {
        return this.giftMessage.getTotalCount();
    }

}
