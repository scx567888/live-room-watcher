package cool.scx.live_room_watcher.impl._560game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import cool.scx.common.util.ObjectUtils;
import cool.scx.http.method.HttpMethod;
import cool.scx.http.ScxHttpClient;
import cool.scx.http.x.ScxHttpClientHelper;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.impl._560game.message.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static cool.scx.common.util.RandomUtils.randomString;
import static cool.scx.http.method.HttpMethod.POST;
import static cool.scx.live_room_watcher.impl._560game._560GameApi.*;
import static cool.scx.live_room_watcher.impl._560game._560GameHelper.getSign;

public class _560GameLiveRoomWatcher extends AbstractLiveRoomWatcher {
    
    private final String mch_id;
    private final String game_id;
    private final String secret;
    private final Map<String, _560GameWatchTask> watchTaskMap = new ConcurrentHashMap<>();
    private String root_uri;

    public _560GameLiveRoomWatcher(String mch_id, String game_id, String secret) {
        this.mch_id = mch_id;
        this.game_id = game_id;
        this.secret = secret;
        this.root_uri = "https://danmu.fa-pay.com";
    }

    public String getRootURI() {
        return root_uri;
    }

    public void setRootURI(String root_url) {
        this.root_uri = root_url;
    }

    public void startWatch(String username, String password) throws IOException, InterruptedException {
        var w = watchTaskMap.get(username);
        if (w == null) {
            var watchTask = new _560GameWatchTask(username, password, this);
            watchTaskMap.put(username, watchTask);
            watchTask.start();
        } else {
            w.start();
        }
    }

    public void stopWatch(String username) throws IOException, InterruptedException {
        var watchTask = watchTaskMap.get(username);
        if (watchTask != null) {
            watchTask.stop();
            watchTaskMap.remove(username);
        }
    }

    public String validateUser(String username, String password) {
        try {
            return validateUser0(username, password);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String validateUser0(String username, String password) throws IOException, InterruptedException {
        var map = new HashMap<String, String>();
        map.put("mch_id", this.mch_id);
        map.put("username", username);
        map.put("password", password);
        map.put("game_id", this.game_id);
        map.put("nonce", randomString(32));

        var sign = getSign(map, secret);
        map.put("sign", sign);

        var response = ScxHttpClientHelper.request()
                .method(POST)
                .uri(root_uri + VALIDATE_USER_URL)
                .send(map);
        var jsonNode = response.body().asJsonNode();
        String message = jsonNode.get("message").asText();
        if (!"success".equals(message)) {
            throw new RuntimeException("返回数据有误 : " + jsonNode);
        }
        return jsonNode.get("data").get("ws_url").asText();
    }

    public JsonNode closeGameNotify(String username) {
        try {
            return closeGameNotify0(username);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭游戏推送通知
     *
     * @param username username
     * @return a
     * @throws IOException          a
     * @throws InterruptedException a
     */
    public JsonNode closeGameNotify0(String username) throws IOException, InterruptedException {
        var map = new HashMap<String, String>();
        map.put("mch_id", this.mch_id);
        map.put("username", username);
        map.put("game_id", this.game_id);
        map.put("nonce", randomString(32));

        var sign = getSign(map, secret);
        map.put("sign", sign);

        var response = ScxHttpClientHelper.request()
                .method(POST)
                .uri(root_uri + CLOSE_GAME_NOTIFY_URL)
                .send(map);
        var jsonNode = response.body().asJsonNode();
        String message = jsonNode.get("message").asText();
        if (!"success".equals(message)) {
            throw new RuntimeException("返回数据有误");
        }
        return jsonNode;
    }

    public JsonNode reportGameNotify(String username) {
        try {
            return reportGameNotify0(username);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonNode reportGameNotify0(String username) throws IOException, InterruptedException {
        var map = new HashMap<String, String>();
        map.put("mch_id", this.mch_id);
        map.put("username", username);
        map.put("game_id", this.game_id);
        map.put("nonce", randomString(32));

        var sign = getSign(map, secret);
        map.put("sign", sign);

        var response = ScxHttpClientHelper.request()
                .method(POST)
                .uri(root_uri + REPORT_GAME_NOTIFY_URL)
                .send(map);
        var jsonNode = response.body().asJsonNode();
        String message = jsonNode.get("message").asText();
        if (!"success".equals(message)) {
            throw new RuntimeException("返回数据有误");
        }
        return jsonNode;
    }

    public List<_560GiftListEntry> getGiftList() throws IOException, InterruptedException {
        var map = new HashMap<String, String>();
        map.put("mch_id", this.mch_id);
        map.put("game_id", this.game_id);
        map.put("nonce", randomString(32));

        var sign = getSign(map, secret);
        map.put("sign", sign);

        var response = ScxHttpClientHelper.request()
                .method(POST)
                .uri(root_uri + GET_GIFT_LIST_URL)
                .send(map);
        var jsonNode = response.body().asJsonNode();
        var message = jsonNode.get("message").asText();
        if (!"success".equals(message)) {
            throw new RuntimeException("返回数据有误");
        }
        return ObjectUtils.convertValue(jsonNode.get("data"), new TypeReference<>() {
        });
    }

    void callMessage(JsonNode jsonNode) {
        var MsgType = jsonNode.get("MsgType").asInt();
        switch (MsgType) {
            case 2 -> callGift(jsonNode); //礼物
            case 3 -> callLike(jsonNode); //点赞
            case 4 -> callChat(jsonNode); //聊天
            case 5 -> callFollow(jsonNode); //关注
            case 6 -> callUser(jsonNode); //加入聊天室
            default -> throw new IllegalArgumentException("未知 MsgType : " + MsgType);
        }
    }

    private void callGift(JsonNode jsonNode) {
        var gift = ObjectUtils.convertValue(jsonNode, _560GameGift.class);
//        gift.roomID = payload.roomId + "";
        this._callOnGift(gift);
    }

    private void callLike(JsonNode jsonNode) {
        var like = ObjectUtils.convertValue(jsonNode, _560GameLike.class);
//        gift.roomID = payload.roomId + "";
        this._callOnLike(like);
    }

    private void callChat(JsonNode jsonNode) {
        var chat = ObjectUtils.convertValue(jsonNode, _560GameChat.class);
//        gift.roomID = payload.roomId + "";
        this._callOnChat(chat);
    }

    private void callFollow(JsonNode jsonNode) {
        var follow = ObjectUtils.convertValue(jsonNode, _560GameFollow.class);
//        gift.roomID = payload.roomId + "";
        this._callOnFollow(follow);
    }

    private void callUser(JsonNode jsonNode) {
        var user = ObjectUtils.convertValue(jsonNode, _560GameUser.class);
//        gift.roomID = payload.roomId + "";
        this._callOnUser(user);
    }

}
