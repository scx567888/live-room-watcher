// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/GameCPUserDownloadMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

/**
 * <p>GameCPUserDownloadMessageOuterClass class.</p>
 *
 * @author scx567888
 * @version $Id: $Id
 */
public final class GameCPUserDownloadMessageOuterClass {
    /**
     * Constant <code>internal_static_GameCPUserDownloadMessage_descriptor</code>
     */
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_GameCPUserDownloadMessage_descriptor;
    /**
     * Constant <code>internal_static_GameCPUserDownloadMessage_fieldAccessorTable</code>
     */
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_GameCPUserDownloadMessage_fieldAccessorTable;
    /**
     * Constant <code>descriptor</code>
     */
    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n*webcast/im/GameCPUserDownloadMessage.p" +
                        "roto\032\027webcast/im/Common.proto\032.webcast/i" +
                        "m/GameCPUserDownloadMessageEnum.proto\"\312\001" +
                        "\n\031GameCPUserDownloadMessage\022\027\n\006common\030\001 " +
                        "\001(\0132\007.Common\022\024\n\014userNickName\030\002 \001(\t\022\031\n\021us" +
                        "erDownloadCount\030\003 \001(\003\022\033\n\023userDownloadCon" +
                        "tent\030\004 \001(\t\022\030\n\020downloadGameName\030\005 \001(\t\022,\n\004" +
                        "type\030\006 \001(\0162\036.GameCPUserDownloadMessageEn" +
                        "umB=\n9cool.scx.live_room_watcher.douyin." +
                        "proto_entity.webcast.imP\001b\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.GameCPUserDownloadMessageEnumOuterClass.getDescriptor(),
                        });
        internal_static_GameCPUserDownloadMessage_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_GameCPUserDownloadMessage_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_GameCPUserDownloadMessage_descriptor,
                new java.lang.String[]{"Common", "UserNickName", "UserDownloadCount", "UserDownloadContent", "DownloadGameName", "Type",});
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.GameCPUserDownloadMessageEnumOuterClass.getDescriptor();
    }
    /**
     * <p>Constructor for GameCPUserDownloadMessageOuterClass.</p>
     */
    private GameCPUserDownloadMessageOuterClass() {
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
