package cool.scx.live_room_watcher.test;


import cool.scx.ansi.Ansi;
import cool.scx.live_room_watcher.impl.douyin_hack.DouYinHackLiveRoomWatcher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

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

    //    @Test
    public static void tes1() {
        var liveRoomWatcher = new DouYinHackLiveRoomWatcher("https://live.douyin.com/201176429482").useGzip(true);

        liveRoomWatcher.onChat(chat -> {
            Ansi.ansi().brightGreen(nowTimeStr() + "[消息] ").defaultColor(chat.user().nickname() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.ansi().brightMagenta(nowTimeStr() + "[来了] ").defaultColor(user.nickname()).println();
        }).onLike(like -> {
            Ansi.ansi().brightYellow(nowTimeStr() + "[点赞] ").defaultColor(like.user().nickname() + " x " + like.count()).println();
        }).onFollow(follow -> {
            Ansi.ansi().brightCyan(nowTimeStr() + "[关注] ").defaultColor(follow.user().nickname()).println();
        }).onGift(gift -> {
            Ansi.ansi().brightBlue(nowTimeStr() + "[礼物] ").defaultColor(gift.user().nickname() + " : ").brightWhite(gift.name() + " x " + gift.count()).println();
        });

        liveRoomWatcher.startWatch();

        System.out.println("[直播流地址] " + liveRoomWatcher.liveRoomWebStreamURLs());

    }

}
