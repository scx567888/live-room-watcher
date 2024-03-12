package cool.scx.live_room_watcher_new.impl.kuaishou;

import cool.scx.util.HashUtils;
import cool.scx.util.ObjectUtils;
import cool.scx.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class KuaiShouHelper {

    /**
     * 获取参数 Map 的签名结果
     *
     * @param signParamsMap 含义见上述示例
     * @return 返回签名结果
     */
    public static String calcSign(Map<String, Object> signParamsMap, String app_ID, String APP_SECRET) {
        // 去掉 value 为空的
        Map<String, Object> trimmedParamMap = signParamsMap.entrySet()
                .stream()
                .filter(item -> !StringUtils.isEmpty(item.getValue().toString()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        trimmedParamMap.put("app_id", app_ID);

        // 按照字母排序
        Map<String, Object> sortedParamMap = trimmedParamMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // 组装成待签名字符串
        String paramStr = sortedParamMap.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
        String signStr = paramStr + APP_SECRET;

        // 生成签名返回 注意快手要求 md5 必须小写
        return HashUtils.md5Hex(signStr).toLowerCase();
    }

    public static String ok() {
        return ObjectUtils.toJson(Map.of("result", 1), "");
    }

    public static String fail(String errorMsg) {
        return ObjectUtils.toJson(Map.of("result", 0, "errorMsg", errorMsg), "");
    }

}
