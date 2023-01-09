package cool.scx.live_room_watcher.douyin;

import cool.scx.live_room_watcher.Chat;
import cool.scx.live_room_watcher.User;
import cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.ChatMessage;

/**
 * 弹幕
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinChat implements Chat {

    private final ChatMessage chatMessage;
    private final DouYinUser douYinUser;

    /**
     * <p>Constructor for DouYinChat.</p>
     *
     * @param chatMessage a {@link cool.scx.live_room_watcher.douyin.proto_entity.webcast.im.ChatMessage} object
     */
    public DouYinChat(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
        this.douYinUser = new DouYinUser(chatMessage.getUser());
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

}
