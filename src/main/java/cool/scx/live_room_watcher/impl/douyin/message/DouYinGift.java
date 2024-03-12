package cool.scx.live_room_watcher.impl.douyin.message;

import cool.scx.live_room_watcher.message.Gift;
import cool.scx.live_room_watcher.message.User;

public class DouYinGift implements Gift, User {

    public String msg_id; // string类型id
    public String sec_openid; // 用户的加密openid，当前其实没有加密
    public String sec_gift_id; // 加密的礼物id
    public String gift_name; // 礼物名称
    public Integer gift_num; // 送出的礼物数量
    public Integer gift_value; // 礼物总价值，单位分
    public String avatar_url; // 用户头像
    public String nickname; // 用户昵称(不加密)
    public Long timestamp; // 礼物毫秒级时间戳

    //由代码赋值
    public String roomID;

    @Override
    public User user() {
        return this;
    }

    @Override
    public String name() {
        return gift_name;
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
