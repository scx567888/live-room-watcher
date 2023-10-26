package cool.scx.live_room_watcher.impl.meme;

import cool.scx.live_room_watcher.util.Helper;
import io.vertx.core.http.WebSocket;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.Logger.Level.DEBUG;
import static java.lang.System.Logger.Level.ERROR;

public class MEMEWatchTask {

    public static final System.Logger logger = System.getLogger(MEMEWatchTask.class.getName());

    final MEMELiveRoomWatcher watcher;
    final String roomID;
    ScheduledFuture<?> heartbeatFuture;
    AtomicInteger heartbeatFailTime = new AtomicInteger(0);
    WebSocket webSocket;

    public MEMEWatchTask(MEMELiveRoomWatcher watcher, String roomID) {
        this.watcher = watcher;
        this.roomID = roomID;
    }

    public void start() {
        stop();
        var webSocketFuture = watcher.httpClient.webSocket(watcher.getWebsocketChannelOptions(roomID));
        webSocketFuture.onSuccess(ws -> {
            webSocket = ws;
            logger.log(DEBUG, "连接成功 ");
            startHeartbeat(ws);
            ws.textMessageHandler(c -> Thread.ofVirtual().start(() -> {
                try {
                    watcher.callMessage(c);
                } catch (Throwable e) {
                    logger.log(ERROR, "调用 callMessage 发生错误 :", e);
                }
            }));
            ws.closeHandler((v) -> {
                logger.log(DEBUG, "连接关闭 ");
                //重连
                start();
            });
            ws.exceptionHandler(e -> {
                logger.log(ERROR, "连接异常 :", e);
                //重连
                start();
            });
        }).onFailure(e -> {
            logger.log(ERROR, "连接失败", e);
            //重连
            start();
        });
    }

    public void startHeartbeat(WebSocket webSocket) {
        stopHeartbeat();
        //重置 失败次数
        heartbeatFailTime.set(0);
        heartbeatFuture = Helper.scheduler.scheduleAtFixedRate(() -> {
            webSocket.writeTextMessage("HEARTBEAT").onSuccess(c -> {
                logger.log(DEBUG, "心跳发送成功 : ");
            }).onFailure(e -> {
                int i = heartbeatFailTime.addAndGet(1);
                if (i < 4) {
                    logger.log(DEBUG, "心跳发送失败第 " + i + " 次 : ", e);
                } else {
                    logger.log(ERROR, "心跳发送失败达到 " + i + " 次, 重新连接 : ", e);
                    start();
                }
            });
        }, 0, 5, TimeUnit.SECONDS);
    }

    public void stop() {
        stopWebSocket();
        stopHeartbeat();
    }

    public void stopWebSocket() {
        if (webSocket != null) {
            webSocket.closeHandler((c) -> {});
            webSocket.exceptionHandler((c) -> {});
            webSocket.close().onSuccess(c -> {
                logger.log(DEBUG, "关闭成功");
                webSocket = null;
            }).onFailure(e -> {
                logger.log(ERROR, "关闭失败", e);
                webSocket = null;
            });
        }
    }

    public void stopHeartbeat() {
        if (heartbeatFuture != null) {
            heartbeatFuture.cancel(false);
            heartbeatFuture = null;
        }
    }

}
