package cool.scx.live_room_watcher.impl.douyin_hack.util;


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

/// 模拟浏览器的 HttpClient 和 WebSocketClient
public final class Browser {

    private final HttpClient httpClient;
    private final WebSocketClient webSocketClient;
    private final Map<String, Cookie> cookieMap;
    private final Navigator navigator;

    /// proxy 可为 null
    public Browser(Proxy proxy) {
        this.httpClient = new HttpClient(new HttpClientOptions().proxy(proxy));
        this.webSocketClient = new WebSocketClient(this.httpClient, new WebSocketOptions().maxFrameSize(65536 * 10).maxMessageSize(65536 * 40));
        this.cookieMap = new HashMap<>();
        this.navigator = new Navigator();
    }

    public ScxHttpClientRequest request() {
        var request = httpClient.request();

        request.addHeader("User-Agent", navigator.userAgent());
        request.addHeader("Accept", acceptValue());
        request.addCookie(cookieMap.values().toArray(Cookie[]::new));

        var setCookies = request.headers().setCookies();
        for (var cookie : setCookies) {
            addCookie(cookie);
        }

        return request;
    }

    public ScxClientWebSocketHandshakeRequest webSocketHandshakeRequest() {
        var webSocketHandshakeRequest = webSocketClient.webSocketHandshakeRequest();

        webSocketHandshakeRequest.addHeader("User-Agent", navigator.userAgent());
        webSocketHandshakeRequest.addHeader("Accept", acceptValue());
        webSocketHandshakeRequest.addCookie(cookieMap.values().toArray(Cookie[]::new));

        return webSocketHandshakeRequest;
    }

    public Cookie getCookie(String cookieName) {
        return cookieMap.get(cookieName);
    }

    public Browser addCookie(Cookie cookie) {
        cookieMap.put(cookie.name(), cookie);
        return this;
    }

    public Browser addCookies(Cookies cookies) {
        if (cookies == null) {
            return this;
        }
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.name(), cookie);
        }
        return this;
    }

    public String acceptValue() {
        return "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7";
    }

    public static final class Navigator {

        public boolean cookieEnabled() {
            return true;
        }

        public String userAgent() {
            return appCodeName() + "/" + appVersion();
        }

        public String appCodeName() {
            return "Mozilla";
        }

        public String language() {
            return "zh-CN";
        }

        public String platform() {
            return "Win32";
        }

        public String appVersion() {
            return "5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.49";
        }

        public boolean onLine() {
            return true;
        }

    }

}
