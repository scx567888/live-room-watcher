// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/Message.proto
// Protobuf Java Version: 4.26.1

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class MessageOuterClass {
  private MessageOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
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
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_MessageExtraMapEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Message_MessageExtraMapEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n$douyin_hack/webcast/im/Message.proto\"\212" +
      "\002\n\007Message\022\016\n\006method\030\001 \001(\t\022\017\n\007payload\030\002 " +
      "\001(\014\022\r\n\005msgId\030\003 \001(\003\022\017\n\007msgType\030\004 \001(\005\022\016\n\006o" +
      "ffset\030\005 \001(\003\022\025\n\rneedWrdsStore\030\006 \001(\010\022\023\n\013wr" +
      "dsVersion\030\007 \001(\003\022\022\n\nwrdsSubKey\030\010 \001(\t\0226\n\017m" +
      "essageExtraMap\030\t \003(\0132\035.Message.MessageEx" +
      "traMapEntry\0326\n\024MessageExtraMapEntry\022\013\n\003k" +
      "ey\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001BG\nCcool.scx." +
      "live_room_watcher.impl.douyin_hack.proto" +
      "_entity.webcast.imP\001b\006proto3"
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
        new java.lang.String[] { "Method", "Payload", "MsgId", "MsgType", "Offset", "NeedWrdsStore", "WrdsVersion", "WrdsSubKey", "MessageExtraMap", });
    internal_static_Message_MessageExtraMapEntry_descriptor =
      internal_static_Message_descriptor.getNestedTypes().get(0);
    internal_static_Message_MessageExtraMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Message_MessageExtraMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
