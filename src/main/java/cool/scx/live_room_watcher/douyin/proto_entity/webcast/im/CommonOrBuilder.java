// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/Common.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>CommonOrBuilder interface.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public interface CommonOrBuilder extends
        // @@protoc_insertion_point(interface_extends:Common)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string method = 1;</code>
     *
     * @return The method.
     */
    java.lang.String getMethod();

    /**
     * <code>string method = 1;</code>
     *
     * @return The bytes for method.
     */
    com.google.protobuf.ByteString
    getMethodBytes();

    /**
     * <code>int64 msgId = 2;</code>
     *
     * @return The msgId.
     */
    long getMsgId();

    /**
     * <code>int64 roomId = 3;</code>
     *
     * @return The roomId.
     */
    long getRoomId();

    /**
     * <code>int64 createTime = 4;</code>
     *
     * @return The createTime.
     */
    long getCreateTime();

    /**
     * <code>int32 monitor = 5;</code>
     *
     * @return The monitor.
     */
    int getMonitor();

    /**
     * <code>bool isShowMsg = 6;</code>
     *
     * @return The isShowMsg.
     */
    boolean getIsShowMsg();

    /**
     * <code>string describe = 7;</code>
     *
     * @return The describe.
     */
    java.lang.String getDescribe();

    /**
     * <code>string describe = 7;</code>
     *
     * @return The bytes for describe.
     */
    com.google.protobuf.ByteString
    getDescribeBytes();

    /**
     * <code>.Text displayText = 8;</code>
     *
     * @return Whether the displayText field is set.
     */
    boolean hasDisplayText();

    /**
     * <code>.Text displayText = 8;</code>
     *
     * @return The displayText.
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Text getDisplayText();

    /**
     * <code>.Text displayText = 8;</code>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextOrBuilder} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextOrBuilder getDisplayTextOrBuilder();

    /**
     * <code>int64 foldType = 9;</code>
     *
     * @return The foldType.
     */
    long getFoldType();

    /**
     * <code>int64 anchorFoldType = 10;</code>
     *
     * @return The anchorFoldType.
     */
    long getAnchorFoldType();

    /**
     * <code>int64 priorityScore = 11;</code>
     *
     * @return The priorityScore.
     */
    long getPriorityScore();

    /**
     * <code>string logId = 12;</code>
     *
     * @return The logId.
     */
    java.lang.String getLogId();

    /**
     * <code>string logId = 12;</code>
     *
     * @return The bytes for logId.
     */
    com.google.protobuf.ByteString
    getLogIdBytes();

    /**
     * <code>string msgProcessFilterK = 13;</code>
     *
     * @return The msgProcessFilterK.
     */
    java.lang.String getMsgProcessFilterK();

    /**
     * <code>string msgProcessFilterK = 13;</code>
     *
     * @return The bytes for msgProcessFilterK.
     */
    com.google.protobuf.ByteString
    getMsgProcessFilterKBytes();

    /**
     * <code>string msgProcessFilterV = 14;</code>
     *
     * @return The msgProcessFilterV.
     */
    java.lang.String getMsgProcessFilterV();

    /**
     * <code>string msgProcessFilterV = 14;</code>
     *
     * @return The bytes for msgProcessFilterV.
     */
    com.google.protobuf.ByteString
    getMsgProcessFilterVBytes();

    /**
     * <code>.User user = 15;</code>
     *
     * @return Whether the user field is set.
     */
    boolean hasUser();

    /**
     * <code>.User user = 15;</code>
     *
     * @return The user.
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.User getUser();

    /**
     * <code>.User user = 15;</code>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

    /**
     * <code>.Room room = 16;</code>
     *
     * @return Whether the room field is set.
     */
    boolean hasRoom();

    /**
     * <code>.Room room = 16;</code>
     *
     * @return The room.
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Room getRoom();

    /**
     * <code>.Room room = 16;</code>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.RoomOrBuilder} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.RoomOrBuilder getRoomOrBuilder();

    /**
     * <code>int64 anchorFoldTypeV2 = 17;</code>
     *
     * @return The anchorFoldTypeV2.
     */
    long getAnchorFoldTypeV2();

    /**
     * <code>int64 processAtSeiTimeMs = 18;</code>
     *
     * @return The processAtSeiTimeMs.
     */
    long getProcessAtSeiTimeMs();

    /**
     * <code>int64 randomDispatchMs = 19;</code>
     *
     * @return The randomDispatchMs.
     */
    long getRandomDispatchMs();

    /**
     * <code>bool isDispatch = 20;</code>
     *
     * @return The isDispatch.
     */
    boolean getIsDispatch();

    /**
     * <code>int64 channelId = 21;</code>
     *
     * @return The channelId.
     */
    long getChannelId();

    /**
     * <code>int64 diffSei2absSecond = 22;</code>
     *
     * @return The diffSei2absSecond.
     */
    long getDiffSei2AbsSecond();

    /**
     * <code>int64 anchorFoldDuration = 23;</code>
     *
     * @return The anchorFoldDuration.
     */
    long getAnchorFoldDuration();

    /**
     * <code>int64 appId = 24;</code>
     *
     * @return The appId.
     */
    long getAppId();
}
