// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/PushFrame.proto
// Protobuf Java Version: 4.29.0

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface PushFrameOrBuilder extends
    // @@protoc_insertion_point(interface_extends:PushFrame)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 SeqID = 1;</code>
   * @return The seqID.
   */
  long getSeqID();

  /**
   * <code>uint64 LogID = 2;</code>
   * @return The logID.
   */
  long getLogID();

  /**
   * <code>int32 service = 3;</code>
   * @return The service.
   */
  int getService();

  /**
   * <code>int32 method = 4;</code>
   * @return The method.
   */
  int getMethod();

  /**
   * <code>repeated .PushHeader headers = 5;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PushHeader> 
      getHeadersList();
  /**
   * <code>repeated .PushHeader headers = 5;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PushHeader getHeaders(int index);
  /**
   * <code>repeated .PushHeader headers = 5;</code>
   */
  int getHeadersCount();
  /**
   * <code>repeated .PushHeader headers = 5;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PushHeaderOrBuilder> 
      getHeadersOrBuilderList();
  /**
   * <code>repeated .PushHeader headers = 5;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PushHeaderOrBuilder getHeadersOrBuilder(
      int index);

  /**
   * <code>string payload_encoding = 6;</code>
   * @return The payloadEncoding.
   */
  java.lang.String getPayloadEncoding();
  /**
   * <code>string payload_encoding = 6;</code>
   * @return The bytes for payloadEncoding.
   */
  com.google.protobuf.ByteString
      getPayloadEncodingBytes();

  /**
   * <code>string payload_type = 7;</code>
   * @return The payloadType.
   */
  java.lang.String getPayloadType();
  /**
   * <code>string payload_type = 7;</code>
   * @return The bytes for payloadType.
   */
  com.google.protobuf.ByteString
      getPayloadTypeBytes();

  /**
   * <code>bytes payload = 8;</code>
   * @return The payload.
   */
  com.google.protobuf.ByteString getPayload();

  /**
   * <code>string LodIDNew = 9;</code>
   * @return The lodIDNew.
   */
  java.lang.String getLodIDNew();
  /**
   * <code>string LodIDNew = 9;</code>
   * @return The bytes for lodIDNew.
   */
  com.google.protobuf.ByteString
      getLodIDNewBytes();
}
