package com.vlocker.theme.f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;

public class b {
    public static boolean A() {
        try {
            return Build.class.getMethod("hasSmartBar", new Class[0]) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean B() {
        try {
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            if (str != null && str.toLowerCase().equals("oppo") && str2 != null && str2.toLowerCase().contains("r7")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean C() {
        try {
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            if (str != null && str.toLowerCase().equals("iuni") && str2 != null && str2.toLowerCase().contains("n1")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean D() {
        return !TextUtils.isEmpty(com.vlocker.setting.a.b.getPropertyByName("ro.miui.ui.version.name"));
    }

    public static boolean E() {
        try {
            return com.vlocker.setting.a.b.getPropertyByName("ro.build.user").toLowerCase().equals("letv");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean F() {
        try {
            if (!com.vlocker.setting.a.b.getPropertyByName("ro.vivo.os.name").toLowerCase().startsWith("funtouch")) {
                return false;
            }
            String str = SystemProperties.get("ro.vivo.os.version");
            long versionCodeByString = com.vlocker.setting.a.b.getVersionCodeByString("3.0");
            return versionCodeByString != -1 && com.vlocker.setting.a.b.getVersionCodeByString(str) >= versionCodeByString;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean G() {
        try {
            return com.vlocker.setting.a.b.getPropertyByName("ro.build.uiversion").toLowerCase().startsWith("360ui");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a() {
        return "samsung".equals(Build.MANUFACTURER);
    }

    public static boolean a(Context context) {
        return com.vlocker.setting.a.b.hasClassInApk(context, "com.oppo.safe", "com.oppo.safe.permission.floatwindow.FloatWindowListActivity") || com.vlocker.setting.a.b.hasClassInApk(context, "com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
    }

    public static boolean a(Context context, int i) {
        if (VERSION.SDK_INT >= 19) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                try {
                    return ((Integer) appOpsManager.getClass().getMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
            }
        }
        return false;
    }

    public static boolean b() {
        return "vivo".equals(Build.MANUFACTURER);
    }

    public static boolean c() {
        try {
            if (!com.vlocker.setting.a.b.getPropertyByName("ro.vivo.os.name").toLowerCase().startsWith("funtouch")) {
                return false;
            }
            String str = SystemProperties.get("ro.vivo.os.version");
            long versionCodeByString = com.vlocker.setting.a.b.getVersionCodeByString("2.5");
            long versionCodeByString2 = com.vlocker.setting.a.b.getVersionCodeByString("3.0");
            if (versionCodeByString == -1) {
                return false;
            }
            long versionCodeByString3 = com.vlocker.setting.a.b.getVersionCodeByString(str);
            return versionCodeByString3 >= versionCodeByString && versionCodeByString3 < versionCodeByString2;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean d() {
        try {
            String trim = SystemProperties.get("ro.build.version.emui", "unkonw").trim();
            if (trim == null || trim.equals("unkonw")) {
                return false;
            }
            int indexOf = trim.indexOf(95);
            if (indexOf == -1) {
                return false;
            }
            trim = trim.substring(indexOf + 1, trim.length());
            Log.i("kevint", trim + ", index = " + indexOf);
            return ((double) Float.parseFloat(trim)) >= 2.0d;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean e() {
        return Build.BRAND.toLowerCase().contains("meizu");
    }

    public static boolean f() {
        String toLowerCase = Build.BRAND.toLowerCase();
        String toLowerCase2 = Build.MODEL.toLowerCase();
        String toLowerCase3 = Build.DEVICE.toLowerCase();
        return toLowerCase.contains("meizu") && (toLowerCase2.contains("m578") || toLowerCase2.contains("m2") || toLowerCase3.contains("m578") || toLowerCase3.contains("m2"));
    }

    public static boolean g() {
        return Build.DISPLAY.contains("Flyme OS 4");
    }

    public static boolean h() {
        return Build.DISPLAY.toLowerCase().contains("flyme 5");
    }

    public static boolean i() {
        return Build.DISPLAY.toLowerCase().contains("flyme 6");
    }

    public static boolean j() {
        String str = Build.DEVICE;
        return str != null && (str.toLowerCase().contains("mx3".toLowerCase()) || str.toLowerCase().contains("mx4".toLowerCase()));
    }

    public static boolean k() {
        String str = Build.DISPLAY;
        if (str != null && str.toUpperCase().contains("MIUI")) {
            return true;
        }
        str = Build.MODEL;
        if (str != null && str.contains("MI-ONE")) {
            return true;
        }
        str = Build.DEVICE;
        if (str != null && str.contains("mione")) {
            return true;
        }
        str = Build.MANUFACTURER;
        if (str != null && str.equalsIgnoreCase("Xiaomi")) {
            return true;
        }
        str = Build.PRODUCT;
        return (str != null && str.contains("mione")) || u();
    }

    public static boolean l() {
        try {
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            if (str != null && str.toLowerCase().equals("huawei") && str2 != null && str2.toLowerCase().contains("p6")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean m() {
        String str = "v1.0";
        try {
            str = SystemProperties.get("ro.build.version.opporom");
            if (str != null && str.toLowerCase().contains("v2.".toLowerCase())) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean n() {
        String str = "v1.0";
        try {
            str = SystemProperties.get("ro.build.version.opporom");
            long versionCodeByString = com.vlocker.setting.a.b.getVersionCodeByString("3.0.0");
            return versionCodeByString != -1 && com.vlocker.setting.a.b.getVersionCodeByString(str) >= versionCodeByString;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean o() {
        String str = "v1.0";
        try {
            str = SystemProperties.get("ro.build.version.opporom");
            if (str != null && str.toLowerCase().contains("3.0.0".toLowerCase())) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean p() {
        String str = "v1.0";
        try {
            if (!TextUtils.isEmpty(SystemProperties.get("ro.build.version.opporom"))) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean q() {
        try {
            String str = SystemProperties.get("ro.sys.vendor");
            if (str != null && str.toLowerCase().contains("yunos")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean r() {
        return SystemProperties.get("ro.miui.ui.version.name", "unkonw").equalsIgnoreCase("V7");
    }

    public static boolean s() {
        return SystemProperties.get("ro.miui.ui.version.name", "unkonw").equalsIgnoreCase("V8");
    }

    public static boolean t() {
        return SystemProperties.get("ro.miui.ui.version.name", "unkonw").equalsIgnoreCase("V6");
    }

    public static boolean u() {
        String str = SystemProperties.get("ro.miui.ui.version.name", "unkonw");
        return str.equalsIgnoreCase("V5") || str.equalsIgnoreCase("V6") || str.equalsIgnoreCase("V7") || str.equalsIgnoreCase("V8");
    }

    public static boolean v() {
        try {
            if (Build.MANUFACTURER.toLowerCase().contains("huawei") || Build.BRAND.toLowerCase().contains("huawei") || Build.MODEL.toLowerCase().contains("huawei")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean w() {
        try {
            return Build.MANUFACTURER.toLowerCase().contains("gionee");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean x() {
        try {
            return com.vlocker.setting.a.b.getPropertyByName("ro.build.nubia.rom.name").equals("nubiaUI");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean y() {
        try {
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            if (str != null && str.toLowerCase().equals("gionee") && str2 != null && str2.toLowerCase().contains("f103")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean z() {
        try {
            String str = Build.BRAND;
            String str2 = Build.MODEL;
            if (str != null && str.toLowerCase().equals("huawei") && str2 != null && str2.toLowerCase().contains("h30-c00")) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
