// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/CommonTextMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

public interface CommonTextMessageOrBuilder extends
        // @@protoc_insertion_point(interface_extends:CommonTextMessage)
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
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

    /**
     * <code>.User user = 2;</code>
     *
     * @return Whether the user field is set.
     */
    boolean hasUser();

    /**
     * <code>.User user = 2;</code>
     *
     * @return The user.
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.User getUser();

    /**
     * <code>.User user = 2;</code>
     */
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

    /**
     * <code>string scene = 3;</code>
     *
     * @return The scene.
     */
    java.lang.String getScene();

    /**
     * <code>string scene = 3;</code>
     *
     * @return The bytes for scene.
     */
    com.google.protobuf.ByteString
    getSceneBytes();
}
