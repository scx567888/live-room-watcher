// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/data/User.proto
// Protobuf Java Version: 4.27.3

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public interface UserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:User)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>int64 short_id = 2;</code>
   * @return The shortId.
   */
  long getShortId();

  /**
   * <code>string nickname = 3;</code>
   * @return The nickname.
   */
  java.lang.String getNickname();
  /**
   * <code>string nickname = 3;</code>
   * @return The bytes for nickname.
   */
  com.google.protobuf.ByteString
      getNicknameBytes();

  /**
   * <code>int32 gender = 4;</code>
   * @return The gender.
   */
  int getGender();

  /**
   * <code>string signature = 5;</code>
   * @return The signature.
   */
  java.lang.String getSignature();
  /**
   * <code>string signature = 5;</code>
   * @return The bytes for signature.
   */
  com.google.protobuf.ByteString
      getSignatureBytes();

  /**
   * <code>int32 level = 6;</code>
   * @return The level.
   */
  int getLevel();

  /**
   * <code>int64 birthday = 7;</code>
   * @return The birthday.
   */
  long getBirthday();

  /**
   * <code>string telephone = 8;</code>
   * @return The telephone.
   */
  java.lang.String getTelephone();
  /**
   * <code>string telephone = 8;</code>
   * @return The bytes for telephone.
   */
  com.google.protobuf.ByteString
      getTelephoneBytes();

  /**
   * <code>.Image avatar_thumb = 9;</code>
   * @return Whether the avatarThumb field is set.
   */
  boolean hasAvatarThumb();
  /**
   * <code>.Image avatar_thumb = 9;</code>
   * @return The avatarThumb.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarThumb();
  /**
   * <code>.Image avatar_thumb = 9;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarThumbOrBuilder();

  /**
   * <code>.Image avatar_medium = 10;</code>
   * @return Whether the avatarMedium field is set.
   */
  boolean hasAvatarMedium();
  /**
   * <code>.Image avatar_medium = 10;</code>
   * @return The avatarMedium.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarMedium();
  /**
   * <code>.Image avatar_medium = 10;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarMediumOrBuilder();

  /**
   * <code>.Image avatar_large = 11;</code>
   * @return Whether the avatarLarge field is set.
   */
  boolean hasAvatarLarge();
  /**
   * <code>.Image avatar_large = 11;</code>
   * @return The avatarLarge.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarLarge();
  /**
   * <code>.Image avatar_large = 11;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarLargeOrBuilder();

  /**
   * <code>bool verified = 12;</code>
   * @return The verified.
   */
  boolean getVerified();

  /**
   * <code>string city = 14;</code>
   * @return The city.
   */
  java.lang.String getCity();
  /**
   * <code>string city = 14;</code>
   * @return The bytes for city.
   */
  com.google.protobuf.ByteString
      getCityBytes();

  /**
   * <code>int32 status = 15;</code>
   * @return The status.
   */
  int getStatus();

  /**
   * <code>int64 create_time = 16;</code>
   * @return The createTime.
   */
  long getCreateTime();

  /**
   * <code>int64 modify_time = 17;</code>
   * @return The modifyTime.
   */
  long getModifyTime();

  /**
   * <code>int32 secret = 18;</code>
   * @return The secret.
   */
  int getSecret();

  /**
   * <code>.Image avatar_jpg = 1012;</code>
   * @return Whether the avatarJpg field is set.
   */
  boolean hasAvatarJpg();
  /**
   * <code>.Image avatar_jpg = 1012;</code>
   * @return The avatarJpg.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarJpg();
  /**
   * <code>.Image avatar_jpg = 1012;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarJpgOrBuilder();
}
