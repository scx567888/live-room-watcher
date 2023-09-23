package cool.scx.live_room_watcher.impl.douyin.message;


import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;


public class DouYinComment implements Chat, User {

    public String msg_id; // string类型id
    public String sec_openid; // 评论用户的加密openid, 当前其实没有加密
    public String content; // 评论内容
    public String avatar_url; // 评论用户头像
    public String nickname; // 评论用户昵称(不加密)
    public Long timestamp; // 评论毫秒级时间戳

    //由代码赋值
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
