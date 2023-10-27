package cool.scx.live_room_watcher.impl.meme;

import io.vertx.core.http.WebSocket;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.Logger.Level.DEBUG;
import static java.lang.System.Logger.Level.ERROR;

public enum MEMEWatchTaskStatus {

    /**
     * 没有启动时
     */
    WAITING,
    
    /**
     * 启动中
     */
    STARTING,

    /**
     * 启动完成运行中
     */
    RUNNING,

    /**
     * 停止
     */
    STOP,

}
