import cool.scx.core.ScxConstant;
import cool.scx.live_room_watcher.douyin.DouYinLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class LiveRoomWatcherTest {

    public static void main(String[] args) {
        tes1();
    }

    /**
     * <p>nowTimeStr.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public static String nowTimeStr() {
        return ScxConstant.DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now()) + " : ";
    }

    @Test
    public static void tes1() {
        var liveRoomWatcher = new DouYinLiveRoomWatcher("https://live.douyin.com/398877650540").useGzip(true);

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
