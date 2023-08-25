package cool.scx.live_room_watcher.cc;

import cool.scx.live_room_watcher.Like;
import cool.scx.live_room_watcher.User;

public class CCLike implements Like, User {

    public String msg_id;
    public String sec_openid;      // 点赞用户的加密openid，当前没有加密
    public Integer like_num;       // 点赞数量，上游定期合并一次数据
    public String avatar_url;      // 点赞用户头像
    public String nickname;        // 点赞用户昵称(不加密)
    public Long timestamp;  // 点赞毫秒级时间戳

    public String roomID;

    @Override
    public User user() {
        return this;
    }

    @Override
    public long count() {
        return like_num;
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
