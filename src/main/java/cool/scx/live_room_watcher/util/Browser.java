package cool.scx.live_room_watcher.util;


import cool.scx.http.*;
import cool.scx.http.cookie.Cookie;
import cool.scx.http.helidon.ScxHttpClientHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * 模拟浏览器的 HttpClient
 */
public class Browser {

    private final Map<String, Cookie> cookieMap = new HashMap<>();
//    private final ScxHttpClient httpClient;
//    private final WebSocketClient webSocketClient;

    public Browser() {
//        this.httpClient = initHttpClient();
//        this.webSocketClient = initWebSocketClient();
    }

    private ScxHttpClient initWebSocketClient() {
//        var options = new WebSocketClientOptions();
//        options.setMaxFrameSize(65536 * 10);
//        options.setMaxMessageSize(65536 * 40);
//        options.setProxyOptions(
//                        new ProxyOptions()
//                                .setHost("127.0.0.1")
//                                .setPort(17890)
//                );
//        return vertx.createWebSocketClient(options);
        return null;
    }

    /**
     * <p>initHttpClient.</p>
     *
     * @return a {@link io.vertx.core.http.HttpClient} object
     */
//    private static ScxHttpClient initHttpClient() {
//        var options = new HttpClientOptions();
        //调大一些
//        options.setMaxWebSocketFrameSize(65536 * 10);
//        options.setMaxWebSocketMessageSize(65536 * 40);
//                .setTrustOptions(new KeyStoreOptions()
//                        .setPath("keystore.jks")
//                        .setPassword("123456")
//                        .setType("jks")
//                )
//        options.setProxyOptions(
//                        new ProxyOptions()
//                                .setHost("127.0.0.1")
//                                .setPort(17890)
//                );
//        return vertx.createHttpClient(options);
//    }

    public ScxHttpClientRequest request() {
        var request = ScxHttpClientHelper.request();
        //
        request.addHeader("User-Agent", navigator().userAgent());
        request.addCookie(cookieMap.values().toArray(Cookie[]::new));
        //
        var setCookie = request.headers().setCookies();
        for (var s : setCookie) {
            addCookie(s);
        }
        return request;
    }

    public ScxClientWebSocketBuilder webSocket(ScxClientWebSocketBuilder options) {
        options.addHeader("User-Agent", navigator().userAgent());
        options.addCookie(cookieMap.values().toArray(Cookie[]::new));
        return options;
    }

    public Cookie getCookie(String cookieName) {
        return cookieMap.get(cookieName);
    }

    public Browser addCookie(Cookie c) {
        cookieMap.put(c.name(), c);
        return this;
    }

}
