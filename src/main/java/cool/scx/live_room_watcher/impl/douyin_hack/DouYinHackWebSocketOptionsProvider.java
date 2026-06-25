package cool.scx.live_room_watcher.impl.douyin_hack;

import cool.scx.live_room_watcher.impl.douyin_hack.util.Browser;
import dev.scx.function.Function1;
import dev.scx.http.headers.cookie.Cookies;

public interface DouYinHackWebSocketOptionsProvider extends Function1<Browser, DouYinHackWebSocketOptions, Exception> {

    static DouYinHackWebSocketOptionsProvider ofWebSocketURL(String websocketURL, String cookiesStr) {
        return _ -> new DouYinHackWebSocketOptions(websocketURL, Cookies.parse(cookiesStr));
    }

    static DouYinHackWebSocketOptionsProvider ofPlaywright(String liveRoomURI) {
        return new PlaywrightDouYinHackWebSocketOptionsProvider(liveRoomURI);
    }

    static DouYinHackWebSocketOptionsProvider ofPlaywright(String liveRoomURI, String cookiesStr) {
        return new PlaywrightDouYinHackWebSocketOptionsProvider(liveRoomURI, cookiesStr);
    }

}
