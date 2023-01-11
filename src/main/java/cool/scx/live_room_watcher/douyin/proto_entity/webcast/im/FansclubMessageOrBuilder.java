// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/FansclubMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>FansclubMessageOrBuilder interface.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public interface FansclubMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:FansclubMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Common common = 1;</code>
   *
   * @return Whether the common field is set.
   */
  boolean hasCommon();
  /**
   * <code>.Common common = 1;</code>
   *
   * @return The common.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.Common getCommon();
  /**
   * <code>.Common common = 1;</code>
   *
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

  /**
   * <pre>
   * 升级是1，加入是2
   * </pre>
   *
   * <code>int32 action = 2;</code>
   *
   * @return The action.
   */
  int getAction();

  /**
   * <code>string content = 3;</code>
   *
   * @return The content.
   */
  java.lang.String getContent();
      /**
       * <code>string content = 3;</code>
       *
       * @return The bytes for content.
       */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <code>.User user = 4;</code>
   *
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.User user = 4;</code>
   *
   * @return The user.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.User getUser();
  /**
   * <code>.User user = 4;</code>
   *
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

  /**
   * <code>.User upgradePrivilege = 5;</code>
   *
   * @return Whether the upgradePrivilege field is set.
   */
  boolean hasUpgradePrivilege();
  /**
   * <code>.User upgradePrivilege = 5;</code>
   *
   * @return The upgradePrivilege.
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.User getUpgradePrivilege();
  /**
   * <code>.User upgradePrivilege = 5;</code>
   *
   * @return a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder} object
   */
  cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOrBuilder getUpgradePrivilegeOrBuilder();
}
