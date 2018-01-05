package com.tencent.open.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;

public class p {
    public static int a(String str) {
        return "shareToQQ".equals(str) ? 10103 : "shareToQzone".equals(str) ? 10104 : "addToQQFavorites".equals(str) ? 10105 : "sendToMyComputer".equals(str) ? 10106 : "shareToTroopBar".equals(str) ? 10107 : "action_login".equals(str) ? 11101 : "action_request".equals(str) ? 10100 : -1;
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException e) {
                return str.compareTo(str2);
            }
        }
        return split.length > i ? 1 : split2.length > i ? -1 : 0;
    }

    public static String a(int i) {
        return i == 10103 ? "shareToQQ" : i == 10104 ? "shareToQzone" : i == 10105 ? "addToQQFavorites" : i == 10106 ? "sendToMyComputer" : i == 10107 ? "shareToTroopBar" : i == 11101 ? "action_login" : i == 10100 ? "action_request" : null;
    }

    public static String a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean a(Context context, Intent intent) {
        return (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static int b(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }
}
