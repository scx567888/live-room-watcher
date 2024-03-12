package cool.scx.live_room_watcher_new.impl.meme;

import cool.scx.util.SingleListenerFuture;
import io.vertx.core.http.WebSocket;

import java.util.concurrent.atomic.AtomicInteger;

import static cool.scx.live_room_watcher_new.impl.meme.MEMEWatchTaskStatus.STARTING;
import static cool.scx.live_room_watcher_new.impl.meme.MEMEWatchTaskStatus.STOP;
import static java.lang.System.Logger.Level.DEBUG;
import static java.lang.System.Logger.Level.ERROR;

public class MEMEWatchTask {

    public static final System.Logger logger = System.getLogger(MEMEWatchTask.class.getName());
    final MEMELiveRoomWatcher watcher;
    final String roomID;
    MEMEWatchTaskStatus status;
    SingleListenerFuture<WebSocket> webSocketFuture;
    Thread heartbeatThread;
    AtomicInteger heartbeatFailTime = new AtomicInteger(0);
    WebSocket webSocket;

    public MEMEWatchTask(MEMELiveRoomWatcher watcher, String roomID) {
        this.watcher = watcher;
        this.roomID = roomID;
    }

    public void start() {
        stop();
        status = STARTING;
        this.webSocketFuture = new SingleListenerFuture<>(watcher.webSocketClient.connect(watcher.getWebsocketChannelOptions(roomID)));
        webSocketFuture.onSuccess(ws -> {
            if (status == STOP) {
                return;
            }
            webSocket = ws;
            logger.log(DEBUG, "连接成功 ");
            startHeartbeat();
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

    public void startHeartbeat() {
        stopHeartbeat();
        //重置 失败次数
        heartbeatFailTime.set(0);
        heartbeat();
    }

    public void heartbeat() {
        if (status == STOP) {
            return;
        }
        webSocket.writeTextMessage("HEARTBEAT").onSuccess(c -> {
            logger.log(DEBUG, "心跳发送成功 : " + this.roomID + " " + this.hashCode());
        }).onFailure(e -> {
            int i = heartbeatFailTime.addAndGet(1);
            if (i < 4) {
                logger.log(DEBUG, "心跳发送失败第 " + i + " 次 : " + this.roomID, e);
            } else {
                logger.log(ERROR, "心跳发送失败达到 " + i + " 次, 重新连接 : " + this.roomID, e);
                start();
            }
        });

        heartbeatThread = Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(5000);
                heartbeat();
            } catch (InterruptedException ignored) {

            }
        });

    }

    public void stop() {
        status = STOP;
        stopWebSocket();
        stopHeartbeat();
    }

    public void stopWebSocket() {
        if (webSocketFuture != null && !webSocketFuture.isComplete()) {
            webSocketFuture.onSuccess(webSocket -> {
                webSocket.close();
            }).onFailure(e -> {

            });
        }
        if (webSocket != null && !webSocket.isClosed()) {
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
        if (heartbeatThread != null) {
            heartbeatThread.interrupt();
            heartbeatThread = null;
        }
    }

}
