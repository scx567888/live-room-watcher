package cool.scx.live_room_watcher.impl.tiktok_hack.message;

import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.GiftMessage;
import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

public class TikTokHackGift implements Gift {
    
    public final GiftMessage giftMessage;
    private final TikTokHackUser user;

    public TikTokHackGift(GiftMessage giftMessage) {
        this.giftMessage=giftMessage;
        this.user=new TikTokHackUser(giftMessage.getUser());
    }

    @Override
    public String name() {
        return giftMessage.getGift().getName();
    }

    @Override
    public long count() {
        return giftMessage.getGroupCount();
    }

    @Override
    public User user() {
        return this.user;
    }

    @Override
    public String roomID() {
        return "";
    }
    
}
