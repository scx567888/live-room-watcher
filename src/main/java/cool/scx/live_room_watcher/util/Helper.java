package cool.scx.live_room_watcher.util;

import io.vertx.core.Vertx;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Helper {

    public static final ScheduledExecutorService SCHEDULER = Executors.newScheduledThreadPool(1000);
   
    public static final Vertx VERTX = Vertx.vertx();

}
