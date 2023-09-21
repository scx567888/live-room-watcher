package cool.scx.live_room_watcher.impl.meme;

import cool.scx.util.HashUtils;

import static java.lang.System.Logger.Level.DEBUG;

public class MEMEHelper {

    public static final System.Logger logger = System.getLogger(MEMEHelper.class.getName());

    public static String getSign(String body, String appSecret, String nonce, Long timestamp) {
        var res = HashUtils.md5Hex(body + appSecret + nonce + timestamp);
        logger.log(DEBUG, "获取签名结果 :{0}", res);
        return res;
    }

}
