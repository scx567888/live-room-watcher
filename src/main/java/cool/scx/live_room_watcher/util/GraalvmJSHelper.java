package cool.scx.live_room_watcher.util;

import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.HostAccess;

public class GraalvmJSHelper {

    public static final Engine ENGINE = Engine.newBuilder().option("engine.WarnInterpreterOnly", "false").build();
    public static final HostAccess HOST_ACCESS = HostAccess.newBuilder(HostAccess.EXPLICIT).allowListAccess(true).build();

}
