package cool.scx.live_room_watcher.test;

import cool.scx.common.ansi.Ansi;
import cool.scx.live_room_watcher.impl.douyin.DouYinLiveRoomWatcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cool.scx.live_room_watcher.test.DouYinHackLiveRoomWatcherTest.nowTimeStr;

public class DouYinLiveRoomWatcherTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        tes1();
    }

    //    @Test
    public static void tes1() throws IOException, InterruptedException {
        var liveRoomWatcher = new DouYinLiveRoomWatcher("appID", "appSecret", "123", "123", "123", new HashMap<>());

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

        liveRoomWatcher.taskStartAll("roomID");

        //此处模拟 接收到了来自抖音的回调请求, 您可以在您的 服务端调用

        liveRoomWatcher.callGift("body", Map.of("x-roomid", "123"));

    }

}
