// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/SocialMessage.proto
// Protobuf Java Version: 4.27.0

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class SocialMessageOuterClass {
  private SocialMessageOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 0,
      /* suffix= */ "",
      SocialMessageOuterClass.class.getName());
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
    internal_static_SocialMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_SocialMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n*douyin_hack/webcast/im/SocialMessage.p" +
      "roto\032#douyin_hack/webcast/im/Common.prot" +
      "o\032#douyin_hack/webcast/data/User.proto\032-" +
      "douyin_hack/webcast/im/PublicAreaCommon." +
      "proto\"\267\001\n\rSocialMessage\022\027\n\006common\030\001 \001(\0132" +
      "\007.Common\022\023\n\004user\030\002 \001(\0132\005.User\022\021\n\tshareTy" +
      "pe\030\003 \001(\003\022\016\n\006action\030\004 \001(\003\022\023\n\013shareTarget\030" +
      "\005 \001(\t\022\023\n\013followCount\030\006 \001(\003\022+\n\020publicArea" +
      "Common\030\007 \001(\0132\021.PublicAreaCommonBG\nCcool." +
      "scx.live_room_watcher.impl.douyin_hack.p" +
      "roto_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PublicAreaCommonOuterClass.getDescriptor(),
        });
    internal_static_SocialMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SocialMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_SocialMessage_descriptor,
        new java.lang.String[] { "Common", "User", "ShareType", "Action", "ShareTarget", "FollowCount", "PublicAreaCommon", });
    descriptor.resolveAllFeaturesImmutable();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PublicAreaCommonOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
