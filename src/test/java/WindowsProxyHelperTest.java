import org.testng.annotations.Test;

import static cool.scx.live_room_watcher.util.WindowsProxyHelper.*;

public class WindowsProxyHelperTest {

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    @Test
    public static void test1() throws InterruptedException {
        var currentOS = System.getProperty("os.name");
        if (currentOS.startsWith("Windows")) {
            getProxyValues().forEach((k, v) -> {
                System.out.println(k + " : " + v);
            });

            setProxy(9999);
            enableProxy();
            Thread.sleep(3000);
            disableProxy();
            clearProxy();

            getProxyValues().forEach((k, v) -> {
                System.out.println(k + " : " + v);
            });
        }
    }

}
