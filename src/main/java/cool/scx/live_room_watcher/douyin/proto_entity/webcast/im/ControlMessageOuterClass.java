// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/ControlMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

public final class ControlMessageOuterClass {
  private ControlMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ControlMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ControlMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ControlMessage_Extra_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ControlMessage_Extra_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\037webcast/im/ControlMessage.proto\032\027webca" +
      "st/im/Common.proto\032\027webcast/data/Text.pr" +
      "oto\"\267\002\n\016ControlMessage\022\027\n\006common\030\001 \001(\0132\007" +
      ".Common\022\016\n\006action\030\002 \001(\003\022\014\n\004tips\030\003 \001(\t\022$\n" +
      "\005extra\030\004 \001(\0132\025.ControlMessage.Extra\032\307\001\n\005" +
      "Extra\022\022\n\nbanInfoUrl\030\001 \001(\t\022\020\n\010reasonNo\030\002 " +
      "\001(\003\022\024\n\005title\030\003 \001(\0132\005.Text\022\036\n\017violationRe" +
      "ason\030\004 \001(\0132\005.Text\022\026\n\007content\030\005 \001(\0132\005.Tex" +
      "t\022\032\n\013gotItButton\030\006 \001(\0132\005.Text\022\036\n\017banDeta" +
      "ilButton\030\007 \001(\0132\005.Text\022\016\n\006source\030\010 \001(\tB=\n" +
      "9cool.scx.live_room_watcher.douyin.proto" +
      "_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextOuterClass.getDescriptor(),
        });
    internal_static_ControlMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ControlMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ControlMessage_descriptor,
        new java.lang.String[] { "Common", "Action", "Tips", "Extra", });
    internal_static_ControlMessage_Extra_descriptor =
      internal_static_ControlMessage_descriptor.getNestedTypes().get(0);
    internal_static_ControlMessage_Extra_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ControlMessage_Extra_descriptor,
        new java.lang.String[] { "BanInfoUrl", "ReasonNo", "Title", "ViolationReason", "Content", "GotItButton", "BanDetailButton", "Source", });
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
