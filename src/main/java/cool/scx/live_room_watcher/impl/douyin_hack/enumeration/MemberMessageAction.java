package cool.scx.live_room_watcher.impl.douyin_hack.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>MemberMessageAction class.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public enum MemberMessageAction {

    ENTER(1),
    LEAVE(2),
    SET_SILENCE(3),
    CANCEL_SILENCE(4),
    SET_ADMIN(5),
    CANCEL_ADMIN(6),
    KICK_OUT(7),
    SHARE(8),
    MANAGER_SET_SILENCE(9),
    MANAGER_CANCEL_SILENCE(10),
    BLOCK(11),
    FOLLOW(20);

    /**
     * Constant <code>MAP</code>
     */
    private static final Map<Long, MemberMessageAction> MAP = initMap();


    final long code;

    MemberMessageAction(long i) {
        this.code = i;
    }

    /**
     * <p>initMap.</p>
     *
     * @return a {@link java.util.Map} object
     */
    private static Map<Long, MemberMessageAction> initMap() {
        var map = new HashMap<Long, MemberMessageAction>();
        for (var value : MemberMessageAction.values()) {
            map.put(value.code(), value);
        }
        return map;
    }

    public static MemberMessageAction of(long i) {
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
