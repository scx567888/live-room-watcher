package cool.scx.live_room_watcher.util;

/**
 * <p>Navigator class.</p>
 *
 * @author scx567888
 * @version 0.0.2
 */
public final class Navigator {

    /**
     * Constant <code>navigator</code>
     */
    private static final Navigator navigator = new Navigator();

    /**
     * <p>Constructor for Navigator.</p>
     */
    private Navigator() {

    }

    /**
     * <p>navigator.</p>
     *
     * @return a {@link cool.scx.live_room_watcher.util.Navigator} object
     */
    public static Navigator navigator() {
        return navigator;
    }

    /**
     * <p>cookieEnabled.</p>
     *
     * @return a boolean
     */
    public boolean cookieEnabled() {
        return true;
    }

    /**
     * <p>userAgent.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String userAgent() {
        return appCodeName() + "/" + appVersion();
    }

    /**
     * <p>appCodeName.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String appCodeName() {
        return "Mozilla";
    }

    /**
     * <p>language.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String language() {
        return "zh-CN";
    }

    /**
     * <p>platform.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String platform() {
        return "Win32";
    }

    /**
     * <p>appVersion.</p>
     *
     * @return a {@link java.lang.String} object
     */
    public String appVersion() {
        return "5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.49";
    }

    /**
     * <p>onLine.</p>
     *
     * @return a boolean
     */
    public boolean onLine() {
        return true;
    }

}
