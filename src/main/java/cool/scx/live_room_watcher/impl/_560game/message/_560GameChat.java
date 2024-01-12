package cool.scx.live_room_watcher.impl._560game.message;

import cool.scx.live_room_watcher.message.Chat;

public class _560GameChat extends _560GameUser implements Chat {

    public String Content;

    @Override
    public String content() {
        return Content;
    }

}
