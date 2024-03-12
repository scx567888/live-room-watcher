package cool.scx.live_room_watcher.util;

import cool.scx.http_client.ScxHttpClientHelper;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import io.netty.handler.codec.http.cookie.ClientCookieDecoder;
import io.netty.handler.codec.http.cookie.ClientCookieEncoder;
import io.netty.handler.codec.http.cookie.Cookie;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟浏览器的 HttpClient
 */
public class Browser {

    private final Map<String, Cookie> cookieMap = new HashMap<>();
    private final HttpClient httpClient;
    private final WebSocketClient webSocketClient;

    public Browser(Vertx vertx) {
        this.httpClient = initHttpClient(vertx);
        this.webSocketClient = initWebSocketClient(vertx);
    }

    private WebSocketClient initWebSocketClient(Vertx vertx) {
        var options=new WebSocketClientOptions();
//        options.setProxyOptions(
//                        new ProxyOptions()
//                                .setHost("127.0.0.1")
//                                .setPort(17890)
//                );
        return vertx.createWebSocketClient(options);
    }

    /**
     * <p>initHttpClient.</p>
     *
     * @return a {@link io.vertx.core.http.HttpClient} object
     */
    private static HttpClient initHttpClient(Vertx vertx) {
        var options = new HttpClientOptions();
        //调大一些
        options.setMaxWebSocketFrameSize(65536 * 10);
        options.setMaxWebSocketMessageSize(65536 * 40);
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
        return vertx.createHttpClient(options);
    }

    public ScxHttpClientResponse request(ScxHttpClientRequest request) throws IOException, InterruptedException {
        String cookieStr = ClientCookieEncoder.STRICT.encode(cookieMap.values());
        request.addHeader("User-Agent", Navigator.navigator().userAgent());
        request.addHeader("Cookie", cookieStr);
        var response = ScxHttpClientHelper.request(request);
        var setCookie = response.headers().allValues("Set-Cookie");
        for (var s : setCookie) {
            addCookie(ClientCookieDecoder.STRICT.decode(s));
        }
        return response;
    }

    public Future<WebSocket> webSocket(WebSocketConnectOptions options) {
        String cookieStr = ClientCookieEncoder.STRICT.encode(cookieMap.values());
        options.addHeader("User-Agent", Navigator.navigator().userAgent());
        options.addHeader("Cookie", cookieStr);
        return webSocketClient.connect(options);
    }

    public Cookie getCookie(String cookieName) {
        return cookieMap.get(cookieName);
    }

    public Browser addCookie(Cookie c) {
        cookieMap.put(c.name(), c);
        return this;
    }

}
