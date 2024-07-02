// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/data/GradeBuffInfo.proto
// Protobuf Java Version: 4.27.1

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public interface GradeBuffInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GradeBuffInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 buffLevel = 1;</code>
   * @return The buffLevel.
   */
  long getBuffLevel();

  /**
   * <code>int32 status = 2;</code>
   * @return The status.
   */
  int getStatus();

  /**
   * <code>int64 endTime = 3;</code>
   * @return The endTime.
   */
  long getEndTime();

  /**
   * <code>map&lt;int64, int64&gt; statsInfoMap = 4;</code>
   */
  int getStatsInfoMapCount();
  /**
   * <code>map&lt;int64, int64&gt; statsInfoMap = 4;</code>
   */
  boolean containsStatsInfoMap(
      long key);
  /**
   * Use {@link #getStatsInfoMapMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.Long, java.lang.Long>
  getStatsInfoMap();
  /**
   * <code>map&lt;int64, int64&gt; statsInfoMap = 4;</code>
   */
  java.util.Map<java.lang.Long, java.lang.Long>
  getStatsInfoMapMap();
  /**
   * <code>map&lt;int64, int64&gt; statsInfoMap = 4;</code>
   */
  long getStatsInfoMapOrDefault(
      long key,
      long defaultValue);
  /**
   * <code>map&lt;int64, int64&gt; statsInfoMap = 4;</code>
   */
  long getStatsInfoMapOrThrow(
      long key);

  /**
   * <code>.Image buffBadge = 5;</code>
   * @return Whether the buffBadge field is set.
   */
  boolean hasBuffBadge();
  /**
   * <code>.Image buffBadge = 5;</code>
   * @return The buffBadge.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getBuffBadge();
  /**
   * <code>.Image buffBadge = 5;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getBuffBadgeOrBuilder();
}
