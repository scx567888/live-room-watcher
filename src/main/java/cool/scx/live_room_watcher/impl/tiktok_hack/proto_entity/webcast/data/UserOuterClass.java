// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: tiktok_hack/webcast/data/User.proto
// Protobuf Java Version: 4.29.0

package cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data;

public final class UserOuterClass {
  private UserOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 0,
      /* suffix= */ "",
      UserOuterClass.class.getName());
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
    internal_static_tiktok_hack_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_tiktok_hack_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n#tiktok_hack/webcast/data/User.proto\022\013t" +
      "iktok_hack\032$tiktok_hack/webcast/data/Ima" +
      "ge.proto\"\240\001\n\004User\022\n\n\002id\030\001 \001(\t\022\020\n\010nicknam" +
      "e\030\003 \001(\t\022\'\n\013avatarThumb\030\t \001(\0132\022.tiktok_ha" +
      "ck.Image\022(\n\014avatarMedium\030\n \001(\0132\022.tiktok_" +
      "hack.Image\022\'\n\013avatarLarge\030\013 \001(\0132\022.tiktok" +
      "_hack.ImageBI\nEcool.scx.live_room_watche" +
      "r.impl.tiktok_hack.proto_entity.webcast." +
      "dataP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.ImageOuterClass.getDescriptor(),
        });
    internal_static_tiktok_hack_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tiktok_hack_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_tiktok_hack_User_descriptor,
        new java.lang.String[] { "Id", "Nickname", "AvatarThumb", "AvatarMedium", "AvatarLarge", });
    descriptor.resolveAllFeaturesImmutable();
    cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.data.ImageOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
