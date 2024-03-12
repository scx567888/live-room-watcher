package cool.scx.live_room_watcher_new.impl.official.cc;

import cool.scx.live_room_watcher_new.type.MsgType;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static cool.scx.util.Base64Utils.encodeToString;
import static cool.scx.util.HashUtils.md5;

public class CCHelper {

    public static final Map<String, String> DEFAULT_CC_GIFT_AND_NAME_MAP = Map.of(
            "26884", "愚你同乐",
            "26885", "小飞机",
            "26886", "营养快充",
            "26887", "杯盏明月",
            "26888", "独角兽",
            "26889", "我养你",
            "27121", "法拉利"
    );

    public static void checkCCData(String bodyStr, Map<String, String> headers, String dataSecret) {
        var x_nonce_str = headers.get("x-nonce-str");
        var x_timestamp = headers.get("x-timestamp");
        var x_signature = headers.get("x-signature");
        var x_roomid = headers.get("x-roomid");
        var x_msg_type = headers.get("x-msg-type");
        if (x_nonce_str == null || x_timestamp == null || x_signature == null || x_roomid == null || x_msg_type == null) {
            throw new InvalidParameterException("参数验证错误！！！");
        }
        var s = Map.of(
                "x-nonce-str", x_nonce_str,
                "x-timestamp", x_timestamp,
                "x-roomid", x_roomid,
                "x-msg-type", x_msg_type
        );

        var s1 = signature(s, bodyStr, dataSecret);
        if (!Objects.equals(s1, x_signature)) {
            throw new InvalidParameterException("参数验证错误！！！");
        }
    }

    private static String signature(Map<String, String> header, String bodyStr, String secret) {
        var urlParams = header.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(k -> k.getKey() + "=" + k.getValue())
                .collect(Collectors.joining("&"));

        var rawData = urlParams + bodyStr + secret;
        var md5Bytes = md5(rawData.getBytes());
        return encodeToString(md5Bytes);
    }

    public static String getMsgTypeValue(MsgType msgType) {
        return switch (msgType) {
            case LIVE_COMMENT -> "live_comment";
            case LIVE_GIFT -> "live_gift";
            case LIVE_LIKE -> "live_like";
            case LIVE_FANS_CLUB, LIVE_FOLLOW -> throw new UnsupportedOperationException();
        };
    }

}
