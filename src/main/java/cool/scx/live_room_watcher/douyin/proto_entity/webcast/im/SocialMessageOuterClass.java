// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/SocialMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

public final class SocialMessageOuterClass {
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_SocialMessage_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_SocialMessage_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\036webcast/im/SocialMessage.proto\032\027webcas" +
                        "t/im/Common.proto\032\027webcast/data/User.pro" +
                        "to\032!webcast/im/PublicAreaCommon.proto\"\267\001" +
                        "\n\rSocialMessage\022\027\n\006common\030\001 \001(\0132\007.Common" +
                        "\022\023\n\004user\030\002 \001(\0132\005.User\022\021\n\tshareType\030\003 \001(\003" +
                        "\022\016\n\006action\030\004 \001(\003\022\023\n\013shareTarget\030\005 \001(\t\022\023\n" +
                        "\013followCount\030\006 \001(\003\022+\n\020publicAreaCommon\030\007" +
                        " \001(\0132\021.PublicAreaCommonB=\n9cool.scx.live" +
                        "_room_watcher.douyin.proto_entity.webcas" +
                        "t.imP\001b\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOuterClass.getDescriptor(),
                                cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.PublicAreaCommonOuterClass.getDescriptor(),
                        });
        internal_static_SocialMessage_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_SocialMessage_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_SocialMessage_descriptor,
                new java.lang.String[]{"Common", "User", "ShareType", "Action", "ShareTarget", "FollowCount", "PublicAreaCommon",});
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOuterClass.getDescriptor();
        cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.PublicAreaCommonOuterClass.getDescriptor();
    }
    private SocialMessageOuterClass() {
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
