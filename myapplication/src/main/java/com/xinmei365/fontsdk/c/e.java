package com.xinmei365.fontsdk.c;

import android.util.Log;
import java.util.regex.Pattern;

public class e {
    private static boolean aB = false;
    public static boolean aC = true;
    private static int aD = 5;

    public static void a(Object obj) {
        if (aB && aD >= 4) {
            Log.d("YiziyunSDK", format(obj));
        }
    }

    public static void b(Object obj) {
        if (aB && aD >= 3) {
            Log.i("YiziyunSDK", format(obj));
        }
    }

    public static void c(Object obj) {
        if (aB && aD >= 1) {
            Log.e("YiziyunSDK", format(obj));
        }
    }

    public static void enableLog(boolean z) {
        aB = z;
    }

    private static String format(Object obj) {
        if (obj == null) {
            obj = "";
        }
        if (!aC) {
            return obj.toString();
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String methodName = stackTraceElement.getMethodName();
        String[] split = stackTraceElement.getClassName().split(Pattern.quote("."));
        return String.format("%s %s ==> %s", new Object[]{split[split.length - 1], methodName, obj});
    }
}
