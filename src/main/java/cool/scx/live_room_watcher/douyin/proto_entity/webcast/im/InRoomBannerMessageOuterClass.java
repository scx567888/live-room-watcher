// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/InRoomBannerMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

public final class InRoomBannerMessageOuterClass {
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_InRoomBannerMessage_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_InRoomBannerMessage_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n$webcast/im/InRoomBannerMessage.proto\032\027" +
                        "webcast/im/Common.proto\032\033webcast/im/Acti" +
                        "onType.proto\"\277\004\n\023InRoomBannerMessage\022\027\n\006" +
                        "common\030\001 \001(\0132\007.Common\022\r\n\005extra\030\002 \001(\t\0223\n\010" +
                        "position\030\003 \001(\0162!.InRoomBannerMessage.Pos" +
                        "itionType\022\037\n\nactionType\030\004 \001(\0162\013.ActionTy" +
                        "pe\022\024\n\014containerUrl\030\005 \001(\t\022\030\n\020lynxContaine" +
                        "rUrl\030\006 \001(\t\0229\n\rcontainerType\030\007 \001(\0162\".InRo" +
                        "omBannerMessage.ContainerType\022+\n\006opType\030" +
                        "\010 \001(\0162\033.InRoomBannerMessage.OpType\"\312\001\n\014P" +
                        "ositionType\022\r\n\tUNDEFINED\020\000\022\020\n\014BOTTOM_RIG" +
                        "HT\020\001\022\r\n\tTOP_RIGHT\020\002\022\014\n\010TOP_LEFT\020\003\022\017\n\013BOT" +
                        "TOM_LEFT\020\004\022\026\n\022ACTIVITY_TOP_RIGHT\020\005\022\033\n\027AC" +
                        "TIVITY_VS_INTERACTIVE\020\006\022\030\n\024ACTIVITY_INTE" +
                        "RACTIVE\020\007\022\034\n\030ACTIVITY_VS_BOTTOM_RIGHT\020\010\"" +
                        "&\n\rContainerType\022\013\n\007WEBVIEW\020\000\022\010\n\004LYNX\020\001\"" +
                        "\035\n\006OpType\022\n\n\006DELETE\020\000\022\007\n\003ADD\020\001B=\n9cool.s" +
                        "cx.live_room_watcher.douyin.proto_entity" +
                        ".webcast.imP\001b\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.ActionTypeOuterClass.getDescriptor(),
                        });
        internal_static_InRoomBannerMessage_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_InRoomBannerMessage_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_InRoomBannerMessage_descriptor,
                new java.lang.String[]{"Common", "Extra", "Position", "ActionType", "ContainerUrl", "LynxContainerUrl", "ContainerType", "OpType",});
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.ActionTypeOuterClass.getDescriptor();
    }
    private InRoomBannerMessageOuterClass() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    // @@protoc_insertion_point(outer_class_scope)
}
