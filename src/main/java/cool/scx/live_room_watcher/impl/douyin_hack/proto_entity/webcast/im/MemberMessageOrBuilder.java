// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/MemberMessage.proto
// Protobuf Java Version: 4.28.2

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface MemberMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:MemberMessage)
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
   * <code>.User user = 2;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.User user = 2;</code>
   * @return The user.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User getUser();
  /**
   * <code>.User user = 2;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

  /**
   * <code>int64 member_count = 3;</code>
   * @return The memberCount.
   */
  long getMemberCount();

  /**
   * <code>.User operator = 4;</code>
   * @return Whether the operator field is set.
   */
  boolean hasOperator();
  /**
   * <code>.User operator = 4;</code>
   * @return The operator.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User getOperator();
  /**
   * <code>.User operator = 4;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOrBuilder getOperatorOrBuilder();

  /**
   * <code>bool is_set_to_admin = 5;</code>
   * @return The isSetToAdmin.
   */
  boolean getIsSetToAdmin();

  /**
   * <code>bool is_top_user = 6;</code>
   * @return The isTopUser.
   */
  boolean getIsTopUser();

  /**
   * <code>int64 rank_score = 7;</code>
   * @return The rankScore.
   */
  long getRankScore();

  /**
   * <code>int64 top_user_no = 8;</code>
   * @return The topUserNo.
   */
  long getTopUserNo();

  /**
   * <code>int64 enter_type = 9;</code>
   * @return The enterType.
   */
  long getEnterType();

  /**
   * <code>int64 action = 10;</code>
   * @return The action.
   */
  long getAction();

  /**
   * <code>string action_description = 11;</code>
   * @return The actionDescription.
   */
  java.lang.String getActionDescription();
  /**
   * <code>string action_description = 11;</code>
   * @return The bytes for actionDescription.
   */
  com.google.protobuf.ByteString
      getActionDescriptionBytes();

  /**
   * <code>int64 user_id = 12;</code>
   * @return The userId.
   */
  long getUserId();
}
