// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/FansclubMessage.proto

// Protobuf Java Version: 3.25.2
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class FansclubMessageOuterClass {
  private FansclubMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FansclubMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FansclubMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FansclubMessage_UpgradePrivilege_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FansclubMessage_UpgradePrivilege_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,douyin_hack/webcast/im/FansclubMessage" +
      ".proto\032#douyin_hack/webcast/im/Common.pr" +
      "oto\032#douyin_hack/webcast/data/User.proto" +
      "\"\317\001\n\017FansclubMessage\022\027\n\006common\030\001 \001(\0132\007.C" +
      "ommon\022\016\n\006action\030\002 \001(\005\022\017\n\007content\030\003 \001(\t\022\023" +
      "\n\004user\030\004 \001(\0132\005.User\022\037\n\020upgradePrivilege\030" +
      "\005 \001(\0132\005.User\032L\n\020UpgradePrivilege\022\017\n\007cont" +
      "ent\030\001 \001(\t\022\023\n\013description\030\002 \001(\t\022\022\n\nbutton" +
      "Type\030\003 \001(\005BG\nCcool.scx.live_room_watcher" +
      ".impl.douyin_hack.proto_entity.webcast.i" +
      "mP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOuterClass.getDescriptor(),
        });
    internal_static_FansclubMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_FansclubMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FansclubMessage_descriptor,
        new java.lang.String[] { "Common", "Action", "Content", "User", "UpgradePrivilege", });
    internal_static_FansclubMessage_UpgradePrivilege_descriptor =
      internal_static_FansclubMessage_descriptor.getNestedTypes().get(0);
    internal_static_FansclubMessage_UpgradePrivilege_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FansclubMessage_UpgradePrivilege_descriptor,
        new java.lang.String[] { "Content", "Description", "ButtonType", });
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
