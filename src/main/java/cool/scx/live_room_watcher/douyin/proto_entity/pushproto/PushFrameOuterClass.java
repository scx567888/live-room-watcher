// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pushproto/PushFrame.proto

package cool.scx.live_room_watcher.douyin.proto_entity.pushproto;

public final class PushFrameOuterClass {
  private PushFrameOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PushFrame_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PushFrame_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031pushproto/PushFrame.proto\032\032pushproto/P" +
      "ushHeader.proto\"\253\001\n\tPushFrame\022\r\n\005seqid\030\001" +
      " \001(\004\022\r\n\005logid\030\002 \001(\004\022\017\n\007service\030\003 \001(\004\022\016\n\006" +
      "method\030\004 \001(\004\022 \n\013headersList\030\005 \003(\0132\013.Push" +
      "Header\022\027\n\017payloadEncoding\030\006 \001(\t\022\023\n\013paylo" +
      "adType\030\007 \001(\t\022\017\n\007payload\030\010 \001(\014B<\n8cool.sc" +
      "x.live_room_watcher.douyin.proto_entity." +
      "pushprotoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.douyin.proto_entity.pushproto.PushHeaderOuterClass.getDescriptor(),
        });
    internal_static_PushFrame_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PushFrame_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PushFrame_descriptor,
        new java.lang.String[] { "Seqid", "Logid", "Service", "Method", "HeadersList", "PayloadEncoding", "PayloadType", "Payload", });
    cool.scx.live_room_watcher.douyin.proto_entity.pushproto.PushHeaderOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
