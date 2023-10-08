package cool.scx.live_room_watcher.test;

import cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher;
import cool.scx.live_room_watcher.impl.kuaishou.KuaiShouLiveRoomWatcher;
import cool.scx.util.ansi.Ansi;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;
import io.vertx.ext.web.RequestBody;
import io.vertx.ext.web.Router;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cool.scx.live_room_watcher.OfficialPassiveLiveRoomWatcher.MsgType.*;
import static cool.scx.live_room_watcher.test.DouYinHackLiveRoomWatcherTest.nowTimeStr;

public class KuaiShouLiveRoomWatcherTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer(new HttpServerOptions()
                .setSsl(true)
                .setKeyStoreOptions(new JksOptions()
                        .setPath("xxxx")
                        .setPassword("xxx"))
        );
        Router router = Router.router(vertx);
        httpServer.requestHandler(router)
                .listen(443);
        test1(router);
    }

    public static void test1(Router router) throws IOException, InterruptedException {
        var liveRoomWatcher = new KuaiShouLiveRoomWatcher("xxx","xxxx");

        String accessToken = liveRoomWatcher.getAccessToken();

        liveRoomWatcher.onChat(chat -> {
            Ansi.out().brightGreen(nowTimeStr() + "[消息] ").defaultColor(chat.user().nickName() + " : ").brightWhite(chat.content()).println();
        }).onUser(user -> {
            Ansi.out().brightMagenta(nowTimeStr() + "[来了] ").defaultColor(user.nickName()).println();
        }).onLike(like -> {
            Ansi.out().brightYellow(nowTimeStr() + "[点赞] ").defaultColor(like.user().nickName() + " x " + like.count()).println();
        }).onFollow(follow -> {
            Ansi.out().brightCyan(nowTimeStr() + "[关注] ").defaultColor(follow.user().nickName()).println();
        }).onGift(gift -> {
            Ansi.out().brightBlue(nowTimeStr() + "[礼物] ").defaultColor(gift.user().nickName() + " : ").brightWhite(gift.name() + " x " + gift.count()).println();
        });

        liveRoomWatcher.startWatch("");


        router.post("/test/comment").handler((c)->{
            RequestBody body = c.body();
            String bodyString = body.asString();
            MultiMap headers = c.response().headers();
            var m=new HashMap<String,String>();
            for (Map.Entry<String, String> header : headers) {
                m.put(header.getKey(),header.getValue());
            }
            liveRoomWatcher.call(bodyString,m, LIVE_COMMENT);
        });

        router.post("/test/like").handler((c)->{
            RequestBody body = c.body();
            String bodyString = body.asString();
            MultiMap headers = c.response().headers();
            var m=new HashMap<String,String>();
            for (Map.Entry<String, String> header : headers) {
                m.put(header.getKey(),header.getValue());
            }
            liveRoomWatcher.call(bodyString,m, LIVE_LIKE);
        });

        router.post("/test/gift").handler((c)->{
            RequestBody body = c.body();
            String bodyString = body.asString();
            MultiMap headers = c.response().headers();
            var m=new HashMap<String,String>();
            for (Map.Entry<String, String> header : headers) {
                m.put(header.getKey(),header.getValue());
            }
            liveRoomWatcher.call(bodyString,m, LIVE_GIFT);
        });

        router.post("/test/follow").handler((c)->{
            RequestBody body = c.body();
            String bodyString = body.asString();
            MultiMap headers = c.response().headers();
            var m=new HashMap<String,String>();
            for (Map.Entry<String, String> header : headers) {
                m.put(header.getKey(),header.getValue());
            }
            liveRoomWatcher.call(bodyString,m, LIVE_FOLLOW);
        });

    }

}
