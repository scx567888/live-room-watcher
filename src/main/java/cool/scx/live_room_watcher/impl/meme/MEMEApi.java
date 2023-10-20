package cool.scx.live_room_watcher.impl.meme;

public class MEMEApi {

    public static String TEST_BASE_URL = "https://test-games.memeyule.com";
    public static String BASE_URL = "https://games.memeyule.com";
    public static String TEST_WEBSOCKET_CHANNEL_URL = "https://test-games-sock.memeyule.com:6211/websocket";
    public static String WEBSOCKET_CHANNEL_URL = "https://ws-game.memeyule.com:6211/websocket";

    private String baseUrl;
    private String websocket_channel_url;

    public MEMEApi() {
        this.setBaseUrl(BASE_URL);
        this.setWebSocketChannelUrl(WEBSOCKET_CHANNEL_URL);
    }

    public String WEBSOCKET_CHANNEL_URL() {
        return websocket_channel_url;
    }

    public String BIND_ROOM_CODE_URL() {
        return baseUrl + "/api/v1/openapi/bindRoomCode";
    }

    public String ROOM_CODE_STATUS_URL() {
        return baseUrl + "/api/v1/openapi/roomCodeStatus";
    }

    public String STAR_INFO_URL() {
        return baseUrl + "/api/v1/openapi/starInfo";
    }

    public String GIFTS_URL() {
        return baseUrl + "/api/v1/openapi/gifts";
    }

    public String END_CALLBACK_URL() {
        return baseUrl + "/api/v1/game/barrage/endCallback";
    }

    public String START_CALLBACK_URL() {
        return baseUrl + "/api/v1/game/barrage/startCallback";
    }

    public String ACCESS_TOKEN_URL() {
        return baseUrl + "/api/v1/openapi/accessToken";
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setWebSocketChannelUrl(String webSocketChannelUrl) {
        this.websocket_channel_url = webSocketChannelUrl;
    }

    public String BASE_URL() {
        return baseUrl;
    }

}
