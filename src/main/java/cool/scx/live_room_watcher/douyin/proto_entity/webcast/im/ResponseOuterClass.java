// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/Response.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>ResponseOuterClass class.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class ResponseOuterClass {
  /**
   * <p>Constructor for ResponseOuterClass.</p>
   */
  private ResponseOuterClass() {}
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
  /** Constant <code>internal_static_Response_descriptor</code> */
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Response_descriptor;
  /** Constant <code>internal_static_Response_fieldAccessorTable</code> */
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Response_fieldAccessorTable;
  /** Constant <code>internal_static_Response_RouteParamsMapEntry_descriptor</code> */
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Response_RouteParamsMapEntry_descriptor;
  /** Constant <code>internal_static_Response_RouteParamsMapEntry_fieldAccessorTable</code> */
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Response_RouteParamsMapEntry_fieldAccessorTable;

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
      "\n\031webcast/im/Response.proto\032\030webcast/im/" +
      "Message.proto\"\337\002\n\010Response\022\036\n\014messagesLi" +
      "st\030\001 \003(\0132\010.Message\022\016\n\006cursor\030\002 \001(\t\022\025\n\rfe" +
      "tchInterval\030\003 \001(\003\022\013\n\003now\030\004 \001(\003\022\023\n\013intern" +
      "alExt\030\005 \001(\t\022\021\n\tfetchType\030\006 \001(\005\0225\n\016routeP" +
      "aramsMap\030\007 \003(\0132\035.Response.RouteParamsMap" +
      "Entry\022\031\n\021heartbeatDuration\030\010 \001(\003\022\017\n\007need" +
      "Ack\030\t \001(\010\022\022\n\npushServer\030\n \001(\t\022\022\n\nliveCur" +
      "sor\030\013 \001(\t\022\025\n\rhistoryNoMore\030\014 \001(\010\0325\n\023Rout" +
      "eParamsMapEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 " +
      "\001(\t:\0028\001B=\n9cool.scx.live_room_watcher.do" +
      "uyin.proto_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.MessageOuterClass.getDescriptor(),
        });
    internal_static_Response_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Response_descriptor,
        new java.lang.String[] { "MessagesList", "Cursor", "FetchInterval", "Now", "InternalExt", "FetchType", "RouteParamsMap", "HeartbeatDuration", "NeedAck", "PushServer", "LiveCursor", "HistoryNoMore", });
    internal_static_Response_RouteParamsMapEntry_descriptor =
      internal_static_Response_descriptor.getNestedTypes().get(0);
    internal_static_Response_RouteParamsMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Response_RouteParamsMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.MessageOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
