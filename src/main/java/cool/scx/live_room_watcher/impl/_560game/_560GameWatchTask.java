package cool.scx.live_room_watcher.impl._560game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cool.scx.common.exception.ScxExceptionHelper;
import cool.scx.common.util.ObjectUtils;
import cool.scx.scheduling.ScheduleContext;
import cool.scx.websocket.handler.ScxEventWebSocket;
import cool.scx.websocket.x.ScxWebSocketClientHelper;

import static cool.scx.live_room_watcher.impl._560game._560GameHelper.getWsUrl;
import static cool.scx.scheduling.ScxScheduling.setTimeout;
import static java.lang.System.Logger.Level.DEBUG;
import static java.lang.System.Logger.Level.ERROR;

public class _560GameWatchTask {

    private static final System.Logger logger = System.getLogger(_560GameWatchTask.class.getName());
    private final int pingIntervalTime;
    private final int pingTimeoutTime;
    private final String username;
    private final String password;
    private final _560GameLiveRoomWatcher watcher;
    private ScxEventWebSocket webSocketFuture;
    private ScxEventWebSocket webSocket;

    private ScheduleContext ping;
    private ScheduleContext pingTimeout;

    public _560GameWatchTask(String username, String password, _560GameLiveRoomWatcher watcher) {
        this.username = username;
        this.password = password;
        this.watcher = watcher;
        this.pingIntervalTime = 1000 * 5;
        this.pingTimeoutTime = 1000 * 5;
    }

    public static void callOffline(JsonNode args) {

    }

    public void start() {
        stop();
        var s = watcher.validateUser(this.username, this.password);
        var ws_url = getWsUrl(s, username);
        logger.log(DEBUG, "连接开始 地址" + ws_url);
        var ws = ScxWebSocketClientHelper.webSocketHandshakeRequest().uri(ws_url).webSocket();
        this.webSocketFuture = ScxEventWebSocket.of(ws);
        try {

            webSocket = webSocketFuture;
            logger.log(DEBUG, "连接成功 ");
            webSocketFuture.onTextMessage((c, _) -> Thread.ofVirtual().start(() -> {
                startPing();
                startPingTimeout();
                logger.log(DEBUG, "收到消息 {0}", c);
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
            webSocketFuture.onClose((v, _) -> {
                logger.log(DEBUG, "连接关闭 ");
                //重连
                start();
            });
            webSocketFuture.onError(e -> {
                logger.log(ERROR, "连接异常 :", e);
                //重连
                start();
            });
            webSocketFuture.start();
        } catch (Exception e) {
            logger.log(ERROR, "连接失败", e);
            //重连
            start();
        }

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
        if (webSocket != null && !webSocket.isClosed()) {
            webSocket.onClose((c, _) -> {});
            webSocket.onError((c) -> {});
            webSocket.close();
            logger.log(DEBUG, "关闭成功");
            webSocket = null;
        }
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
        try {
            var sendPingFuture = this.webSocket.send("ping");


            //LOGGER
            if (logger.isLoggable(DEBUG)) {
                logger.log(DEBUG, "发送 ping 成功");
            }
        } catch (Exception e) {
            //LOGGER
            if (logger.isLoggable(DEBUG)) {
                logger.log(DEBUG, "发送 ping 失败", e);
            }
        }


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

    protected void doPingTimeout() {
        start();
    }

}
