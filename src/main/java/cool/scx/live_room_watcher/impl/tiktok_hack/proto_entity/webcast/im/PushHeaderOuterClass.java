// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tiktok_hack/webcast/im/PushHeader.proto
// Protobuf Java Version: 4.26.1

package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im;

public final class PushHeaderOuterClass {
  private PushHeaderOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      PushHeaderOuterClass.class.getName());
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
    internal_static_tiktok_hack_PushHeader_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_tiktok_hack_PushHeader_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\'tiktok_hack/webcast/im/PushHeader.prot" +
      "o\022\013tiktok_hack\"(\n\nPushHeader\022\013\n\003key\030\001 \001(" +
      "\t\022\r\n\005value\030\002 \001(\tBG\nCcool.scx.live_room_w" +
      "atcher.impl.tiktok_hack.proto_entity.web" +
      "cast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tiktok_hack_PushHeader_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tiktok_hack_PushHeader_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_tiktok_hack_PushHeader_descriptor,
        new java.lang.String[] { "Key", "Value", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
