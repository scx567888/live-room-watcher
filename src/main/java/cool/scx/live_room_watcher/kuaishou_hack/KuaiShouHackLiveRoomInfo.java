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
        return kuaiShouInitialState.liveroom.author.name;
    }

    @Override
    public String anchorAvatar() {
        return kuaiShouInitialState.liveroom.author.avatar;
    }

    @Override
    public String anchorID() {
        return kuaiShouInitialState.liveroom.author.id;
    }

    @Override
    public List<String> liveRoomWebStreamURLs() {
        return List.of();
    }

    @Override
    public String liveRoomTitle() {
        return kuaiShouInitialState.liveroom.liveStream.caption;
    }

    @Override
    public String liveRoomID() {
        return kuaiShouInitialState.liveroom.liveStream.id;
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return this;
    }
}
