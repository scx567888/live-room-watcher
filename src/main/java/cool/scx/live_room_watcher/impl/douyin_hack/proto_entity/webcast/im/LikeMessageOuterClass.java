// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: douyin_hack/webcast/im/LikeMessage.proto
// Protobuf Java Version: 4.27.2

package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public final class LikeMessageOuterClass {
  private LikeMessageOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 2,
      /* suffix= */ "",
      LikeMessageOuterClass.class.getName());
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
    internal_static_LikeMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_LikeMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(douyin_hack/webcast/im/LikeMessage.pro" +
      "to\032#douyin_hack/webcast/im/Common.proto\032" +
      "#douyin_hack/webcast/data/User.proto\032-do" +
      "uyin_hack/webcast/im/DoubleLikeDetail.pr" +
      "oto\032/douyin_hack/webcast/im/DisplayContr" +
      "olInfo.proto\032,douyin_hack/webcast/im/Pic" +
      "oDisplayInfo.proto\"\247\002\n\013LikeMessage\022\027\n\006co" +
      "mmon\030\001 \001(\0132\007.Common\022\r\n\005count\030\002 \001(\003\022\r\n\005to" +
      "tal\030\003 \001(\003\022\r\n\005color\030\004 \001(\003\022\023\n\004user\030\005 \001(\0132\005" +
      ".User\022\014\n\004icon\030\006 \001(\t\022+\n\020doubleLikeDetail\030" +
      "\007 \001(\0132\021.DoubleLikeDetail\022/\n\022displayContr" +
      "olInfo\030\010 \001(\0132\023.DisplayControlInfo\022\027\n\017lin" +
      "kmicGuestUid\030\t \001(\003\022\r\n\005scene\030\n \001(\t\022)\n\017pic" +
      "oDisplayInfo\030\013 \001(\0132\020.PicoDisplayInfoBG\nC" +
      "cool.scx.live_room_watcher.impl.douyin_h" +
      "ack.proto_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.DoubleLikeDetailOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.DisplayControlInfoOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PicoDisplayInfoOuterClass.getDescriptor(),
        });
    internal_static_LikeMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_LikeMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_LikeMessage_descriptor,
        new java.lang.String[] { "Common", "Count", "Total", "Color", "User", "Icon", "DoubleLikeDetail", "DisplayControlInfo", "LinkmicGuestUid", "Scene", "PicoDisplayInfo", });
    descriptor.resolveAllFeaturesImmutable();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.DoubleLikeDetailOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.DisplayControlInfoOuterClass.getDescriptor();
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PicoDisplayInfoOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
