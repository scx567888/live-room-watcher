package cool.scx.live_room_watcher.impl.douyin_hack.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>ControlMessageAction class.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public enum ControlMessageAction {

    PAUSE(1),
    RESUME(2),
    FINISH(3),
    FINISH_BY_ADMIN(4),
    CHANGE_NODE(5),
    ROOM_FINISH_BY_SWITCH(6),
    PING_TIMEOUT(7);

    /**
     * Constant <code>MAP</code>
     */
    private static final Map<Long, ControlMessageAction> MAP = initMap();
    
    final long code;

    ControlMessageAction(long i) {
        this.code = i;
    }

    /**
     * <p>initMap.</p>
     *
     * @return a {@link java.util.Map} object
     */
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

    /**
     * <p>code.</p>
     *
     * @return a long
     */
    public long code() {
        return code;
    }

}
