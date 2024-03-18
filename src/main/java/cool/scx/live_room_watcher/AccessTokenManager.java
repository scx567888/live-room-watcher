package cool.scx.live_room_watcher;

import cool.scx.live_room_watcher.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 官方的被动接受的接口
 */
public abstract class AccessTokenManager {
    
    final Logger logger= LoggerFactory.getLogger(this.getClass());

    protected String accessToken;

    protected abstract AccessToken getAccessToken0() throws IOException, InterruptedException;

    /**
     * 获取 accessToken
     *
     * @return a
     */
    public synchronized String getAccessToken() {
        if (this.accessToken == null) {
            refreshAccessToken();
        }
        return this.accessToken;
    }

    /**
     * 刷新 accessToken
     * 首次调用后 会一直循环进行获取 所以理论上讲只需要获取一次
     */
    public synchronized void refreshAccessToken() {
        try {
            var accessToken0 = getAccessToken0();
            logger.debug("获取 accessToken 成功 : {}",accessToken0);
            this.accessToken = accessToken0.accessToken();
            Helper.SCHEDULER.schedule(this::refreshAccessToken, accessToken0.expiresIn() / 2, SECONDS);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            //发生错误的话 2秒后重试
            Helper.SCHEDULER.schedule(this::refreshAccessToken, 2000, SECONDS);
        }
    }

}
