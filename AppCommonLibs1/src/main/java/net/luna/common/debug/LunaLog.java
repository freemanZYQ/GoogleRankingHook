package net.luna.common.debug;

import android.util.Log;

import java.util.Locale;

/**
 * 测试用log输出
 */
public class LunaLog {

    public final static boolean isDebug = true;

    private static String mTag = createDefaultTag();

    private static String createDefaultTag() {
        return "luna";
    }

    public static void d(String msg) {
        try {
            if (isDebug) {
                Log.d(mTag, msg + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(Throwable e) {
        try {
            if (isDebug) {
                Log.w(mTag, "SDK error", e);
            }
        } catch (Exception e1) {
            e.printStackTrace();
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(mTag, msg);
        }
    }

    public static void e(String msg, Throwable e) {
        try {
            if (isDebug) {
                Log.e(mTag, msg, e);
            }
        } catch (Exception e1) {
            e.printStackTrace();
        }
    }

    public static void d(String sfm, Object... args) {
        try {
            if (isDebug) {
                sfm = String.format(Locale.getDefault(), sfm, args);
                Log.d(mTag, sfm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
