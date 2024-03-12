package cool.scx.live_room_watcher;

import java.io.IOException;

public abstract class OfficialLiveRoomWatcher extends BaseLiveRoomWatcher {

    /**
     * 查询直播间信息
     *
     * @param tokenOrRoomID a
     * @return a
     */
    public abstract LiveRoomInfo liveInfo(String tokenOrRoomID) throws IOException, InterruptedException;

    /**
     * 推送失败数据获取
     *
     * @param roomID   房间号
     * @param msgType  消息类型
     * @param pageNum  分页
     * @param pageSize 分页
     * @return a
     */
    public abstract Object failDataGet(String roomID, MsgType msgType, Integer pageNum, Integer pageSize) throws IOException, InterruptedException;

    /**
     * 置顶礼物
     *
     * @param roomCode      a
     * @param secGiftIDList a
     * @return a
     */
    public abstract Object topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException;

}
