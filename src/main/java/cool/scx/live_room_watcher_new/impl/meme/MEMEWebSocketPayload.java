package cool.scx.live_room_watcher_new.impl.meme;

import java.util.Map;

public class MEMEWebSocketPayload {
    public String messageId;
    public Long roomId;
    public String action;
    public Map<String, Object> data;
    public Long timestamp;
}
