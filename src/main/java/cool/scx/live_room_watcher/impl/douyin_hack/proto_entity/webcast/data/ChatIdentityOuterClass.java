// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/data/ChatIdentity.proto

// Protobuf Java Version: 3.25.3
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public final class ChatIdentityOuterClass {
  private ChatIdentityOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChatIdentity_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChatIdentity_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n+douyin_hack/webcast/data/ChatIdentity." +
      "proto\032$douyin_hack/webcast/data/Image.pr" +
      "oto\"C\n\014ChatIdentity\022\024\n\014showIdentity\030\001 \001(" +
      "\005\022\035\n\ridentityLabel\030\002 \001(\0132\006.ImageBI\nEcool" +
      ".scx.live_room_watcher.impl.douyin_hack." +
      "proto_entity.webcast.dataP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOuterClass.getDescriptor(),
        });
    internal_static_ChatIdentity_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ChatIdentity_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChatIdentity_descriptor,
        new java.lang.String[] { "ShowIdentity", "IdentityLabel", });
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
