package cool.scx.live_room_watcher.impl.kuaishou_hack;

import com.fasterxml.jackson.core.JsonProcessingException;
import cool.scx.live_room_watcher.impl.kuaishou_hack.entity.KuaiShouInitialState;
import cool.scx.util.ObjectUtils;
import cool.scx.util.URIBuilder;
import org.graalvm.polyglot.Context;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static cool.scx.live_room_watcher.util.GraalvmJSHelper.ENGINE;
import static cool.scx.live_room_watcher.util.GraalvmJSHelper.HOST_ACCESS;

public class KuaiShouHackHelper {

    /**
     * 标准化 直播间 URI
     *
     * @param uri a {@link java.lang.String} object
     * @return a {@link java.lang.String} object
     */
    public static String initLiveRoomURI(String uri) {
        var liveRoomURI = URIBuilder.of(uri).removeAllParams().build();
        //检查是否为快手直播间地址
        if (!"live.kuaishou.com".equals(liveRoomURI.getHost())) {
            throw new IllegalArgumentException("不是合法快手直播间 url : " + uri);
        }
        //清理掉所有的多余路径
        return liveRoomURI.toString();
    }

    public static KuaiShouInitialState parseBody(String html) throws JsonProcessingException {
        Context context = Context.newBuilder().allowHostAccess(HOST_ACCESS).engine(ENGINE).build();
        try (context) {
            Document parse = Jsoup.parse(html);
            Elements select = parse.select("script");
            String initialStateScript = null;
            for (Element element : select) {
                String text = element.html();
                if (text.startsWith("window.__INITIAL_STATE__")) {
                    initialStateScript = text;
                    break;
                }
            }
            if (initialStateScript == null) {
                throw new IllegalArgumentException();
            }
            context.eval("js", """
                    var window= {};
                    var document={
                            scripts:[{
                                parentNode:{removeChild(e){}}
                            }]};
                    """);
            context.eval("js", initialStateScript);
            var value = context.eval("js", """
                    JSON.stringify(window.__INITIAL_STATE__)
                    """);
            return ObjectUtils.jsonMapper().readValue(value.asString(), KuaiShouInitialState.class);
        }
    }

}
