package cool.scx.live_room_watcher.impl.douyin_hack;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.impl.douyin_hack.entity.DouYinAPP;

import java.util.ArrayList;
import java.util.List;

import static cool.scx.live_room_watcher.impl.douyin_hack.DouYinHackHelper.parseBody;

public class DouYinHackLiveRoomInfo implements LiveRoomInfo, LiveRoomAnchor {

    private final DouYinAPP douYinApp;

    public DouYinHackLiveRoomInfo(String indexHtmlStr) throws JsonProcessingException {
        this.douYinApp = parseBody(indexHtmlStr);
    }

    @Override
    public List<String> liveRoomWebStreamURLs() {
        var webStreamUrl = this.douYinApp.state.roomStore.roomInfo.web_stream_url;
        if (webStreamUrl == null) {
            return List.of();
        }
        var list = new ArrayList<String>();
        list.add(webStreamUrl.hls_pull_url_map.FULL_HD1);
        list.add(webStreamUrl.hls_pull_url_map.SD1);
        list.add(webStreamUrl.hls_pull_url_map.SD2);
        list.add(webStreamUrl.flv_pull_url.FULL_HD1);
        list.add(webStreamUrl.flv_pull_url.SD1);
        list.add(webStreamUrl.flv_pull_url.SD2);
        return list;
    }

    @Override
    public String liveRoomTitle() {
        return this.douYinApp.state.roomStore.roomInfo.room.title;
    }

    @Override
    public String liveRoomID() {
        return this.douYinApp.state.roomStore.roomInfo.roomId;
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return this;
    }


    @Override
    public String anchorNickName() {
        return this.douYinApp.state.roomStore.roomInfo.anchor.nickname;
    }

    @Override
    public String anchorAvatar() {
        return this.douYinApp.state.roomStore.roomInfo.anchor.avatar_thumb.url_list.get(0);
    }

    @Override
    public String anchorID() {
        return this.douYinApp.state.roomStore.roomInfo.anchor.sec_uid;
    }

}
