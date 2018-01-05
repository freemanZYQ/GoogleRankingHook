package com.vlocker.setting.a;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.vlocker.security.MoSecurityApplication;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {
    private static final Pattern a = Pattern.compile("(\\d+)(\\.(\\d+))?(\\.(\\d+))?(\\.(\\d+))?");

    public static boolean CheckNotifiServiceValid(Context context) {
        Object string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        String[] split = string.split(":");
        for (String unflattenFromString : split) {
            ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
            if (unflattenFromString2 != null && unflattenFromString2.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a() {
        boolean z = true;
        if (VERSION.SDK_INT < 19) {
            return false;
        }
        String propertyByName = getPropertyByName("ro.build.version.incremental");
        if (TextUtils.isEmpty(propertyByName)) {
            return false;
        }
        if (propertyByName.startsWith("KXDCNB") || propertyByName.startsWith("KHHCNB")) {
            return true;
        }
        if (propertyByName.startsWith("JLB")) {
            return false;
        }
        if (getVersionCodeByString(propertyByName) <= getVersionCodeByString("4.5.8")) {
            z = false;
        }
        return z;
    }

    public static boolean checkFloatWindowAllowShow(Context context, e eVar) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        if (MoSecurityApplication.e) {
            eVar.onResult(false);
            return true;
        }
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2003;
        layoutParams.flags = 16;
        layoutParams.width = 0;
        layoutParams.height = 0;
        Handler handler = new Handler();
        View cVar = new c(context, handler, windowManager, eVar);
        windowManager.addView(cVar, layoutParams);
        handler.postDelayed(new d(windowManager, cVar, handler, eVar), 100);
        return true;
    }

    public static final String getPropertyByName(String str) {
        return SystemProperties.get(str, "");
    }

    public static final long getVersionCodeByString(String str) {
        long j = -1;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            Matcher matcher = a.matcher(str);
            if (matcher.find()) {
                j = 0;
                for (int i = 0; i * 2 < matcher.groupCount(); i++) {
                    String group = matcher.group((i * 2) + 1);
                    if (group != null) {
                        j |= Long.parseLong(group) << ((3 - i) * 16);
                    }
                }
            }
        }
        return j;
    }

    public static final boolean hasClassInApk(Context context, String str, String str2) {
        boolean z = false;
        try {
            Context createPackageContext = context.createPackageContext(str, 3);
            if (createPackageContext != null) {
                Class loadClass = createPackageContext.getClassLoader().loadClass(str2);
                if (loadClass != null) {
                    z = true;
                }
                Log.e(b.class.getSimpleName(), loadClass.getName());
            }
        } catch (Exception e) {
            Log.e(b.class.getSimpleName(), e.toString());
        }
        return z;
    }

    @TargetApi(19)
    public static boolean isFloatWindowOpen(Context context) {
        boolean z = true;
        if (VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                return ((Integer) appOpsManager.getClass().getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if ((context.getApplicationInfo().flags & 134217728) == 0) {
            z = false;
        }
        return z;
    }

    public static boolean isOpenForV5(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo;
            int i = 134217728;
            if (a()) {
                i = 33554432;
            }
            return (i & applicationInfo.flags) != 0;
        } catch (NameNotFoundException e) {
            Log.e(b.class.getSimpleName(), e.toString());
            return false;
        }
    }

    public static final boolean isPackageNameUninstalled(Context context, String str) {
        return isPackageNameUninstalled(context.getPackageManager(), str);
    }

    public static final boolean isPackageNameUninstalled(PackageManager packageManager, String str) {
        try {
            packageManager.getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            Log.e(b.class.getSimpleName(), e.toString());
            return false;
        }
    }

    public static boolean validateIntent(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentActivities(intent, 1).size() > 0;
    }
}
