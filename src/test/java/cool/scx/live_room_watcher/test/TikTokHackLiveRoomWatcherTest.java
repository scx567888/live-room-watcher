package cool.scx.live_room_watcher.test;


import cool.scx.ansi.Ansi;
import cool.scx.http.x.proxy.Proxy;
import cool.scx.live_room_watcher.impl.tiktok_hack.TikTokHackLiveRoomWatcher;

import static cool.scx.live_room_watcher.test.DouYinHackLiveRoomWatcherTest.nowTimeStr;

public class TikTokHackLiveRoomWatcherTest {

    public static void main(String[] args) {
        tes1();
    }

    //    @Test
    public static void tes1() {
        var liveRoomWatcher = new TikTokHackLiveRoomWatcher("https://www.tiktok.com/@74azp/live",Proxy.of("127.0.0.1",17890));

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

    }

}
