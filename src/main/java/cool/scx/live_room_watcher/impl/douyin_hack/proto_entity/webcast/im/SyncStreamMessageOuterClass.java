// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/SyncStreamMessage.proto

// Protobuf Java Version: 3.25.3
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class SyncStreamMessageOuterClass {
  private SyncStreamMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SyncStreamMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SyncStreamMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n.douyin_hack/webcast/im/SyncStreamMessa" +
      "ge.proto\0322douyin_hack/webcast/im/SyncStr" +
      "eamInfoMessage.proto\"Q\n\021SyncStreamMessag" +
      "e\022\016\n\006common\030\001 \001(\t\022,\n\014infoListList\030\002 \003(\0132" +
      "\026.SyncStreamInfoMessageBG\nCcool.scx.live" +
      "_room_watcher.impl.douyin_hack.proto_ent" +
      "ity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.SyncStreamInfoMessageOuterClass.getDescriptor(),
        });
    internal_static_SyncStreamMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SyncStreamMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SyncStreamMessage_descriptor,
        new java.lang.String[] { "Common", "InfoListList", });
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.SyncStreamInfoMessageOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
