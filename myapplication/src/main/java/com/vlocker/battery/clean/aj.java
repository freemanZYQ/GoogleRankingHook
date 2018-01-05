package com.vlocker.battery.clean;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.security.MoSecurityApplication;
import java.util.ArrayList;
import java.util.List;

public class aj {
    private static final String[] a = new String[]{"com.android", "vlocker", "moxiu", WXApp.WXAPP_PACKAGE_NAME, "com.tencent.mobileqq", "com.sohu.inputmethod.sogou", "com.iflytek.inputmethod", "com.baidu.input", "com.google.android.inputmethod.pinyin", "com.cootek.smartinputv5"};

    public static List a() {
        return VERSION.SDK_INT >= 21 ? b() : c();
    }

    public static void a(List list) {
        ActivityManager activityManager = (ActivityManager) MoSecurityApplication.a().getSystemService("activity");
        for (int i = 0; i < list.size(); i++) {
            try {
                activityManager.killBackgroundProcesses((String) list.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(String str) {
        return (TextUtils.isEmpty(str) || c(str) || b(str)) ? false : true;
    }

    private static List b() {
        List arrayList = new ArrayList();
        List runningServices = ((ActivityManager) MoSecurityApplication.a().getSystemService("activity")).getRunningServices(30);
        for (int i = 0; i < runningServices.size(); i++) {
            String packageName = ((RunningServiceInfo) runningServices.get(i)).service.getPackageName();
            if (a(packageName) && !arrayList.contains(packageName)) {
                arrayList.add(packageName);
            }
        }
        return arrayList;
    }

    private static boolean b(String str) {
        for (CharSequence contains : a) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    private static List c() {
        List arrayList = new ArrayList();
        List runningAppProcesses = ((ActivityManager) MoSecurityApplication.a().getSystemService("activity")).getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            String[] strArr = ((RunningAppProcessInfo) runningAppProcesses.get(i)).pkgList;
            String str = "";
            for (String str2 : strArr) {
            }
            if (a(str) && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static boolean c(String str) {
        try {
            return (MoSecurityApplication.a().getPackageManager().getPackageInfo(str, 0).applicationInfo.flags & 1) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
