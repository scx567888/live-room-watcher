package cool.scx.live_room_watcher.impl.douyin;

import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;

/**
 * 直播间信息相应包装体
 */
public class DouYinWebcastMateInfo implements LiveRoomInfo, LiveRoomAnchor {

    public String room_id;
    public String anchor_open_id;
    public String avatar_url;
    public String nick_name;

    @Override
    public String nickname() {
        return nick_name;
    }

    @Override
    public String avatar() {
        return avatar_url;
    }

    @Override
    public String anchorID() {
        return anchor_open_id;
    }

    @Override
    public String[] webStreamURLs() {
        return null;
    }

    @Override
    public String title() {
        return null;
    }

    @Override
    public String roomID() {
        return room_id;
    }

    @Override
    public LiveRoomAnchor anchor() {
        return this;
    }

}
