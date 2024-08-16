// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/Response.proto
// Protobuf Java Version: 4.27.3

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface ResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Response)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Message messages = 1;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.Message> 
      getMessagesList();
  /**
   * <code>repeated .Message messages = 1;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.Message getMessages(int index);
  /**
   * <code>repeated .Message messages = 1;</code>
   */
  int getMessagesCount();
  /**
   * <code>repeated .Message messages = 1;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.MessageOrBuilder> 
      getMessagesOrBuilderList();
  /**
   * <code>repeated .Message messages = 1;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.MessageOrBuilder getMessagesOrBuilder(
      int index);

  /**
   * <code>string cursor = 2;</code>
   * @return The cursor.
   */
  java.lang.String getCursor();
  /**
   * <code>string cursor = 2;</code>
   * @return The bytes for cursor.
   */
  com.google.protobuf.ByteString
      getCursorBytes();

  /**
   * <code>int64 fetch_interval = 3;</code>
   * @return The fetchInterval.
   */
  long getFetchInterval();

  /**
   * <code>int64 now = 4;</code>
   * @return The now.
   */
  long getNow();

  /**
   * <code>string internal_ext = 5;</code>
   * @return The internalExt.
   */
  java.lang.String getInternalExt();
  /**
   * <code>string internal_ext = 5;</code>
   * @return The bytes for internalExt.
   */
  com.google.protobuf.ByteString
      getInternalExtBytes();

  /**
   * <code>int32 fetch_type = 6;</code>
   * @return The fetchType.
   */
  int getFetchType();

  /**
   * <code>int64 heartbeat_duration = 8;</code>
   * @return The heartbeatDuration.
   */
  long getHeartbeatDuration();

  /**
   * <code>bool need_ack = 9;</code>
   * @return The needAck.
   */
  boolean getNeedAck();

  /**
   * <code>string push_server = 10;</code>
   * @return The pushServer.
   */
  java.lang.String getPushServer();
  /**
   * <code>string push_server = 10;</code>
   * @return The bytes for pushServer.
   */
  com.google.protobuf.ByteString
      getPushServerBytes();

  /**
   * <code>string live_cursor = 11;</code>
   * @return The liveCursor.
   */
  java.lang.String getLiveCursor();
  /**
   * <code>string live_cursor = 11;</code>
   * @return The bytes for liveCursor.
   */
  com.google.protobuf.ByteString
      getLiveCursorBytes();

  /**
   * <code>bool history_no_more = 12;</code>
   * @return The historyNoMore.
   */
  boolean getHistoryNoMore();

  /**
   * <code>string proxy_server = 13;</code>
   * @return The proxyServer.
   */
  java.lang.String getProxyServer();
  /**
   * <code>string proxy_server = 13;</code>
   * @return The bytes for proxyServer.
   */
  com.google.protobuf.ByteString
      getProxyServerBytes();
}
