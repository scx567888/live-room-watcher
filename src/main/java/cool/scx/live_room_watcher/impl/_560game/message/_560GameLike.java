package cool.scx.live_room_watcher.impl._560game.message;

import cool.scx.live_room_watcher.message.Like;

public class _560GameLike extends _560GameUser implements Like {

    public Long Count;
    public Long Total;

    @Override
    public long count() {
        return Count;
    }

}
