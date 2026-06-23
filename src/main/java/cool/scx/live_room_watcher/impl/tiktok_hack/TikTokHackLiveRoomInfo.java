package cool.scx.live_room_watcher.impl.tiktok_hack;

import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;
import dev.scx.node.Node;
import dev.scx.node.ObjectNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

import static dev.scx.serialize.ScxSerialize.convertObject;
import static dev.scx.serialize.ScxSerialize.fromJson;

// todo 暂已失效
public class TikTokHackLiveRoomInfo implements LiveRoomInfo {

    public final TikTokHackLiveRoom LiveRoom;

    public TikTokHackLiveRoomInfo(String htmlStr) {
        try {
            Document parse = Jsoup.parse(htmlStr);
            var element = parse.selectFirst("#SIGI_STATE");
            var html = element.html();
            var root = (ObjectNode) fromJson(html);
            this.LiveRoom = convertObject(root.get("LiveRoom"), TikTokHackLiveRoom.class);
        } catch (Exception e) {
            throw new RuntimeException("解析直播间错误 !!!", e);
        }
    }

    @Override
    public List<String> webStreamURLs() {
        return null;
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
        public Node streamData;
        public String roomID;
    }

}
