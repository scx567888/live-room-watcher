// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/GiftMessage.proto

// Protobuf Java Version: 4.26.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface GiftMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GiftMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Common common = 1;</code>
   * @return Whether the common field is set.
   */
  boolean hasCommon();
  /**
   * <code>.Common common = 1;</code>
   * @return The common.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.Common getCommon();
  /**
   * <code>.Common common = 1;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CommonOrBuilder getCommonOrBuilder();

  /**
   * <code>int64 giftId = 2;</code>
   * @return The giftId.
   */
  long getGiftId();

  /**
   * <code>int64 fanTicketCount = 3;</code>
   * @return The fanTicketCount.
   */
  long getFanTicketCount();

  /**
   * <code>int64 groupCount = 4;</code>
   * @return The groupCount.
   */
  long getGroupCount();

  /**
   * <code>int64 repeatCount = 5;</code>
   * @return The repeatCount.
   */
  long getRepeatCount();

  /**
   * <code>int64 comboCount = 6;</code>
   * @return The comboCount.
   */
  long getComboCount();

  /**
   * <code>.User user = 7;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.User user = 7;</code>
   * @return The user.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User getUser();
  /**
   * <code>.User user = 7;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOrBuilder getUserOrBuilder();

  /**
   * <code>.User toUser = 8;</code>
   * @return Whether the toUser field is set.
   */
  boolean hasToUser();
  /**
   * <code>.User toUser = 8;</code>
   * @return The toUser.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User getToUser();
  /**
   * <code>.User toUser = 8;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOrBuilder getToUserOrBuilder();

  /**
   * <code>int32 repeatEnd = 9;</code>
   * @return The repeatEnd.
   */
  int getRepeatEnd();

  /**
   * <code>.GiftMessage.TextEffect textEffect = 10;</code>
   * @return Whether the textEffect field is set.
   */
  boolean hasTextEffect();
  /**
   * <code>.GiftMessage.TextEffect textEffect = 10;</code>
   * @return The textEffect.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.GiftMessage.TextEffect getTextEffect();
  /**
   * <code>.GiftMessage.TextEffect textEffect = 10;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.GiftMessage.TextEffectOrBuilder getTextEffectOrBuilder();

  /**
   * <code>int64 groupId = 11;</code>
   * @return The groupId.
   */
  long getGroupId();

  /**
   * <code>int64 incomeTaskgifts = 12;</code>
   * @return The incomeTaskgifts.
   */
  long getIncomeTaskgifts();

  /**
   * <code>int64 roomFanTicketCount = 13;</code>
   * @return The roomFanTicketCount.
   */
  long getRoomFanTicketCount();

  /**
   * <code>.GiftIMPriority priority = 14;</code>
   * @return Whether the priority field is set.
   */
  boolean hasPriority();
  /**
   * <code>.GiftIMPriority priority = 14;</code>
   * @return The priority.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftIMPriority getPriority();
  /**
   * <code>.GiftIMPriority priority = 14;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftIMPriorityOrBuilder getPriorityOrBuilder();

  /**
   * <code>.GiftStruct gift = 15;</code>
   * @return Whether the gift field is set.
   */
  boolean hasGift();
  /**
   * <code>.GiftStruct gift = 15;</code>
   * @return The gift.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftStruct getGift();
  /**
   * <code>.GiftStruct gift = 15;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftStructOrBuilder getGiftOrBuilder();

  /**
   * <code>string logId = 16;</code>
   * @return The logId.
   */
  java.lang.String getLogId();
  /**
   * <code>string logId = 16;</code>
   * @return The bytes for logId.
   */
  com.google.protobuf.ByteString
      getLogIdBytes();

  /**
   * <code>int64 sendType = 17;</code>
   * @return The sendType.
   */
  long getSendType();

  /**
   * <code>.PublicAreaCommon publicAreaCommon = 18;</code>
   * @return Whether the publicAreaCommon field is set.
   */
  boolean hasPublicAreaCommon();
  /**
   * <code>.PublicAreaCommon publicAreaCommon = 18;</code>
   * @return The publicAreaCommon.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PublicAreaCommon getPublicAreaCommon();
  /**
   * <code>.PublicAreaCommon publicAreaCommon = 18;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PublicAreaCommonOrBuilder getPublicAreaCommonOrBuilder();

  /**
   * <code>.Text trayDisplayText = 19;</code>
   * @return Whether the trayDisplayText field is set.
   */
  boolean hasTrayDisplayText();
  /**
   * <code>.Text trayDisplayText = 19;</code>
   * @return The trayDisplayText.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Text getTrayDisplayText();
  /**
   * <code>.Text trayDisplayText = 19;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.TextOrBuilder getTrayDisplayTextOrBuilder();

  /**
   * <code>int64 bannedDisplayEffects = 20;</code>
   * @return The bannedDisplayEffects.
   */
  long getBannedDisplayEffects();

  /**
   * <code>.GiftTrayInfo trayInfo = 21;</code>
   * @return Whether the trayInfo field is set.
   */
  boolean hasTrayInfo();
  /**
   * <code>.GiftTrayInfo trayInfo = 21;</code>
   * @return The trayInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftTrayInfo getTrayInfo();
  /**
   * <code>.GiftTrayInfo trayInfo = 21;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftTrayInfoOrBuilder getTrayInfoOrBuilder();

  /**
   * <code>.AssetEffectMixInfo assetEffectMixInfo = 24;</code>
   * @return Whether the assetEffectMixInfo field is set.
   */
  boolean hasAssetEffectMixInfo();
  /**
   * <code>.AssetEffectMixInfo assetEffectMixInfo = 24;</code>
   * @return The assetEffectMixInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.AssetEffectMixInfo getAssetEffectMixInfo();
  /**
   * <code>.AssetEffectMixInfo assetEffectMixInfo = 24;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.AssetEffectMixInfoOrBuilder getAssetEffectMixInfoOrBuilder();

  /**
   * <code>bool displayForSelf = 25;</code>
   * @return The displayForSelf.
   */
  boolean getDisplayForSelf();

  /**
   * <code>string interactGiftInfo = 26;</code>
   * @return The interactGiftInfo.
   */
  java.lang.String getInteractGiftInfo();
  /**
   * <code>string interactGiftInfo = 26;</code>
   * @return The bytes for interactGiftInfo.
   */
  com.google.protobuf.ByteString
      getInteractGiftInfoBytes();

  /**
   * <code>string diyItemInfo = 27;</code>
   * @return The diyItemInfo.
   */
  java.lang.String getDiyItemInfo();
  /**
   * <code>string diyItemInfo = 27;</code>
   * @return The bytes for diyItemInfo.
   */
  com.google.protobuf.ByteString
      getDiyItemInfoBytes();

  /**
   * <code>int64 minAssetSetList = 28;</code>
   * @return The minAssetSetList.
   */
  long getMinAssetSetList();

  /**
   * <code>int64 totalCount = 29;</code>
   * @return The totalCount.
   */
  long getTotalCount();

  /**
   * <code>int32 clientGiftSource = 30;</code>
   * @return The clientGiftSource.
   */
  int getClientGiftSource();

  /**
   * <code>.AnchorGiftData anchorGift = 31;</code>
   * @return Whether the anchorGift field is set.
   */
  boolean hasAnchorGift();
  /**
   * <code>.AnchorGiftData anchorGift = 31;</code>
   * @return The anchorGift.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.AnchorGiftData getAnchorGift();
  /**
   * <code>.AnchorGiftData anchorGift = 31;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.AnchorGiftDataOrBuilder getAnchorGiftOrBuilder();

  /**
   * <code>repeated int64 toUserIdsList = 32;</code>
   * @return A list containing the toUserIdsList.
   */
  java.util.List<java.lang.Long> getToUserIdsListList();
  /**
   * <code>repeated int64 toUserIdsList = 32;</code>
   * @return The count of toUserIdsList.
   */
  int getToUserIdsListCount();
  /**
   * <code>repeated int64 toUserIdsList = 32;</code>
   * @param index The index of the element to return.
   * @return The toUserIdsList at the given index.
   */
  long getToUserIdsList(int index);

  /**
   * <code>int64 sendTime = 33;</code>
   * @return The sendTime.
   */
  long getSendTime();

  /**
   * <code>int64 forceDisplayEffects = 34;</code>
   * @return The forceDisplayEffects.
   */
  long getForceDisplayEffects();

  /**
   * <code>string traceId = 35;</code>
   * @return The traceId.
   */
  java.lang.String getTraceId();
  /**
   * <code>string traceId = 35;</code>
   * @return The bytes for traceId.
   */
  com.google.protobuf.ByteString
      getTraceIdBytes();

  /**
   * <code>int64 effectDisplayTs = 36;</code>
   * @return The effectDisplayTs.
   */
  long getEffectDisplayTs();
}
