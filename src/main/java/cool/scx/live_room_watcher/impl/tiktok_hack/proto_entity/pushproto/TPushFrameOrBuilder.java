// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tiktok_hack/pushproto/TPushFrame.proto

// Protobuf Java Version: 3.25.1
package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.pushproto;

public interface TPushFrameOrBuilder extends
    // @@protoc_insertion_point(interface_extends:TPushFrame)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 seqid = 1;</code>
   * @return The seqid.
   */
  long getSeqid();

  /**
   * <code>uint64 logid = 2;</code>
   * @return The logid.
   */
  long getLogid();

  /**
   * <code>uint64 service = 3;</code>
   * @return The service.
   */
  long getService();

  /**
   * <code>uint64 method = 4;</code>
   * @return The method.
   */
  long getMethod();

  /**
   * <code>repeated .TPushHeader headersList = 5;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.pushproto.TPushHeader> 
      getHeadersListList();
  /**
   * <code>repeated .TPushHeader headersList = 5;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.pushproto.TPushHeader getHeadersList(int index);
  /**
   * <code>repeated .TPushHeader headersList = 5;</code>
   */
  int getHeadersListCount();
  /**
   * <code>repeated .TPushHeader headersList = 5;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.pushproto.TPushHeaderOrBuilder> 
      getHeadersListOrBuilderList();
  /**
   * <code>repeated .TPushHeader headersList = 5;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.pushproto.TPushHeaderOrBuilder getHeadersListOrBuilder(
      int index);

  /**
   * <code>string payloadEncoding = 6;</code>
   * @return The payloadEncoding.
   */
  java.lang.String getPayloadEncoding();
  /**
   * <code>string payloadEncoding = 6;</code>
   * @return The bytes for payloadEncoding.
   */
  com.google.protobuf.ByteString
      getPayloadEncodingBytes();

  /**
   * <code>string payloadType = 7;</code>
   * @return The payloadType.
   */
  java.lang.String getPayloadType();
  /**
   * <code>string payloadType = 7;</code>
   * @return The bytes for payloadType.
   */
  com.google.protobuf.ByteString
      getPayloadTypeBytes();

  /**
   * <code>bytes payload = 8;</code>
   * @return The payload.
   */
  com.google.protobuf.ByteString getPayload();
}