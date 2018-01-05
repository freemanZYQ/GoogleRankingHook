package net.luna.common.util;

import android.support.annotation.NonNull;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SystemUtils
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-5-15
 */
public class SystemUtils {

    /**
     * recommend default thread pool size according to system available processors, {@link #getDefaultThreadPoolSize()}
     **/
    public static final int DEFAULT_THREAD_POOL_SIZE = getDefaultThreadPoolSize();

    private SystemUtils() {
        throw new AssertionError();
    }

    /**
     * get recommend default thread pool size
     *
     * @return if 2 * availableProcessors + 1 less than 8, return it, else return 8;
     * @see {@link #getDefaultThreadPoolSize(int)} max is 8
     */
    public static int getDefaultThreadPoolSize() {
        return getDefaultThreadPoolSize(8);
    }

    /**
     * get recommend default thread pool size
     *
     * @param max
     * @return if 2 * availableProcessors + 1 less than max, return it, else return max;
     */
    public static int getDefaultThreadPoolSize(int max) {
        int availableProcessors = 2 * Runtime.getRuntime().availableProcessors() + 1;
        return availableProcessors > max ? max : availableProcessors;
    }

    /**
     * 获取系统属性值
     *
     * @param propertyName name
     * @return string
     */
    public static String getSystemProperty(@NonNull String propertyName) {
        BufferedReader reader = null;
        try {
            java.lang.Process p = Runtime.getRuntime().exec("getprop " + propertyName);
            reader = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(reader);
        }
        return "UNKNOWN";
    }
}
