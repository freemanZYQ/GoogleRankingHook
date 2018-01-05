package net.luna.common.basic;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultThreadPool {

    /**
     * BaseRequest任务队列
     */
    static ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(15);
    /**
     * 线程池
     */
    static AbstractExecutorService pool = new ThreadPoolExecutor(8, 15, 15L, TimeUnit.SECONDS, blockingQueue,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    private static DefaultThreadPool instance = null;

    private Handler mUiHandler;

    public static DefaultThreadPool getInstance() {
        if (instance == null) {
            instance = new DefaultThreadPool();
        }
        return instance;
    }

    public DefaultThreadPool() {
        mUiHandler = new Handler(Looper.getMainLooper());
    }

    public void execute(Runnable r) {
        pool.execute(r);
    }

    /**
     * 关闭，并等待任务执行完成，不接受新任务
     */
    public static void shutdown() {
        if (pool != null) {
            pool.shutdown();
        }
    }

    /**
     * 关闭，立即关闭，并挂起所有正在执行的线程，不接受新任务
     */
    public static void shutdownRightnow() {
        if (pool != null) {
            // List<Runnable> tasks =pool.shutdownNow();
            pool.shutdownNow();
            try {
                // 设置超时极短，强制关闭所有任务
                pool.awaitTermination(1, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void removeTaskFromQueue() {
        // blockingQueue.contains(o);
    }

    public Handler getUiHandler() {
        return mUiHandler;
    }

    public void setUiHandler(Handler uiHandler) {
        this.mUiHandler = uiHandler;
    }

}
