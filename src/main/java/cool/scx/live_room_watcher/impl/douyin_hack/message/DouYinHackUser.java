package cool.scx.live_room_watcher.impl.douyin_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.MemberMessage;
import cool.scx.live_room_watcher.message.User;


/**
 * 直播间用户
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackUser implements User {

    private final MemberMessage memberMessage;
    private final cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User user;

    public DouYinHackUser(MemberMessage memberMessage) {
        this.memberMessage = memberMessage;
        this.user = memberMessage.getUser();
    }


    public DouYinHackUser(cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User user) {
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

    @Override
    public String userID() {
        return null;
    }

    public MemberMessage _memberMessage() {
        return memberMessage;
    }

    public cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.data.User _user() {
        return user;
    }

    @Override
    public String roomID() {
        return null;
    }

}
