package com.vlocker.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;

public class i {
    public static long a() {
        return MoSecurityApplication.a().getSharedPreferences("ALauncher_settings", 0).getLong("updatetime", 0);
    }

    public static String a(Context context) {
        return b(context).getString("mx_launcher_domestic_md5", "");
    }

    public static void a(long j) {
        MoSecurityApplication.a().getSharedPreferences("ALauncher_settings", 0).edit().putLong("updatetime", j).commit();
    }

    public static void a(Context context, UpdateApkParamBean updateApkParamBean) {
        c(context).putInt("update_service_ver", updateApkParamBean.a()).putString("version_name", updateApkParamBean.q()).putString("update_service_notification", updateApkParamBean.b()).putString("update_service_url", updateApkParamBean.d()).putInt("update_service_type", updateApkParamBean.f()).putBoolean("three_market_update", updateApkParamBean.g()).putString("third_market_list", updateApkParamBean.p()).putString("parm_uptate_md5", updateApkParamBean.c()).commit();
    }

    public static void a(Context context, String str) {
        Editor edit = b(context).edit();
        edit.putString("mx_launcher_domestic_md5", str);
        edit.commit();
    }

    public static void a(Context context, boolean z) {
        int i = 1;
        if (!z) {
            i = 0;
        }
        context.getSharedPreferences("ALauncher_settings", 0).edit().putInt("wifiStateAutoDW", i).commit();
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("ALauncher_settings", 0);
    }

    public static boolean b() {
        return System.currentTimeMillis() - a() >= 86400000;
    }

    public static Editor c(Context context) {
        return context.getSharedPreferences("ALauncher_settings", 0).edit();
    }

    public static UpdateApkParamBean d(Context context) {
        UpdateApkParamBean updateApkParamBean = new UpdateApkParamBean();
        SharedPreferences sharedPreferences = context.getSharedPreferences("ALauncher_settings", 0);
        updateApkParamBean.a(sharedPreferences.getInt("update_service_ver", 0));
        updateApkParamBean.p(sharedPreferences.getString("version_name", ""));
        updateApkParamBean.a(sharedPreferences.getString("update_service_notification", ""));
        updateApkParamBean.c(sharedPreferences.getString("update_service_url", ""));
        updateApkParamBean.c(sharedPreferences.getInt("update_service_type", 0));
        updateApkParamBean.a(sharedPreferences.getBoolean("three_market_update", false));
        updateApkParamBean.o(sharedPreferences.getString("third_market_list", ""));
        updateApkParamBean.b(sharedPreferences.getString("parm_uptate_md5", ""));
        return updateApkParamBean;
    }

    public static Boolean e(Context context) {
        String str = (String) context.getResources().getText(R.string.t_market_theme_manager_child);
        return (str.equals("B-lenovo") || str.equals("A-google")) ? Boolean.valueOf(true) : Boolean.valueOf(false);
    }
}
