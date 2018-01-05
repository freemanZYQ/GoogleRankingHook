package com.baidu.lbsapi.auth;

import android.util.Log;

class a {
    public static boolean a = false;

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    public static void a(String str) {
        if (Thread.currentThread().getStackTrace().length != 0) {
            Log.d(a(), str);
        }
    }
}
