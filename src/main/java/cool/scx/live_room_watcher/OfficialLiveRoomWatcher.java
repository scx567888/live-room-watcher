package cool.scx.live_room_watcher;

import java.io.IOException;

public interface OfficialLiveRoomWatcher extends LiveRoomWatcher {

    /**
     * 查询直播间信息
     *
     * @param tokenOrRoomID a
     * @return a
     */
    LiveRoomInfo liveInfo(String tokenOrRoomID) throws IOException, InterruptedException;

    /**
     * 推送失败数据获取
     *
     * @param roomID   房间号
     * @param msgType  消息类型
     * @param pageNum  分页
     * @param pageSize 分页
     * @return a
     */
    Object failDataGet(String roomID, MsgType msgType, Integer pageNum, Integer pageSize) throws IOException, InterruptedException;

    /**
     * 置顶礼物
     *
     * @param roomCode      a
     * @param secGiftIDList a
     * @return a
     */
    Object topGift(String roomCode, String[] secGiftIDList) throws IOException, InterruptedException;

    @Override
    default void startWatch() {
        throw new UnsupportedOperationException("请使用 startWatch(String roomID) !!!");
    }

    @Override
    default void stopWatch() {
        throw new UnsupportedOperationException("请使用 stopWatch(String roomID) !!!");
    }

    /**
     * a
     *
     * @param roomID a
     */
    void startWatch(String roomID) throws IOException, InterruptedException;

    /**
     * a
     *
     * @param roomID a
     */
    void stopWatch(String roomID) throws IOException, InterruptedException;

}
