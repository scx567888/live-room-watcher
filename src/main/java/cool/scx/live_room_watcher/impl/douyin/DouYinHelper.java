package cool.scx.live_room_watcher.impl.douyin;

import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static cool.scx.common.util.HashUtils.md5;

class DouYinHelper {

    /**
     * 校验参数数据是否正确
     */
    public static void checkDouYinData(String bodyStr, Map<String, String> headers, String dataSecret) {
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

    /**
     * 验证算法
     *
     * @param header  a
     * @param bodyStr a
     * @param secret  a
     * @return a
     */
    private static String signature(Map<String, String> header, String bodyStr, String secret) {
        var urlParams = header.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(k -> k.getKey() + "=" + k.getValue())
                .collect(Collectors.joining("&"));

        var rawData = urlParams + bodyStr + secret;
        var md5Bytes = md5(rawData.getBytes());
        return Base64.getEncoder().encodeToString(md5Bytes);
    }

}
