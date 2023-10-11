package cool.scx.live_room_watcher.impl.meme;

public class MEMEApi {

    private String BASE_URL = "https://test-games.memeyule.com";

    private String WEBSOCKET_CHANNEL_URL = "https://test-games-sock.memeyule.com:6211/websocket";

    public String WEBSOCKET_CHANNEL_URL() {
        return WEBSOCKET_CHANNEL_URL;
    }

    public String BIND_ROOM_CODE_URL() {
        return BASE_URL + "/api/v1/openapi/bindRoomCode";
    }

    public String ROOM_CODE_STATUS_URL() {
        return BASE_URL + "/api/v1/openapi/roomCodeStatus";
    }

    public String STAR_INFO_URL() {
        return BASE_URL + "/api/v1/openapi/starInfo";
    }

    public String GIFTS_URL() {
        return BASE_URL + "/api/v1/openapi/gifts";
    }

    public String END_CALLBACK_URL() {
        return BASE_URL + "/api/v1/game/barrage/endCallback";
    }

    public String START_CALLBACK_URL() {
        return BASE_URL + "/api/v1/game/barrage/startCallback";
    }

    public String ACCESS_TOKEN_URL() {
        return BASE_URL + "/api/v1/openapi/accessToken";
    }

    public void setBaseUrl(String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    public void setWebSocketChannelUrl(String webSocketChannelUrl) {
        this.WEBSOCKET_CHANNEL_URL = webSocketChannelUrl;
    }

    public String BASE_URL() {
        return BASE_URL;
    }

}
