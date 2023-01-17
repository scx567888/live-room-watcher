package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.douyin.DouYinLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;

import static cool.scx.live_room_watcher.LiveRoomWatcher.nowTimeStr;

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
        var liveRoomWatcher = new DouYinLiveRoomWatcher("https://live.douyin.com/950159208474?cover_type=1&enter_from_merge=web_live&enter_method=web_card&game_name=%E6%A0%BC%E6%96%97%E6%89%8B%E6%B8%B8&is_recommend=1&live_type=game&more_detail=game_687&request_id=2023011709485397EF063DBB37ABA46C7C&room_id=7189420631958555452&stream_type=horizontal&title_type=1&web_live_page=game_4618&web_live_tab=more");

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

        liveRoomWatcher.startWatch();
    }

}
