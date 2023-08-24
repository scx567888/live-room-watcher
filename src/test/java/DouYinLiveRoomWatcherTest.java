import cool.scx.live_room_watcher.douyin.DouYinLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static cool.scx.live_room_watcher.douyin.DouYinMsgType.LIVE_GIFT;

public class DouYinLiveRoomWatcherTest {

    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws IOException, InterruptedException {
        tes1();
    }

    /**
     * <p>nowTimeStr.</p>
     *
     * @return a {@link String} object
     */
    public static String nowTimeStr() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now()) + " : ";
    }

//    @Test
    public static void tes1() throws IOException, InterruptedException {
        var liveRoomWatcher = new DouYinLiveRoomWatcher("appID", "appSecret", "123", "123", "123");

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

        liveRoomWatcher.startWatch("roomID");

        //此处模拟 接收到了来自抖音的回调请求, 您可以在您的 服务端调用
        
        liveRoomWatcher.call("body", Map.of("x-roomid", "123"), LIVE_GIFT);

    }

}
