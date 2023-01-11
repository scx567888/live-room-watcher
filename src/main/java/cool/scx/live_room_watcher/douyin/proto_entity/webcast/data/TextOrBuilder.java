// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/data/Text.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.data;

public interface TextOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Text)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string key = 1;</code>
   * @return The key.
   */
  java.lang.String getKey();
  /**
   * <code>string key = 1;</code>
   * @return The bytes for key.
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>string defaultPattern = 2;</code>
   * @return The defaultPattern.
   */
  java.lang.String getDefaultPattern();
  /**
   * <code>string defaultPattern = 2;</code>
   * @return The bytes for defaultPattern.
   */
  com.google.protobuf.ByteString
      getDefaultPatternBytes();

  /**
   * <code>.TextFormat defaultFormat = 3;</code>
   * @return Whether the defaultFormat field is set.
   */
  boolean hasDefaultFormat();
  /**
   * <code>.TextFormat defaultFormat = 3;</code>
   * @return The defaultFormat.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextFormat getDefaultFormat();
  /**
   * <code>.TextFormat defaultFormat = 3;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextFormatOrBuilder getDefaultFormatOrBuilder();

  /**
   * <code>repeated .TextPiece piecesList = 4;</code>
   */
  java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPiece> 
      getPiecesListList();
  /**
   * <code>repeated .TextPiece piecesList = 4;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPiece getPiecesList(int index);
  /**
   * <code>repeated .TextPiece piecesList = 4;</code>
   */
  int getPiecesListCount();
  /**
   * <code>repeated .TextPiece piecesList = 4;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceOrBuilder> 
      getPiecesListOrBuilderList();
  /**
   * <code>repeated .TextPiece piecesList = 4;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceOrBuilder getPiecesListOrBuilder(
      int index);
}
