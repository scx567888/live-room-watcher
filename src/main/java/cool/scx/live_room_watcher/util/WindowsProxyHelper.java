package cool.scx.live_room_watcher.util;

import com.sun.jna.platform.win32.Advapi32Util;

import java.util.Map;

import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;

/**
 * 设置 windows 系统的代理 如果后期改为采用 代理的方式获取 弹幕时可以用到
 *
 * @author scx567888
 * @version 0.0.1
 */
public final class WindowsProxyHelper {

    /**
     * Constant <code>keyPath="Software\\Microsoft\\Windows\\CurrentVe"{trunked}</code>
     */
    public static final String INTERNET_SETTINGS_KEY_PATH = "Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings";

    /**
     * 获取代理配置信息
     *
     * @return 代理配置信息
     */
    public static Map<String, Object> getProxyValues() {
        return Advapi32Util.registryGetValues(
                HKEY_CURRENT_USER,
                INTERNET_SETTINGS_KEY_PATH
        );
    }

    /**
     * 开启 代理
     */
    public static void enableProxy() {
        Advapi32Util.registrySetIntValue(
                HKEY_CURRENT_USER,
                INTERNET_SETTINGS_KEY_PATH,
                "ProxyEnable",
                1
        );
    }

    /**
     * 设置代理 (主机默认为本机)
     *
     * @param port 端口
     */
    public static void setProxy(int port) {
        setProxy("127.0.0.1", port);
    }

    /**
     * 设置 代理
     *
     * @param host 主机
     * @param port 端口号
     */
    public static void setProxy(String host, int port) {
        Advapi32Util.registrySetStringValue(
                HKEY_CURRENT_USER,
                INTERNET_SETTINGS_KEY_PATH,
                "ProxyServer",
                host + ":" + port
        );
    }

    /**
     * 关闭 代理设置
     */
    public static void disableProxy() {
        Advapi32Util.registrySetIntValue(
                HKEY_CURRENT_USER,
                INTERNET_SETTINGS_KEY_PATH,
                "ProxyEnable",
                0
        );
    }

    /**
     * 清空 代理设置
     */
    public static void clearProxy() {
        Advapi32Util.registrySetStringValue(
                HKEY_CURRENT_USER,
                INTERNET_SETTINGS_KEY_PATH,
                "ProxyServer",
                ""
        );
    }

}
