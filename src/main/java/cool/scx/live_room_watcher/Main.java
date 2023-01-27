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
    }

}
