package com.vlocker.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Date;

public class a {
    public static Editor a(Context context) {
        return context.getSharedPreferences("Vlock_settings", 0).edit();
    }

    public static void a(Context context, int i) {
        a(context).putInt("battery_saver_request_time", i).commit();
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("Vlock_settings", 0);
    }

    public static void b(Context context, int i) {
        a(context).putInt("battery_saver_request_day", i).commit();
    }

    public static int c(Context context) {
        int date = new Date().getDate();
        if (date == d(context)) {
            return b(context).getInt("battery_saver_request_time", 0);
        }
        b(context, date);
        a(context).putInt("battery_saver_request_time", 0).commit();
        return 0;
    }

    public static void c(Context context, int i) {
        a(context).putInt("battery_saver_show_time", i).commit();
    }

    public static int d(Context context) {
        return b(context).getInt("battery_saver_request_day", -1);
    }

    public static int e(Context context) {
        int date = new Date().getDate();
        if (date == d(context)) {
            return b(context).getInt("battery_saver_show_time", 0);
        }
        b(context, date);
        a(context).putInt("battery_saver_show_time", 0).commit();
        return 0;
    }
}
