package cool.scx.live_room_watcher.impl.meme;

import cool.scx.live_room_watcher.util.Helper;
import cool.scx.util.$;
import io.vertx.core.http.WebSocket;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static cool.scx.constant.ScxDateTimeFormatter.yyyy_MM_dd_HH_mm_ss;
import static cool.scx.constant.ScxDateTimeFormatter.yyyy_MM_dd_HH_mm_ss_SSS;
import static java.lang.System.Logger.Level.DEBUG;

public class WatchTask {

    public static final System.Logger logger = System.getLogger(WatchTask.class.getName());

    final MEMELiveRoomWatcher watcher;
    final String roomID;
    ScheduledFuture<?> heartbeatFuture;
    AtomicInteger heartbeatFailTime = new AtomicInteger(0);
    WebSocket webSocket;

    public WatchTask(MEMELiveRoomWatcher watcher, String roomID) {
        this.watcher = watcher;
        this.roomID = roomID;
    }

    public void start() {
        stop();
        var webSocketFuture = watcher.httpClient.webSocket(watcher.getWebsocketChannelOptions(roomID));
        webSocketFuture.onSuccess(ws -> {
            webSocket = ws;
            logger.log(DEBUG,"连接成功 " + yyyy_MM_dd_HH_mm_ss.format(LocalDateTime.now()));
            startHeartbeat(ws);
            ws.textMessageHandler(c -> {
                $.async(() -> watcher.callMessage(c));
            });
            ws.closeHandler((v) -> {
                logger.log(DEBUG,"连接关闭 " + yyyy_MM_dd_HH_mm_ss.format(LocalDateTime.now()));
                //重连
                start();
            });
            ws.exceptionHandler(e -> {
                e.printStackTrace();
                //重连
                start();
            });
        }).onFailure(e -> {
            e.printStackTrace();
            logger.log(DEBUG,"连接失败");
        });
    }

    public void startHeartbeat(WebSocket webSocket) {
        heartbeatFuture = Helper.scheduler.scheduleAtFixedRate(() -> {
            webSocket.writeTextMessage("HEARTBEAT").onSuccess(c -> {
                logger.log(DEBUG,"心跳发送成功 : " + yyyy_MM_dd_HH_mm_ss_SSS.format(LocalDateTime.now()));
            }).onFailure(e -> {
                int i = heartbeatFailTime.addAndGet(1);
                if (i < 4) {
                    logger.log(DEBUG,"心跳发送失败第 " + i + " 次 : " + yyyy_MM_dd_HH_mm_ss_SSS.format(LocalDateTime.now()));
                } else {
                    logger.log(DEBUG,"心跳发送失败达到 " + i + " 次, 重新连接 : " + yyyy_MM_dd_HH_mm_ss_SSS.format(LocalDateTime.now()));
                    start();
                }
            });
        }, 0, 5, TimeUnit.SECONDS);
    }

    public void stop() {
        if (webSocket != null) {
            webSocket.closeHandler((c) -> {});
            webSocket.exceptionHandler((c) -> {});
            webSocket.close().onSuccess(c -> {
                logger.log(DEBUG,"关闭成功");
                webSocket = null;
            });
        }
        if (heartbeatFuture != null) {
            heartbeatFuture.cancel(false);
            heartbeatFuture = null;
        }
    }

}
