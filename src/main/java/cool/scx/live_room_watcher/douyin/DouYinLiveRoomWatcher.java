package cool.scx.live_room_watcher.douyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import cool.scx.http_client.ScxHttpClientRequest;
import cool.scx.http_client.ScxHttpClientResponse;
import cool.scx.live_room_watcher.AbstractLiveRoomWatcher;
import cool.scx.live_room_watcher.douyin.enumeration.ControlMessageAction;
import cool.scx.live_room_watcher.douyin.enumeration.MemberMessageAction;
import cool.scx.live_room_watcher.douyin_hack.*;
import cool.scx.live_room_watcher.douyin_hack.entity.DouYinApplication;
import cool.scx.live_room_watcher.douyin_hack.proto_entity.pushproto.PushFrame;
import cool.scx.live_room_watcher.douyin_hack.proto_entity.webcast.im.*;
import cool.scx.live_room_watcher.util.Browser;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;
import cool.scx.util.zip.GunzipBuilder;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketConnectOptions;

import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static cool.scx.enumeration.HttpMethod.GET;
import static cool.scx.live_room_watcher.util.Navigator.navigator;

/**
 * <p>DouYinLiveRoomWatcher class.</p>
 *
 * @author scx567888
 * @version 0.0.1
 */
public class DouYinLiveRoomWatcher extends AbstractLiveRoomWatcher {


    @Override
    public void startWatch() {
        
    }

    @Override
    public void stopWatch() {

    }
    
}
