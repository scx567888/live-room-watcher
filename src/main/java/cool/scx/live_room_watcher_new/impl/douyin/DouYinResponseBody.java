package cool.scx.live_room_watcher_new.impl.douyin;

import com.fasterxml.jackson.databind.JsonNode;

public record DouYinResponseBody(Integer errcode, String errmsg, String err_tips, String err_msg, Integer error,
                                 Integer err_no,
                                 String logid, String message, JsonNode data) {
}
