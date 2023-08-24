package cool.scx.live_room_watcher.douyin_hack;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.douyin_hack.entity.DouYinApplication;

import java.util.ArrayList;
import java.util.List;

import static cool.scx.live_room_watcher.douyin_hack.DouYinHackHelper.parseBody;

public class DouYinHackLiveRoomInfo implements LiveRoomInfo {

    private final DouYinApplication douYinApplication;

    public DouYinHackLiveRoomInfo(String indexHtmlStr) throws JsonProcessingException {
        this.douYinApplication = parseBody(indexHtmlStr);
    }

    @Override
    public List<String> liveRoomWebStreamURLs() {
        var webStreamUrl = this.douYinApplication.app.initialState.roomStore.roomInfo.web_stream_url;
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
        return this.douYinApplication.app.initialState.roomStore.roomInfo.room.title;
    }

    @Override
    public String liveRoomID() {
        return this.douYinApplication.app.initialState.roomStore.roomInfo.roomId;
    }
    
}
