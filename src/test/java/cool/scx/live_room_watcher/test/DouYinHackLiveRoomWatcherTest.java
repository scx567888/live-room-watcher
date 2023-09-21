package cool.scx.live_room_watcher.test;


import cool.scx.live_room_watcher.impl.douyin_hack.DouYinHackLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DouYinHackLiveRoomWatcherTest {

    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        tes1();
    }

    /**
     * <p>nowTimeStr.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public static String nowTimeStr() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now()) + " : ";
    }

    @Test
    public static void tes1() {
        var liveRoomWatcher = new DouYinHackLiveRoomWatcher("https://live.douyin.com/71427343402").useGzip(true);

        liveRoomWatcher.onChat(chat -> {
            Ansi.out().brightGreen(nowTimeStr() + " [消息] ").defaultColor(chat.user().nickName() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.out().brightMagenta(nowTimeStr() + "[来了] ").defaultColor(user.nickName()).println();
        }).onLike(like -> {
            Ansi.out().brightYellow(nowTimeStr() + "[点赞] ").defaultColor(like.user().nickName() + " x " + like.count()).println();
        }).onFollow(follow -> {
            Ansi.out().brightCyan(nowTimeStr() + "[关注] ").defaultColor(follow.user().nickName()).println();
        }).onGift(gift -> {
            Ansi.out().brightBlue(nowTimeStr() + "[礼物] ").defaultColor(gift.user().nickName() + " : ").brightWhite(gift.name() + " x " + gift.count()).println();
        });

        liveRoomWatcher.startWatch();

        System.out.println("[直播流地址] " + liveRoomWatcher.liveRoomWebStreamURLs());

    }

}
