package cool.scx.live_room_watcher;

import com.sun.jna.platform.win32.Advapi32Util;

import java.util.Objects;

import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;

/**
 * 设置 windows 系统的代理 如果后期改为采用 代理的方式获取 弹幕时可以用到
 *
 * @author scx567888
 * @version 0.0.1
 */
public class WindowsProxySettings {

    /**
     * Constant <code>keyPath="Software\\Microsoft\\Windows\\CurrentVe"{trunked}</code>
     */
    static String keyPath = "Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings";

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects
     */
    public static void main(String[] args) {

        var values = Advapi32Util.registryGetValues(
                HKEY_CURRENT_USER,
                keyPath
        );

        values.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

        Advapi32Util.registrySetIntValue(
                HKEY_CURRENT_USER,
                keyPath,
                "ProxyEnable",
                1
        );

        Advapi32Util.registrySetStringValue(
                HKEY_CURRENT_USER,
                keyPath,
                "ProxyServer",
                "127.0.0.1:8989"
        );
        System.out.println("是否开启代理 :" + Objects.equals(1, values.get("ProxyEnable")));

    }

}
