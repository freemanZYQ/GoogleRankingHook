package com.vlocker.theme.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class a {
    public static String a = "Firstin";
    public static String b = "isfirstset";
    public static String c = "isnewdownload";
    public static String d = "isdialogshow";
    public static String e = "currentversionmanager";
    public static String f = "isupadate";
    private static String g = "com.moxiu";

    public static int a() {
        try {
            if (VERSION.SDK_INT >= 14) {
                return 4;
            }
        } catch (NumberFormatException e) {
        } catch (Exception e2) {
        }
        return 0;
    }

    public static int a(String str, Context context, int i) {
        return a(context).getInt(str, i);
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences(g, a());
    }

    public static String a(String str, Context context) {
        return a(context).getString(str, "");
    }

    public static void a(String str, int i, Context context) {
        Editor edit = a(context).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static void a(String str, Boolean bool, Context context) {
        Editor edit = a(context).edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.commit();
    }

    public static void a(String str, Long l, Context context) {
        Editor edit = a(context).edit();
        edit.putLong(str, l.longValue());
        edit.commit();
    }

    public static void a(String str, String str2, Context context) {
        Editor edit = a(context).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static Long b(String str, Context context) {
        return Long.valueOf(a(context).getLong(str, 0));
    }

    public static Boolean c(String str, Context context) {
        return Boolean.valueOf(a(context).getBoolean(str, false));
    }
}
