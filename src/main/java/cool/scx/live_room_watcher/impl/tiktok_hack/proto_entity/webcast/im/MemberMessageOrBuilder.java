// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: tiktok_hack/webcast/im/MemberMessage.proto
// Protobuf Java Version: 4.27.3

package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im;

public interface MemberMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tiktok_hack.MemberMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.tiktok_hack.Common common = 1;</code>
   * @return Whether the common field is set.
   */
  boolean hasCommon();
  /**
   * <code>.tiktok_hack.Common common = 1;</code>
   * @return The common.
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.Common getCommon();
  /**
   * <code>.tiktok_hack.Common common = 1;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

  /**
   * <code>.tiktok_hack.User user = 2;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.tiktok_hack.User user = 2;</code>
   * @return The user.
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.User getUser();
  /**
   * <code>.tiktok_hack.User user = 2;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

  /**
   * <code>string memberCount = 3;</code>
   * @return The memberCount.
   */
  java.lang.String getMemberCount();
  /**
   * <code>string memberCount = 3;</code>
   * @return The bytes for memberCount.
   */
  com.google.protobuf.ByteString
      getMemberCountBytes();
}
