// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/Message.proto
// Protobuf Java Version: 4.29.0

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class MessageOuterClass {
  private MessageOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 0,
      /* suffix= */ "",
      MessageOuterClass.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n$douyin_hack/webcast/im/Message.proto\"\241" +
      "\001\n\007Message\022\016\n\006method\030\001 \001(\t\022\017\n\007payload\030\002 " +
      "\001(\014\022\016\n\006msg_id\030\003 \001(\003\022\020\n\010msg_type\030\004 \001(\005\022\016\n" +
      "\006offset\030\005 \001(\003\022\027\n\017need_wrds_store\030\006 \001(\010\022\024" +
      "\n\014wrds_version\030\007 \001(\003\022\024\n\014wrds_sub_key\030\010 \001" +
      "(\tBG\nCcool.scx.live_room_watcher.impl.do" +
      "uyin_hack.proto_entity.webcast.imP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Message_descriptor,
        new java.lang.String[] { "Method", "Payload", "MsgId", "MsgType", "Offset", "NeedWrdsStore", "WrdsVersion", "WrdsSubKey", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
