// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/RoomStatsMessage.proto

// Protobuf Java Version: 3.25.2
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class RoomStatsMessageOuterClass {
  private RoomStatsMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RoomStatsMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RoomStatsMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n-douyin_hack/webcast/im/RoomStatsMessag" +
      "e.proto\032#douyin_hack/webcast/im/Common.p" +
      "roto\"\346\001\n\020RoomStatsMessage\022\027\n\006common\030\001 \001(" +
      "\0132\007.Common\022\024\n\014displayShort\030\002 \001(\t\022\025\n\rdisp" +
      "layMiddle\030\003 \001(\t\022\023\n\013displayLong\030\004 \001(\t\022\024\n\014" +
      "displayValue\030\005 \001(\003\022\026\n\016displayVersion\030\006 \001" +
      "(\003\022\023\n\013incremental\030\007 \001(\010\022\020\n\010isHidden\030\010 \001(" +
      "\010\022\r\n\005total\030\t \001(\003\022\023\n\013displayType\030\n \001(\003BG\n" +
      "Ccool.scx.live_room_watcher.impl.douyin_" +
      "hack.proto_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
        });
    internal_static_RoomStatsMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RoomStatsMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RoomStatsMessage_descriptor,
        new java.lang.String[] { "Common", "DisplayShort", "DisplayMiddle", "DisplayLong", "DisplayValue", "DisplayVersion", "Incremental", "IsHidden", "Total", "DisplayType", });
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
