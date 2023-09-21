package cool.scx.live_room_watcher.impl.kuaishou;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;

import java.io.IOException;
import java.util.Map;

// todo 未完成
public class KuaiShouLiveRoomWatcher extends OfficialPassiveLiveRoomWatcher {

    @Override
    protected AccessToken getAccessToken0() throws IOException, InterruptedException {
        return null;
    }

    @Override
    protected LiveRoomInfo liveInfo(String tokenOrRoomID) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public String taskStart(String roomID, MsgType msgType) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public String taskStop(String roomID, MsgType msgType) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public String taskStatus(String roomID, MsgType msgType) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public String failDataGet(String roomID, MsgType msgType, Integer pageNum, Integer pageSize) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public String topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException {
        return null;
    }

    @Override
    public void call(String bodyStr, Map<String, String> header, MsgType msgType) throws JsonProcessingException {

    }

}
