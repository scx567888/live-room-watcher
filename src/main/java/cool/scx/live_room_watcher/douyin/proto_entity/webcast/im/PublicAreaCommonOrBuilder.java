// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/PublicAreaCommon.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>PublicAreaCommonOrBuilder interface.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public interface PublicAreaCommonOrBuilder extends
        // @@protoc_insertion_point(interface_extends:PublicAreaCommon)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.Image userLabel = 1;</code>
     *
     * @return Whether the userLabel field is set.
     */
    boolean hasUserLabel();

    /**
     * <code>.Image userLabel = 1;</code>
     *
     * @return The userLabel.
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image getUserLabel();

    /**
     * <code>.Image userLabel = 1;</code>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.ImageOrBuilder} object
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.ImageOrBuilder getUserLabelOrBuilder();

    /**
     * <code>int64 userConsumeInRoom = 2;</code>
     *
     * @return The userConsumeInRoom.
     */
    long getUserConsumeInRoom();

    /**
     * <code>int64 userSendGiftCntInRoom = 3;</code>
     *
     * @return The userSendGiftCntInRoom.
     */
    long getUserSendGiftCntInRoom();
}
