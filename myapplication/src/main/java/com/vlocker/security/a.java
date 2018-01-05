package com.vlocker.security;

import android.text.TextUtils;
import java.util.zip.CRC32;

public class a {
    private static String a(String str) {
        int indexOf = str.indexOf("{");
        int indexOf2 = str.indexOf("}");
        if (!(indexOf == -1 || indexOf2 == -1)) {
            indexOf2++;
            if (indexOf2 > str.length()) {
                indexOf2 = str.length();
            }
            str = str.replace(str.substring(indexOf, indexOf2), " -ADDR- ").trim();
        }
        indexOf = str.indexOf("@");
        if (indexOf != -1) {
            indexOf2 = indexOf + 9;
            if (indexOf2 > str.length()) {
                indexOf2 = str.length();
            }
            str = str.replace(str.substring(indexOf, indexOf2), " -ADDR- ").trim();
        }
        if (str.indexOf("(") == -1) {
            return str;
        }
        indexOf2 = str.lastIndexOf(":");
        return indexOf2 != -1 ? str.substring(0, indexOf2).trim() : str;
    }

    public static String a(Throwable th) {
        Object obj = null;
        StackTraceElement[] b = b(th);
        if (th == null && b == null) {
            return "1001";
        }
        StackTraceElement[] stackTrace = (b == null || b.length == 0) ? th.getStackTrace() : b;
        if (stackTrace == null || stackTrace.length == 0) {
            return "1002";
        }
        String stackTraceElement;
        String str = "";
        String str2 = "";
        for (StackTraceElement stackTraceElement2 : stackTrace) {
            if (!(TextUtils.isEmpty(stackTraceElement2.toString()) || stackTraceElement2.toString().contains("android.os.Parcel"))) {
                if (stackTraceElement2.toString().contains("com.vlocker.")) {
                    stackTraceElement = stackTraceElement2.toString();
                    break;
                } else if (obj == null) {
                    str = stackTraceElement2.toString();
                    obj = 1;
                }
            }
        }
        stackTraceElement = str2;
        str2 = "";
        stackTraceElement = !TextUtils.isEmpty(stackTraceElement) ? a(stackTraceElement) : a(str);
        CRC32 crc32 = new CRC32();
        crc32.update(stackTraceElement.getBytes());
        return Long.toString(crc32.getValue());
    }

    private static StackTraceElement[] b(Throwable th) {
        StackTraceElement[] stackTraceElementArr = null;
        while (th != null) {
            stackTraceElementArr = th.getStackTrace();
            th = th.getCause();
        }
        return stackTraceElementArr;
    }
}
