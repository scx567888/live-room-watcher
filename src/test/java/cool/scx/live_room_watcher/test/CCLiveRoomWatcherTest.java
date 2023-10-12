package cool.scx.live_room_watcher.test;

import cool.scx.live_room_watcher.impl.cc.CCLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;

import java.io.IOException;
import java.util.Map;

import static cool.scx.live_room_watcher.MsgType.LIVE_GIFT;
import static cool.scx.live_room_watcher.test.DouYinHackLiveRoomWatcherTest.nowTimeStr;

public class CCLiveRoomWatcherTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        test1();
    }

    public static void test1() throws IOException, InterruptedException {
        var liveRoomWatcher = new CCLiveRoomWatcher("appID", "appSecret", "123", "123", "123");

        liveRoomWatcher.onChat(chat -> {
            Ansi.out().brightGreen(nowTimeStr() + "[消息] ").defaultColor(chat.user().nickName() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.out().brightMagenta(nowTimeStr() + "[来了] ").defaultColor(user.nickName()).println();
        }).onLike(like -> {
            Ansi.out().brightYellow(nowTimeStr() + "[点赞] ").defaultColor(like.user().nickName() + " x " + like.count()).println();
        }).onFollow(follow -> {
            Ansi.out().brightCyan(nowTimeStr() + "[关注] ").defaultColor(follow.user().nickName()).println();
        }).onGift(gift -> {
            Ansi.out().brightBlue(nowTimeStr() + "[礼物] ").defaultColor(gift.user().nickName() + " : ").brightWhite(gift.name() + " x " + gift.count()).println();
        });

        liveRoomWatcher.startWatch("roomID");

        //此处模拟 接收到了来自抖音的回调请求, 您可以在您的 服务端调用

        liveRoomWatcher.call("body", Map.of("x-roomid", "123"), LIVE_GIFT);
        
    }

}
