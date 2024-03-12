package cool.scx.live_room_watcher.impl.meme;

import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;

import java.util.List;

public class MEMELiveRoomAnchor implements LiveRoomAnchor, LiveRoomInfo {

    public Integer starId;
    public String starNickName;
    public String starAvatar;
    public String liveId;
    public String ws;

    @Override
    public String anchorNickName() {
        return starNickName;
    }

    @Override
    public String anchorAvatar() {
        return starAvatar;
    }

    @Override
    public String anchorID() {
        return starId + "";
    }

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
        return liveId;
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return this;
    }

}
