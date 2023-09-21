package cool.scx.live_room_watcher.impl.douyin_hack.message;

import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;
import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.ChatMessage;

/**
 * 弹幕
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinHackChat implements Chat {

    private final ChatMessage chatMessage;
    private final DouYinHackUser douYinUser;

    /**
     * <p>Constructor for DouYinChat.</p>
     *
     * @param chatMessage a {@link cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.ChatMessage} object
     */
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
