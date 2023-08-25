package cool.scx.live_room_watcher.cc;

import cool.scx.live_room_watcher.MsgType;

import java.util.Map;

public class CCHelper {

    public static String getMsgTypeValue(MsgType msgType) {
        return switch (msgType) {
            case LIVE_COMMENT -> "live_comment";
            case LIVE_GIFT -> "live_gift";
            case LIVE_LIKE -> "live_like";
            case LIVE_FANS_CLUB -> throw new UnsupportedOperationException();
        };
    }

   public static final Map<String,String> DEFAULT_CC_GIFT_AND_NAME_MAP = Map.of(
           "26884","愚你同乐",
           "26885","小飞机",
           "26886","营养快充",
           "26887","杯盏明月",
           "26888","独角兽",
           "26889","我养你",
           "27121","法拉利"
   ); 
    
}
