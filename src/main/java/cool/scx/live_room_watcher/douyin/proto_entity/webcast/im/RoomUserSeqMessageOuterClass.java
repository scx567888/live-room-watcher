// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webcast/im/RoomUserSeqMessage.proto

package cool.scx.live_room_watcher.douyin.proto_entity.webcast.im;

public final class RoomUserSeqMessageOuterClass {
  private RoomUserSeqMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RoomUserSeqMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RoomUserSeqMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RoomUserSeqMessage_Contributor_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RoomUserSeqMessage_Contributor_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n#webcast/im/RoomUserSeqMessage.proto\032\027w" +
      "ebcast/im/Common.proto\032\027webcast/data/Use" +
      "r.proto\"\207\004\n\022RoomUserSeqMessage\022\027\n\006common" +
      "\030\001 \001(\0132\007.Common\0222\n\tranksList\030\002 \003(\0132\037.Roo" +
      "mUserSeqMessage.Contributor\022\r\n\005total\030\003 \001" +
      "(\003\022\016\n\006popStr\030\004 \001(\t\0222\n\tseatsList\030\005 \003(\0132\037." +
      "RoomUserSeqMessage.Contributor\022\022\n\npopula" +
      "rity\030\006 \001(\003\022\021\n\ttotalUser\030\007 \001(\003\022\024\n\014totalUs" +
      "erStr\030\010 \001(\t\022\020\n\010totalStr\030\t \001(\t\022\033\n\023onlineU" +
      "serForAnchor\030\n \001(\t\022\030\n\020totalPvForAnchor\030\013" +
      " \001(\t\022\027\n\017upRightStatsStr\030\014 \001(\t\022\037\n\027upRight" +
      "StatsStrComplete\030\r \001(\t\032\220\001\n\013Contributor\022\r" +
      "\n\005score\030\001 \001(\003\022\023\n\004user\030\002 \001(\0132\005.User\022\014\n\004ra" +
      "nk\030\003 \001(\003\022\r\n\005delta\030\004 \001(\003\022\020\n\010isHidden\030\005 \001(" +
      "\010\022\030\n\020scoreDescription\030\006 \001(\t\022\024\n\014exactlySc" +
      "ore\030\007 \001(\tB=\n9cool.scx.live_room_watcher." +
      "douyin.proto_entity.webcast.imP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor(),
          cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOuterClass.getDescriptor(),
        });
    internal_static_RoomUserSeqMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_RoomUserSeqMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RoomUserSeqMessage_descriptor,
        new java.lang.String[] { "Common", "RanksList", "Total", "PopStr", "SeatsList", "Popularity", "TotalUser", "TotalUserStr", "TotalStr", "OnlineUserForAnchor", "TotalPvForAnchor", "UpRightStatsStr", "UpRightStatsStrComplete", });
    internal_static_RoomUserSeqMessage_Contributor_descriptor =
      internal_static_RoomUserSeqMessage_descriptor.getNestedTypes().get(0);
    internal_static_RoomUserSeqMessage_Contributor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RoomUserSeqMessage_Contributor_descriptor,
        new java.lang.String[] { "Score", "User", "Rank", "Delta", "IsHidden", "ScoreDescription", "ExactlyScore", });
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.CommonOuterClass.getDescriptor();
    cool.scx.live_room_watcher.douyin.proto_entity.webcast.data.UserOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
