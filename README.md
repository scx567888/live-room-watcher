## 直播间监控器 可抓取直播间弹幕,礼物等 (仅供学习使用,不得用于商业用途)

### 抖音     (✔)

### 哔哩哔哩  (计划中)

#### 由于第三方的系统总是在不断的更新升级 如果功能失效请提 issues 并详细说明情况

### 基本用法

``` java
import cool.scx.live_room_watcher.douyin.DouYinLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;

public class Main {

    public static void main(String[] args) {
        var liveRoomWatcher = new DouYinLiveRoomWatcher("https://live.douyin.com/xxx");

        liveRoomWatcher.onChat(chat -> {
            Ansi.out().brightGreen("[消息] ").defaultColor(chat.user().nickName() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.out().brightMagenta("[来了] ").defaultColor(user.nickName()).println();
        }).onLike(like -> {
            Ansi.out().brightYellow("[点赞] ").defaultColor(like.user().nickName()).println();
        }).onFollow(follow -> {
            Ansi.out().brightCyan("[关注] ").defaultColor(follow.user().nickName()).println();
        }).onGift(gift -> {
            Ansi.out().brightBlue("[礼物] ").defaultColor(gift.user().nickName() + " : ").brightWhite(gift.name()).println();
        });

        liveRoomWatcher.startWatch();
    }

}
```