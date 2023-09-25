package cool.scx.live_room_watcher.impl.kuaishou;

import cool.scx.util.ObjectUtils;

import java.util.Map;

public class KuaiShouResponse {
    
    public static String ok() {
        return ObjectUtils.toJson(Map.of("result",1),"");
    }

    public static String fail(String errorMsg) {
        return ObjectUtils.toJson(Map.of("result",0,"errorMsg",errorMsg),"");
    }
    
}
