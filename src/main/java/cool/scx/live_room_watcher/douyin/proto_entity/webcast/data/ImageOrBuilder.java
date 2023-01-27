// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/data/Image.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.data;

/**
 * <p>ImageOrBuilder interface.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public interface ImageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Image)
    com.google.protobuf.MessageOrBuilder {

      /**
       * <code>repeated string urlListList = 1;</code>
       *
       * @return A list containing the urlListList.
       */
  java.util.List<java.lang.String>
      getUrlListListList();
  /**
   * <code>repeated string urlListList = 1;</code>
   *
   * @return The count of urlListList.
   */
  int getUrlListListCount();
  /**
   * <code>repeated string urlListList = 1;</code>
   *
   * @param index The index of the element to return.
   * @return The urlListList at the given index.
   */
  java.lang.String getUrlListList(int index);
      /**
       * <code>repeated string urlListList = 1;</code>
       *
       * @param index The index of the value to return.
       * @return The bytes of the urlListList at the given index.
       */
  com.google.protobuf.ByteString
      getUrlListListBytes(int index);

  /**
   * <code>string uri = 2;</code>
   *
   * @return The uri.
   */
  java.lang.String getUri();
      /**
       * <code>string uri = 2;</code>
       *
       * @return The bytes for uri.
       */
  com.google.protobuf.ByteString
      getUriBytes();

  /**
   * <code>int64 height = 3;</code>
   *
   * @return The height.
   */
  long getHeight();

  /**
   * <code>int64 width = 4;</code>
   *
   * @return The width.
   */
  long getWidth();

  /**
   * <code>string avgColor = 5;</code>
   *
   * @return The avgColor.
   */
  java.lang.String getAvgColor();
      /**
       * <code>string avgColor = 5;</code>
       *
       * @return The bytes for avgColor.
       */
  com.google.protobuf.ByteString
      getAvgColorBytes();

  /**
   * <code>int32 imageType = 6;</code>
   *
   * @return The imageType.
   */
  int getImageType();

  /**
   * <code>string openWebUrl = 7;</code>
   *
   * @return The openWebUrl.
   */
  java.lang.String getOpenWebUrl();
      /**
       * <code>string openWebUrl = 7;</code>
       *
       * @return The bytes for openWebUrl.
       */
  com.google.protobuf.ByteString
      getOpenWebUrlBytes();

  /**
   * <code>.Image.Content content = 8;</code>
   *
   * @return Whether the content field is set.
   */
  boolean hasContent();
  /**
   * <code>.Image.Content content = 8;</code>
   *
   * @return The content.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.Content getContent();
  /**
   * <code>.Image.Content content = 8;</code>
   *
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.ContentOrBuilder} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.ContentOrBuilder getContentOrBuilder();

  /**
   * <code>bool isAnimated = 9;</code>
   *
   * @return The isAnimated.
   */
  boolean getIsAnimated();

      /**
       * <code>repeated .Image.NinePatchSetting flexSettingListList = 10;</code>
       *
       * @return a {@link java.util.List} object
       */
  java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSetting>
      getFlexSettingListListList();
  /**
   * <code>repeated .Image.NinePatchSetting flexSettingListList = 10;</code>
   *
   * @param index a int
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSetting} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSetting getFlexSettingListList(int index);
  /**
   * <code>repeated .Image.NinePatchSetting flexSettingListList = 10;</code>
   *
   * @return a int
   */
  int getFlexSettingListListCount();
      /**
       * <code>repeated .Image.NinePatchSetting flexSettingListList = 10;</code>
       *
       * @return a {@link java.util.List} object
       */
  java.util.List<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSettingOrBuilder>
      getFlexSettingListListOrBuilderList();
  /**
   * <code>repeated .Image.NinePatchSetting flexSettingListList = 10;</code>
   *
   * @param index a int
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSettingOrBuilder} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSettingOrBuilder getFlexSettingListListOrBuilder(
      int index);

      /**
       * <code>repeated .Image.NinePatchSetting textSettingListList = 11;</code>
       *
       * @return a {@link java.util.List} object
       */
  java.util.List<cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSetting>
      getTextSettingListListList();
  /**
   * <code>repeated .Image.NinePatchSetting textSettingListList = 11;</code>
   *
   * @param index a int
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSetting} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSetting getTextSettingListList(int index);
  /**
   * <code>repeated .Image.NinePatchSetting textSettingListList = 11;</code>
   *
   * @return a int
   */
  int getTextSettingListListCount();
      /**
       * <code>repeated .Image.NinePatchSetting textSettingListList = 11;</code>
       *
       * @return a {@link java.util.List} object
       */
  java.util.List<? extends cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSettingOrBuilder>
      getTextSettingListListOrBuilderList();
  /**
   * <code>repeated .Image.NinePatchSetting textSettingListList = 11;</code>
   *
   * @param index a int
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSettingOrBuilder} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.Image.NinePatchSettingOrBuilder getTextSettingListListOrBuilder(
      int index);
}
