// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pushproto/PushHeader.proto

package cool.scx.live_room_watcher.douyin.proto_entity.pushproto;

/**
 * <p>PushHeaderOuterClass class.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class PushHeaderOuterClass {
  /**
   * <p>Constructor for PushHeaderOuterClass.</p>
   */
  private PushHeaderOuterClass() {}
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
  /** Constant <code>internal_static_PushHeader_descriptor</code> */
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PushHeader_descriptor;
  /** Constant <code>internal_static_PushHeader_fieldAccessorTable</code> */
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PushHeader_fieldAccessorTable;

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
      "\n\032pushproto/PushHeader.proto\"(\n\nPushHead" +
      "er\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\tB<\n8cool.s" +
      "cx.live_room_watcher.douyin.proto_entity" +
      ".pushprotoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_PushHeader_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PushHeader_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PushHeader_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
