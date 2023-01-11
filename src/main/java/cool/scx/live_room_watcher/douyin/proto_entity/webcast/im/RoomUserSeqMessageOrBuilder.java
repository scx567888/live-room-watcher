// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/RoomUserSeqMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>RoomUserSeqMessageOrBuilder interface.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public interface RoomUserSeqMessageOrBuilder extends
        // @@protoc_insertion_point(interface_extends:RoomUserSeqMessage)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.Common common = 1;</code>
     *
     * @return Whether the common field is set.
     */
    boolean hasCommon();

    /**
     * <code>.Common common = 1;</code>
     *
     * @return The common.
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common getCommon();

    /**
     * <code>.Common common = 1;</code>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor ranksList = 2;</code>
     *
     * @return a {@link java.util.List} object
     */
    java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.Contributor>
    getRanksListList();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor ranksList = 2;</code>
     *
     * @param index a int
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.Contributor} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.Contributor getRanksList(int index);

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor ranksList = 2;</code>
     *
     * @return a int
     */
    int getRanksListCount();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor ranksList = 2;</code>
     *
     * @return a {@link java.util.List} object
     */
    java.util.List<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.ContributorOrBuilder>
    getRanksListOrBuilderList();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor ranksList = 2;</code>
     *
     * @param index a int
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.ContributorOrBuilder} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.ContributorOrBuilder getRanksListOrBuilder(
            int index);

    /**
     * <code>int64 total = 3;</code>
     *
     * @return The total.
     */
    long getTotal();

    /**
     * <code>string popStr = 4;</code>
     *
     * @return The popStr.
     */
    java.lang.String getPopStr();

    /**
     * <code>string popStr = 4;</code>
     *
     * @return The bytes for popStr.
     */
    com.google.protobuf.ByteString
    getPopStrBytes();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor seatsList = 5;</code>
     *
     * @return a {@link java.util.List} object
     */
    java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.Contributor>
    getSeatsListList();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor seatsList = 5;</code>
     *
     * @param index a int
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.Contributor} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.Contributor getSeatsList(int index);

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor seatsList = 5;</code>
     *
     * @return a int
     */
    int getSeatsListCount();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor seatsList = 5;</code>
     *
     * @return a {@link java.util.List} object
     */
    java.util.List<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.ContributorOrBuilder>
    getSeatsListOrBuilderList();

    /**
     * <code>repeated .RoomUserSeqMessage.Contributor seatsList = 5;</code>
     *
     * @param index a int
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.ContributorOrBuilder} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.RoomUserSeqMessage.ContributorOrBuilder getSeatsListOrBuilder(
            int index);

    /**
     * <code>int64 popularity = 6;</code>
     *
     * @return The popularity.
     */
    long getPopularity();

    /**
     * <code>int64 totalUser = 7;</code>
     *
     * @return The totalUser.
     */
    long getTotalUser();

    /**
     * <code>string totalUserStr = 8;</code>
     *
     * @return The totalUserStr.
     */
    java.lang.String getTotalUserStr();

    /**
     * <code>string totalUserStr = 8;</code>
     *
     * @return The bytes for totalUserStr.
     */
    com.google.protobuf.ByteString
    getTotalUserStrBytes();

    /**
     * <code>string totalStr = 9;</code>
     *
     * @return The totalStr.
     */
    java.lang.String getTotalStr();

    /**
     * <code>string totalStr = 9;</code>
     *
     * @return The bytes for totalStr.
     */
    com.google.protobuf.ByteString
    getTotalStrBytes();

    /**
     * <code>string onlineUserForAnchor = 10;</code>
     *
     * @return The onlineUserForAnchor.
     */
    java.lang.String getOnlineUserForAnchor();

    /**
     * <code>string onlineUserForAnchor = 10;</code>
     *
     * @return The bytes for onlineUserForAnchor.
     */
    com.google.protobuf.ByteString
    getOnlineUserForAnchorBytes();

    /**
     * <code>string totalPvForAnchor = 11;</code>
     *
     * @return The totalPvForAnchor.
     */
    java.lang.String getTotalPvForAnchor();

    /**
     * <code>string totalPvForAnchor = 11;</code>
     *
     * @return The bytes for totalPvForAnchor.
     */
    com.google.protobuf.ByteString
    getTotalPvForAnchorBytes();

    /**
     * <code>string upRightStatsStr = 12;</code>
     *
     * @return The upRightStatsStr.
     */
    java.lang.String getUpRightStatsStr();

    /**
     * <code>string upRightStatsStr = 12;</code>
     *
     * @return The bytes for upRightStatsStr.
     */
    com.google.protobuf.ByteString
    getUpRightStatsStrBytes();

    /**
     * <code>string upRightStatsStrComplete = 13;</code>
     *
     * @return The upRightStatsStrComplete.
     */
    java.lang.String getUpRightStatsStrComplete();

    /**
     * <code>string upRightStatsStrComplete = 13;</code>
     *
     * @return The bytes for upRightStatsStrComplete.
     */
    com.google.protobuf.ByteString
    getUpRightStatsStrCompleteBytes();
}
