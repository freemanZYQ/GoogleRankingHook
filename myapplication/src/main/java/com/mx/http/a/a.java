package com.mx.http.a;

import android.text.TextUtils;
import java.io.File;

public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("/") || !str.contains(".")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        return (lastIndexOf == -1 || lastIndexOf2 == str.length() || lastIndexOf == -1 || lastIndexOf2 == str.length() || lastIndexOf >= str.length() - 1 || lastIndexOf <= lastIndexOf2) ? null : str.substring(lastIndexOf);
    }

    public static boolean b(String str) {
        return (str == null || "".equals(str)) ? false : new File(str).exists();
    }
}
