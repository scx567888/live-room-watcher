// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: tiktok_hack/webcast/im/LikeMessage.proto
// Protobuf Java Version: 4.27.1

package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im;

public interface LikeMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tiktok_hack.LikeMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.tiktok_hack.Common common = 1;</code>
   * @return Whether the common field is set.
   */
  boolean hasCommon();
  /**
   * <code>.tiktok_hack.Common common = 1;</code>
   * @return The common.
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.Common getCommon();
  /**
   * <code>.tiktok_hack.Common common = 1;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

  /**
   * <code>int64 count = 2;</code>
   * @return The count.
   */
  long getCount();

  /**
   * <code>string total = 3;</code>
   * @return The total.
   */
  java.lang.String getTotal();
  /**
   * <code>string total = 3;</code>
   * @return The bytes for total.
   */
  com.google.protobuf.ByteString
      getTotalBytes();

  /**
   * <code>string color = 4;</code>
   * @return The color.
   */
  java.lang.String getColor();
  /**
   * <code>string color = 4;</code>
   * @return The bytes for color.
   */
  com.google.protobuf.ByteString
      getColorBytes();

  /**
   * <code>.tiktok_hack.User user = 5;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.tiktok_hack.User user = 5;</code>
   * @return The user.
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.User getUser();
  /**
   * <code>.tiktok_hack.User user = 5;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

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
   * <code>.tiktok_hack.Image iconsList = 7;</code>
   * @return Whether the iconsList field is set.
   */
  boolean hasIconsList();
  /**
   * <code>.tiktok_hack.Image iconsList = 7;</code>
   * @return The iconsList.
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.Image getIconsList();
  /**
   * <code>.tiktok_hack.Image iconsList = 7;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.ImageOrBuilder getIconsListOrBuilder();

  /**
   * <code>repeated .tiktok_hack.SpecifiedDisplayText specifiedDisplayTextList = 8;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.SpecifiedDisplayText> 
      getSpecifiedDisplayTextListList();
  /**
   * <code>repeated .tiktok_hack.SpecifiedDisplayText specifiedDisplayTextList = 8;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.SpecifiedDisplayText getSpecifiedDisplayTextList(int index);
  /**
   * <code>repeated .tiktok_hack.SpecifiedDisplayText specifiedDisplayTextList = 8;</code>
   */
  int getSpecifiedDisplayTextListCount();
  /**
   * <code>repeated .tiktok_hack.SpecifiedDisplayText specifiedDisplayTextList = 8;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.SpecifiedDisplayTextOrBuilder> 
      getSpecifiedDisplayTextListOrBuilderList();
  /**
   * <code>repeated .tiktok_hack.SpecifiedDisplayText specifiedDisplayTextList = 8;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.SpecifiedDisplayTextOrBuilder getSpecifiedDisplayTextListOrBuilder(
      int index);

  /**
   * <code>string effectCnt = 9;</code>
   * @return The effectCnt.
   */
  java.lang.String getEffectCnt();
  /**
   * <code>string effectCnt = 9;</code>
   * @return The bytes for effectCnt.
   */
  com.google.protobuf.ByteString
      getEffectCntBytes();

  /**
   * <code>repeated .tiktok_hack.LikeEffect likeEffectList = 10;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LikeEffect> 
      getLikeEffectListList();
  /**
   * <code>repeated .tiktok_hack.LikeEffect likeEffectList = 10;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LikeEffect getLikeEffectList(int index);
  /**
   * <code>repeated .tiktok_hack.LikeEffect likeEffectList = 10;</code>
   */
  int getLikeEffectListCount();
  /**
   * <code>repeated .tiktok_hack.LikeEffect likeEffectList = 10;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LikeEffectOrBuilder> 
      getLikeEffectListOrBuilderList();
  /**
   * <code>repeated .tiktok_hack.LikeEffect likeEffectList = 10;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.LikeEffectOrBuilder getLikeEffectListOrBuilder(
      int index);

  /**
   * <code>.tiktok_hack.PublicAreaMessageCommon publicAreaMessageCommon = 11;</code>
   * @return Whether the publicAreaMessageCommon field is set.
   */
  boolean hasPublicAreaMessageCommon();
  /**
   * <code>.tiktok_hack.PublicAreaMessageCommon publicAreaMessageCommon = 11;</code>
   * @return The publicAreaMessageCommon.
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.PublicAreaMessageCommon getPublicAreaMessageCommon();
  /**
   * <code>.tiktok_hack.PublicAreaMessageCommon publicAreaMessageCommon = 11;</code>
   */
  cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.PublicAreaMessageCommonOrBuilder getPublicAreaMessageCommonOrBuilder();
}
