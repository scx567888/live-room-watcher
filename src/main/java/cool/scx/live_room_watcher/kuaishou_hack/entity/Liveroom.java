package cool.scx.live_room_watcher.kuaishou_hack.entity;

import java.util.List;
import java.util.Map;

public class Liveroom {

    public LiveStream liveStream;
    public Author author;
    public GameInfo gameInfo;
    public List<String> websocketUrls;
    public String token;
    public String authToken;
    public List<String> watchingList;
    public List<NoticeList> noticeList;
    public List<String> recommendList;
    public boolean isLiving;
    public String principalId;
    public ChatSetting chatSetting;
    public Map<String, Object> sensitiveWordInfo;
    public ErrorType errorType;
    public boolean $isServerPretch;


}
