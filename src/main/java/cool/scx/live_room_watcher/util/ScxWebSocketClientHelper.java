package cool.scx.live_room_watcher.util;


import dev.scx.websocket.x.ScxClientWebSocketHandshakeRequest;
import dev.scx.websocket.x.ScxWebSocketClient;
import dev.scx.websocket.x.WebSocketClient;

/// ScxWebSocketClientHelper
///
/// @author scx567888
/// @version 0.0.1
public final class ScxWebSocketClientHelper {

    public static final ScxWebSocketClient DEFAULT_WEBSOCKET_CLIENT = new WebSocketClient();

    public static ScxClientWebSocketHandshakeRequest webSocketHandshakeRequest() {
        return DEFAULT_WEBSOCKET_CLIENT.webSocketHandshakeRequest();
    }

}

