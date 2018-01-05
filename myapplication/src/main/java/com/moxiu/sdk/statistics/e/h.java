package com.moxiu.sdk.statistics.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.moxiu.sdk.statistics.b;

public class h {
    private static long a = -1;
    private static String b = "";

    private static int a() {
        try {
            if (VERSION.SDK_INT >= 14) {
                return 4;
            }
        } catch (Throwable e) {
            i.a("getConMode Exception = ", e);
        }
        return 0;
    }

    public static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    public static long a(Context context) {
        if (a < 0) {
            a = context.getSharedPreferences(b.d(), a()).getLong(b.e(), 0);
        }
        return a;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                b = context.getString(a(context, "t_market_theme_manager_child"));
            } catch (Throwable e) {
                i.a("getChild Exception = ", e);
            }
        }
        return b;
    }
}
