## 可抓取直播间 弹幕, 礼物, 点赞, 原始流地址等 (仅供学习使用,不得用于商业用途)

|  平台  | 弹幕(消息) | 点赞  | 礼物  | 进入直播间 | 原始流地址 |
|:----:|:------:|:---:|:---:|:-----:|:-----:|
|  抖音  |   ✔    |  ✔  |  ✔  |   ✔   |   ✔   |
| 哔哩哔哩 |  计划中   | 计划中 | 计划中 |  计划中  |  计划中  |

### 基本用法

``` java
package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.douyin.DouYinLiveRoomWatcher;

public class Main {

    public static void main(String[] args) {
        var liveRoomWatcher = new DouYinLiveRoomWatcher("https://live.douyin.com/357626301151");

        liveRoomWatcher.onChat(chat -> {
            System.out.println("[消息] " + chat.user().nickName() + " : " + chat.content());
        }).onUser(user -> {
            System.out.println("[来了] " + user.nickName());
        }).onLike(like -> {
            System.out.println("[点赞] " + like.user().nickName() + " x " + like.count());
        }).onFollow(follow -> {
            System.out.println("[关注] " + follow.user().nickName());
        }).onGift(gift -> {
            System.out.println("[礼物] " + gift.user().nickName() + " : " + gift.name() + " x " + gift.count());
        });

        liveRoomWatcher.startWatch();
        
        System.out.println("[直播流地址] " + liveRoomWatcher.liveRoomWebStreamURLs());
    }

}
```

#### 由于第三方的系统总是在不断的更新升级 如果功能失效请提 issues 并详细说明情况