package cool.scx.live_room_watcher.impl._560game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cool.scx.util.ObjectUtils;
import cool.scx.util.ScxExceptionHelper;
import cool.scx.util.ScxFuture;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketConnectOptions;

import static cool.scx.live_room_watcher.impl._560game._560GameHelper.getWsUrl;
import static java.lang.System.Logger.Level.DEBUG;
import static java.lang.System.Logger.Level.ERROR;

public class _560GameWatchTask {

    private static final System.Logger logger = System.getLogger(_560GameWatchTask.class.getName());

    private final String username;
    private final String password;
    private final _560GameLiveRoomWatcher watcher;
    private ScxFuture<WebSocket> webSocketFuture;
    private WebSocket webSocket;

    public _560GameWatchTask(String username, String password, _560GameLiveRoomWatcher watcher) {
        this.username = username;
        this.password = password;
        this.watcher = watcher;
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
                try {
                    var jsonNode = ScxExceptionHelper.wrap(() -> ObjectUtils.jsonMapper().readTree(c));
                    ((ObjectNode) jsonNode).put("roomID", username);
                    var MsgType = jsonNode.get("MsgType").asInt();
                    switch (MsgType) {
                        case 7 -> callOffline(jsonNode);//游戏下线
                        case 8 -> callPing(jsonNode);//心跳响应
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
    }

    public void stop() {
        stopWebSocket();
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

    public void callPing(JsonNode args) {
        webSocket.writeTextMessage("ping");
    }

}
