package cool.scx.live_room_watcher.impl.douyin_hack.entity;

import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.PushFrame;
import cool.scx.live_room_watcher.impl.douyin_hack.proto_entity.webcast.im.Response;

public record PushFrameAndResponse(PushFrame pushFrame, Response response) {

}
