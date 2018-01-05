package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class q {
    private static SharedPreferences a = null;

    public static int a(Context context, String str, int i) {
        return a(context).getInt(l.a(context, "wxop_" + str), i);
    }

    public static long a(Context context, String str) {
        return a(context).getLong(l.a(context, "wxop_" + str), 0);
    }

    private static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (q.class) {
            sharedPreferences = context.getSharedPreferences(".mta-wxop", 0);
            a = sharedPreferences;
            if (sharedPreferences == null) {
                a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(l.a(context, "wxop_" + str), str2);
    }

    public static void a(Context context, String str, long j) {
        String a = l.a(context, "wxop_" + str);
        Editor edit = a(context).edit();
        edit.putLong(a, j);
        edit.commit();
    }

    public static void b(Context context, String str, int i) {
        String a = l.a(context, "wxop_" + str);
        Editor edit = a(context).edit();
        edit.putInt(a, i);
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        String a = l.a(context, "wxop_" + str);
        Editor edit = a(context).edit();
        edit.putString(a, str2);
        edit.commit();
    }
}
