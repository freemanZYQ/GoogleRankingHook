package com.vlocker.msg;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.SettingService;

public class an {
    private static boolean a;

    public static Intent a() {
        return VERSION.SDK_INT >= 18 ? new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS") : new Intent("android.settings.ACCESSIBILITY_SETTINGS");
    }

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(Context context) {
        int i = VERSION.SDK_INT;
        String str = Build.MODEL;
        return (str == null || !str.toLowerCase().contains("vivo y11")) ? Build.MANUFACTURER == null || !Build.MANUFACTURER.toLowerCase().contains("gionee") || i > 18 : false;
    }

    public static boolean b(Context context) {
        int i = VERSION.SDK_INT;
        return (i < 18 || (MoSecurityApplication.e && !SettingService.b(context))) ? i >= 14 : d(context);
    }

    public static boolean c(Context context) {
        return VERSION.SDK_INT >= 18 ? d(context) : false;
    }

    private static boolean d(Context context) {
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
}
