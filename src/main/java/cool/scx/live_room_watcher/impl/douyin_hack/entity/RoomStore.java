package cool.scx.live_room_watcher.impl.douyin_hack.entity;

import java.util.List;
import java.util.Map;

/**
 * <p>RoomStore class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class RoomStore {

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
    public List<Map<String,Object>> relevantRooms;

}
