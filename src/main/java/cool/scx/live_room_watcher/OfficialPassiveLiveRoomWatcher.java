package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.util.Helper;

import java.io.IOException;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 官方的被动接受的接口
 */
public abstract class OfficialPassiveLiveRoomWatcher extends OfficialLiveRoomWatcher {

    public abstract void call(String bodyStr, Map<String, String> header, MsgType msgType);

    public abstract String taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException;

    public abstract String taskStop(String roomID, MsgType msgType) throws IOException, InterruptedException;

    public abstract String taskStatus(String roomID, MsgType msgType) throws IOException, InterruptedException;

}
