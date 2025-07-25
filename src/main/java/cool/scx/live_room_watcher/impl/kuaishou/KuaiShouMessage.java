package cool.scx.live_room_watcher.impl.kuaishou;

import cool.scx.object.node.Node;

public class KuaiShouMessage {

    public Long timestamp;
    public String app_id;
    public String event;
    public String message_id;
    public KuaiShouMessageData data;

    public static class KuaiShouMessageData {
        public String push_type;
        public String unique_message_id;
        public String author_open_id;
        public String live_timestamp;
        public String room_code;
        public Node payload;
    }

}
