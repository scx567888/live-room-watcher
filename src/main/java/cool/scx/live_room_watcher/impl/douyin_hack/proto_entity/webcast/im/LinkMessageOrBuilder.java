// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_hack/webcast/im/LinkMessage.proto

// Protobuf Java Version: 4.26.1
package cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im;

public interface LinkMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:LinkMessage)
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
   * <code>int64 messageType = 2;</code>
   * @return The messageType.
   */
  long getMessageType();

  /**
   * <code>int64 linkerId = 3;</code>
   * @return The linkerId.
   */
  long getLinkerId();

  /**
   * <code>int64 scene = 4;</code>
   * @return The scene.
   */
  long getScene();

  /**
   * <code>.LinkerInviteContent inviteContent = 5;</code>
   * @return Whether the inviteContent field is set.
   */
  boolean hasInviteContent();
  /**
   * <code>.LinkerInviteContent inviteContent = 5;</code>
   * @return The inviteContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerInviteContent getInviteContent();
  /**
   * <code>.LinkerInviteContent inviteContent = 5;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerInviteContentOrBuilder getInviteContentOrBuilder();

  /**
   * <code>.LinkerReplyContent replyContent = 6;</code>
   * @return Whether the replyContent field is set.
   */
  boolean hasReplyContent();
  /**
   * <code>.LinkerReplyContent replyContent = 6;</code>
   * @return The replyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerReplyContent getReplyContent();
  /**
   * <code>.LinkerReplyContent replyContent = 6;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerReplyContentOrBuilder getReplyContentOrBuilder();

  /**
   * <code>.LinkerCreateContent createContent = 7;</code>
   * @return Whether the createContent field is set.
   */
  boolean hasCreateContent();
  /**
   * <code>.LinkerCreateContent createContent = 7;</code>
   * @return The createContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCreateContent getCreateContent();
  /**
   * <code>.LinkerCreateContent createContent = 7;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCreateContentOrBuilder getCreateContentOrBuilder();

  /**
   * <code>.LinkerCloseContent closeContent = 8;</code>
   * @return Whether the closeContent field is set.
   */
  boolean hasCloseContent();
  /**
   * <code>.LinkerCloseContent closeContent = 8;</code>
   * @return The closeContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCloseContent getCloseContent();
  /**
   * <code>.LinkerCloseContent closeContent = 8;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCloseContentOrBuilder getCloseContentOrBuilder();

  /**
   * <code>.LinkerEnterContent enterContent = 9;</code>
   * @return Whether the enterContent field is set.
   */
  boolean hasEnterContent();
  /**
   * <code>.LinkerEnterContent enterContent = 9;</code>
   * @return The enterContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnterContent getEnterContent();
  /**
   * <code>.LinkerEnterContent enterContent = 9;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnterContentOrBuilder getEnterContentOrBuilder();

  /**
   * <code>.LinkerLeaveContent leaveContent = 10;</code>
   * @return Whether the leaveContent field is set.
   */
  boolean hasLeaveContent();
  /**
   * <code>.LinkerLeaveContent leaveContent = 10;</code>
   * @return The leaveContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLeaveContent getLeaveContent();
  /**
   * <code>.LinkerLeaveContent leaveContent = 10;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLeaveContentOrBuilder getLeaveContentOrBuilder();

  /**
   * <code>.LinkerCancelContent cancelContent = 11;</code>
   * @return Whether the cancelContent field is set.
   */
  boolean hasCancelContent();
  /**
   * <code>.LinkerCancelContent cancelContent = 11;</code>
   * @return The cancelContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCancelContent getCancelContent();
  /**
   * <code>.LinkerCancelContent cancelContent = 11;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCancelContentOrBuilder getCancelContentOrBuilder();

  /**
   * <code>.LinkerKickOutContent kickOutContent = 12;</code>
   * @return Whether the kickOutContent field is set.
   */
  boolean hasKickOutContent();
  /**
   * <code>.LinkerKickOutContent kickOutContent = 12;</code>
   * @return The kickOutContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerKickOutContent getKickOutContent();
  /**
   * <code>.LinkerKickOutContent kickOutContent = 12;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerKickOutContentOrBuilder getKickOutContentOrBuilder();

  /**
   * <code>.LinkerLinkedListChangeContent linkedListChangeContent = 13;</code>
   * @return Whether the linkedListChangeContent field is set.
   */
  boolean hasLinkedListChangeContent();
  /**
   * <code>.LinkerLinkedListChangeContent linkedListChangeContent = 13;</code>
   * @return The linkedListChangeContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLinkedListChangeContent getLinkedListChangeContent();
  /**
   * <code>.LinkerLinkedListChangeContent linkedListChangeContent = 13;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLinkedListChangeContentOrBuilder getLinkedListChangeContentOrBuilder();

  /**
   * <code>.LinkerUpdateUserContent updateUserContent = 14;</code>
   * @return Whether the updateUserContent field is set.
   */
  boolean hasUpdateUserContent();
  /**
   * <code>.LinkerUpdateUserContent updateUserContent = 14;</code>
   * @return The updateUserContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerUpdateUserContent getUpdateUserContent();
  /**
   * <code>.LinkerUpdateUserContent updateUserContent = 14;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerUpdateUserContentOrBuilder getUpdateUserContentOrBuilder();

  /**
   * <code>.LinkerWaitingListChangeContent waitingListChangeContent = 15;</code>
   * @return Whether the waitingListChangeContent field is set.
   */
  boolean hasWaitingListChangeContent();
  /**
   * <code>.LinkerWaitingListChangeContent waitingListChangeContent = 15;</code>
   * @return The waitingListChangeContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerWaitingListChangeContent getWaitingListChangeContent();
  /**
   * <code>.LinkerWaitingListChangeContent waitingListChangeContent = 15;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerWaitingListChangeContentOrBuilder getWaitingListChangeContentOrBuilder();

  /**
   * <code>.LinkerBanContent banContent = 16;</code>
   * @return Whether the banContent field is set.
   */
  boolean hasBanContent();
  /**
   * <code>.LinkerBanContent banContent = 16;</code>
   * @return The banContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerBanContent getBanContent();
  /**
   * <code>.LinkerBanContent banContent = 16;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerBanContentOrBuilder getBanContentOrBuilder();

  /**
   * <code>.LinkerItemContent itemContent = 17;</code>
   * @return Whether the itemContent field is set.
   */
  boolean hasItemContent();
  /**
   * <code>.LinkerItemContent itemContent = 17;</code>
   * @return The itemContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerItemContent getItemContent();
  /**
   * <code>.LinkerItemContent itemContent = 17;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerItemContentOrBuilder getItemContentOrBuilder();

  /**
   * <code>.LinkerViolationReminderContent violationReminderContent = 18;</code>
   * @return Whether the violationReminderContent field is set.
   */
  boolean hasViolationReminderContent();
  /**
   * <code>.LinkerViolationReminderContent violationReminderContent = 18;</code>
   * @return The violationReminderContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerViolationReminderContent getViolationReminderContent();
  /**
   * <code>.LinkerViolationReminderContent violationReminderContent = 18;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerViolationReminderContentOrBuilder getViolationReminderContentOrBuilder();

  /**
   * <code>.LinkerUpdateLinkTypeApplyContent updateLinkTypeApplyContent = 19;</code>
   * @return Whether the updateLinkTypeApplyContent field is set.
   */
  boolean hasUpdateLinkTypeApplyContent();
  /**
   * <code>.LinkerUpdateLinkTypeApplyContent updateLinkTypeApplyContent = 19;</code>
   * @return The updateLinkTypeApplyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerUpdateLinkTypeApplyContent getUpdateLinkTypeApplyContent();
  /**
   * <code>.LinkerUpdateLinkTypeApplyContent updateLinkTypeApplyContent = 19;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerUpdateLinkTypeApplyContentOrBuilder getUpdateLinkTypeApplyContentOrBuilder();

  /**
   * <code>.LinkerUpdateLinkTypeReplyContent updateLinkTypeReplyContent = 20;</code>
   * @return Whether the updateLinkTypeReplyContent field is set.
   */
  boolean hasUpdateLinkTypeReplyContent();
  /**
   * <code>.LinkerUpdateLinkTypeReplyContent updateLinkTypeReplyContent = 20;</code>
   * @return The updateLinkTypeReplyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerUpdateLinkTypeReplyContent getUpdateLinkTypeReplyContent();
  /**
   * <code>.LinkerUpdateLinkTypeReplyContent updateLinkTypeReplyContent = 20;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerUpdateLinkTypeReplyContentOrBuilder getUpdateLinkTypeReplyContentOrBuilder();

  /**
   * <code>.LinkerAvatarAuditContent avatarAuditContent = 21;</code>
   * @return Whether the avatarAuditContent field is set.
   */
  boolean hasAvatarAuditContent();
  /**
   * <code>.LinkerAvatarAuditContent avatarAuditContent = 21;</code>
   * @return The avatarAuditContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerAvatarAuditContent getAvatarAuditContent();
  /**
   * <code>.LinkerAvatarAuditContent avatarAuditContent = 21;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerAvatarAuditContentOrBuilder getAvatarAuditContentOrBuilder();

  /**
   * <code>.LinkerApplyExpiredContent applyExpiredContent = 22;</code>
   * @return Whether the applyExpiredContent field is set.
   */
  boolean hasApplyExpiredContent();
  /**
   * <code>.LinkerApplyExpiredContent applyExpiredContent = 22;</code>
   * @return The applyExpiredContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerApplyExpiredContent getApplyExpiredContent();
  /**
   * <code>.LinkerApplyExpiredContent applyExpiredContent = 22;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerApplyExpiredContentOrBuilder getApplyExpiredContentOrBuilder();

  /**
   * <code>.LinkerApplyStrongReminderContent applyStrongReminderContent = 23;</code>
   * @return Whether the applyStrongReminderContent field is set.
   */
  boolean hasApplyStrongReminderContent();
  /**
   * <code>.LinkerApplyStrongReminderContent applyStrongReminderContent = 23;</code>
   * @return The applyStrongReminderContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerApplyStrongReminderContent getApplyStrongReminderContent();
  /**
   * <code>.LinkerApplyStrongReminderContent applyStrongReminderContent = 23;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerApplyStrongReminderContentOrBuilder getApplyStrongReminderContentOrBuilder();

  /**
   * <code>.LinkerAnchorStreamSwitchContent anchorStreamSwitchContent = 24;</code>
   * @return Whether the anchorStreamSwitchContent field is set.
   */
  boolean hasAnchorStreamSwitchContent();
  /**
   * <code>.LinkerAnchorStreamSwitchContent anchorStreamSwitchContent = 24;</code>
   * @return The anchorStreamSwitchContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerAnchorStreamSwitchContent getAnchorStreamSwitchContent();
  /**
   * <code>.LinkerAnchorStreamSwitchContent anchorStreamSwitchContent = 24;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerAnchorStreamSwitchContentOrBuilder getAnchorStreamSwitchContentOrBuilder();

  /**
   * <code>.LinkerClickScreenContent clickScreenContent = 25;</code>
   * @return Whether the clickScreenContent field is set.
   */
  boolean hasClickScreenContent();
  /**
   * <code>.LinkerClickScreenContent clickScreenContent = 25;</code>
   * @return The clickScreenContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerClickScreenContent getClickScreenContent();
  /**
   * <code>.LinkerClickScreenContent clickScreenContent = 25;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerClickScreenContentOrBuilder getClickScreenContentOrBuilder();

  /**
   * <code>.LinkerLockPositionContent lockPositionContent = 26;</code>
   * @return Whether the lockPositionContent field is set.
   */
  boolean hasLockPositionContent();
  /**
   * <code>.LinkerLockPositionContent lockPositionContent = 26;</code>
   * @return The lockPositionContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLockPositionContent getLockPositionContent();
  /**
   * <code>.LinkerLockPositionContent lockPositionContent = 26;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLockPositionContentOrBuilder getLockPositionContentOrBuilder();

  /**
   * <code>.LinkerFollowStrongGuideContent followStrongGuideContent = 27;</code>
   * @return Whether the followStrongGuideContent field is set.
   */
  boolean hasFollowStrongGuideContent();
  /**
   * <code>.LinkerFollowStrongGuideContent followStrongGuideContent = 27;</code>
   * @return The followStrongGuideContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerFollowStrongGuideContent getFollowStrongGuideContent();
  /**
   * <code>.LinkerFollowStrongGuideContent followStrongGuideContent = 27;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerFollowStrongGuideContentOrBuilder getFollowStrongGuideContentOrBuilder();

  /**
   * <code>.LinkerShareVideoImContent shareVideoImContent = 28;</code>
   * @return Whether the shareVideoImContent field is set.
   */
  boolean hasShareVideoImContent();
  /**
   * <code>.LinkerShareVideoImContent shareVideoImContent = 28;</code>
   * @return The shareVideoImContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerShareVideoImContent getShareVideoImContent();
  /**
   * <code>.LinkerShareVideoImContent shareVideoImContent = 28;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerShareVideoImContentOrBuilder getShareVideoImContentOrBuilder();

  /**
   * <code>.LinkerGuestInviteContent guestInviteContent = 29;</code>
   * @return Whether the guestInviteContent field is set.
   */
  boolean hasGuestInviteContent();
  /**
   * <code>.LinkerGuestInviteContent guestInviteContent = 29;</code>
   * @return The guestInviteContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerGuestInviteContent getGuestInviteContent();
  /**
   * <code>.LinkerGuestInviteContent guestInviteContent = 29;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerGuestInviteContentOrBuilder getGuestInviteContentOrBuilder();

  /**
   * <code>.LinkerGuestExitCastScreenContent exitCastScreenContent = 30;</code>
   * @return Whether the exitCastScreenContent field is set.
   */
  boolean hasExitCastScreenContent();
  /**
   * <code>.LinkerGuestExitCastScreenContent exitCastScreenContent = 30;</code>
   * @return The exitCastScreenContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerGuestExitCastScreenContent getExitCastScreenContent();
  /**
   * <code>.LinkerGuestExitCastScreenContent exitCastScreenContent = 30;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerGuestExitCastScreenContentOrBuilder getExitCastScreenContentOrBuilder();

  /**
   * <code>.LinkerSwitchSceneContent switchSceneContent = 31;</code>
   * @return Whether the switchSceneContent field is set.
   */
  boolean hasSwitchSceneContent();
  /**
   * <code>.LinkerSwitchSceneContent switchSceneContent = 31;</code>
   * @return The switchSceneContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerSwitchSceneContent getSwitchSceneContent();
  /**
   * <code>.LinkerSwitchSceneContent switchSceneContent = 31;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerSwitchSceneContentOrBuilder getSwitchSceneContentOrBuilder();

  /**
   * <code>.LinkPhaseEnterNextNotifyContent linkPhaseEnterNextContent = 32;</code>
   * @return Whether the linkPhaseEnterNextContent field is set.
   */
  boolean hasLinkPhaseEnterNextContent();
  /**
   * <code>.LinkPhaseEnterNextNotifyContent linkPhaseEnterNextContent = 32;</code>
   * @return The linkPhaseEnterNextContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkPhaseEnterNextNotifyContent getLinkPhaseEnterNextContent();
  /**
   * <code>.LinkPhaseEnterNextNotifyContent linkPhaseEnterNextContent = 32;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkPhaseEnterNextNotifyContentOrBuilder getLinkPhaseEnterNextContentOrBuilder();

  /**
   * <code>.LinkerChangePlayModeContent changePlayModeContent = 33;</code>
   * @return Whether the changePlayModeContent field is set.
   */
  boolean hasChangePlayModeContent();
  /**
   * <code>.LinkerChangePlayModeContent changePlayModeContent = 33;</code>
   * @return The changePlayModeContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerChangePlayModeContent getChangePlayModeContent();
  /**
   * <code>.LinkerChangePlayModeContent changePlayModeContent = 33;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerChangePlayModeContentOrBuilder getChangePlayModeContentOrBuilder();

  /**
   * <code>.LinkerLowBalanceForPaidLinkmicContent lowBalanceForPaidLinkmicContent = 34;</code>
   * @return Whether the lowBalanceForPaidLinkmicContent field is set.
   */
  boolean hasLowBalanceForPaidLinkmicContent();
  /**
   * <code>.LinkerLowBalanceForPaidLinkmicContent lowBalanceForPaidLinkmicContent = 34;</code>
   * @return The lowBalanceForPaidLinkmicContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLowBalanceForPaidLinkmicContent getLowBalanceForPaidLinkmicContent();
  /**
   * <code>.LinkerLowBalanceForPaidLinkmicContent lowBalanceForPaidLinkmicContent = 34;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerLowBalanceForPaidLinkmicContentOrBuilder getLowBalanceForPaidLinkmicContentOrBuilder();

  /**
   * <code>.LinkerDegradeAlertContent degradeAlertContent = 35;</code>
   * @return Whether the degradeAlertContent field is set.
   */
  boolean hasDegradeAlertContent();
  /**
   * <code>.LinkerDegradeAlertContent degradeAlertContent = 35;</code>
   * @return The degradeAlertContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerDegradeAlertContent getDegradeAlertContent();
  /**
   * <code>.LinkerDegradeAlertContent degradeAlertContent = 35;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerDegradeAlertContentOrBuilder getDegradeAlertContentOrBuilder();

  /**
   * <code>.LinkerEnlargeGuestInviteContent enlargeGuestInviteContent = 36;</code>
   * @return Whether the enlargeGuestInviteContent field is set.
   */
  boolean hasEnlargeGuestInviteContent();
  /**
   * <code>.LinkerEnlargeGuestInviteContent enlargeGuestInviteContent = 36;</code>
   * @return The enlargeGuestInviteContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnlargeGuestInviteContent getEnlargeGuestInviteContent();
  /**
   * <code>.LinkerEnlargeGuestInviteContent enlargeGuestInviteContent = 36;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnlargeGuestInviteContentOrBuilder getEnlargeGuestInviteContentOrBuilder();

  /**
   * <code>.LinkerEnlargeGuestReplyContent enlargeGuestReplyContent = 37;</code>
   * @return Whether the enlargeGuestReplyContent field is set.
   */
  boolean hasEnlargeGuestReplyContent();
  /**
   * <code>.LinkerEnlargeGuestReplyContent enlargeGuestReplyContent = 37;</code>
   * @return The enlargeGuestReplyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnlargeGuestReplyContent getEnlargeGuestReplyContent();
  /**
   * <code>.LinkerEnlargeGuestReplyContent enlargeGuestReplyContent = 37;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnlargeGuestReplyContentOrBuilder getEnlargeGuestReplyContentOrBuilder();

  /**
   * <code>.LinkerEnlargeGuestApplyContent enlargeGuestApplyContent = 38;</code>
   * @return Whether the enlargeGuestApplyContent field is set.
   */
  boolean hasEnlargeGuestApplyContent();
  /**
   * <code>.LinkerEnlargeGuestApplyContent enlargeGuestApplyContent = 38;</code>
   * @return The enlargeGuestApplyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnlargeGuestApplyContent getEnlargeGuestApplyContent();
  /**
   * <code>.LinkerEnlargeGuestApplyContent enlargeGuestApplyContent = 38;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerEnlargeGuestApplyContentOrBuilder getEnlargeGuestApplyContentOrBuilder();

  /**
   * <code>.LinkPrepareApplyContent prepareApplyContent = 39;</code>
   * @return Whether the prepareApplyContent field is set.
   */
  boolean hasPrepareApplyContent();
  /**
   * <code>.LinkPrepareApplyContent prepareApplyContent = 39;</code>
   * @return The prepareApplyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkPrepareApplyContent getPrepareApplyContent();
  /**
   * <code>.LinkPrepareApplyContent prepareApplyContent = 39;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkPrepareApplyContentOrBuilder getPrepareApplyContentOrBuilder();

  /**
   * <code>.LinkerCrossRoomUpdateContent crossRoomUpdateContent = 40;</code>
   * @return Whether the crossRoomUpdateContent field is set.
   */
  boolean hasCrossRoomUpdateContent();
  /**
   * <code>.LinkerCrossRoomUpdateContent crossRoomUpdateContent = 40;</code>
   * @return The crossRoomUpdateContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCrossRoomUpdateContent getCrossRoomUpdateContent();
  /**
   * <code>.LinkerCrossRoomUpdateContent crossRoomUpdateContent = 40;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerCrossRoomUpdateContentOrBuilder getCrossRoomUpdateContentOrBuilder();

  /**
   * <code>.LinkerChangeMultiPKTeamInfoContent changeMultiPkTeamInfoContent = 41;</code>
   * @return Whether the changeMultiPkTeamInfoContent field is set.
   */
  boolean hasChangeMultiPkTeamInfoContent();
  /**
   * <code>.LinkerChangeMultiPKTeamInfoContent changeMultiPkTeamInfoContent = 41;</code>
   * @return The changeMultiPkTeamInfoContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerChangeMultiPKTeamInfoContent getChangeMultiPkTeamInfoContent();
  /**
   * <code>.LinkerChangeMultiPKTeamInfoContent changeMultiPkTeamInfoContent = 41;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerChangeMultiPKTeamInfoContentOrBuilder getChangeMultiPkTeamInfoContentOrBuilder();

  /**
   * <code>.CrossRoomLinkInviteContent crossRoomLinkInviteContent = 42;</code>
   * @return Whether the crossRoomLinkInviteContent field is set.
   */
  boolean hasCrossRoomLinkInviteContent();
  /**
   * <code>.CrossRoomLinkInviteContent crossRoomLinkInviteContent = 42;</code>
   * @return The crossRoomLinkInviteContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomLinkInviteContent getCrossRoomLinkInviteContent();
  /**
   * <code>.CrossRoomLinkInviteContent crossRoomLinkInviteContent = 42;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomLinkInviteContentOrBuilder getCrossRoomLinkInviteContentOrBuilder();

  /**
   * <code>.CrossRoomLinkReplyContent crossRoomLinkReplyContent = 43;</code>
   * @return Whether the crossRoomLinkReplyContent field is set.
   */
  boolean hasCrossRoomLinkReplyContent();
  /**
   * <code>.CrossRoomLinkReplyContent crossRoomLinkReplyContent = 43;</code>
   * @return The crossRoomLinkReplyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomLinkReplyContent getCrossRoomLinkReplyContent();
  /**
   * <code>.CrossRoomLinkReplyContent crossRoomLinkReplyContent = 43;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomLinkReplyContentOrBuilder getCrossRoomLinkReplyContentOrBuilder();

  /**
   * <code>.CrossRoomLinkCancelInviteContent crossRoomLinkCancelInviteContent = 44;</code>
   * @return Whether the crossRoomLinkCancelInviteContent field is set.
   */
  boolean hasCrossRoomLinkCancelInviteContent();
  /**
   * <code>.CrossRoomLinkCancelInviteContent crossRoomLinkCancelInviteContent = 44;</code>
   * @return The crossRoomLinkCancelInviteContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomLinkCancelInviteContent getCrossRoomLinkCancelInviteContent();
  /**
   * <code>.CrossRoomLinkCancelInviteContent crossRoomLinkCancelInviteContent = 44;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomLinkCancelInviteContentOrBuilder getCrossRoomLinkCancelInviteContentOrBuilder();

  /**
   * <code>.LinkerResumeAudienceContent linkerResumeAudienceContent = 45;</code>
   * @return Whether the linkerResumeAudienceContent field is set.
   */
  boolean hasLinkerResumeAudienceContent();
  /**
   * <code>.LinkerResumeAudienceContent linkerResumeAudienceContent = 45;</code>
   * @return The linkerResumeAudienceContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerResumeAudienceContent getLinkerResumeAudienceContent();
  /**
   * <code>.LinkerResumeAudienceContent linkerResumeAudienceContent = 45;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerResumeAudienceContentOrBuilder getLinkerResumeAudienceContentOrBuilder();

  /**
   * <code>.LinkerBattleConnectContent linkerBattleConnectContent = 46;</code>
   * @return Whether the linkerBattleConnectContent field is set.
   */
  boolean hasLinkerBattleConnectContent();
  /**
   * <code>.LinkerBattleConnectContent linkerBattleConnectContent = 46;</code>
   * @return The linkerBattleConnectContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerBattleConnectContent getLinkerBattleConnectContent();
  /**
   * <code>.LinkerBattleConnectContent linkerBattleConnectContent = 46;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerBattleConnectContentOrBuilder getLinkerBattleConnectContentOrBuilder();

  /**
   * <code>.LinkerResumeApplyContent linkerResumeApplyContent = 47;</code>
   * @return Whether the linkerResumeApplyContent field is set.
   */
  boolean hasLinkerResumeApplyContent();
  /**
   * <code>.LinkerResumeApplyContent linkerResumeApplyContent = 47;</code>
   * @return The linkerResumeApplyContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerResumeApplyContent getLinkerResumeApplyContent();
  /**
   * <code>.LinkerResumeApplyContent linkerResumeApplyContent = 47;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerResumeApplyContentOrBuilder getLinkerResumeApplyContentOrBuilder();

  /**
   * <code>.CrossRoomRTCInfoContent crossRoomRtcInfoContent = 48;</code>
   * @return Whether the crossRoomRtcInfoContent field is set.
   */
  boolean hasCrossRoomRtcInfoContent();
  /**
   * <code>.CrossRoomRTCInfoContent crossRoomRtcInfoContent = 48;</code>
   * @return The crossRoomRtcInfoContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomRTCInfoContent getCrossRoomRtcInfoContent();
  /**
   * <code>.CrossRoomRTCInfoContent crossRoomRtcInfoContent = 48;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.CrossRoomRTCInfoContentOrBuilder getCrossRoomRtcInfoContentOrBuilder();

  /**
   * <code>.AnchorUpdateLinkmicConfigContent anchorUpdateLinkmicConfigContent = 49;</code>
   * @return Whether the anchorUpdateLinkmicConfigContent field is set.
   */
  boolean hasAnchorUpdateLinkmicConfigContent();
  /**
   * <code>.AnchorUpdateLinkmicConfigContent anchorUpdateLinkmicConfigContent = 49;</code>
   * @return The anchorUpdateLinkmicConfigContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.AnchorUpdateLinkmicConfigContent getAnchorUpdateLinkmicConfigContent();
  /**
   * <code>.AnchorUpdateLinkmicConfigContent anchorUpdateLinkmicConfigContent = 49;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.AnchorUpdateLinkmicConfigContentOrBuilder getAnchorUpdateLinkmicConfigContentOrBuilder();

  /**
   * <code>.AnchorUpdateLayoutContent anchorUpdateLayoutContent = 50;</code>
   * @return Whether the anchorUpdateLayoutContent field is set.
   */
  boolean hasAnchorUpdateLayoutContent();
  /**
   * <code>.AnchorUpdateLayoutContent anchorUpdateLayoutContent = 50;</code>
   * @return The anchorUpdateLayoutContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.AnchorUpdateLayoutContent getAnchorUpdateLayoutContent();
  /**
   * <code>.AnchorUpdateLayoutContent anchorUpdateLayoutContent = 50;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.AnchorUpdateLayoutContentOrBuilder getAnchorUpdateLayoutContentOrBuilder();

  /**
   * <code>.LinkerApplyRankChangeContent applyRankChangeContent = 52;</code>
   * @return Whether the applyRankChangeContent field is set.
   */
  boolean hasApplyRankChangeContent();
  /**
   * <code>.LinkerApplyRankChangeContent applyRankChangeContent = 52;</code>
   * @return The applyRankChangeContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerApplyRankChangeContent getApplyRankChangeContent();
  /**
   * <code>.LinkerApplyRankChangeContent applyRankChangeContent = 52;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerApplyRankChangeContentOrBuilder getApplyRankChangeContentOrBuilder();

  /**
   * <code>.LinkerSysKickOutContent sysKickOutContent = 101;</code>
   * @return Whether the sysKickOutContent field is set.
   */
  boolean hasSysKickOutContent();
  /**
   * <code>.LinkerSysKickOutContent sysKickOutContent = 101;</code>
   * @return The sysKickOutContent.
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerSysKickOutContent getSysKickOutContent();
  /**
   * <code>.LinkerSysKickOutContent sysKickOutContent = 101;</code>
   */
  cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.LinkerSysKickOutContentOrBuilder getSysKickOutContentOrBuilder();

  /**
   * <code>int64 fallbackScene = 199;</code>
   * @return The fallbackScene.
   */
  long getFallbackScene();

  /**
   * <code>string extra = 200;</code>
   * @return The extra.
   */
  java.lang.String getExtra();
  /**
   * <code>string extra = 200;</code>
   * @return The bytes for extra.
   */
  com.google.protobuf.ByteString
      getExtraBytes();
}
