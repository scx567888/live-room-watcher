package cool.scx.live_room_watcher.impl.tiktok_hack.message;

import cool.scx.live_room_watcher.impl.douyin_hack.message.DouYinHackUser;
import cool.scx.live_room_watcher.impl.tiktok_hack.proto_entity.webcast.im.ChatMessage;
import cool.scx.live_room_watcher.message.Chat;
import cool.scx.live_room_watcher.message.User;

public class TikTokHackChat implements Chat {

    TikTokHackUser tiktokUser;
    ChatMessage chatMessage;
    
    public TikTokHackChat(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
        this.tiktokUser = new TikTokHackUser(chatMessage.getUser());
    }


    @Override
    public String content() {
        return chatMessage.getContent();
    }

    @Override
    public User user() {
        return tiktokUser;
    }

    @Override
    public String roomID() {
        return null;
    }
    
    
}
