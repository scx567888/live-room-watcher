// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/data/TextPieceImage.proto

// Protobuf Java Version: 3.25.3
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public final class TextPieceImageOuterClass {
  private TextPieceImageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TextPieceImage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TextPieceImage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n-douyin_hack/webcast/data/TextPieceImag" +
      "e.proto\032$douyin_hack/webcast/data/Image." +
      "proto\"<\n\016TextPieceImage\022\025\n\005image\030\001 \001(\0132\006" +
      ".Image\022\023\n\013scalingRate\030\002 \001(\002BI\nEcool.scx." +
      "live_room_watcher.impl.douyin_hack.proto" +
      "_entity.webcast.dataP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOuterClass.getDescriptor(),
        });
    internal_static_TextPieceImage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TextPieceImage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TextPieceImage_descriptor,
        new java.lang.String[] { "Image", "ScalingRate", });
    cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
