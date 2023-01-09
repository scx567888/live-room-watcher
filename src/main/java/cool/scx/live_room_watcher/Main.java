package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.douyin.DouYinLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;

/**
 * <p>Main class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class Main {

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects
     */
    public static void main(String[] args) {
        var liveRoomWatcher = new DouYinLiveRoomWatcher("https://live.douyin.com/398877650540");

        liveRoomWatcher.onChat(chat -> {
            Ansi.out().brightGreen("[消息] ").defaultColor(chat.user().nickName() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.out().brightMagenta("[来了] ").defaultColor(user.nickName()).println();
        }).onLike(like -> {
            Ansi.out().brightYellow("[点赞] ").defaultColor(like.user().nickName()).println();
        }).onFollow(follow -> {
            Ansi.out().brightCyan("[关注] ").defaultColor(follow.user().nickName()).println();
        }).onGift(gift -> {
            Ansi.out().brightBlue("[礼物] ").defaultColor(gift.user().nickName() + " : ").brightWhite(gift.name()).println();
        });

        liveRoomWatcher.startWatch();
    }

}
