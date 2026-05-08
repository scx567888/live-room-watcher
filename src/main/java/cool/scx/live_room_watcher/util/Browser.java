package cool.scx.live_room_watcher.util;


import dev.scx.http.ScxHttpClientRequest;
import dev.scx.http.headers.cookie.Cookie;
import dev.scx.http.headers.cookie.Cookies;
import dev.scx.http.x.HttpClient;
import dev.scx.http.x.HttpClientOptions;
import dev.scx.http.x.proxy.Proxy;
import dev.scx.websocket.x.ScxClientWebSocketHandshakeRequest;
import dev.scx.websocket.x.WebSocketClient;
import dev.scx.websocket.x.WebSocketOptions;

import java.util.HashMap;
import java.util.Map;

import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * 模拟浏览器的 HttpClient
 */
public class Browser {

    private final Map<String, Cookie> cookieMap = new HashMap<>();
    private final HttpClient httpClient;
    private final WebSocketClient webSocketClient;

    public Browser(Proxy proxy) {
        this.httpClient = new HttpClient(new HttpClientOptions().proxy(proxy));
        this.webSocketClient = new WebSocketClient(this.httpClient, new WebSocketOptions().maxFrameSize(65536 * 10).maxMessageSize(65536 * 40));
    }

    public Browser() {
        this(null);
    }

    public ScxHttpClientRequest request() {
        var request = httpClient.request();

        request.addHeader("User-Agent", navigator().userAgent());
        request.addCookie(cookieMap.values().toArray(Cookie[]::new));

        var setCookie = request.headers().setCookies();
        for (var s : setCookie) {
            addCookie(s);
        }
        return request;
    }

    public ScxClientWebSocketHandshakeRequest webSocketHandshakeRequest() {
        var webSocketHandshakeRequest = webSocketClient.webSocketHandshakeRequest();

        webSocketHandshakeRequest.addHeader("User-Agent", navigator().userAgent());
        webSocketHandshakeRequest.addCookie(cookieMap.values().toArray(Cookie[]::new));

        return webSocketHandshakeRequest;
    }

    public Cookie getCookie(String cookieName) {
        return cookieMap.get(cookieName);
    }

    public Browser addCookie(Cookie c) {
        cookieMap.put(c.name(), c);
        return this;
    }

    public Browser addCookies(Cookies c) {
        if (c == null) {
            return this;
        }
        for (Cookie cookie : c) {
            cookieMap.put(cookie.name(), cookie);
        }
        return this;
    }

}
