// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/FlexImageStruct.proto
// Protobuf Java Version: 4.27.2

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface FlexImageStructOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FlexImageStruct)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string urlListList = 1;</code>
   * @return A list containing the urlListList.
   */
  java.util.List<java.lang.String>
      getUrlListListList();
  /**
   * <code>repeated string urlListList = 1;</code>
   * @return The count of urlListList.
   */
  int getUrlListListCount();
  /**
   * <code>repeated string urlListList = 1;</code>
   * @param index The index of the element to return.
   * @return The urlListList at the given index.
   */
  java.lang.String getUrlListList(int index);
  /**
   * <code>repeated string urlListList = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the urlListList at the given index.
   */
  com.google.protobuf.ByteString
      getUrlListListBytes(int index);

  /**
   * <code>string uri = 2;</code>
   * @return The uri.
   */
  java.lang.String getUri();
  /**
   * <code>string uri = 2;</code>
   * @return The bytes for uri.
   */
  com.google.protobuf.ByteString
      getUriBytes();

  /**
   * <code>repeated int64 flexSettingList = 3;</code>
   * @return A list containing the flexSettingList.
   */
  java.util.List<java.lang.Long> getFlexSettingListList();
  /**
   * <code>repeated int64 flexSettingList = 3;</code>
   * @return The count of flexSettingList.
   */
  int getFlexSettingListCount();
  /**
   * <code>repeated int64 flexSettingList = 3;</code>
   * @param index The index of the element to return.
   * @return The flexSettingList at the given index.
   */
  long getFlexSettingList(int index);

  /**
   * <code>repeated int64 textSettingList = 4;</code>
   * @return A list containing the textSettingList.
   */
  java.util.List<java.lang.Long> getTextSettingListList();
  /**
   * <code>repeated int64 textSettingList = 4;</code>
   * @return The count of textSettingList.
   */
  int getTextSettingListCount();
  /**
   * <code>repeated int64 textSettingList = 4;</code>
   * @param index The index of the element to return.
   * @return The textSettingList at the given index.
   */
  long getTextSettingList(int index);

  /**
   * <code>int64 topBorderHeight = 5;</code>
   * @return The topBorderHeight.
   */
  long getTopBorderHeight();
}
