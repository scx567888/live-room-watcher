// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/GameCPUserDownloadMessage.proto

// Protobuf Java Version: 3.25.3
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface GameCPUserDownloadMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GameCPUserDownloadMessage)
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
   * <code>string userNickName = 2;</code>
   * @return The userNickName.
   */
  java.lang.String getUserNickName();
  /**
   * <code>string userNickName = 2;</code>
   * @return The bytes for userNickName.
   */
  com.google.protobuf.ByteString
      getUserNickNameBytes();

  /**
   * <code>int64 userDownloadCount = 3;</code>
   * @return The userDownloadCount.
   */
  long getUserDownloadCount();

  /**
   * <code>string userDownloadContent = 4;</code>
   * @return The userDownloadContent.
   */
  java.lang.String getUserDownloadContent();
  /**
   * <code>string userDownloadContent = 4;</code>
   * @return The bytes for userDownloadContent.
   */
  com.google.protobuf.ByteString
      getUserDownloadContentBytes();

  /**
   * <code>string downloadGameName = 5;</code>
   * @return The downloadGameName.
   */
  java.lang.String getDownloadGameName();
  /**
   * <code>string downloadGameName = 5;</code>
   * @return The bytes for downloadGameName.
   */
  com.google.protobuf.ByteString
      getDownloadGameNameBytes();

  /**
   * <code>.GameCPUserDownloadMessageEnum type = 6;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.GameCPUserDownloadMessageEnum type = 6;</code>
   * @return The type.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.GameCPUserDownloadMessageEnum getType();
}
