package com.c.a.k;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class c {
    public static boolean a(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        boolean z = true;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("[.]");
        String[] split2 = str2.split("[.]");
        int length = split.length < split2.length ? split.length : split2.length;
        int i = 0;
        while (i < length) {
            int intValue = Integer.valueOf(split[i]).intValue();
            int intValue2 = Integer.valueOf(split2[i]).intValue();
            if (intValue != intValue2) {
                return intValue > intValue2;
            } else {
                i++;
            }
        }
        if (split.length <= split2.length) {
            z = false;
        }
        return z;
    }

    public static boolean b(String str) {
        return a(str) ? false : Pattern.compile("^(http://|https://)?((?:[A-Za-z0-9]+-[A-Za-z0-9]+|[A-Za-z0-9]+)\\.)+([A-Za-z]+)[/\\?\\:]?.*$").matcher(str).matches();
    }
}
