package cool.scx.live_room_watcher.cc;

import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;

import java.util.List;

/**
 * 直播间信息相应包装体
 */
public class CCLiveInfo implements LiveRoomInfo, LiveRoomAnchor {

    public String roomid;
    public String sec_openid;
    public String avatar_url;
    public String nickname;

    @Override
    public List<String> liveRoomWebStreamURLs() {
        return null;
    }

    @Override
    public String liveRoomTitle() {
        return null;
    }

    @Override
    public String liveRoomID() {
        return roomid;
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return this;
    }


    @Override
    public String anchorNickName() {
        return nickname;
    }

    @Override
    public String anchorAvatar() {
        return avatar_url;
    }

    @Override
    public String anchorID() {
        return sec_openid;
    }
    
}
