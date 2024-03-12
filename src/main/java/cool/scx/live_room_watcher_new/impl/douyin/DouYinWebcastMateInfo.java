package cool.scx.live_room_watcher_new.impl.douyin;

import cool.scx.live_room_watcher_new.LiveRoomAnchor;
import cool.scx.live_room_watcher_new.LiveRoomInfo;

import java.util.List;

/**
 * 直播间信息相应包装体
 */
public class DouYinWebcastMateInfo implements LiveRoomInfo, LiveRoomAnchor {

    public String room_id;
    public String anchor_open_id;
    public String avatar_url;
    public String nick_name;

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
        return room_id;
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return this;
    }

    @Override
    public String anchorNickName() {
        return nick_name;
    }

    @Override
    public String anchorAvatar() {
        return avatar_url;
    }

    @Override
    public String anchorID() {
        return anchor_open_id;
    }

}
