// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/UpdateFanTicketMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>UpdateFanTicketMessageOuterClass class.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class UpdateFanTicketMessageOuterClass {
    /**
     * Constant <code>internal_static_UpdateFanTicketMessage_descriptor</code>
     */
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_UpdateFanTicketMessage_descriptor;
    /**
     * Constant <code>internal_static_UpdateFanTicketMessage_fieldAccessorTable</code>
     */
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_UpdateFanTicketMessage_fieldAccessorTable;
    /**
     * Constant <code>descriptor</code>
     */
    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\'webcast/im/UpdateFanTicketMessage.prot" +
                        "o\032\027webcast/im/Common.proto\"\202\001\n\026UpdateFan" +
                        "TicketMessage\022\027\n\006common\030\001 \001(\0132\007.Common\022\036" +
                        "\n\026roomFanTicketCountText\030\002 \001(\t\022\032\n\022roomFa" +
                        "nTicketCount\030\003 \001(\003\022\023\n\013forceUpdate\030\004 \001(\010B" +
                        "=\n9cool.scx.live_room_watcher.douyin.pro" +
                        "to_entity.webcast.imP\001b\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
                        });
        internal_static_UpdateFanTicketMessage_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_UpdateFanTicketMessage_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_UpdateFanTicketMessage_descriptor,
                new java.lang.String[]{"Common", "RoomFanTicketCountText", "RoomFanTicketCount", "ForceUpdate",});
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
    }
    /**
     * <p>Constructor for UpdateFanTicketMessageOuterClass.</p>
     */
    private UpdateFanTicketMessageOuterClass() {
    }

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

    /**
     * <p>Getter for the field <code>descriptor</code>.</p>
     *
     * @return a {@link com.google.protobuf.Descriptors.FileDescriptor} object
     */
    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    // @@protoc_insertion_point(outer_class_scope)
}
