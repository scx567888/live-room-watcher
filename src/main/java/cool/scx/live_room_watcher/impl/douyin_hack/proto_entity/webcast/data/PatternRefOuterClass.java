// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/data/PatternRef.proto
// Protobuf Java Version: 4.27.2

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public final class PatternRefOuterClass {
  private PatternRefOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      PatternRefOuterClass.class.getName());
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
    internal_static_PatternRef_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_PatternRef_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n)douyin_hack/webcast/data/PatternRef.pr" +
      "oto\"1\n\nPatternRef\022\013\n\003key\030\001 \001(\t\022\026\n\016defaul" +
      "tPattern\030\002 \001(\tBI\nEcool.scx.live_room_wat" +
      "cher.impl.douyin_hack.proto_entity.webca" +
      "st.dataP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_PatternRef_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PatternRef_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_PatternRef_descriptor,
        new java.lang.String[] { "Key", "DefaultPattern", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
