// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/data/TextPiece.proto

// Protobuf Java Version: 3.25.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public interface TextPieceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:TextPiece)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 type = 1;</code>
   * @return The type.
   */
  int getType();

  /**
   * <code>.TextFormat format = 2;</code>
   * @return Whether the format field is set.
   */
  boolean hasFormat();
  /**
   * <code>.TextFormat format = 2;</code>
   * @return The format.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormat getFormat();
  /**
   * <code>.TextFormat format = 2;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextFormatOrBuilder getFormatOrBuilder();

  /**
   * <code>string stringValue = 11;</code>
   * @return The stringValue.
   */
  java.lang.String getStringValue();
  /**
   * <code>string stringValue = 11;</code>
   * @return The bytes for stringValue.
   */
  com.google.protobuf.ByteString
      getStringValueBytes();

  /**
   * <code>.TextPieceUser userValue = 21;</code>
   * @return Whether the userValue field is set.
   */
  boolean hasUserValue();
  /**
   * <code>.TextPieceUser userValue = 21;</code>
   * @return The userValue.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceUser getUserValue();
  /**
   * <code>.TextPieceUser userValue = 21;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceUserOrBuilder getUserValueOrBuilder();

  /**
   * <code>.TextPieceGift giftValue = 22;</code>
   * @return Whether the giftValue field is set.
   */
  boolean hasGiftValue();
  /**
   * <code>.TextPieceGift giftValue = 22;</code>
   * @return The giftValue.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGift getGiftValue();
  /**
   * <code>.TextPieceGift giftValue = 22;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceGiftOrBuilder getGiftValueOrBuilder();

  /**
   * <code>.TextPieceHeart heartValue = 23;</code>
   * @return Whether the heartValue field is set.
   */
  boolean hasHeartValue();
  /**
   * <code>.TextPieceHeart heartValue = 23;</code>
   * @return The heartValue.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceHeart getHeartValue();
  /**
   * <code>.TextPieceHeart heartValue = 23;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceHeartOrBuilder getHeartValueOrBuilder();

  /**
   * <code>.TextPiecePatternRef patternRefValue = 24;</code>
   * @return Whether the patternRefValue field is set.
   */
  boolean hasPatternRefValue();
  /**
   * <code>.TextPiecePatternRef patternRefValue = 24;</code>
   * @return The patternRefValue.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPiecePatternRef getPatternRefValue();
  /**
   * <code>.TextPiecePatternRef patternRefValue = 24;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPiecePatternRefOrBuilder getPatternRefValueOrBuilder();

  /**
   * <code>.TextPieceImage imageValue = 25;</code>
   * @return Whether the imageValue field is set.
   */
  boolean hasImageValue();
  /**
   * <code>.TextPieceImage imageValue = 25;</code>
   * @return The imageValue.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceImage getImageValue();
  /**
   * <code>.TextPieceImage imageValue = 25;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextPieceImageOrBuilder getImageValueOrBuilder();
}
