// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/data/Text.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.data;

/**
 * <p>TextOuterClass class.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class TextOuterClass {
  /**
   * <p>Constructor for TextOuterClass.</p>
   */
  private TextOuterClass() {}
  /**
   * <p>registerAllExtensions.</p>
   *
   * @param registry a {@link com.google.protobuf.ExtensionRegistryLite} object
   */
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  /**
   * <p>registerAllExtensions.</p>
   *
   * @param registry a {@link com.google.protobuf.ExtensionRegistry} object
   */
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /** Constant <code>internal_static_Text_descriptor</code> */
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Text_descriptor;
  /** Constant <code>internal_static_Text_fieldAccessorTable</code> */
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Text_fieldAccessorTable;

  /**
   * <p>Getter for the field <code>descriptor</code>.</p>
   *
   * @return a {@link com.google.protobuf.Descriptors.FileDescriptor} object
   */
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  /** Constant <code>descriptor</code> */
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027webcast/data/Text.proto\032\035webcast/data/" +
      "TextFormat.proto\032\034webcast/data/TextPiece" +
      ".proto\"o\n\004Text\022\013\n\003key\030\001 \001(\t\022\026\n\016defaultPa" +
      "ttern\030\002 \001(\t\022\"\n\rdefaultFormat\030\003 \001(\0132\013.Tex" +
      "tFormat\022\036\n\npiecesList\030\004 \003(\0132\n.TextPieceB" +
      "?\n;cool.scx.live_room_watcher.douyin.pro" +
      "to_entity.webcast.dataP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextFormatOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceOuterClass.getDescriptor(),
        });
    internal_static_Text_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Text_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Text_descriptor,
        new java.lang.String[] { "Key", "DefaultPattern", "DefaultFormat", "PiecesList", });
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextFormatOuterClass.getDescriptor();
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.TextPieceOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
