package cool.scx.live_room_watcher.impl.kuaishou;

import dev.scx.http.media.multi_part.MultiPart;
import dev.scx.http.x.HttpClient;
import dev.scx.timer.ScheduledExecutorTimer;
import dev.scx.timer.ScxTimer;


import java.lang.System.Logger;
import java.util.concurrent.Executors;

import static dev.scx.http.method.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl.kuaishou.KuaiShouApi.ACCESS_TOKEN_URL;
import static dev.scx.serialize.ScxSerialize.fromJson;
import static java.lang.System.Logger.Level.DEBUG;
import static java.util.concurrent.TimeUnit.SECONDS;

public class KuaiShouAccessTokenManager {

    static final Logger logger = System.getLogger(KuaiShouAccessTokenManager.class.getName());

    protected final String appID;
    protected final String appSecret;
    private final HttpClient httpClient;
    private final ScxTimer timer;

    public KuaiShouAccessTokenManager(String appID, String appSecret, HttpClient httpClient) {
        this.appID = appID;
        this.appSecret = appSecret;
        this.httpClient=httpClient;
        this.timer = new ScheduledExecutorTimer(Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    public KuaiShouAccessToken getAccessToken0() {
        var response = httpClient.request()
                .method(POST)
                .uri(ACCESS_TOKEN_URL)
                .send(
                    MultiPart.of()
                        .add("app_id", appID)
                        .add("app_secret", appSecret)
                        .add("grant_type", "client_credentials")
                );

        var resBody= response.asString();

        var accessTokenResult = fromJson(resBody,KuaiShouAccessToken.class);

        if (accessTokenResult.result != 1) {
            throw new IllegalArgumentException(resBody);
        }

        return accessTokenResult;
    }

    protected String accessToken;

    /// 获取 accessToken
    public synchronized String getAccessToken() {
        if (this.accessToken == null) {
            refreshAccessToken();
        }
        return this.accessToken;
    }

    /// 刷新 accessToken
    /// 首次调用后 会一直循环进行获取 所以理论上讲只需要获取一次
    public synchronized void refreshAccessToken() {
        try {
            var accessToken0 = getAccessToken0();
            logger.log(DEBUG,"获取 accessToken 成功 : {}", accessToken0);
            this.accessToken = accessToken0.accessToken();
            timer.runAfter(this::refreshAccessToken, accessToken0.expiresIn() / 2, SECONDS);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            // 发生错误的话 2秒后重试
            timer.runAfter(this::refreshAccessToken, 2000, SECONDS);
        }
    }

}
