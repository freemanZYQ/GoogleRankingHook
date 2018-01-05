package com.vlocker.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.settings.GuideWindowActivity;
import com.vlocker.theme.f.b;

public class e {
    public static boolean a = false;

    public static void a(Context context) {
        try {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity"));
            intent.putExtra("extra_pkgname", context.getPackageName());
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, int i) {
        Intent intent;
        if (i == 1) {
            try {
                if (b.t()) {
                    a(context);
                    return;
                }
                intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 2) {
            try {
                a = false;
                if (b.t()) {
                    b(context);
                    return;
                }
                intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent.setComponent(new ComponentName("com.android.settings", "com.miui.securitycenter.permission.AppPermissionsEditor"));
                intent.putExtra("extra_package_uid", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.uid);
                context.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    a = true;
                    intent = new Intent();
                    intent.setClassName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
                    intent.putExtra("package", context.getPackageName());
                    context.startActivity(intent);
                    Toast makeText = Toast.makeText(context, R.string.auto_miui_m2_intro_message, 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                } catch (Exception e3) {
                }
            }
        } else if (i == 3) {
            try {
                context.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
    }

    public static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.securitycenter.MainActivity"));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean c(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity"));
            if (context.getPackageManager().queryIntentActivities(intent, 1).size() > 0) {
                return true;
            }
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.StartupSpeedActivity"));
            if (context.getPackageManager().queryIntentActivities(intent, 1).size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static void d(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity"));
            if (context.getPackageManager().queryIntentActivities(intent, 1).size() > 0) {
                context.startActivity(intent);
                GuideWindowActivity.a(context, 2, 1);
                return;
            }
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.StartupSpeedActivity"));
            context.startActivity(intent);
            GuideWindowActivity.a(context, 2, 2);
        } catch (Exception e) {
            Toast.makeText(context, "当前设置项不支持你的手机", 0).show();
            e.printStackTrace();
        }
    }
}
