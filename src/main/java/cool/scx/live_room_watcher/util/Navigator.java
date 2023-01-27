package cool.scx.live_room_watcher.util;

public final class Navigator {

    public boolean cookieEnabled() {
        return true;
    }

    public String userAgent() {
        return appCodeName() + "/" + appVersion();
    }

    public String appCodeName() {
        return "Mozilla";
    }

    public String language() {
        return "zh-CN";
    }

    public String platform() {
        return "Win32";
    }

    public String appVersion() {
        return "5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.49";
    }

    public boolean onLine() {
        return true;
    }

    private static final Navigator navigator = new Navigator();

    public static Navigator navigator() {
        return navigator;
    }

    private Navigator() {

    }

}
