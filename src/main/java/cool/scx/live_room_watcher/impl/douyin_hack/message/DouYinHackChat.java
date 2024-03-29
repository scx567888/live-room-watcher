package cool.scx.live_room_watcher.impl.douyin_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.ChatMessage;
import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;

/**
 * 弹幕
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackChat implements Chat {

    private final ChatMessage chatMessage;
    private final DouYinHackUser douYinUser;


    public DouYinHackChat(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
        this.douYinUser = new DouYinHackUser(chatMessage.getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String content() {
        return chatMessage.getContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User user() {
        return douYinUser;
    }

    @Override
    public String roomID() {
        return null;
    }

}
