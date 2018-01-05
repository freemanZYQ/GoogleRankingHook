package com.xinmei365.fontsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.xinmei365.fontsdk.c.e;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class a {
    public static HashMap d = new HashMap();
    public static String e;
    public static String f;

    public static String a(Context context) {
        if (TextUtils.isEmpty(e)) {
            e = a(context, "YIZIYUN_APPKEY");
            if (TextUtils.isEmpty(e)) {
                return "";
            }
        }
        return e;
    }

    private static String a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object string = applicationInfo.metaData.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    return string.trim();
                }
                e.c("Could not read " + str + " meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            e.c("Could not read " + str + " meta-data from AndroidManifest.xml." + e);
        }
        return null;
    }

    public static boolean a(String str) {
        if (!b(str)) {
            return false;
        }
        e = str;
        return true;
    }

    private static boolean b(String str) {
        if (str != null) {
            int length = str.length();
            if (length >= 10 && length <= 32) {
                return true;
            }
        }
        return false;
    }

    public static Typeface c(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            if (d.containsKey(str) && d.get(str) != null && ((SoftReference) d.get(str)).get() != null) {
                return (Typeface) ((SoftReference) d.get(str)).get();
            }
            Typeface createFromFile = Typeface.createFromFile(str);
            try {
                d.put(str, new SoftReference(createFromFile));
                return createFromFile;
            } catch (Exception e) {
                return createFromFile;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
