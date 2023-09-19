package cool.scx.live_room_watcher.kuaishou_hack;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.kuaishou_hack.entity.KuaiShouInitialState;

import java.util.List;

import static cool.scx.live_room_watcher.kuaishou_hack.KuaiShouHackHelper.parseBody;

public class KuaiShouHackLiveRoomInfo implements LiveRoomInfo, LiveRoomAnchor {

    private final KuaiShouInitialState kuaiShouInitialState;

    public KuaiShouHackLiveRoomInfo(String string) throws JsonProcessingException {
        this.kuaiShouInitialState = parseBody(string);
    }

    @Override
    public String anchorNickName() {
        return null;
    }

    @Override
    public String anchorAvatar() {
        return null;
    }

    @Override
    public String anchorID() {
        return null;
    }

    @Override
    public List<String> liveRoomWebStreamURLs() {
        return List.of();
    }

    @Override
    public String liveRoomTitle() {
        return null;
    }

    @Override
    public String liveRoomID() {
        return  null;
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return this;
    }
}
