package cool.scx.live_room_watcher.douyin.type;

import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;

import java.util.List;

/**
 * 直播间信息相应包装体
 */
public class WebcastMateInfo implements LiveRoomInfo, LiveRoomAnchor {

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
