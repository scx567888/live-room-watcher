package cool.scx.live_room_watcher.kuaishou_hack;

import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import cool.scx.http_client.ScxHttpClientResponseBody;
import cool.scx.live_room_watcher.BaseLiveRoomWatcher;
import cool.scx.live_room_watcher.LiveRoomAnchor;
import cool.scx.live_room_watcher.LiveRoomInfo;
import cool.scx.live_room_watcher.util.Browser;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import io.vertx.core.http.WebSocketConnectOptions;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static cool.scx.enumeration.HttpMethod.GET;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * todo 未完成
 */
public class KuaiShouHackLiveRoomWatcher extends BaseLiveRoomWatcher implements LiveRoomInfo {
    private final Browser browser;
    private final String liveRoomURI;
    private KuaiShouHackLiveRoomInfo liveRoomInfo;

    public KuaiShouHackLiveRoomWatcher(String url) {
        this.liveRoomURI= KuaiShouHackHelper.initLiveRoomURI(url);
        this.browser = new Browser(vertx).addCookie(new DefaultCookie("userId", "3030376223")).addCookie(new DefaultCookie("_did","web_7085119610F79C3B"));
    }

    @Override
    public void startWatch() {
        //终止上一次的监听
        stopWatch();
        try {
            System.out.println("解析中...");
            this.liveRoomInfo = getLiveRoomInfo();
            System.out.println("解析完成 -> " + liveRoomTitle() + " (ID : " + liveRoomID() + ")");
        } catch (Exception e) {
            throw new RuntimeException("解析 直播间错误 !!!", e);
        }
        System.out.println("连接中...");
        var webSocketFuture = browser.webSocket(getWebSocketOptions());
        webSocketFuture.onSuccess(c -> {
//            webSocket = c;
//            startPing(c);
            c.binaryMessageHandler(b -> {
//                var v = parseFrame(b.getBytes());
//                if (v.response().getNeedAck()) {
//                    sendAck(c, v.pushFrame(), v.response());
//                }
            });
            c.textMessageHandler(System.out::println);
            c.exceptionHandler(e -> {
                e.printStackTrace();
                startWatch();
            });
            System.out.println("连接成功 !!!");
        }).onFailure(e -> {
            e.printStackTrace();
            startWatch();
        });
    }

    public WebSocketConnectOptions getWebSocketOptions() {
        try {
            ScxHttpClientResponse response = browser.request(new ScxHttpClientRequest().method(GET)
                    .uri("https://live.kuaishou.com/live_api/liveroom/websocketinfo?liveStreamId=" + liveRoomID())
            );
            var body = response.body().toString();
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        var uri = getWebSocketURI(liveRoomID(), useGzip);
//        return new WebSocketConnectOptions()
//                .setURI(uri.toString())
//                .setSsl(true)
//                .setHost("webcast3-ws-web-lf.douyin.com")
//                .setPort(443);
        return null;
    }

    public KuaiShouHackLiveRoomInfo getLiveRoomInfo() throws IOException, InterruptedException {
        var indexHtml = getIndexHtml(this.liveRoomURI);
        return new KuaiShouHackLiveRoomInfo(indexHtml.body().toString());
    }

    private ScxHttpClientResponse getIndexHtml(String liveRoomURI) throws IOException, InterruptedException {
        //模拟浏览器发送请求
        return browser.request(new ScxHttpClientRequest()
                .method(GET)
                .uri(URI.create(liveRoomURI))
                .setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"));
    }

    @Override
    public List<String> liveRoomWebStreamURLs() {
        return this.liveRoomInfo.liveRoomWebStreamURLs();
    }

    @Override
    public String liveRoomTitle() {
        return this.liveRoomInfo.liveRoomTitle();
    }

    @Override
    public String liveRoomID() {
        return this.liveRoomInfo.liveRoomID();
    }

    @Override
    public LiveRoomAnchor liveRoomAnchor() {
        return this.liveRoomInfo.liveRoomAnchor();
    }

    @Override
    public void stopWatch() {

    }
    
}
