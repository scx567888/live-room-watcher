// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/LikeMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

public interface LikeMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:LikeMessage)
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
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common getCommon();
  /**
   * <code>.Common common = 1;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

  /**
   * <code>int64 count = 2;</code>
   * @return The count.
   */
  long getCount();

  /**
   * <code>int64 total = 3;</code>
   * @return The total.
   */
  long getTotal();

  /**
   * <code>int64 color = 4;</code>
   * @return The color.
   */
  long getColor();

  /**
   * <code>.User user = 5;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.User user = 5;</code>
   * @return The user.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.User getUser();
  /**
   * <code>.User user = 5;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

  /**
   * <code>string icon = 6;</code>
   * @return The icon.
   */
  java.lang.String getIcon();
  /**
   * <code>string icon = 6;</code>
   * @return The bytes for icon.
   */
  com.google.protobuf.ByteString
      getIconBytes();

  /**
   * <code>.DoubleLikeDetail doubleLikeDetail = 7;</code>
   * @return Whether the doubleLikeDetail field is set.
   */
  boolean hasDoubleLikeDetail();
  /**
   * <code>.DoubleLikeDetail doubleLikeDetail = 7;</code>
   * @return The doubleLikeDetail.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.DoubleLikeDetail getDoubleLikeDetail();
  /**
   * <code>.DoubleLikeDetail doubleLikeDetail = 7;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.DoubleLikeDetailOrBuilder getDoubleLikeDetailOrBuilder();

  /**
   * <code>.DisplayControlInfo displayControlInfo = 8;</code>
   * @return Whether the displayControlInfo field is set.
   */
  boolean hasDisplayControlInfo();
  /**
   * <code>.DisplayControlInfo displayControlInfo = 8;</code>
   * @return The displayControlInfo.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.DisplayControlInfo getDisplayControlInfo();
  /**
   * <code>.DisplayControlInfo displayControlInfo = 8;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.DisplayControlInfoOrBuilder getDisplayControlInfoOrBuilder();

  /**
   * <code>int64 linkmicGuestUid = 9;</code>
   * @return The linkmicGuestUid.
   */
  long getLinkmicGuestUid();

  /**
   * <code>string scene = 10;</code>
   * @return The scene.
   */
  java.lang.String getScene();
  /**
   * <code>string scene = 10;</code>
   * @return The bytes for scene.
   */
  com.google.protobuf.ByteString
      getSceneBytes();

  /**
   * <code>.PicoDisplayInfo picoDisplayInfo = 11;</code>
   * @return Whether the picoDisplayInfo field is set.
   */
  boolean hasPicoDisplayInfo();
  /**
   * <code>.PicoDisplayInfo picoDisplayInfo = 11;</code>
   * @return The picoDisplayInfo.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.PicoDisplayInfo getPicoDisplayInfo();
  /**
   * <code>.PicoDisplayInfo picoDisplayInfo = 11;</code>
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.PicoDisplayInfoOrBuilder getPicoDisplayInfoOrBuilder();
}
