package cool.scx.live_room_watcher.test;

import cool.scx.common.ansi.Ansi;
import cool.scx.live_room_watcher.impl.kuaishou.KuaiShouLiveRoomWatcher;

import java.io.IOException;

import static cool.scx.live_room_watcher.test.DouYinHackLiveRoomWatcherTest.nowTimeStr;

public class KuaiShouLiveRoomWatcherTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        test1();
    }

    public static void test1() throws IOException, InterruptedException {
        var liveRoomWatcher = new KuaiShouLiveRoomWatcher("xxx", "xxxx");

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

        liveRoomWatcher.taskStart("", "");

    }

}
