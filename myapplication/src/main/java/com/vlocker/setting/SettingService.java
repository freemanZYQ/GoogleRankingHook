package com.vlocker.setting;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.a.a;
import com.vlocker.setting.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(16)
public final class SettingService extends AccessibilityService {
    private static Map a = null;
    private static Map b = null;
    private static SettingService c = null;

    public SettingService() {
        c = this;
    }

    private final AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        int i = 0;
        while (accessibilityNodeInfo2 == null && i < accessibilityNodeInfo.getChildCount()) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child == null) {
                child = accessibilityNodeInfo2;
            } else if (child.getText() == null || !list.contains(child.getText().toString())) {
                child = a(child, list);
            } else {
                Log.d(getClass().getSimpleName(), child.getClassName().toString());
            }
            i++;
            accessibilityNodeInfo2 = child;
        }
        return accessibilityNodeInfo2;
    }

    public static final SettingService a() {
        return c;
    }

    public static final String a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        String str = (accessibilityNodeInfo.getPackageName().toString() + "1" + b(accessibilityNodeInfo) + c(accessibilityNodeInfo)) + a(accessibilityNodeInfo, 2);
        Log.d("accessibility", str);
        return str;
    }

    private static final String a(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        String str = "";
        int i2 = 0;
        while (accessibilityNodeInfo != null && i2 < accessibilityNodeInfo.getChildCount()) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2);
            if (child != null) {
                str = str + i + b(child) + c(child);
                if (child.getChildCount() > 0) {
                    str = str + a(child, i + 1);
                }
            }
            i2++;
        }
        return str;
    }

    public static final boolean a(Context context) {
        boolean z = true;
        boolean z2 = VERSION.SDK_INT >= 16;
        if (z2) {
            if (context.getPackageManager().queryIntentActivities(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 1).size() <= 0) {
                z = false;
            }
            if (MoSecurityApplication.e && "3.1.0".equals(b.getPropertyByName("ro.yunos.version"))) {
                return false;
            }
        }
        z = z2;
        return z;
    }

    private static final boolean a(Context context, Intent intent) {
        try {
            intent.addFlags(268468224);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static final String b(AccessibilityNodeInfo accessibilityNodeInfo) {
        String str = "";
        if (a == null) {
            a = new HashMap();
            String[] split = "Button#B,CheckBox#C,CompoundButton#c,CheckedTextView#CT,FrameLayout#F,ImageView#I,ImageButton#i,LinearLayout#L,ListView#l,RelativeLayout#R,ScrollView#S,Switch#s,TextView#T,ToggleButton#t,View#V,ViewPager#v".split(",");
            for (String split2 : split) {
                String[] split3 = split2.split("#");
                a.put(split3[0], split3[1]);
            }
        }
        if (accessibilityNodeInfo.getClassName() == null) {
            return str;
        }
        String charSequence = accessibilityNodeInfo.getClassName().toString();
        int lastIndexOf = charSequence.lastIndexOf(".");
        charSequence = lastIndexOf != -1 ? charSequence.substring(lastIndexOf + 1, charSequence.length()) : str;
        return a.containsKey(charSequence) ? (String) a.get(charSequence) : charSequence;
    }

    public static boolean b() {
        String propertyByName = b.getPropertyByName("ro.build.display.id");
        if (propertyByName != null && propertyByName.startsWith("Flyme")) {
            if ("PRO 6".equals(Build.MODEL)) {
                if (b.getVersionCodeByString(propertyByName) > b.getVersionCodeByString("Flyme 5.2.1.0")) {
                    return true;
                }
            } else if (propertyByName.endsWith("beta")) {
                if (b.getVersionCodeByString(propertyByName) >= b.getVersionCodeByString("Flyme 5.6.6.7 beta")) {
                    return true;
                }
            } else if (b.getVersionCodeByString(propertyByName) >= b.getVersionCodeByString("Flyme 5.1.7.0A")) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(Context context) {
        return (MoSecurityApplication.e && "3.1.0".equals(b.getPropertyByName("ro.yunos.version"))) ? false : true;
    }

    private static final String c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getText() != null ? accessibilityNodeInfo.getText().toString() : "";
    }

    public static final boolean c(Context context) {
        int i;
        boolean z;
        String str = context.getPackageName() + "/" + SettingService.class.getName();
        try {
            i = Secure.getInt(context.getApplicationContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e) {
            Log.e(SettingService.class.getSimpleName(), e.toString());
            i = 0;
        }
        SimpleStringSplitter simpleStringSplitter = new SimpleStringSplitter(':');
        if (i == 1) {
            String string = Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
            Log.d(SettingService.class.getSimpleName(), "settingValue=" + string);
            if (string != null) {
                simpleStringSplitter.setString(string);
                z = false;
                while (!z && simpleStringSplitter.hasNext()) {
                    z = str.equalsIgnoreCase(simpleStringSplitter.next());
                }
                if (z || c == null) {
                    return (z || c == null) ? false : true;
                } else {
                    if (z) {
                        return false;
                    }
                }
            }
        }
        z = false;
        if (z) {
        }
        if (z) {
            return false;
        }
    }

    public static void d(Context context) {
        if (OneKeySettingActivity.a() != null) {
            OneKeySettingActivity.a().a("Vlocker_Open_Rescue_Service_PPC_TF");
        }
        a instance = a.getInstance();
        if (instance == null || !(instance.hasRomReature("miui") || instance.hasRomReature("amigo2"))) {
            g(context);
        } else if (!h(context)) {
            g(context);
        }
    }

    public static int e(Context context) {
        int i = 0;
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) context.getSystemService("accessibility")).getInstalledAccessibilityServiceList();
        String str = context.getPackageName() + "/" + SettingService.class.getName();
        if (installedAccessibilityServiceList == null || installedAccessibilityServiceList.size() <= 0) {
            return 0;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
            ComponentInfo componentInfo = accessibilityServiceInfo.getResolveInfo().serviceInfo;
            accessibilityServiceInfo.getResolveInfo();
            String str2 = "";
            if (componentInfo != null) {
                Object obj = componentInfo.packageName + "/" + componentInfo.name;
            } else {
                String str3 = str2;
            }
            int i2 = i + 1;
            if (str.equals(obj)) {
                return i2;
            }
            i = i2;
        }
        return i;
    }

    public static boolean f(Context context) {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        try {
            intent.addFlags(268468224);
            return b.validateIntent(context.getPackageManager(), intent);
        } catch (Exception e) {
            return false;
        }
    }

    private static final void g(Context context) {
        if (a(context, new Intent("android.settings.ACCESSIBILITY_SETTINGS"))) {
            com.vlocker.setting.ui.b.a().c();
        } else {
            List maunalTasks = a.getInstance().getMaunalTasks(true);
            if (maunalTasks != null && maunalTasks.size() > 0) {
                ManualRepairActivity.a(context, true, "from_accessibility");
            }
        }
        p.a(context, "Vlocker_WSP_Location_Accessibility_Rescue_PPC_TF", "location", e(context) + "");
    }

    private static final boolean h(Context context) {
        return a(context, i(context));
    }

    private static final Intent i(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        String packageName = context.getPackageName();
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings"));
        intent.putExtra(":android:show_fragment_short_title", 0);
        intent.putExtra(":android:show_fragment_args", 0);
        intent.putExtra(":android:show_fragment_title", 0);
        intent.putExtra(":android:no_headers", true);
        intent.putExtra("setting:ui_options", 1);
        Bundle bundle = new Bundle();
        bundle.putString("summary", context.getString(R.string.setting_service_description));
        bundle.putString("title", context.getString(R.string.setting_service_name));
        bundle.putString("preference_key", packageName + "/" + SettingService.class.getName());
        bundle.putParcelable("component_name", new ComponentName(packageName, SettingService.class.getName()));
        bundle.putBoolean("checked", false);
        String str = "com.android.settings.accessibility.ToggleAccessibilityServicePreferenceFragment";
        if (VERSION.SDK_INT < 19 || !b.hasClassInApk(context, "com.android.settings", str)) {
            bundle.putString("disable_warning_message", "触摸“确定”会停用【微锁屏】");
            bundle.putString("enable_warning_message", "【微锁屏】会收集您键入的所有文字信息（密码除外），其中包括信用卡号等个人数据。它还会收集关于您与手机互动情况的数据。");
            bundle.putString("disable_warning_title", "要停用【微锁屏】吗？");
            bundle.putString("disable_warning_message", "要停用【微锁屏】吗？");
            bundle.putString("enable_warning_title", "要使用【微锁屏】吗？");
            bundle.putString("service_component_name", packageName + "/" + SettingService.class.getName());
            intent.putExtra(":android:show_fragment", "com.android.settings.AccessibilitySettings$ToggleAccessibilityServicePreferenceFragment");
        } else {
            intent.putExtra(":android:show_fragment", str);
        }
        intent.putExtra(":android:show_fragment_args", bundle);
        intent.addFlags(268468224);
        return intent;
    }

    public void c() {
        performGlobalAction(1);
    }

    public final void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (s.g() && accessibilityEvent != null && !accessibilityEvent.isFullScreen()) {
            AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
            if (rootInActiveWindow != null && rootInActiveWindow.equals(accessibilityEvent.getSource())) {
                List list;
                if (b == null) {
                    b = new HashMap();
                    String[] split = "android#权限请求#BACK,android#无法访问短信#BACK,android#安全警告#BACK,com.baidu.appsearch#开启桌面悬浮窗#BACK,com.baidu.appsearch#请开通权限#取消,com.baidu.appsearch#新增炫酷悬浮窗#BACK,com.baidu.appsearch#恭喜你！#BACK,com.baidu.appsearch#马上登录#BACK,com.baidu.appsearch#点击查看#BACK,com.ijinshan.kbatterydoctor#跳过#跳过,com.iqoo.secure#提示#继续,com.lbe.security#运行提醒#BACK,com.mediatek.security#安全警告#允许,com.moxiu.launcher#好，这就去#BACK,com.oppo.secure#程序加密#取消,com.oppo.secure#程序加密#BACK,com.qihoo.cleandroid_cn#立即开启#BACK,com.qihoo360.mobilesafe#重要提示#BACK,com.qihoo360.mobilesafe#360手机卫士提示#允许,com.tencent.qqpimsecure#设置来电秀#进入首页,com.tencent.qqpimsecure#更多#关闭,com.tencent.qqpimsecure#温馨提示#放弃使用,com.tencent.qqpimsecure#未开启广告拦截#BACK,com.tencent.qqpimsecure#警告#确定,com.tencent.qqpimsecure#温馨提示#取消,cn.opda.a.phonoalbumshoushou#开启强效加速#BACK".split(",");
                    for (String split2 : split) {
                        String[] split3 = split2.split("#");
                        list = (List) b.get(split3[0]);
                        if (list == null) {
                            list = new ArrayList();
                            b.put(split3[0], list);
                        }
                        list.add(split3[1]);
                    }
                }
                list = (List) b.get(rootInActiveWindow.getPackageName());
                if (list != null && a(rootInActiveWindow, list) != null) {
                    performGlobalAction(1);
                }
            }
        }
    }

    public final void onInterrupt() {
    }

    public final void onServiceConnected() {
        super.onServiceConnected();
        if (OneKeySettingActivity.a() != null) {
            performGlobalAction(1);
            OneKeySettingActivity.a((Context) this, "from_service");
            if (OneKeySettingActivity.a() != null) {
                OneKeySettingActivity.a().a("Vlocker_Success_Rescue_Service_PPC_TF");
            }
        }
    }
}
