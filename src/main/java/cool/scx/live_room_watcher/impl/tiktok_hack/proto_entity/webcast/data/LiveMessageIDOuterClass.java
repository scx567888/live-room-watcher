// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: tiktok_hack/webcast/data/LiveMessageID.proto
// Protobuf Java Version: 4.29.0

package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data;

public final class LiveMessageIDOuterClass {
  private LiveMessageIDOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 0,
      /* suffix= */ "",
      LiveMessageIDOuterClass.class.getName());
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
    internal_static_tiktok_hack_LiveMessageID_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_tiktok_hack_LiveMessageID_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n,tiktok_hack/webcast/data/LiveMessageID" +
      ".proto\022\013tiktok_hack\"8\n\rLiveMessageID\022\021\n\t" +
      "primaryId\030\001 \001(\t\022\024\n\014messageScene\030\002 \001(\tBI\n" +
      "Ecool.scx.live_room_watcher.impl.tiktok_" +
      "hack.proto_entity.webcast.dataP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tiktok_hack_LiveMessageID_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tiktok_hack_LiveMessageID_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_tiktok_hack_LiveMessageID_descriptor,
        new java.lang.String[] { "PrimaryId", "MessageScene", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
