// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/AudioChatMessage.proto

// Protobuf Java Version: 4.26.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface AudioChatMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AudioChatMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Common common = 1;</code>
   * @return Whether the common field is set.
   */
  boolean hasCommon();
  /**
   * <code>.Common common = 1;</code>
   * @return The common.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.Common getCommon();
  /**
   * <code>.Common common = 1;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

  /**
   * <code>.User user = 2;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.User user = 2;</code>
   * @return The user.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User getUser();
  /**
   * <code>.User user = 2;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

  /**
   * <code>string content = 3;</code>
   * @return The content.
   */
  java.lang.String getContent();
  /**
   * <code>string content = 3;</code>
   * @return The bytes for content.
   */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <code>string audioUrl = 4;</code>
   * @return The audioUrl.
   */
  java.lang.String getAudioUrl();
  /**
   * <code>string audioUrl = 4;</code>
   * @return The bytes for audioUrl.
   */
  com.google.protobuf.ByteString
      getAudioUrlBytes();

  /**
   * <code>int64 audioDuration = 5;</code>
   * @return The audioDuration.
   */
  long getAudioDuration();

  /**
   * <code>.PublicAreaCommon publicAreaCommon = 6;</code>
   * @return Whether the publicAreaCommon field is set.
   */
  boolean hasPublicAreaCommon();
  /**
   * <code>.PublicAreaCommon publicAreaCommon = 6;</code>
   * @return The publicAreaCommon.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PublicAreaCommon getPublicAreaCommon();
  /**
   * <code>.PublicAreaCommon publicAreaCommon = 6;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PublicAreaCommonOrBuilder getPublicAreaCommonOrBuilder();
}
