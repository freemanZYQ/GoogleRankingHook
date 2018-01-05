package com.moxiu.sdk.statistics.e;

import android.text.TextUtils;
import android.util.Log;
import com.moxiu.sdk.statistics.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class i {
    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void a(String str) {
        if (b.b()) {
            Log.d("mxstat", c(str));
        }
    }

    public static void a(String str, Throwable th) {
        if (b.b()) {
            Log.e("mxstat", c(str) + a(th));
        }
    }

    public static void b(String str) {
        if (b.b()) {
            Log.w("mxstat", c(str));
        }
    }

    private static String c(String str) {
        String str2 = "";
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            str2 = "(" + className + ":" + stackTraceElement.getLineNumber() + ")";
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(str)) {
            str = "executed";
        }
        return str2 + str;
    }
}
