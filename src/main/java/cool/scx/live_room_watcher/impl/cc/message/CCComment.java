package cool.scx.live_room_watcher.impl.cc.message;

import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;

public class CCComment implements Chat, User {

    public String msg_id;
    public String sec_openid;       // 弹幕用户的加密openid, 当前没有加密
    public String content;         // 弹幕内容
    public String avatar_url;      // 弹幕用户头像
    public String nickname;     // 弹幕用户昵称(不加密)
    public Long timestamp;   // 弹幕毫秒级时间戳

    public String roomID;

    @Override
    public String content() {
        return content;
    }

    @Override
    public User user() {
        return this;
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
