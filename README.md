# Live Room Watcher

<p align="center">
    <a target="_blank" href="https://github.com/scx567888/live-room-watcher/actions/workflows/ci.yml">
        <img src="https://github.com/scx567888/live-room-watcher/actions/workflows/ci.yml/badge.svg" alt="CI"/>
    </a>
    <a target="_blank" href="https://search.maven.org/artifact/cool.scx/live-room-watcher">
        <img src="https://img.shields.io/maven-central/v/cool.scx/live-room-watcher?color=ff69b4" alt="maven-central"/>
    </a>
    <a target="_blank" href="https://github.com/scx567888/live-room-watcher">
        <img src="https://img.shields.io/github/languages/code-size/scx567888/live-room-watcher?color=orange" alt="code-size"/>
    </a>
    <a target="_blank" href="https://github.com/scx567888/live-room-watcher/issues">
        <img src="https://img.shields.io/github/issues/scx567888/live-room-watcher" alt="issues"/>
    </a>
    <a target="_blank" href="https://github.com/scx567888/live-room-watcher/blob/master/LICENSE">
        <img src="https://img.shields.io/github/license/scx567888/live-room-watcher" alt="license"/>
    </a>
</p>
<p align="center">
    <a target="_blank" href="https://github.com/scx567888/scx">
        <img src="https://img.shields.io/badge/SCX Common-f44336" alt="SCX Common"/>
    </a>
    <a target="_blank" href="https://github.com/protocolbuffers/protobuf">
        <img src="https://img.shields.io/badge/Protocol Buffers-ff8000" alt="Protocol Buffers"/>
    </a>
    <a target="_blank" href="https://github.com/cbeust/testng">
        <img src="https://img.shields.io/badge/TestNG-9c27b0" alt="TestNG"/>
    </a>
</p>

## 📺 可抓取直播间 弹幕, 礼物, 点赞, 原始流地址等 (仅供学习使用,不得用于商业用途)

|    平台    | 弹幕(消息) | 点赞  | 礼物  | 进入直播间 | 关注  | 原始流地址 |
|:--------:|:------:|:---:|:---:|:-----:|:---:|:-----:|
|  抖音(官方)  |   ✔    |  ✔  |  ✔  |   ❌   |  ❌  |   ❌   |
| 抖音(Hack) |   ✔    |  ✔  |  ✔  |   ✔   |  ✔  |   ✔   |
|  快手(官方)  |  计划中   | 计划中 | 计划中 |  计划中  | 计划中 |  计划中  |
| 快手(Hack) |  计划中   | 计划中 | 计划中 |  计划中  | 计划中 |  计划中  |
|   哔哩哔哩   |  计划中   | 计划中 | 计划中 |  计划中  | 计划中 |  计划中  |
|   网易CC   |   ✔    |  ✔  |  ✔  |   ❌   |  ❌  |   ❌   |
|   么么直播   |   ✔    |  ✔  |  ✔  |   ✔   |  ❌  |   ❌   |

## Maven

``` xml
<dependency>
    <groupId>cool.scx</groupId>
    <artifactId>live-room-watcher</artifactId>
    <version>{version}</version>
</dependency>
```

## 基本用法

``` java
import cool.scx.live_room_watcher.douyin_hack.DouYinHackLiveRoomWatcher;

public class Main {

    public static void main(String[] args) {
        var liveRoomWatcher = new DouYinHackLiveRoomWatcher("https://live.douyin.com/357626301151");

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

### 由于第三方的系统总是在不断的更新升级 如果功能失效请提 issues 并详细说明情况 .
