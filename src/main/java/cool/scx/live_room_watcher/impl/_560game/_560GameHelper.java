package cool.scx.live_room_watcher.impl._560game;

import cool.scx.http.uri.ScxURI;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

import static cool.scx.common.util.HashUtils.md5Hex;
import static cool.scx.common.util.HashUtils.sha256Hex;
import static cool.scx.common.constant.ScxDateTimeFormatter.yyyy_MM_dd;

public class _560GameHelper {

    public static ScxURI getWsUrl(String baseUrl, String roomid) {
        var data = yyyy_MM_dd.format(LocalDate.now()) + ":" + roomid;
        return ScxURI.of(baseUrl)
                .addQuery("client_token", sha256Hex(data).toLowerCase())
                .addQuery("roomId", roomid);
    }

    public static String getSign(Map<String, String> map, String secret) {
        var urlParams = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(k -> k.getKey() + "=" + k.getValue())
                .collect(Collectors.joining("&"));
        var s = urlParams + "&secret=" + secret;
        return md5Hex(s).toUpperCase();
    }

}
