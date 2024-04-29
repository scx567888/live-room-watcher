package cool.scx.live_room_watcher.test;


import cool.scx.common.ansi.Ansi;
import cool.scx.live_room_watcher.impl.tiktok_hack.TikTokHackLiveRoomWatcher;

import static cool.scx.live_room_watcher.test.DouYinHackLiveRoomWatcherTest.nowTimeStr;

public class TikTokHackLiveRoomWatcherTest {

    public static void main(String[] args) {
        tes1();
    }

    //    @Test
    public static void tes1() {
        var liveRoomWatcher = new TikTokHackLiveRoomWatcher("https://www.tiktok.com/@onepiece.staff.official/live");

        liveRoomWatcher.onChat(chat -> {
            Ansi.ansi().brightGreen(nowTimeStr() + "[消息] ").defaultColor(chat.user().nickName() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.ansi().brightMagenta(nowTimeStr() + "[来了] ").defaultColor(user.nickName()).println();
        }).onLike(like -> {
            Ansi.ansi().brightYellow(nowTimeStr() + "[点赞] ").defaultColor(like.user().nickName() + " x " + like.count()).println();
        }).onFollow(follow -> {
            Ansi.ansi().brightCyan(nowTimeStr() + "[关注] ").defaultColor(follow.user().nickName()).println();
        }).onGift(gift -> {
            Ansi.ansi().brightBlue(nowTimeStr() + "[礼物] ").defaultColor(gift.user().nickName() + " : ").brightWhite(gift.name() + " x " + gift.count()).println();
        });

        liveRoomWatcher.startWatch();

    }

}
