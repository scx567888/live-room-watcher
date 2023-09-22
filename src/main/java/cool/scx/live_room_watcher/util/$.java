package cool.scx.live_room_watcher.util;

import cool.scx.functional.ScxRunnable;
import io.vertx.core.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static cool.scx.util.ScxExceptionHelper.getRootCause;

public class $ {

    public static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE, Thread.ofVirtual().factory());

    public static CompletableFuture<Void> async(ScxRunnable<?> runnable) {

        var promise = new CompletableFuture<Void>();
        Thread.ofVirtual().start(() -> {
            try {
                runnable.run();
                promise.complete(null);
            } catch (Throwable e) {
                promise.completeExceptionally(e);
            }
        });
        return promise;
    }

    public static <T> CompletableFuture<T> async(Callable<T> callable) {
        var promise = new CompletableFuture<T>();
        Thread.ofVirtual().start(() -> {
            try {
                var t = callable.call();
                promise.complete(t);
            } catch (Throwable e) {
                promise.completeExceptionally(e);
            }
        });
        return promise;
    }

    public static <T> T await(CompletableFuture<T> promise) throws Throwable {
        try {
            return promise.get();
        } catch (Exception e) {
            throw getRootCause(e);
        }
    }

    //**************** 以下的貌似有问题 *******************
    public static Future<Void> asyncToVertxFuture(ScxRunnable<?> runnable) {
        return Future.fromCompletionStage(async(runnable));
    }

    public static <T> Future<T> asyncToVertxFuture(Callable<T> callable) {
        return Future.fromCompletionStage(async(callable));
    }

    public static <T> T await(Future<T> future) throws Throwable {
        return await((CompletableFuture<T>) future.toCompletionStage());
    }

}
