package cool.scx.live_room_watcher.impl.douyin_hack.entity;

import java.util.List;
import java.util.Map;

public class DouYinAPP {

    public State state;

    public static class State {

        public Boolean isLiveModal;
        public Map<String, Object> appStore;
        public Map<String, Object> userStore;
        public Map<String, Object> homeStore;
        public RoomStore roomStore;
        public Map<String, Object> linkmicStore;
        public Map<String, Object> giftStore;
        public Map<String, Object> pkStore;
        public Map<String, Object> audienceStore;
        public Map<String, Object> abStore;
        public Map<String, Object> fansClubStore;
        public Map<String, Object> layoutStore;
        public Map<String, Object> streamStore;
        public Map<String, Object> cameraStore;
        public Map<String, Object> exhibitionStore;
        public Map<String, Object> hourRankListStore;
        public Map<String, Object> feedStore;
        public Map<String, Object> singletonStore;
        public Map<String, Object> wishListStore;
        public Map<String, Object> hybridStore;
        public Map<String, Object> eventStore;
        public Map<String, Object> paidLiveStore;

    }

    public static class RoomStore {

        public String store;
        public RoomInfo roomInfo;
        public List<String> emojiList;
        public Map<String, Object> emojiReflex;
        public String liveStatus;
        public Map<String, Object> likeStatus;
        public Map<String, Object> followInfo;
        public Boolean isUgcLive;
        public Boolean pausePop;
        public Boolean hasAppointment;
        public Boolean enableProgramme;
        public Boolean abProgramme;
        public Boolean forceEnableH265;
        public Boolean liveDetailPlayerHasPlay;
        public String notSupportReason;
        public List<String> longtouchList;
        public Boolean longtouchShowTcc;
        public List<String> usePageUrlBannerId;
        public Boolean isAsianGames;
        public List<Map<String, Object>> relevantRooms;

    }

    public static class RoomInfo {

        public Room room;
        public String roomId;
        public String web_rid;
        public Anchor anchor;
        public Map<String, Object> roomExtra;
        public Integer enter_mode;
        public String qrcode_url;
        public Map<String, Object> partition_road_map;
        public WebStreamUrl web_stream_url;

    }

    public static class Room {

        public String id_str;
        public String title;
        public StreamUrl stream_url;
        public Integer live_room_mode;
        public Map<String, Object> room_view_stats;
        public Stats stats;
        public Map<String, Object> paid_live_data;
        public String strategy_config;
        public Owner owner;
        public Integer like_count;

    }

    public static class WebStreamUrl {

        public PullUrl flv_pull_url;
        public String default_resolution;
        public PullUrl hls_pull_url_map;
        public String hls_pull_url;
        public Integer stream_orientation;
        public Map<String, Object> live_core_sdk_data;
        public Map<String, Object> extra;
        public Map<String, Object> pull_datas;

    }

    public static class PullUrl {

        public String FULL_HD1;
        public String SD1;
        public String SD2;

    }

    public static class StreamUrl {

        public PullUrl flv_pull_url;
        public String default_resolution;
        public Map<String, Object> live_core_sdk_data;
        public PullUrl hls_pull_url_map;
        public Integer stream_orientation;

    }

    public static class Stats {

        public String total_user_desp;
        public Integer like_count;
        public String total_user_str;
        public String user_count_str;

    }

    public static class Owner {

        public String nickname;
        public String id_str;
        public String sec_uid;

    }

    public static class Anchor {

        public String id_str;
        public String sec_uid;
        public String nickname;
        public AvatarThumb avatar_thumb;
        public Map<String, Object> follow_info;

    }

    public static class AvatarThumb {

        public List<String> url_list;

    }

}
