package cool.scx.live_room_watcher.douyin_hack;

import cool.scx.live_room_watcher.User;
import cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.MemberMessage;


/**
 * 直播间用户
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackUser implements User {

    private final MemberMessage memberMessage;
    private final cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.data.User user;

    /**
     * <p>Constructor for DouYinUser.</p>
     *
     * @param memberMessage a {@link cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.MemberMessage} object
     */
    public DouYinHackUser(MemberMessage memberMessage) {
        this.memberMessage = memberMessage;
        this.user = memberMessage.getUser();
    }

    /**
     * <p>Constructor for DouYinUser.</p>
     *
     * @param user a {@link cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.data.User} object
     */
    public DouYinHackUser(cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.data.User user) {
        this.memberMessage = null;
        this.user = user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String nickName() {
        return user.getNickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String avatar() {
        return user.getAvatarThumb().getUrlListList(0);
    }

    /**
     * <p>_memberMessage.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.MemberMessage} object
     */
    public MemberMessage _memberMessage() {
        return memberMessage;
    }

    /**
     * <p>_user.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.data.User} object
     */
    public cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.data.User _user() {
        return user;
    }

}
