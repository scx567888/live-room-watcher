package cool.scx.live_room_watcher;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Map;

public abstract class OfficialPassiveLiveRoomWatcher extends OfficialLiveRoomWatcher {

    /**
     * 被动调用接口
     *
     * @param bodyStr a
     * @param header  a
     * @param msgType a
     */
    public abstract void call(String bodyStr, Map<String, String> header, MsgType msgType) throws JsonProcessingException;

    public abstract Object taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException;

    public abstract Object taskStop(String roomID, MsgType msgType) throws IOException, InterruptedException;

    public abstract Object taskStatus(String roomID, MsgType msgType) throws IOException, InterruptedException;

}
