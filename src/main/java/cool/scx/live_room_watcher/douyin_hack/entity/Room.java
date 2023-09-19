package cool.scx.live_room_watcher.douyin_hack.entity;

import java.util.Map;

/**
 * <p>Room class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class Room {
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
