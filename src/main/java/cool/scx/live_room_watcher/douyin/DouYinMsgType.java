package cool.scx.live_room_watcher.douyin;

/**
 * 消息类型
 */
public enum DouYinMsgType {

    /**
     * 评论
     */
    LIVE_COMMENT("live_comment"),

    /**
     * 礼物
     */
    LIVE_GIFT("live_gift"),

    /**
     * 点赞
     */
    LIVE_LIKE("live_like"),

    /**
     * 粉丝团
     */
    LIVE_FANS_CLUB("live_fansclub");

    private final String value;

    DouYinMsgType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
