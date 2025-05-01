package cool.scx.live_room_watcher.impl.tiktok_hack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import cool.scx.common.util.ObjectUtils;
import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class TikTokHackLiveRoomInfo implements LiveRoomInfo {

    public final TikTokHackLiveRoom LiveRoom;

    public TikTokHackLiveRoomInfo(String htmlStr) {
        try {
            Document parse = Jsoup.parse(htmlStr);
            var element = parse.selectFirst("#SIGI_STATE");
            var html = element.html();
            var root = ObjectUtils.jsonMapper().readTree(html);
            this.LiveRoom = ObjectUtils.jsonMapper().convertValue(root.get("LiveRoom"), TikTokHackLiveRoom.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("解析直播间错误 !!!", e);
        }
    }

    @Override
    public String[] webStreamURLs() {
        return new String[]{};
    }

    @Override
    public String title() {
        return LiveRoom.liveRoomUserInfo.liveRoom.title;
    }

    @Override
    public String roomID() {
        return LiveRoom.liveRoomUserInfo.user.roomId;
    }

    @Override
    public LiveRoomAnchor anchor() {
        return null;
    }

    static class TikTokHackLiveRoom {
        public TikTokHackLiveRoomUserInfo liveRoomUserInfo;
    }

    static class TikTokHackLiveRoomUserInfo {
        public TikTokHackLiveRoomUserInfoUser user;
        public TikTokHackLiveRoomUserInfoLiveRoom liveRoom;
    }

    static class TikTokHackLiveRoomUserInfoUser {
        public String avatarLarger;
        public String avatarMedium;
        public String avatarThumb;
        public String id;
        public String nickname;
        public String secUid;
        public String secret;
        public String uniqueId;
        public String verified;
        public String roomId;
        public String signature;
        public String status;
    }

    static class TikTokHackLiveRoomUserInfoLiveRoom {
        public String title;
        public JsonNode streamData;
        public String roomID;
    }

}
