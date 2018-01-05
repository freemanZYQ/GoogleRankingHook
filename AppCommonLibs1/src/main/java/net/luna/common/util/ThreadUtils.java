package net.luna.common.util;

import android.os.Looper;

import net.luna.common.basic.DefaultThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class ThreadUtils {

    public static final int DEFAULT_THREAD_POOL_SIZE = getDefaultThreadPoolSize();

    private ThreadUtils() {
        throw new AssertionError();
    }

    public static int getDefaultThreadPoolSize() {
        return getDefaultThreadPoolSize(8);
    }

    public static int getDefaultThreadPoolSize(int max) {
        int availableProcessors = 2 * Runtime.getRuntime().availableProcessors() + 1;
        return availableProcessors > max ? max : availableProcessors;
    }

    /**
     * 使用多线程
     *
     * @param task
     */
    public static void execute(Runnable task) {
        DefaultThreadPool.getInstance().execute(task);
    }

    public static boolean isInUIThread() {
        try {
            return Looper.myLooper() == Looper.getMainLooper();
        } catch (Throwable e) {
        }
        return false;
    }

    public static boolean runInUiThread(Runnable runnable) {
        try {
            if (runnable == null) {
                return false;
            }
            return DefaultThreadPool.getInstance().getUiHandler().post(runnable);
        } catch (Throwable e) {
        }
        return false;
    }

    public static boolean runInUiThreadDelay(Runnable runnable, long delay) {
        try {
            if (runnable == null) {
                return false;
            }
            return DefaultThreadPool.getInstance().getUiHandler().postDelayed(runnable, delay);
        } catch (Throwable e) {
        }
        return false;
    }

    /**
     * 延迟指定时间之后执行任务
     *
     * @param runnable     要执行的任务
     * @param delayTime_ms 要延迟的毫秒数
     * @return
     */
    public static boolean runInUiThreadDelayed_ms(Runnable runnable, long delayTime_ms) {
        try {
            if (runnable == null) {
                return false;
            }
            return DefaultThreadPool.getInstance().getUiHandler().postDelayed(runnable, delayTime_ms);
        } catch (Throwable e) {
        }
        return false;
    }


    public static Object runSingleThreadTimeout(Runnable runnable, long timeout) throws InterruptedException, ExecutionException, TimeoutException {
        return RunningTimeout.Run(runnable, "run", null, timeout);
    }

}
