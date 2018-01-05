package com.vlocker.setting.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.vlocker.b.p;
import com.vlocker.setting.OneKeySettingActivity;

public class a {
    public static boolean checkApkInstall(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static String getCurrentHomePackage(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            return context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName;
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean isMoxiuCurrentDefault(Context context) {
        String currentHomePackage = getCurrentHomePackage(context);
        return currentHomePackage != null && currentHomePackage.equals("com.moxiu.launcher");
    }

    public static void post(Context context) {
        if (OneKeySettingActivity.a() == null) {
            return;
        }
        if (checkApkInstall(context, "com.moxiu.launcher")) {
            String str = isMoxiuCurrentDefault(context) ? "Yes" : "No";
            p.a(context, "Vlocker_DefaultLauncher_Moxiu_PPC_TF", "launchermoxiu", str, "status", OneKeySettingActivity.d, "Pause", OneKeySettingActivity.a().b());
            return;
        }
        p.a(context, "Vlocker_DefaultLauncher_Moxiu_PPC_TF", "launchermoxiu", "notInstall", "status", OneKeySettingActivity.d, "Pause", OneKeySettingActivity.a().b());
    }
}
