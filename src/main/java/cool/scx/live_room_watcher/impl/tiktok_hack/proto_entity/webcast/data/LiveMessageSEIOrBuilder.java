// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: tiktok_hack/webcast/data/LiveMessageSEI.proto
// Protobuf Java Version: 4.29.0

package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data;

public interface LiveMessageSEIOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tiktok_hack.LiveMessageSEI)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.tiktok_hack.LiveMessageID uniqueId = 1;</code>
   * @return Whether the uniqueId field is set.
   */
  boolean hasUniqueId();
  /**
   * <code>.tiktok_hack.LiveMessageID uniqueId = 1;</code>
   * @return The uniqueId.
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageID getUniqueId();
  /**
   * <code>.tiktok_hack.LiveMessageID uniqueId = 1;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LiveMessageIDOrBuilder getUniqueIdOrBuilder();

  /**
   * <code>string timestamp = 2;</code>
   * @return The timestamp.
   */
  java.lang.String getTimestamp();
  /**
   * <code>string timestamp = 2;</code>
   * @return The bytes for timestamp.
   */
  com.google.protobuf.ByteString
      getTimestampBytes();
}
