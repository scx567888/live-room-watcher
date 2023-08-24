package cool.scx.live_room_watcher.douyin;

/**
 * 官方的获取方式
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcherOptions {

    String appID;
    String appSecret;
    String commentDataSecret;
    String giftDataSecret;
    String likeDataSecret;

    public DouYinLiveRoomWatcherOptions appID(String appID) {
        this.appID = appID;
        return this;
    }

    public DouYinLiveRoomWatcherOptions appSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    public DouYinLiveRoomWatcherOptions commentDataSecret(String commentDataSecret) {
        this.commentDataSecret = commentDataSecret;
        return this;
    }

    public DouYinLiveRoomWatcherOptions giftDataSecret(String giftDataSecret) {
        this.giftDataSecret = giftDataSecret;
        return this;
    }

    public DouYinLiveRoomWatcherOptions likeDataSecret(String likeDataSecret) {
        this.likeDataSecret = likeDataSecret;
        return this;
    }

    void checkOptions() {
        if (appID == null || appSecret == null || commentDataSecret == null || giftDataSecret == null || likeDataSecret == null) {
            throw new RuntimeException();
        }
    }

}
