package cool.scx.live_room_watcher.util;

import dev.scx.http.ScxHttpClient;
import dev.scx.http.ScxHttpClientRequest;
import dev.scx.http.ScxHttpClientResponse;
import dev.scx.http.media.multi_part.MultiPart;
import dev.scx.http.uri.ScxURI;
import dev.scx.http.x.HttpClient;

import static dev.scx.http.method.HttpMethod.*;

/// ScxHttpClientHelper
///
/// @author scx567888
/// @version 0.0.1
public final class ScxHttpClientHelper {

    public static final ScxHttpClient DEFAULT_HTTP_CLIENT = new HttpClient();

    public static ScxHttpClientRequest request() {
        return DEFAULT_HTTP_CLIENT.request();
    }

    public static ScxHttpClientResponse get(ScxURI uri) {
        return DEFAULT_HTTP_CLIENT.request().method(GET).uri(uri).send();
    }

    public static ScxHttpClientResponse post(ScxURI uri, MultiPart content) {
        return DEFAULT_HTTP_CLIENT.request().method(POST).uri(uri).send(content);
    }

    public static ScxHttpClientResponse put(ScxURI uri, MultiPart content) {
        return DEFAULT_HTTP_CLIENT.request().method(PUT).uri(uri).send(content);
    }

    public static ScxHttpClientResponse delete(ScxURI uri, MultiPart content) {
        return DEFAULT_HTTP_CLIENT.request().method(DELETE).uri(uri).send(content);
    }

    public static ScxHttpClientResponse get(String uri) {
        return DEFAULT_HTTP_CLIENT.request().method(GET).uri(uri).send();
    }

    public static ScxHttpClientResponse post(String uri, MultiPart content) {
        return DEFAULT_HTTP_CLIENT.request().method(POST).uri(uri).send(content);
    }

    public static ScxHttpClientResponse put(String uri, MultiPart content) {
        return DEFAULT_HTTP_CLIENT.request().method(PUT).uri(uri).send(content);
    }

    public static ScxHttpClientResponse delete(String uri, MultiPart content) {
        return DEFAULT_HTTP_CLIENT.request().method(DELETE).uri(uri).send(content);
    }

}
