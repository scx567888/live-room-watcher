// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/RoomMessage.proto

// Protobuf Java Version: 3.25.2
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class RoomMessageOuterClass {
  private RoomMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RoomMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RoomMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RoomMessage_BuriedPointMapEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RoomMessage_BuriedPointMapEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(douyin_hack/webcast/im/RoomMessage.pro" +
      "to\032#douyin_hack/webcast/im/Common.proto\032" +
      ",douyin_hack/webcast/im/RoomMsgTypeEnum." +
      "proto\"\256\002\n\013RoomMessage\022\027\n\006common\030\001 \001(\0132\007." +
      "Common\022\017\n\007content\030\002 \001(\t\022\030\n\020supprotLandsc" +
      "ape\030\003 \001(\010\022)\n\017roommessagetype\030\004 \001(\0162\020.Roo" +
      "mMsgTypeEnum\022\024\n\014systemTopMsg\030\005 \001(\010\022\027\n\017fo" +
      "rcedGuarantee\030\006 \001(\010\022\020\n\010bizScene\030\024 \001(\t\0228\n" +
      "\016buriedPointMap\030\036 \003(\0132 .RoomMessage.Buri" +
      "edPointMapEntry\0325\n\023BuriedPointMapEntry\022\013" +
      "\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001BG\nCcool.s" +
      "cx.live_room_watcher.impl.douyin_hack.pr" +
      "oto_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.RoomMsgTypeEnumOuterClass.getDescriptor(),
        });
    internal_static_RoomMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RoomMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RoomMessage_descriptor,
        new java.lang.String[] { "Common", "Content", "SupprotLandscape", "Roommessagetype", "SystemTopMsg", "ForcedGuarantee", "BizScene", "BuriedPointMap", });
    internal_static_RoomMessage_BuriedPointMapEntry_descriptor =
      internal_static_RoomMessage_descriptor.getNestedTypes().get(0);
    internal_static_RoomMessage_BuriedPointMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RoomMessage_BuriedPointMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.RoomMsgTypeEnumOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
