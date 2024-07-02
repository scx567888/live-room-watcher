package cool.scx.live_room_watcher;

import java.util.Map;

/**
 * 针对一些官方的接口
 */
public interface OfficialLiveRoomWatcher extends LiveRoomWatcher {

    /**
     * 查询直播间信息
     *
     * @param tokenOrRoomID a
     * @return a
     */
    LiveRoomInfo liveInfo(String tokenOrRoomID);

    /**
     * 推送失败数据获取
     *
     * @param roomID      房间号
     * @param messageType 消息类型
     * @param pageNum     分页
     * @param pageSize    分页
     * @return a
     */
    Object failDataGet(String roomID, MessageType messageType, Integer pageNum, Integer pageSize);

    /**
     * 置顶礼物
     *
     * @param roomID  a
     * @param giftIDs a
     * @return a
     */
    Object topGift(String roomID, String... giftIDs);

    /**
     * 启动推送任务
     *
     * @param roomID  roomID
     * @param roundID roundID
     * @param msgType msgType
     * @return a
     */
    Object taskStart(String roomID, String roundID, MessageType msgType);

    /**
     * 终止推送任务
     *
     * @param roomID  roomID
     * @param roundID roundID
     * @param msgType msgType
     * @return a
     */
    Object taskStop(String roomID, String roundID, MessageType msgType);

    /**
     * 查询任务状态
     *
     * @param roomID  roomID
     * @param roundID roundID
     * @param msgType msgType
     * @return a
     */
    Object taskStatus(String roomID, String roundID, MessageType msgType);

    /**
     * 被动调用接口
     *
     * @param bodyStr     a
     * @param header      a
     * @param messageType a
     */
    void call(String bodyStr, Map<String, String> header, MessageType messageType);

}
