package net.luna.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.view.Window;

import net.luna.common.debug.LunaLog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by bintou on 16/4/21.
 */
public class MIUIUtils {


    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

    public static boolean isMIUI() {
        try {
            final BuildProperties prop = BuildProperties.newInstance();
            return prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null
                    || prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null
                    || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null;
        } catch (final Exception e) {
            return false;
        }
    }


    public static final int OP_SYSTEM_ALERT_WINDOW = 24;

    public static int VERSION;

    static {
        String versionName = SystemUtils.getSystemProperty("ro.miui.ui.version.name");
        if (versionName != null) {
            try {
                VERSION = ParseUtils.stringToInt(versionName.substring(1));
            } catch (Exception e) {
                e.printStackTrace();
                VERSION = 0;
            }
        } else {
            VERSION = 0;
        }
    }

    public static Intent getOpenPermissionManagerActivityIntent(@NonNull Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.MainAcitivty");
        return SystemIntentUtils.isIntentAvailable(context, intent) ? intent : null;
    }

    public static Intent getOpenPermissionActivityIntent(@NonNull Context context) {
        return getOpenPermissionActivityIntent(context, context.getPackageName());
    }

    public static Intent getOpenPermissionActivityIntent(@NonNull Context context, @NonNull String packageName) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");

        if (VERSION >= 6) {
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", packageName);
        } else if (VERSION == 5) {
            try {
                PackageInfo pInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                intent.setClassName("com.android.settings", "com.miui.securitycenter.permission.AppPermissionsEditor");
                intent.putExtra("extra_package_uid", pInfo.applicationInfo.uid);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return SystemIntentUtils.isIntentAvailable(context, intent) ? intent : null;
    }

    public static void setLauncherIconCornerMark(@NonNull Context context, int notifyId, int count) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        Notification notification = builder.build();
        try {
            Class<?> miuiNotificationClass = Class.forName("android.app.MiuiNotification");
            Object miuiNotification = miuiNotificationClass.newInstance();
            Field field = miuiNotification.getClass().getDeclaredField("messageCount");
            field.setAccessible(true);
            field.set(miuiNotification, count);
            field = notification.getClass().getField("extraNotification");
            field.set(notification, miuiNotification);
        } catch (Exception e) {
            LunaLog.e(e);
        }
        manager.notify(notifyId, notification);
    }

    @SuppressWarnings("IncompatibleBitwiseMaskOperation")
    public static boolean isFloatWindowPermissionAllowed(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return checkOp(context, OP_SYSTEM_ALERT_WINDOW);
        } else {
            return (context.getApplicationInfo().flags & 1 << 27) == 1;
        }
    }

    /**
     * {@link #checkOp(Context, int, String, int)}
     */
    public static boolean checkOp(Context context, int op) {
        return checkOp(context, op, context.getPackageName(), Binder.getCallingUid());
    }

    /**
     * 检查操作权限
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean checkOp(Context context, int op, String packageName, int uid) {
        final int version = Build.VERSION.SDK_INT;

        if (version >= Build.VERSION_CODES.KITKAT) {
            AppOpsManager manager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            try {
                return (AppOpsManager.MODE_ALLOWED == (Integer) (Reflect.on(manager).call("checkOp", op, uid, packageName).get()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LunaLog.e("Below API 19 cannot invoke!");
        }
        return false;
    }

    public static boolean setMiuiStatusBarDarkMode(Activity activity, boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}


