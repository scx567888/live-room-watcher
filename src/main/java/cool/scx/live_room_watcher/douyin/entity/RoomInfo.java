package cool.scx.live_room_watcher.douyin.entity;

import java.util.List;
import java.util.Map;

/**
 * <p>RoomInfo class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class RoomInfo {

    public Room room;
    public String roomId;
    public String web_rid;
    public Anchor anchor;
    public RoomExtra roomExtra;
    public Integer enter_mode;
    public String qrcode_url;
    public PartitionRoadMap partition_road_map;
    public List<Map<String, Object>> relevant_rooms;
    public WebStreamUrl web_stream_url;

}
