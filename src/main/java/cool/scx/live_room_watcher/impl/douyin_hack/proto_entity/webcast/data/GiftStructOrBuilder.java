// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/data/GiftStruct.proto

// Protobuf Java Version: 3.25.2
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public interface GiftStructOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GiftStruct)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Image image = 1;</code>
   * @return Whether the image field is set.
   */
  boolean hasImage();
  /**
   * <code>.Image image = 1;</code>
   * @return The image.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getImage();
  /**
   * <code>.Image image = 1;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getImageOrBuilder();

  /**
   * <code>string describe = 2;</code>
   * @return The describe.
   */
  java.lang.String getDescribe();
  /**
   * <code>string describe = 2;</code>
   * @return The bytes for describe.
   */
  com.google.protobuf.ByteString
      getDescribeBytes();

  /**
   * <code>bool notify = 3;</code>
   * @return The notify.
   */
  boolean getNotify();

  /**
   * <code>int64 duration = 4;</code>
   * @return The duration.
   */
  long getDuration();

  /**
   * <code>int64 id = 5;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>.GiftStruct.GiftStructFansClubInfo fansclubInfo = 6;</code>
   * @return Whether the fansclubInfo field is set.
   */
  boolean hasFansclubInfo();
  /**
   * <code>.GiftStruct.GiftStructFansClubInfo fansclubInfo = 6;</code>
   * @return The fansclubInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftStruct.GiftStructFansClubInfo getFansclubInfo();
  /**
   * <code>.GiftStruct.GiftStructFansClubInfo fansclubInfo = 6;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftStruct.GiftStructFansClubInfoOrBuilder getFansclubInfoOrBuilder();

  /**
   * <code>bool forLinkmic = 7;</code>
   * @return The forLinkmic.
   */
  boolean getForLinkmic();

  /**
   * <code>bool doodle = 8;</code>
   * @return The doodle.
   */
  boolean getDoodle();

  /**
   * <code>bool forFansclub = 9;</code>
   * @return The forFansclub.
   */
  boolean getForFansclub();

  /**
   * <code>bool combo = 10;</code>
   * @return The combo.
   */
  boolean getCombo();

  /**
   * <code>int32 type = 11;</code>
   * @return The type.
   */
  int getType();

  /**
   * <code>int32 diamondCount = 12;</code>
   * @return The diamondCount.
   */
  int getDiamondCount();

  /**
   * <code>int32 isDisplayedOnPanel = 13;</code>
   * @return The isDisplayedOnPanel.
   */
  int getIsDisplayedOnPanel();

  /**
   * <code>int64 primaryEffectId = 14;</code>
   * @return The primaryEffectId.
   */
  long getPrimaryEffectId();

  /**
   * <code>.Image giftLabelIcon = 15;</code>
   * @return Whether the giftLabelIcon field is set.
   */
  boolean hasGiftLabelIcon();
  /**
   * <code>.Image giftLabelIcon = 15;</code>
   * @return The giftLabelIcon.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getGiftLabelIcon();
  /**
   * <code>.Image giftLabelIcon = 15;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getGiftLabelIconOrBuilder();

  /**
   * <code>string name = 16;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 16;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string region = 17;</code>
   * @return The region.
   */
  java.lang.String getRegion();
  /**
   * <code>string region = 17;</code>
   * @return The bytes for region.
   */
  com.google.protobuf.ByteString
      getRegionBytes();

  /**
   * <code>string manual = 18;</code>
   * @return The manual.
   */
  java.lang.String getManual();
  /**
   * <code>string manual = 18;</code>
   * @return The bytes for manual.
   */
  com.google.protobuf.ByteString
      getManualBytes();

  /**
   * <code>bool forCustom = 19;</code>
   * @return The forCustom.
   */
  boolean getForCustom();

  /**
   * <code>map&lt;string, int64&gt; specialEffects = 20;</code>
   */
  int getSpecialEffectsCount();
  /**
   * <code>map&lt;string, int64&gt; specialEffects = 20;</code>
   */
  boolean containsSpecialEffects(
      java.lang.String key);
  /**
   * Use {@link #getSpecialEffectsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.Long>
  getSpecialEffects();
  /**
   * <code>map&lt;string, int64&gt; specialEffects = 20;</code>
   */
  java.util.Map<java.lang.String, java.lang.Long>
  getSpecialEffectsMap();
  /**
   * <code>map&lt;string, int64&gt; specialEffects = 20;</code>
   */
  long getSpecialEffectsOrDefault(
      java.lang.String key,
      long defaultValue);
  /**
   * <code>map&lt;string, int64&gt; specialEffects = 20;</code>
   */
  long getSpecialEffectsOrThrow(
      java.lang.String key);

  /**
   * <code>.Image icon = 21;</code>
   * @return Whether the icon field is set.
   */
  boolean hasIcon();
  /**
   * <code>.Image icon = 21;</code>
   * @return The icon.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getIcon();
  /**
   * <code>.Image icon = 21;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getIconOrBuilder();

  /**
   * <code>int32 actionType = 22;</code>
   * @return The actionType.
   */
  int getActionType();

  /**
   * <code>int32 watermelonSeeds = 23;</code>
   * @return The watermelonSeeds.
   */
  int getWatermelonSeeds();

  /**
   * <code>string goldEffect = 24;</code>
   * @return The goldEffect.
   */
  java.lang.String getGoldEffect();
  /**
   * <code>string goldEffect = 24;</code>
   * @return The bytes for goldEffect.
   */
  com.google.protobuf.ByteString
      getGoldEffectBytes();

  /**
   * <code>repeated .LuckyMoneyGiftMeta subs = 25;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.LuckyMoneyGiftMeta> 
      getSubsList();
  /**
   * <code>repeated .LuckyMoneyGiftMeta subs = 25;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.LuckyMoneyGiftMeta getSubs(int index);
  /**
   * <code>repeated .LuckyMoneyGiftMeta subs = 25;</code>
   */
  int getSubsCount();
  /**
   * <code>repeated .LuckyMoneyGiftMeta subs = 25;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.LuckyMoneyGiftMetaOrBuilder> 
      getSubsOrBuilderList();
  /**
   * <code>repeated .LuckyMoneyGiftMeta subs = 25;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.LuckyMoneyGiftMetaOrBuilder getSubsOrBuilder(
      int index);

  /**
   * <code>int64 goldenBeans = 26;</code>
   * @return The goldenBeans.
   */
  long getGoldenBeans();

  /**
   * <code>int64 honorLevel = 27;</code>
   * @return The honorLevel.
   */
  long getHonorLevel();

  /**
   * <code>int32 itemType = 28;</code>
   * @return The itemType.
   */
  int getItemType();

  /**
   * <code>string schemeUrl = 29;</code>
   * @return The schemeUrl.
   */
  java.lang.String getSchemeUrl();
  /**
   * <code>string schemeUrl = 29;</code>
   * @return The bytes for schemeUrl.
   */
  com.google.protobuf.ByteString
      getSchemeUrlBytes();

  /**
   * <code>.GiftPanelOperation giftOperation = 30;</code>
   * @return Whether the giftOperation field is set.
   */
  boolean hasGiftOperation();
  /**
   * <code>.GiftPanelOperation giftOperation = 30;</code>
   * @return The giftOperation.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftPanelOperation getGiftOperation();
  /**
   * <code>.GiftPanelOperation giftOperation = 30;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftPanelOperationOrBuilder getGiftOperationOrBuilder();

  /**
   * <code>string eventName = 31;</code>
   * @return The eventName.
   */
  java.lang.String getEventName();
  /**
   * <code>string eventName = 31;</code>
   * @return The bytes for eventName.
   */
  com.google.protobuf.ByteString
      getEventNameBytes();

  /**
   * <code>int64 nobleLevel = 32;</code>
   * @return The nobleLevel.
   */
  long getNobleLevel();

  /**
   * <code>string guideUrl = 33;</code>
   * @return The guideUrl.
   */
  java.lang.String getGuideUrl();
  /**
   * <code>string guideUrl = 33;</code>
   * @return The bytes for guideUrl.
   */
  com.google.protobuf.ByteString
      getGuideUrlBytes();

  /**
   * <code>bool punishMedicine = 34;</code>
   * @return The punishMedicine.
   */
  boolean getPunishMedicine();

  /**
   * <code>bool forPortal = 35;</code>
   * @return The forPortal.
   */
  boolean getForPortal();

  /**
   * <code>string businessText = 36;</code>
   * @return The businessText.
   */
  java.lang.String getBusinessText();
  /**
   * <code>string businessText = 36;</code>
   * @return The bytes for businessText.
   */
  com.google.protobuf.ByteString
      getBusinessTextBytes();

  /**
   * <code>bool cnyGift = 37;</code>
   * @return The cnyGift.
   */
  boolean getCnyGift();

  /**
   * <code>int64 appId = 38;</code>
   * @return The appId.
   */
  long getAppId();

  /**
   * <code>int64 vipLevel = 39;</code>
   * @return The vipLevel.
   */
  long getVipLevel();

  /**
   * <code>bool isGray = 40;</code>
   * @return The isGray.
   */
  boolean getIsGray();

  /**
   * <code>string graySchemeUrl = 41;</code>
   * @return The graySchemeUrl.
   */
  java.lang.String getGraySchemeUrl();
  /**
   * <code>string graySchemeUrl = 41;</code>
   * @return The bytes for graySchemeUrl.
   */
  com.google.protobuf.ByteString
      getGraySchemeUrlBytes();

  /**
   * <code>int64 giftScene = 42;</code>
   * @return The giftScene.
   */
  long getGiftScene();

  /**
   * <code>.GiftBanner giftBanner = 43;</code>
   * @return Whether the giftBanner field is set.
   */
  boolean hasGiftBanner();
  /**
   * <code>.GiftBanner giftBanner = 43;</code>
   * @return The giftBanner.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftBanner getGiftBanner();
  /**
   * <code>.GiftBanner giftBanner = 43;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftBannerOrBuilder getGiftBannerOrBuilder();

  /**
   * <code>repeated string triggerWords = 44;</code>
   * @return A list containing the triggerWords.
   */
  java.util.List<java.lang.String>
      getTriggerWordsList();
  /**
   * <code>repeated string triggerWords = 44;</code>
   * @return The count of triggerWords.
   */
  int getTriggerWordsCount();
  /**
   * <code>repeated string triggerWords = 44;</code>
   * @param index The index of the element to return.
   * @return The triggerWords at the given index.
   */
  java.lang.String getTriggerWords(int index);
  /**
   * <code>repeated string triggerWords = 44;</code>
   * @param index The index of the value to return.
   * @return The bytes of the triggerWords at the given index.
   */
  com.google.protobuf.ByteString
      getTriggerWordsBytes(int index);

  /**
   * <code>repeated .GiftBuffInfo giftBuffInfos = 45;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftBuffInfo> 
      getGiftBuffInfosList();
  /**
   * <code>repeated .GiftBuffInfo giftBuffInfos = 45;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftBuffInfo getGiftBuffInfos(int index);
  /**
   * <code>repeated .GiftBuffInfo giftBuffInfos = 45;</code>
   */
  int getGiftBuffInfosCount();
  /**
   * <code>repeated .GiftBuffInfo giftBuffInfos = 45;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftBuffInfoOrBuilder> 
      getGiftBuffInfosOrBuilderList();
  /**
   * <code>repeated .GiftBuffInfo giftBuffInfos = 45;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftBuffInfoOrBuilder getGiftBuffInfosOrBuilder(
      int index);

  /**
   * <code>bool forFirstRecharge = 46;</code>
   * @return The forFirstRecharge.
   */
  boolean getForFirstRecharge();

  /**
   * <code>.Image dynamicImgForSelected = 47;</code>
   * @return Whether the dynamicImgForSelected field is set.
   */
  boolean hasDynamicImgForSelected();
  /**
   * <code>.Image dynamicImgForSelected = 47;</code>
   * @return The dynamicImgForSelected.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getDynamicImgForSelected();
  /**
   * <code>.Image dynamicImgForSelected = 47;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getDynamicImgForSelectedOrBuilder();

  /**
   * <code>int32 afterSendAction = 48;</code>
   * @return The afterSendAction.
   */
  int getAfterSendAction();

  /**
   * <code>int64 giftOfflineTime = 49;</code>
   * @return The giftOfflineTime.
   */
  long getGiftOfflineTime();

  /**
   * <code>string topBarText = 50;</code>
   * @return The topBarText.
   */
  java.lang.String getTopBarText();
  /**
   * <code>string topBarText = 50;</code>
   * @return The bytes for topBarText.
   */
  com.google.protobuf.ByteString
      getTopBarTextBytes();

  /**
   * <code>.Image topRightAvatar = 51;</code>
   * @return Whether the topRightAvatar field is set.
   */
  boolean hasTopRightAvatar();
  /**
   * <code>.Image topRightAvatar = 51;</code>
   * @return The topRightAvatar.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getTopRightAvatar();
  /**
   * <code>.Image topRightAvatar = 51;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getTopRightAvatarOrBuilder();

  /**
   * <code>string bannerSchemeUrl = 52;</code>
   * @return The bannerSchemeUrl.
   */
  java.lang.String getBannerSchemeUrl();
  /**
   * <code>string bannerSchemeUrl = 52;</code>
   * @return The bytes for bannerSchemeUrl.
   */
  com.google.protobuf.ByteString
      getBannerSchemeUrlBytes();

  /**
   * <code>bool isLocked = 53;</code>
   * @return The isLocked.
   */
  boolean getIsLocked();

  /**
   * <code>int64 reqExtraType = 54;</code>
   * @return The reqExtraType.
   */
  long getReqExtraType();

  /**
   * <code>repeated int64 assetIds = 55;</code>
   * @return A list containing the assetIds.
   */
  java.util.List<java.lang.Long> getAssetIdsList();
  /**
   * <code>repeated int64 assetIds = 55;</code>
   * @return The count of assetIds.
   */
  int getAssetIdsCount();
  /**
   * <code>repeated int64 assetIds = 55;</code>
   * @param index The index of the element to return.
   * @return The assetIds at the given index.
   */
  long getAssetIds(int index);

  /**
   * <code>.GiftPreviewInfo giftPreviewInfo = 56;</code>
   * @return Whether the giftPreviewInfo field is set.
   */
  boolean hasGiftPreviewInfo();
  /**
   * <code>.GiftPreviewInfo giftPreviewInfo = 56;</code>
   * @return The giftPreviewInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftPreviewInfo getGiftPreviewInfo();
  /**
   * <code>.GiftPreviewInfo giftPreviewInfo = 56;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftPreviewInfoOrBuilder getGiftPreviewInfoOrBuilder();

  /**
   * <code>.GiftTip giftTip = 57;</code>
   * @return Whether the giftTip field is set.
   */
  boolean hasGiftTip();
  /**
   * <code>.GiftTip giftTip = 57;</code>
   * @return The giftTip.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftTip getGiftTip();
  /**
   * <code>.GiftTip giftTip = 57;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftTipOrBuilder getGiftTipOrBuilder();

  /**
   * <code>int32 needSweepLightCount = 58;</code>
   * @return The needSweepLightCount.
   */
  int getNeedSweepLightCount();

  /**
   * <code>repeated .GiftGroupInfo groupInfo = 59;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftGroupInfo> 
      getGroupInfoList();
  /**
   * <code>repeated .GiftGroupInfo groupInfo = 59;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftGroupInfo getGroupInfo(int index);
  /**
   * <code>repeated .GiftGroupInfo groupInfo = 59;</code>
   */
  int getGroupInfoCount();
  /**
   * <code>repeated .GiftGroupInfo groupInfo = 59;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftGroupInfoOrBuilder> 
      getGroupInfoOrBuilderList();
  /**
   * <code>repeated .GiftGroupInfo groupInfo = 59;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.GiftGroupInfoOrBuilder getGroupInfoOrBuilder(
      int index);
}
