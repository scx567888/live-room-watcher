// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/data/User.proto

// Protobuf Java Version: 4.26.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data;

public interface UserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:User)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>int64 shortId = 2;</code>
   * @return The shortId.
   */
  long getShortId();

  /**
   * <code>string nickname = 3;</code>
   * @return The nickname.
   */
  java.lang.String getNickname();
  /**
   * <code>string nickname = 3;</code>
   * @return The bytes for nickname.
   */
  com.google.protobuf.ByteString
      getNicknameBytes();

  /**
   * <code>int32 gender = 4;</code>
   * @return The gender.
   */
  int getGender();

  /**
   * <code>string signature = 5;</code>
   * @return The signature.
   */
  java.lang.String getSignature();
  /**
   * <code>string signature = 5;</code>
   * @return The bytes for signature.
   */
  com.google.protobuf.ByteString
      getSignatureBytes();

  /**
   * <code>int32 level = 6;</code>
   * @return The level.
   */
  int getLevel();

  /**
   * <code>int64 birthday = 7;</code>
   * @return The birthday.
   */
  long getBirthday();

  /**
   * <code>string telephone = 8;</code>
   * @return The telephone.
   */
  java.lang.String getTelephone();
  /**
   * <code>string telephone = 8;</code>
   * @return The bytes for telephone.
   */
  com.google.protobuf.ByteString
      getTelephoneBytes();

  /**
   * <code>.Image avatarThumb = 9;</code>
   * @return Whether the avatarThumb field is set.
   */
  boolean hasAvatarThumb();
  /**
   * <code>.Image avatarThumb = 9;</code>
   * @return The avatarThumb.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarThumb();
  /**
   * <code>.Image avatarThumb = 9;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarThumbOrBuilder();

  /**
   * <code>.Image avatarMedium = 10;</code>
   * @return Whether the avatarMedium field is set.
   */
  boolean hasAvatarMedium();
  /**
   * <code>.Image avatarMedium = 10;</code>
   * @return The avatarMedium.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarMedium();
  /**
   * <code>.Image avatarMedium = 10;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarMediumOrBuilder();

  /**
   * <code>.Image avatarLarge = 11;</code>
   * @return Whether the avatarLarge field is set.
   */
  boolean hasAvatarLarge();
  /**
   * <code>.Image avatarLarge = 11;</code>
   * @return The avatarLarge.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarLarge();
  /**
   * <code>.Image avatarLarge = 11;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarLargeOrBuilder();

  /**
   * <code>bool verified = 12;</code>
   * @return The verified.
   */
  boolean getVerified();

  /**
   * <code>int32 experience = 13;</code>
   * @return The experience.
   */
  int getExperience();

  /**
   * <code>string city = 14;</code>
   * @return The city.
   */
  java.lang.String getCity();
  /**
   * <code>string city = 14;</code>
   * @return The bytes for city.
   */
  com.google.protobuf.ByteString
      getCityBytes();

  /**
   * <code>int32 status = 15;</code>
   * @return The status.
   */
  int getStatus();

  /**
   * <code>int64 createTime = 16;</code>
   * @return The createTime.
   */
  long getCreateTime();

  /**
   * <code>int64 modifyTime = 17;</code>
   * @return The modifyTime.
   */
  long getModifyTime();

  /**
   * <code>int32 secret = 18;</code>
   * @return The secret.
   */
  int getSecret();

  /**
   * <code>string shareQrcodeUri = 19;</code>
   * @return The shareQrcodeUri.
   */
  java.lang.String getShareQrcodeUri();
  /**
   * <code>string shareQrcodeUri = 19;</code>
   * @return The bytes for shareQrcodeUri.
   */
  com.google.protobuf.ByteString
      getShareQrcodeUriBytes();

  /**
   * <code>int32 incomeSharePercent = 20;</code>
   * @return The incomeSharePercent.
   */
  int getIncomeSharePercent();

  /**
   * <code>.Image badgeImageListList = 21;</code>
   * @return Whether the badgeImageListList field is set.
   */
  boolean hasBadgeImageListList();
  /**
   * <code>.Image badgeImageListList = 21;</code>
   * @return The badgeImageListList.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getBadgeImageListList();
  /**
   * <code>.Image badgeImageListList = 21;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getBadgeImageListListOrBuilder();

  /**
   * <code>.User.FollowInfo followInfo = 22;</code>
   * @return Whether the followInfo field is set.
   */
  boolean hasFollowInfo();
  /**
   * <code>.User.FollowInfo followInfo = 22;</code>
   * @return The followInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.FollowInfo getFollowInfo();
  /**
   * <code>.User.FollowInfo followInfo = 22;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.FollowInfoOrBuilder getFollowInfoOrBuilder();

  /**
   * <code>.User.PayGrade payGrade = 23;</code>
   * @return Whether the payGrade field is set.
   */
  boolean hasPayGrade();
  /**
   * <code>.User.PayGrade payGrade = 23;</code>
   * @return The payGrade.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.PayGrade getPayGrade();
  /**
   * <code>.User.PayGrade payGrade = 23;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.PayGradeOrBuilder getPayGradeOrBuilder();

  /**
   * <code>.User.FansClub fansClub = 24;</code>
   * @return Whether the fansClub field is set.
   */
  boolean hasFansClub();
  /**
   * <code>.User.FansClub fansClub = 24;</code>
   * @return The fansClub.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.FansClub getFansClub();
  /**
   * <code>.User.FansClub fansClub = 24;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.FansClubOrBuilder getFansClubOrBuilder();

  /**
   * <code>.User.Border border = 25;</code>
   * @return Whether the border field is set.
   */
  boolean hasBorder();
  /**
   * <code>.User.Border border = 25;</code>
   * @return The border.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.Border getBorder();
  /**
   * <code>.User.Border border = 25;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.BorderOrBuilder getBorderOrBuilder();

  /**
   * <code>string specialId = 26;</code>
   * @return The specialId.
   */
  java.lang.String getSpecialId();
  /**
   * <code>string specialId = 26;</code>
   * @return The bytes for specialId.
   */
  com.google.protobuf.ByteString
      getSpecialIdBytes();

  /**
   * <code>.Image avatarBorder = 27;</code>
   * @return Whether the avatarBorder field is set.
   */
  boolean hasAvatarBorder();
  /**
   * <code>.Image avatarBorder = 27;</code>
   * @return The avatarBorder.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarBorder();
  /**
   * <code>.Image avatarBorder = 27;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarBorderOrBuilder();

  /**
   * <code>.Image medal = 28;</code>
   * @return Whether the medal field is set.
   */
  boolean hasMedal();
  /**
   * <code>.Image medal = 28;</code>
   * @return The medal.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getMedal();
  /**
   * <code>.Image medal = 28;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getMedalOrBuilder();

  /**
   * <code>repeated .Image realTimeIconsList = 29;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image> 
      getRealTimeIconsListList();
  /**
   * <code>repeated .Image realTimeIconsList = 29;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getRealTimeIconsList(int index);
  /**
   * <code>repeated .Image realTimeIconsList = 29;</code>
   */
  int getRealTimeIconsListCount();
  /**
   * <code>repeated .Image realTimeIconsList = 29;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder> 
      getRealTimeIconsListOrBuilderList();
  /**
   * <code>repeated .Image realTimeIconsList = 29;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getRealTimeIconsListOrBuilder(
      int index);

  /**
   * <code>repeated .Image newRealTimeIconsList = 30;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image> 
      getNewRealTimeIconsListList();
  /**
   * <code>repeated .Image newRealTimeIconsList = 30;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getNewRealTimeIconsList(int index);
  /**
   * <code>repeated .Image newRealTimeIconsList = 30;</code>
   */
  int getNewRealTimeIconsListCount();
  /**
   * <code>repeated .Image newRealTimeIconsList = 30;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder> 
      getNewRealTimeIconsListOrBuilderList();
  /**
   * <code>repeated .Image newRealTimeIconsList = 30;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getNewRealTimeIconsListOrBuilder(
      int index);

  /**
   * <code>int64 topVipNo = 31;</code>
   * @return The topVipNo.
   */
  long getTopVipNo();

  /**
   * <code>.User.UserAttr userAttr = 32;</code>
   * @return Whether the userAttr field is set.
   */
  boolean hasUserAttr();
  /**
   * <code>.User.UserAttr userAttr = 32;</code>
   * @return The userAttr.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.UserAttr getUserAttr();
  /**
   * <code>.User.UserAttr userAttr = 32;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.UserAttrOrBuilder getUserAttrOrBuilder();

  /**
   * <code>.User.OwnRoom ownRoom = 33;</code>
   * @return Whether the ownRoom field is set.
   */
  boolean hasOwnRoom();
  /**
   * <code>.User.OwnRoom ownRoom = 33;</code>
   * @return The ownRoom.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.OwnRoom getOwnRoom();
  /**
   * <code>.User.OwnRoom ownRoom = 33;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.OwnRoomOrBuilder getOwnRoomOrBuilder();

  /**
   * <code>int64 payScore = 34;</code>
   * @return The payScore.
   */
  long getPayScore();

  /**
   * <code>int64 ticketCount = 35;</code>
   * @return The ticketCount.
   */
  long getTicketCount();

  /**
   * <code>.User.AnchorInfo anchorInfo = 36;</code>
   * @return Whether the anchorInfo field is set.
   */
  boolean hasAnchorInfo();
  /**
   * <code>.User.AnchorInfo anchorInfo = 36;</code>
   * @return The anchorInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AnchorInfo getAnchorInfo();
  /**
   * <code>.User.AnchorInfo anchorInfo = 36;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AnchorInfoOrBuilder getAnchorInfoOrBuilder();

  /**
   * <code>int32 linkMicStats = 37;</code>
   * @return The linkMicStats.
   */
  int getLinkMicStats();

  /**
   * <code>string displayId = 38;</code>
   * @return The displayId.
   */
  java.lang.String getDisplayId();
  /**
   * <code>string displayId = 38;</code>
   * @return The bytes for displayId.
   */
  com.google.protobuf.ByteString
      getDisplayIdBytes();

  /**
   * <code>bool withCommercePermission = 39;</code>
   * @return The withCommercePermission.
   */
  boolean getWithCommercePermission();

  /**
   * <code>bool withFusionShopEntry = 40;</code>
   * @return The withFusionShopEntry.
   */
  boolean getWithFusionShopEntry();

  /**
   * <code>int64 totalRechargeDiamondCount = 41;</code>
   * @return The totalRechargeDiamondCount.
   */
  long getTotalRechargeDiamondCount();

  /**
   * <code>.User.AnchorLevel webcastAnchorLevel = 42;</code>
   * @return Whether the webcastAnchorLevel field is set.
   */
  boolean hasWebcastAnchorLevel();
  /**
   * <code>.User.AnchorLevel webcastAnchorLevel = 42;</code>
   * @return The webcastAnchorLevel.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AnchorLevel getWebcastAnchorLevel();
  /**
   * <code>.User.AnchorLevel webcastAnchorLevel = 42;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AnchorLevelOrBuilder getWebcastAnchorLevelOrBuilder();

  /**
   * <code>string verifiedContent = 43;</code>
   * @return The verifiedContent.
   */
  java.lang.String getVerifiedContent();
  /**
   * <code>string verifiedContent = 43;</code>
   * @return The bytes for verifiedContent.
   */
  com.google.protobuf.ByteString
      getVerifiedContentBytes();

  /**
   * <code>.User.AuthorStats authorStats = 44;</code>
   * @return Whether the authorStats field is set.
   */
  boolean hasAuthorStats();
  /**
   * <code>.User.AuthorStats authorStats = 44;</code>
   * @return The authorStats.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AuthorStats getAuthorStats();
  /**
   * <code>.User.AuthorStats authorStats = 44;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AuthorStatsOrBuilder getAuthorStatsOrBuilder();

  /**
   * <code>repeated .User topFansList = 45;</code>
   */
  java.util.List<cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User> 
      getTopFansListList();
  /**
   * <code>repeated .User topFansList = 45;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User getTopFansList(int index);
  /**
   * <code>repeated .User topFansList = 45;</code>
   */
  int getTopFansListCount();
  /**
   * <code>repeated .User topFansList = 45;</code>
   */
  java.util.List<? extends cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOrBuilder> 
      getTopFansListOrBuilderList();
  /**
   * <code>repeated .User topFansList = 45;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserOrBuilder getTopFansListOrBuilder(
      int index);

  /**
   * <code>string secUid = 46;</code>
   * @return The secUid.
   */
  java.lang.String getSecUid();
  /**
   * <code>string secUid = 46;</code>
   * @return The bytes for secUid.
   */
  com.google.protobuf.ByteString
      getSecUidBytes();

  /**
   * <code>int32 userRole = 47;</code>
   * @return The userRole.
   */
  int getUserRole();

  /**
   * <code>.User.XiguaParams xiguaInfo = 48;</code>
   * @return Whether the xiguaInfo field is set.
   */
  boolean hasXiguaInfo();
  /**
   * <code>.User.XiguaParams xiguaInfo = 48;</code>
   * @return The xiguaInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.XiguaParams getXiguaInfo();
  /**
   * <code>.User.XiguaParams xiguaInfo = 48;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.XiguaParamsOrBuilder getXiguaInfoOrBuilder();

  /**
   * <code>.User.ActivityInfo activityReward = 49;</code>
   * @return Whether the activityReward field is set.
   */
  boolean hasActivityReward();
  /**
   * <code>.User.ActivityInfo activityReward = 49;</code>
   * @return The activityReward.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.ActivityInfo getActivityReward();
  /**
   * <code>.User.ActivityInfo activityReward = 49;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.ActivityInfoOrBuilder getActivityRewardOrBuilder();

  /**
   * <code>.User.NobleLevelInfo nobleInfo = 50;</code>
   * @return Whether the nobleInfo field is set.
   */
  boolean hasNobleInfo();
  /**
   * <code>.User.NobleLevelInfo nobleInfo = 50;</code>
   * @return The nobleInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.NobleLevelInfo getNobleInfo();
  /**
   * <code>.User.NobleLevelInfo nobleInfo = 50;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.NobleLevelInfoOrBuilder getNobleInfoOrBuilder();

  /**
   * <code>.User.BrotherhoodInfo brotherhoodInfo = 51;</code>
   * @return Whether the brotherhoodInfo field is set.
   */
  boolean hasBrotherhoodInfo();
  /**
   * <code>.User.BrotherhoodInfo brotherhoodInfo = 51;</code>
   * @return The brotherhoodInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.BrotherhoodInfo getBrotherhoodInfo();
  /**
   * <code>.User.BrotherhoodInfo brotherhoodInfo = 51;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.BrotherhoodInfoOrBuilder getBrotherhoodInfoOrBuilder();

  /**
   * <code>.Image personalCard = 52;</code>
   * @return Whether the personalCard field is set.
   */
  boolean hasPersonalCard();
  /**
   * <code>.Image personalCard = 52;</code>
   * @return The personalCard.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getPersonalCard();
  /**
   * <code>.Image personalCard = 52;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getPersonalCardOrBuilder();

  /**
   * <code>.User.AuthenticationInfo authenticationInfo = 53;</code>
   * @return Whether the authenticationInfo field is set.
   */
  boolean hasAuthenticationInfo();
  /**
   * <code>.User.AuthenticationInfo authenticationInfo = 53;</code>
   * @return The authenticationInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AuthenticationInfo getAuthenticationInfo();
  /**
   * <code>.User.AuthenticationInfo authenticationInfo = 53;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AuthenticationInfoOrBuilder getAuthenticationInfoOrBuilder();

  /**
   * <code>int32 authorizationInfo = 54;</code>
   * @return The authorizationInfo.
   */
  int getAuthorizationInfo();

  /**
   * <code>int32 adversaryAuthorizationInfo = 55;</code>
   * @return The adversaryAuthorizationInfo.
   */
  int getAdversaryAuthorizationInfo();

  /**
   * <code>.User.PoiInfo poiInfo = 56;</code>
   * @return Whether the poiInfo field is set.
   */
  boolean hasPoiInfo();
  /**
   * <code>.User.PoiInfo poiInfo = 56;</code>
   * @return The poiInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.PoiInfo getPoiInfo();
  /**
   * <code>.User.PoiInfo poiInfo = 56;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.PoiInfoOrBuilder getPoiInfoOrBuilder();

  /**
   * <code>.Image mediaBadgeImageListList = 57;</code>
   * @return Whether the mediaBadgeImageListList field is set.
   */
  boolean hasMediaBadgeImageListList();
  /**
   * <code>.Image mediaBadgeImageListList = 57;</code>
   * @return The mediaBadgeImageListList.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getMediaBadgeImageListList();
  /**
   * <code>.Image mediaBadgeImageListList = 57;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getMediaBadgeImageListListOrBuilder();

  /**
   * <code>int32 adversaryUserStatus = 58;</code>
   * @return The adversaryUserStatus.
   */
  int getAdversaryUserStatus();

  /**
   * <code>.UserVIPInfo userVipInfo = 59;</code>
   * @return Whether the userVipInfo field is set.
   */
  boolean hasUserVipInfo();
  /**
   * <code>.UserVIPInfo userVipInfo = 59;</code>
   * @return The userVipInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserVIPInfo getUserVipInfo();
  /**
   * <code>.UserVIPInfo userVipInfo = 59;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.UserVIPInfoOrBuilder getUserVipInfoOrBuilder();

  /**
   * <code>repeated int64 commerceWebcastConfigIdsList = 60;</code>
   * @return A list containing the commerceWebcastConfigIdsList.
   */
  java.util.List<java.lang.Long> getCommerceWebcastConfigIdsListList();
  /**
   * <code>repeated int64 commerceWebcastConfigIdsList = 60;</code>
   * @return The count of commerceWebcastConfigIdsList.
   */
  int getCommerceWebcastConfigIdsListCount();
  /**
   * <code>repeated int64 commerceWebcastConfigIdsList = 60;</code>
   * @param index The index of the element to return.
   * @return The commerceWebcastConfigIdsList at the given index.
   */
  long getCommerceWebcastConfigIdsList(int index);

  /**
   * <code>.Image badgeImageListV2List = 61;</code>
   * @return Whether the badgeImageListV2List field is set.
   */
  boolean hasBadgeImageListV2List();
  /**
   * <code>.Image badgeImageListV2List = 61;</code>
   * @return The badgeImageListV2List.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getBadgeImageListV2List();
  /**
   * <code>.Image badgeImageListV2List = 61;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getBadgeImageListV2ListOrBuilder();

  /**
   * <code>.IndustryCertification industryCertification = 62;</code>
   * @return Whether the industryCertification field is set.
   */
  boolean hasIndustryCertification();
  /**
   * <code>.IndustryCertification industryCertification = 62;</code>
   * @return The industryCertification.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.IndustryCertification getIndustryCertification();
  /**
   * <code>.IndustryCertification industryCertification = 62;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.IndustryCertificationOrBuilder getIndustryCertificationOrBuilder();

  /**
   * <code>string locationCity = 63;</code>
   * @return The locationCity.
   */
  java.lang.String getLocationCity();
  /**
   * <code>string locationCity = 63;</code>
   * @return The bytes for locationCity.
   */
  com.google.protobuf.ByteString
      getLocationCityBytes();

  /**
   * <code>.User.FansGroupInfo fansGroupInfo = 64;</code>
   * @return Whether the fansGroupInfo field is set.
   */
  boolean hasFansGroupInfo();
  /**
   * <code>.User.FansGroupInfo fansGroupInfo = 64;</code>
   * @return The fansGroupInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.FansGroupInfo getFansGroupInfo();
  /**
   * <code>.User.FansGroupInfo fansGroupInfo = 64;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.FansGroupInfoOrBuilder getFansGroupInfoOrBuilder();

  /**
   * <code>string remarkName = 65;</code>
   * @return The remarkName.
   */
  java.lang.String getRemarkName();
  /**
   * <code>string remarkName = 65;</code>
   * @return The bytes for remarkName.
   */
  com.google.protobuf.ByteString
      getRemarkNameBytes();

  /**
   * <code>int32 mysteryMan = 66;</code>
   * @return The mysteryMan.
   */
  int getMysteryMan();

  /**
   * <code>string webRid = 67;</code>
   * @return The webRid.
   */
  java.lang.String getWebRid();
  /**
   * <code>string webRid = 67;</code>
   * @return The bytes for webRid.
   */
  com.google.protobuf.ByteString
      getWebRidBytes();

  /**
   * <code>string desensitizedNickname = 68;</code>
   * @return The desensitizedNickname.
   */
  java.lang.String getDesensitizedNickname();
  /**
   * <code>string desensitizedNickname = 68;</code>
   * @return The bytes for desensitizedNickname.
   */
  com.google.protobuf.ByteString
      getDesensitizedNicknameBytes();

  /**
   * <code>.User.JAccreditInfo jAccreditInfo = 69;</code>
   * @return Whether the jAccreditInfo field is set.
   */
  boolean hasJAccreditInfo();
  /**
   * <code>.User.JAccreditInfo jAccreditInfo = 69;</code>
   * @return The jAccreditInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.JAccreditInfo getJAccreditInfo();
  /**
   * <code>.User.JAccreditInfo jAccreditInfo = 69;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.JAccreditInfoOrBuilder getJAccreditInfoOrBuilder();

  /**
   * <code>.User.Subscribe subscribe = 70;</code>
   * @return Whether the subscribe field is set.
   */
  boolean hasSubscribe();
  /**
   * <code>.User.Subscribe subscribe = 70;</code>
   * @return The subscribe.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.Subscribe getSubscribe();
  /**
   * <code>.User.Subscribe subscribe = 70;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.SubscribeOrBuilder getSubscribeOrBuilder();

  /**
   * <code>bool isAnonymous = 71;</code>
   * @return The isAnonymous.
   */
  boolean getIsAnonymous();

  /**
   * <code>int32 consumeDiamondLevel = 72;</code>
   * @return The consumeDiamondLevel.
   */
  int getConsumeDiamondLevel();

  /**
   * <code>string webcastUid = 73;</code>
   * @return The webcastUid.
   */
  java.lang.String getWebcastUid();
  /**
   * <code>string webcastUid = 73;</code>
   * @return The bytes for webcastUid.
   */
  com.google.protobuf.ByteString
      getWebcastUidBytes();

  /**
   * <code>.User.ProfileStyleParams profileStyleParams = 74;</code>
   * @return Whether the profileStyleParams field is set.
   */
  boolean hasProfileStyleParams();
  /**
   * <code>.User.ProfileStyleParams profileStyleParams = 74;</code>
   * @return The profileStyleParams.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.ProfileStyleParams getProfileStyleParams();
  /**
   * <code>.User.ProfileStyleParams profileStyleParams = 74;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.ProfileStyleParamsOrBuilder getProfileStyleParamsOrBuilder();

  /**
   * <code>.User.UserDressInfo userDressInfo = 75;</code>
   * @return Whether the userDressInfo field is set.
   */
  boolean hasUserDressInfo();
  /**
   * <code>.User.UserDressInfo userDressInfo = 75;</code>
   * @return The userDressInfo.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.UserDressInfo getUserDressInfo();
  /**
   * <code>.User.UserDressInfo userDressInfo = 75;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.UserDressInfoOrBuilder getUserDressInfoOrBuilder();

  /**
   * <code>bool allowBeLocated = 1001;</code>
   * @return The allowBeLocated.
   */
  boolean getAllowBeLocated();

  /**
   * <code>bool allowFindByContacts = 1002;</code>
   * @return The allowFindByContacts.
   */
  boolean getAllowFindByContacts();

  /**
   * <code>bool allowOthersDownloadVideo = 1003;</code>
   * @return The allowOthersDownloadVideo.
   */
  boolean getAllowOthersDownloadVideo();

  /**
   * <code>bool allowOthersDownloadWhenSharingVideo = 1004;</code>
   * @return The allowOthersDownloadWhenSharingVideo.
   */
  boolean getAllowOthersDownloadWhenSharingVideo();

  /**
   * <code>bool allowShareShowProfile = 1005;</code>
   * @return The allowShareShowProfile.
   */
  boolean getAllowShareShowProfile();

  /**
   * <code>bool allowShowInGossip = 1006;</code>
   * @return The allowShowInGossip.
   */
  boolean getAllowShowInGossip();

  /**
   * <code>bool allowShowMyAction = 1007;</code>
   * @return The allowShowMyAction.
   */
  boolean getAllowShowMyAction();

  /**
   * <code>bool allowStrangeComment = 1008;</code>
   * @return The allowStrangeComment.
   */
  boolean getAllowStrangeComment();

  /**
   * <code>bool allowUnfollowerComment = 1009;</code>
   * @return The allowUnfollowerComment.
   */
  boolean getAllowUnfollowerComment();

  /**
   * <code>bool allowUseLinkmic = 1010;</code>
   * @return The allowUseLinkmic.
   */
  boolean getAllowUseLinkmic();

  /**
   * <code>.User.AnchorLevel anchorLevel = 1011;</code>
   * @return Whether the anchorLevel field is set.
   */
  boolean hasAnchorLevel();
  /**
   * <code>.User.AnchorLevel anchorLevel = 1011;</code>
   * @return The anchorLevel.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AnchorLevel getAnchorLevel();
  /**
   * <code>.User.AnchorLevel anchorLevel = 1011;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.AnchorLevelOrBuilder getAnchorLevelOrBuilder();

  /**
   * <code>.Image avatarJpg = 1012;</code>
   * @return Whether the avatarJpg field is set.
   */
  boolean hasAvatarJpg();
  /**
   * <code>.Image avatarJpg = 1012;</code>
   * @return The avatarJpg.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.Image getAvatarJpg();
  /**
   * <code>.Image avatarJpg = 1012;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.ImageOrBuilder getAvatarJpgOrBuilder();

  /**
   * <code>string bgImgUrl = 1013;</code>
   * @return The bgImgUrl.
   */
  java.lang.String getBgImgUrl();
  /**
   * <code>string bgImgUrl = 1013;</code>
   * @return The bytes for bgImgUrl.
   */
  com.google.protobuf.ByteString
      getBgImgUrlBytes();

  /**
   * <code>string birthdayDescription = 1014;</code>
   * @return The birthdayDescription.
   */
  java.lang.String getBirthdayDescription();
  /**
   * <code>string birthdayDescription = 1014;</code>
   * @return The bytes for birthdayDescription.
   */
  com.google.protobuf.ByteString
      getBirthdayDescriptionBytes();

  /**
   * <code>bool birthdayValid = 1015;</code>
   * @return The birthdayValid.
   */
  boolean getBirthdayValid();

  /**
   * <code>int32 blockStatus = 1016;</code>
   * @return The blockStatus.
   */
  int getBlockStatus();

  /**
   * <code>int32 commentRestrict = 1017;</code>
   * @return The commentRestrict.
   */
  int getCommentRestrict();

  /**
   * <code>string constellation = 1018;</code>
   * @return The constellation.
   */
  java.lang.String getConstellation();
  /**
   * <code>string constellation = 1018;</code>
   * @return The bytes for constellation.
   */
  com.google.protobuf.ByteString
      getConstellationBytes();

  /**
   * <code>int32 disableIchat = 1019;</code>
   * @return The disableIchat.
   */
  int getDisableIchat();

  /**
   * <code>int64 enableIchatImg = 1020;</code>
   * @return The enableIchatImg.
   */
  long getEnableIchatImg();

  /**
   * <code>int32 exp = 1021;</code>
   * @return The exp.
   */
  int getExp();

  /**
   * <code>int64 fanTicketCount = 1022;</code>
   * @return The fanTicketCount.
   */
  long getFanTicketCount();

  /**
   * <code>bool foldStrangerChat = 1023;</code>
   * @return The foldStrangerChat.
   */
  boolean getFoldStrangerChat();

  /**
   * <code>int64 followStatus = 1024;</code>
   * @return The followStatus.
   */
  long getFollowStatus();

  /**
   * <code>bool hotsoonVerified = 1025;</code>
   * @return The hotsoonVerified.
   */
  boolean getHotsoonVerified();

  /**
   * <code>string hotsoonVerifiedReason = 1026;</code>
   * @return The hotsoonVerifiedReason.
   */
  java.lang.String getHotsoonVerifiedReason();
  /**
   * <code>string hotsoonVerifiedReason = 1026;</code>
   * @return The bytes for hotsoonVerifiedReason.
   */
  com.google.protobuf.ByteString
      getHotsoonVerifiedReasonBytes();

  /**
   * <code>int32 ichatRestrictType = 1027;</code>
   * @return The ichatRestrictType.
   */
  int getIchatRestrictType();

  /**
   * <code>string idStr = 1028;</code>
   * @return The idStr.
   */
  java.lang.String getIdStr();
  /**
   * <code>string idStr = 1028;</code>
   * @return The bytes for idStr.
   */
  com.google.protobuf.ByteString
      getIdStrBytes();

  /**
   * <code>bool isFollower = 1029;</code>
   * @return The isFollower.
   */
  boolean getIsFollower();

  /**
   * <code>bool isFollowing = 1030;</code>
   * @return The isFollowing.
   */
  boolean getIsFollowing();

  /**
   * <code>bool needProfileGuide = 1031;</code>
   * @return The needProfileGuide.
   */
  boolean getNeedProfileGuide();

  /**
   * <code>int64 payScores = 1032;</code>
   * @return The payScores.
   */
  long getPayScores();

  /**
   * <code>bool pushCommentStatus = 1033;</code>
   * @return The pushCommentStatus.
   */
  boolean getPushCommentStatus();

  /**
   * <code>bool pushDigg = 1034;</code>
   * @return The pushDigg.
   */
  boolean getPushDigg();

  /**
   * <code>bool pushFollow = 1035;</code>
   * @return The pushFollow.
   */
  boolean getPushFollow();

  /**
   * <code>bool pushFriendAction = 1036;</code>
   * @return The pushFriendAction.
   */
  boolean getPushFriendAction();

  /**
   * <code>bool pushIchat = 1037;</code>
   * @return The pushIchat.
   */
  boolean getPushIchat();

  /**
   * <code>bool pushStatus = 1038;</code>
   * @return The pushStatus.
   */
  boolean getPushStatus();

  /**
   * <code>bool pushVideoPost = 1039;</code>
   * @return The pushVideoPost.
   */
  boolean getPushVideoPost();

  /**
   * <code>bool pushVideoRecommend = 1040;</code>
   * @return The pushVideoRecommend.
   */
  boolean getPushVideoRecommend();

  /**
   * <code>.User.UserStats stats = 1041;</code>
   * @return Whether the stats field is set.
   */
  boolean hasStats();
  /**
   * <code>.User.UserStats stats = 1041;</code>
   * @return The stats.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.UserStats getStats();
  /**
   * <code>.User.UserStats stats = 1041;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User.UserStatsOrBuilder getStatsOrBuilder();

  /**
   * <code>bool verifiedMobile = 1042;</code>
   * @return The verifiedMobile.
   */
  boolean getVerifiedMobile();

  /**
   * <code>string verifiedReason = 1043;</code>
   * @return The verifiedReason.
   */
  java.lang.String getVerifiedReason();
  /**
   * <code>string verifiedReason = 1043;</code>
   * @return The bytes for verifiedReason.
   */
  com.google.protobuf.ByteString
      getVerifiedReasonBytes();

  /**
   * <code>bool withCarManagementPermission = 1044;</code>
   * @return The withCarManagementPermission.
   */
  boolean getWithCarManagementPermission();

  /**
   * <code>int32 ageRange = 1045;</code>
   * @return The ageRange.
   */
  int getAgeRange();

  /**
   * <code>int64 watchDurationMonth = 1046;</code>
   * @return The watchDurationMonth.
   */
  long getWatchDurationMonth();
}
