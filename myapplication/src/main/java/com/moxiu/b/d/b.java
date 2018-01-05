package com.moxiu.b.d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class b {
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

    public static int a(Context context) {
        return context.getSharedPreferences("ad_preferences", a()).getInt("ad_init_version", 0);
    }

    public static String a(Context context, String str) {
        return context.getSharedPreferences("ad_pid_preferences", a()).getString(str + "_adkey", "");
    }

    public static void a(Context context, int i) {
        context.getSharedPreferences("ad_preferences", a()).edit().putInt("ad_init_version", i).commit();
    }

    public static void a(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences("ad_preferences", a()).edit();
        edit.putInt(str + "_weekday", i);
        edit.commit();
    }

    public static void a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("ad_pid_preferences", a()).edit();
        edit.putString(str + "_adkey", str2);
        edit.commit();
    }

    public static void a(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("ad_preferences", a()).edit();
        edit.putBoolean("app_debug", z);
        edit.commit();
    }

    public static String b(Context context, String str) {
        return context.getSharedPreferences("ad_param_preferences", a()).getString(str + "_param", "");
    }

    public static void b(Context context) {
        context.getSharedPreferences("ad_pid_preferences", a()).edit().clear().commit();
    }

    public static void b(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences("ad_preferences", a()).edit();
        edit.putInt(str + "_times", i);
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        context.getSharedPreferences("ad_param_preferences", a()).edit().putString(str + "_param", str2).commit();
    }

    public static void c(Context context) {
        context.getSharedPreferences("ad_param_preferences", a()).edit().clear().commit();
    }

    public static void c(Context context, String str) {
        Editor edit = context.getSharedPreferences("ad_preferences", a()).edit();
        edit.putString("placeid_json", str);
        edit.commit();
    }

    public static void c(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("ad_preferences", a()).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static int d(Context context, String str) {
        return context.getSharedPreferences("ad_preferences", a()).getInt(str + "_weekday", 0);
    }

    public static String d(Context context) {
        return context.getSharedPreferences("ad_preferences", a()).getString("placeid_json", "");
    }

    public static int e(Context context, String str) {
        return context.getSharedPreferences("ad_preferences", a()).getInt(str + "_times", 0);
    }

    public static String e(Context context) {
        return context.getSharedPreferences("ad_preferences", a()).getString("app_channel", "");
    }

    public static void f(Context context, String str) {
        Editor edit = context.getSharedPreferences("ad_preferences", a()).edit();
        edit.putString("app_channel", str);
        edit.commit();
    }

    public static boolean f(Context context) {
        return context.getSharedPreferences("ad_preferences", a()).getBoolean("app_debug", false);
    }

    public static String g(Context context) {
        return context.getSharedPreferences("ad_preferences", 2).getString("madphoneimei", "");
    }

    public static String g(Context context, String str) {
        return context.getSharedPreferences("ad_preferences", a()).getString(str, "");
    }

    public static String h(Context context) {
        return context.getSharedPreferences("ad_preferences", a()).getString("device_mac", "");
    }

    public static void h(Context context, String str) {
        Editor edit = context.getSharedPreferences("ad_preferences", 2).edit();
        edit.putString("madphoneimei", str);
        edit.commit();
    }

    public static void i(Context context, String str) {
        context.getSharedPreferences("ad_preferences", a()).edit().putString("device_mac", str).commit();
    }
}
