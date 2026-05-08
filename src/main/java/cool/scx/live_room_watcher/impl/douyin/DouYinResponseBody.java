package cool.scx.live_room_watcher.impl.douyin;

import dev.scx.node.Node;

/**
 * 抖音官方的通用响应体结构
 */
public record DouYinResponseBody(Integer errcode,
                                 String errmsg,
                                 String err_tips,
                                 String err_msg,
                                 Integer error,
                                 Integer err_no,
                                 String logid,
                                 String message,
                                 Node data) {

}
