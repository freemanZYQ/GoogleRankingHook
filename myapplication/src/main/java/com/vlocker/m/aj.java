package com.vlocker.m;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.vlocker.security.MoSecurityApplication;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aj {
    public static ArrayList a(Context context, String str) {
        int i = 0;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (queryIntentActivities == null) {
            return null;
        }
        int size = queryIntentActivities.size();
        if (size <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (i < size) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            arrayList.add(resolveInfo.activityInfo.applicationInfo.packageName + "/" + resolveInfo.activityInfo.name);
            i++;
        }
        return arrayList;
    }

    public static List a(int i) {
        if (i < 1) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) MoSecurityApplication.a().getApplicationContext().getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        List runningTasks;
        try {
            runningTasks = activityManager.getRunningTasks(i);
        } catch (SecurityException e) {
            runningTasks = null;
        } catch (NullPointerException e2) {
            runningTasks = null;
        }
        if (runningTasks == null || runningTasks.size() <= 0) {
            return null;
        }
        List arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            if (i2 + 1 <= runningTasks.size() && runningTasks.get(i2) != null) {
                arrayList.add(((RunningTaskInfo) runningTasks.get(i2)).topActivity);
            }
            i2++;
        }
        return arrayList;
    }

    public static boolean a(String str) {
        return b(str) != null;
    }

    public static boolean a(String str, int i) {
        if (i <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        if (VERSION.SDK_INT >= 21 && bb.a(MoSecurityApplication.a())) {
            try {
                if (bb.b(MoSecurityApplication.a()).contains(str)) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        List a = a(i);
        if (a == null || a.size() <= 0) {
            return false;
        }
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ComponentName componentName = (ComponentName) a.get(i2);
            if (componentName != null && str.equals(componentName.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static String[] a(ActivityManager activityManager) {
        Set<String> hashSet = new HashSet();
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100) {
                    hashSet.addAll(Arrays.asList(runningAppProcessInfo.pkgList));
                }
            }
        } catch (Exception e) {
        }
        for (String toLowerCase : hashSet) {
            toLowerCase.toLowerCase();
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static int b(Context context, String str) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static ApplicationInfo b(String str) {
        ApplicationInfo applicationInfo = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = MoSecurityApplication.a().getApplicationContext().getPackageManager().getPackageInfo(str, 0);
                if (packageInfo != null) {
                    applicationInfo = packageInfo.applicationInfo;
                }
            } catch (Exception e) {
            }
        }
        return applicationInfo;
    }

    public static String[] b(ActivityManager activityManager) {
        Set hashSet = new HashSet();
        List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        Field declaredField = RunningAppProcessInfo.class.getDeclaredField("processState");
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100) {
                Integer num = null;
                try {
                    num = Integer.valueOf(declaredField.getInt(runningAppProcessInfo));
                } catch (Exception e) {
                }
                if (num != null) {
                    if (num.intValue() == 2) {
                        hashSet.addAll(Arrays.asList(runningAppProcessInfo.pkgList));
                        break;
                    }
                }
                try {
                    hashSet.addAll(Arrays.asList(runningAppProcessInfo.pkgList));
                } catch (Exception e2) {
                }
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static int c(Context context, String str) {
        int i = -1;
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 262144) != 0 ? 1 : 0;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }
}
