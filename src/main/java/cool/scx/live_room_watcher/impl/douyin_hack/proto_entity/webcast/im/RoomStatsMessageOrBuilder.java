// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/RoomStatsMessage.proto
// Protobuf Java Version: 4.27.1

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface RoomStatsMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RoomStatsMessage)
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
   * <code>string displayShort = 2;</code>
   * @return The displayShort.
   */
  java.lang.String getDisplayShort();
  /**
   * <code>string displayShort = 2;</code>
   * @return The bytes for displayShort.
   */
  com.google.protobuf.ByteString
      getDisplayShortBytes();

  /**
   * <code>string displayMiddle = 3;</code>
   * @return The displayMiddle.
   */
  java.lang.String getDisplayMiddle();
  /**
   * <code>string displayMiddle = 3;</code>
   * @return The bytes for displayMiddle.
   */
  com.google.protobuf.ByteString
      getDisplayMiddleBytes();

  /**
   * <code>string displayLong = 4;</code>
   * @return The displayLong.
   */
  java.lang.String getDisplayLong();
  /**
   * <code>string displayLong = 4;</code>
   * @return The bytes for displayLong.
   */
  com.google.protobuf.ByteString
      getDisplayLongBytes();

  /**
   * <code>int64 displayValue = 5;</code>
   * @return The displayValue.
   */
  long getDisplayValue();

  /**
   * <code>int64 displayVersion = 6;</code>
   * @return The displayVersion.
   */
  long getDisplayVersion();

  /**
   * <code>bool incremental = 7;</code>
   * @return The incremental.
   */
  boolean getIncremental();

  /**
   * <code>bool isHidden = 8;</code>
   * @return The isHidden.
   */
  boolean getIsHidden();

  /**
   * <code>int64 total = 9;</code>
   * @return The total.
   */
  long getTotal();

  /**
   * <code>int64 displayType = 10;</code>
   * @return The displayType.
   */
  long getDisplayType();
}
