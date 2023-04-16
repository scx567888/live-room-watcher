package cool.scx.live_room_watcher.douyin.entity;

import java.util.List;
import java.util.Map;

/**
 * <p>RoomStore class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class RoomStore {

    public RoomInfo roomInfo;
    public List<String> emojiList;
    public Map<String, Object> emojiReflex;
    public String liveStatus;
    public Map<String, Object> followInfo;
    public Boolean isUgcLive;
    public Boolean hasAppointment;
    public Boolean enableProgramme;
    public Boolean abProgramme;
    public Boolean forceEnableH265;

}
