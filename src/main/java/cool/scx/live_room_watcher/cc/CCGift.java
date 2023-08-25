package cool.scx.live_room_watcher.cc;

import cool.scx.live_room_watcher.Gift;
import cool.scx.live_room_watcher.User;

public class CCGift implements Gift, User {

    public String msg_id;
    public String sec_openid;    // 用户的加密openid，当前没有加密
    public String sec_gift_id;   // 加密的礼物id，当前没有加密
    public Integer gift_num;      // 送出的礼物数量
    public Long gift_value;      // 礼物总价值，单位分
    public String avatar_url;      // 用户头像
    public String nickname;     // 用户昵称(不加密)
    public Long timestamp; // 礼物毫秒级时间戳

    public String giftName;
    public String roomID;

    @Override
    public User user() {
        return this;
    }

    @Override
    public String name() {
        return giftName;
    }

    @Override
    public long count() {
        return gift_num;
    }

    @Override
    public String roomID() {
        return roomID;
    }

    @Override
    public String nickName() {
        return nickname;
    }

    @Override
    public String avatar() {
        return avatar_url;
    }

    @Override
    public String userID() {
        return sec_openid;
    }
}
