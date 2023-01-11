package cool.scx.live_room_watcher.douyin.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum ControlMessageAction {

    PAUSE(1),
    RESUME(2),
    FINISH(3),
    FINISH_BY_ADMIN(4),
    CHANGE_NODE(5),
    ROOM_FINISH_BY_SWITCH(6),
    PING_TIMEOUT(7);

    private static final Map<Long, ControlMessageAction> MAP = initMap();

    final long code;

    ControlMessageAction(long i) {
        this.code = i;
    }

    private static Map<Long, ControlMessageAction> initMap() {
        var map = new HashMap<Long, ControlMessageAction>();
        for (var value : ControlMessageAction.values()) {
            map.put(value.code(), value);
        }
        return map;
    }

    public static ControlMessageAction of(long i) {
        return MAP.get(i);
    }

    public long code() {
        return code;
    }

}
