package cool.scx.live_room_watcher.impl._560game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cool.scx.util.ObjectUtils;
import cool.scx.util.ScxExceptionHelper;
import cool.scx.util.ScxFuture;
import io.netty.util.Timeout;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketConnectOptions;

import static cool.scx.live_room_watcher.impl._560game._560GameHelper.getWsUrl;
import static cool.scx.live_room_watcher.impl._560game._560GameHelper.setTimeout;
import static java.lang.System.Logger.Level.DEBUG;
import static java.lang.System.Logger.Level.ERROR;

public class _560GameWatchTask {

    private final int pingIntervalTime;

    private final int pingTimeoutTime;

    private static final System.Logger logger = System.getLogger(_560GameWatchTask.class.getName());

    private final String username;
    private final String password;
    private final _560GameLiveRoomWatcher watcher;
    private ScxFuture<WebSocket> webSocketFuture;
    private WebSocket webSocket;

    private Timeout ping;
    private Timeout pingTimeout;

    public _560GameWatchTask(String username, String password, _560GameLiveRoomWatcher watcher) {
        this.username = username;
        this.password = password;
        this.watcher = watcher;
        this.pingIntervalTime = 1000 * 5;
        this.pingTimeoutTime = 1000 * 5;
    }

    public void start() {
        stop();
        var s = watcher.validateUser(this.username, this.password);
        var ws_url = getWsUrl(s, username);
        this.webSocketFuture = new ScxFuture<>(watcher.webSocketClient.connect(new WebSocketConnectOptions().setAbsoluteURI(ws_url)));

        webSocketFuture.onSuccess(ws -> {
            webSocket = ws;
            logger.log(DEBUG, "连接成功 ");
            ws.textMessageHandler(c -> Thread.ofVirtual().start(() -> {
                startPing();
                startPingTimeout();
                logger.log(DEBUG,"收到消息 {0}",c);
                try {
                    var jsonNode = ScxExceptionHelper.wrap(() -> ObjectUtils.jsonMapper().readTree(c));
                    ((ObjectNode) jsonNode).put("roomID", username);
                    var MsgType = jsonNode.get("MsgType").asInt();
                    switch (MsgType) {
                        case 7 -> callOffline(jsonNode);//游戏下线
                        case 8 -> callPong(jsonNode);//心跳响应
                        default -> watcher.callMessage(jsonNode);
                    }
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

        //启动心跳
        this.startPing();
        //心跳超时
        this.startPingTimeout();
    }

    public void stop() {
        stopWebSocket();
        //取消心跳
        this.cancelPing();
        //取消心跳超时
        this.cancelPingTimeout();
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

    public static void callOffline(JsonNode args) {

    }

    private void startPingTimeout() {
        cancelPingTimeout();
        this.pingTimeout = setTimeout(this::doPingTimeout, pingTimeoutTime + pingIntervalTime);
    }
    
    protected void startPing() {
        cancelPing();
        this.ping = setTimeout(() -> {
            sendPing();
            startPing();
        }, pingIntervalTime);
    }

    private void sendPing() {
        var sendPingFuture = this.webSocket.writeTextMessage("ping");

        sendPingFuture.onSuccess(v -> {

            //LOGGER
            if (logger.isLoggable(DEBUG)) {
                logger.log(DEBUG, "发送 ping 成功");
            }

        }).onFailure(c -> {

            //LOGGER
            if (logger.isLoggable(DEBUG)) {
                logger.log(DEBUG, "发送 ping 失败",c);
            }

        });
    }

    private void cancelPing() {
        if (this.ping != null) {
            this.ping.cancel();
            this.ping = null;
        }
    }

    public void callPong(JsonNode args) {
        
    }

    private void cancelPingTimeout() {
        if (this.pingTimeout != null) {
            this.pingTimeout.cancel();
            this.pingTimeout = null;
        }
    }

    protected  void doPingTimeout(){
        start();
    }

}
