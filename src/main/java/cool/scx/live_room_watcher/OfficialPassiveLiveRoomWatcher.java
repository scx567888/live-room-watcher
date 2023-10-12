package cool.scx.live_room_watcher;

import java.io.IOException;
import java.util.Map;

/**
 * 官方的被动接受的接口
 */
public abstract class OfficialPassiveLiveRoomWatcher extends OfficialLiveRoomWatcher {

    public abstract void call(String bodyStr, Map<String, String> header, MsgType msgType);

    public abstract Object taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException;

    public abstract Object taskStop(String roomID, MsgType msgType) throws IOException, InterruptedException;

    public abstract Object taskStatus(String roomID, MsgType msgType) throws IOException, InterruptedException;

}
