// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tiktok_hack/webcast/im/TMessage.proto

// Protobuf Java Version: 3.25.3
package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im;

public final class TMessageOuterClass {
  private TMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TMessage_MessageExtraMapEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TMessage_MessageExtraMapEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n%tiktok_hack/webcast/im/TMessage.proto\"" +
      "\214\002\n\010TMessage\022\016\n\006method\030\001 \001(\t\022\017\n\007payload\030" +
      "\002 \001(\014\022\r\n\005msgId\030\003 \001(\003\022\017\n\007msgType\030\004 \001(\005\022\016\n" +
      "\006offset\030\005 \001(\003\022\025\n\rneedWrdsStore\030\006 \001(\010\022\023\n\013" +
      "wrdsVersion\030\007 \001(\003\022\022\n\nwrdsSubKey\030\010 \001(\t\0227\n" +
      "\017messageExtraMap\030\t \003(\0132\036.TMessage.Messag" +
      "eExtraMapEntry\0326\n\024MessageExtraMapEntry\022\013" +
      "\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001BG\nCcool.s" +
      "cx.live_room_watcher.impl.tiktok_hack.pr" +
      "oto_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_TMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TMessage_descriptor,
        new java.lang.String[] { "Method", "Payload", "MsgId", "MsgType", "Offset", "NeedWrdsStore", "WrdsVersion", "WrdsSubKey", "MessageExtraMap", });
    internal_static_TMessage_MessageExtraMapEntry_descriptor =
      internal_static_TMessage_descriptor.getNestedTypes().get(0);
    internal_static_TMessage_MessageExtraMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TMessage_MessageExtraMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}