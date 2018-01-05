package com.vlocker.msg;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.moxiu.b.d.c;
import com.vlocker.b.i;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.battery.clean.y;
import com.vlocker.locker.R;
import com.vlocker.m.a;
import com.vlocker.m.aj;
import com.vlocker.new_theme.activity.ThemeMainActivity;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.activity.LocationThemeActivity;
import com.vlocker.theme.activity.ThemeDetailActivity;
import com.vlocker.theme.f.e;
import com.vlocker.update.UpdateApkParamBean;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ao {
    public static a a;

    public static Intent a() {
        return new Intent();
    }

    public static Intent a(Context context) {
        Intent intent = new Intent();
        if (!e.c(context)) {
            return new Intent(context, LocationThemeActivity.class);
        }
        intent = new Intent(context, ThemeMainActivity.class);
        intent.putExtra("tag", "digest");
        return intent;
    }

    public static Intent a(Context context, String str) {
        Intent intent = new Intent(context, FlowWebViewActivity.class);
        intent.putExtra("url", str);
        return intent;
    }

    public static Intent a(String str) {
        HashMap hashMap = new HashMap();
        PackageManager packageManager = null == null ? MoSecurityApplication.a().getPackageManager() : null;
        if (hashMap.containsKey(str)) {
            return (Intent) hashMap.get(str);
        }
        try {
            Intent intent;
            if (str.equals("com.android.phone") || str.equals("com.android.server.telecom")) {
                intent = new Intent();
                if (VERSION.SDK_INT >= 20) {
                    intent.setAction("android.intent.action.DIAL");
                } else {
                    intent.setAction("android.intent.action.CALL_BUTTON");
                }
                intent.addFlags(268435456);
            } else if (str.equals("com.android.mms") || str.equals("com.google.android.apps.messaging")) {
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setType("vnd.android-dir/mms-sms");
                intent.addFlags(268435456);
            } else {
                intent = packageManager.getLaunchIntentForPackage(str);
                intent.addFlags(268435456);
            }
            synchronized (hashMap) {
                hashMap.put(str, intent);
            }
            return intent;
        } catch (Exception e) {
            return null;
        }
    }

    private static Intent a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            try {
                return a(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (str3 == null || TextUtils.isEmpty(str3)) {
            r1 = new Intent("android.intent.action.VIEW");
            r1.setComponent(new ComponentName(str, str2));
            r1.setFlags(268435456);
            return r1;
        } else if (TextUtils.isEmpty(str3)) {
            return null;
        } else {
            r1 = new Intent("android.intent.action.VIEW");
            r1.setComponent(new ComponentName(str, str2));
            r1.setData(Uri.parse(str3));
            r1.setFlags(268435456);
            return r1;
        }
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        try {
            str2 = jSONObject.getString(str);
        } catch (Exception e) {
        }
        return str2;
    }

    public static void a(Context context, String str, String str2) {
        try {
            com.alimama.ad.mobile.b.a aVar = new com.alimama.ad.mobile.b.a();
            aVar.a("login", 2);
            aVar.a("url", str);
            aVar.a("appContext", (Object) context);
            if (str2 != null && str2.equals("banner")) {
                aVar.a("backUrl", "sh://vlocker.setting");
            }
            com.alimama.ad.mobile.a.a().b(aVar);
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (e.b(context).booleanValue()) {
            UpdateApkParamBean updateApkParamBean = new UpdateApkParamBean();
            updateApkParamBean.c(str);
            updateApkParamBean.b(true);
            updateApkParamBean.f(str2);
            updateApkParamBean.g(i.g);
            updateApkParamBean.e(101);
            updateApkParamBean.i(str3);
            updateApkParamBean.h(context.getResources().getString(R.string.vlocker_domestic_launcher_name) + context.getResources().getString(R.string.vlocker_update_downloadapk_notificationtitle));
            updateApkParamBean.d((int) R.drawable.t_market_domestic_launcher_download_notification_logo);
            try {
                String h = updateApkParamBean.h();
                File file = new File(i.g + updateApkParamBean.h() + ".apk");
                if (aj.a(h)) {
                    PackageManager packageManager = context.getPackageManager();
                    Intent intent = new Intent();
                    context.startActivity(packageManager.getLaunchIntentForPackage(h));
                } else if (file.exists()) {
                    com.vlocker.update.a.a(context, file);
                } else {
                    new com.vlocker.e.e(context).a(updateApkParamBean);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        UpdateApkParamBean updateApkParamBean = new UpdateApkParamBean();
        updateApkParamBean.n(str5);
        updateApkParamBean.c(str);
        updateApkParamBean.d(str2);
        updateApkParamBean.b(false);
        updateApkParamBean.f(str3);
        updateApkParamBean.g(i.g);
        updateApkParamBean.e(101);
        updateApkParamBean.i(str4);
        updateApkParamBean.h(str4);
        updateApkParamBean.d((int) R.drawable.l_down_msg_icon);
        try {
            String h = updateApkParamBean.h();
            File file = new File(i.g + updateApkParamBean.h() + ".apk");
            if (!TextUtils.isEmpty(h) && c.c(context, h)) {
                Toast.makeText(context, context.getString(R.string.vlocker_update_apk_installed), 2000).show();
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent();
                context.startActivity(packageManager.getLaunchIntentForPackage(h));
            } else if (file.exists()) {
                Toast.makeText(context, context.getString(R.string.vlocker_update_install), 2000).show();
                com.vlocker.update.a.a(context, file);
            } else {
                new com.vlocker.e.e(context).a(updateApkParamBean);
            }
        } catch (Exception e) {
        }
    }

    public static void a(a aVar) {
        a = aVar;
    }

    public static void b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a = a(jSONObject, "package", null);
            if (a == null || a.trim().equals("")) {
                a = context.getPackageName();
            }
            String a2 = a(jSONObject, "activity", null);
            String a3 = a(jSONObject, "uri", null);
            if ("com.moxiu.launcher".equals(a) && a2.equals("com.moxiu.launcher.manager.activity.Theme_OnlineDetail")) {
                if (!j.a(context, "com.moxiu.launcher") || aj.b(context, "com.moxiu.launcher") <= 454 || MoSecurityApplication.a) {
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent();
                    intent.setClass(context, ThemeDetailActivity.class);
                    bundle.putInt("position", 5);
                    bundle.putString("tag", "locktheme");
                    intent.putExtras(bundle);
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                context.startActivity(a(a, a2, a3));
            } else if (!aj.a(a)) {
                a2 = a(jSONObject, "downurl", null);
                if (a2 != null && e.b(context).booleanValue()) {
                    String a4 = a(jSONObject, "name", null);
                    if (a4 == null) {
                        a4 = " ";
                    }
                    a(context, a2, a, a4);
                }
            } else if (a2 == null || a2.trim().equals("")) {
                context.startActivity(a(a));
            } else {
                context.startActivity(a(a, a2, a3));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        UpdateApkParamBean updateApkParamBean = new UpdateApkParamBean();
        updateApkParamBean.n("clean_app");
        updateApkParamBean.c(str);
        updateApkParamBean.b(false);
        updateApkParamBean.f(str3);
        updateApkParamBean.g(i.g);
        updateApkParamBean.e(109);
        updateApkParamBean.i(str2);
        updateApkParamBean.h(str2);
        updateApkParamBean.d((int) R.drawable.l_down_msg_icon);
        int cs = com.vlocker.c.a.a(context).cs();
        try {
            File file = new File(i.g + str3 + ".apk");
            if (!TextUtils.isEmpty(str2) && c.c(context, str2)) {
                Toast.makeText(context, context.getString(R.string.vlocker_update_apk_installed), 2000).show();
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str2));
                p.a(MoSecurityApplication.a(), "Vlocker_Click_Ad_SavePower_PPC_RR", "type", "open", "from", y.a().h(), "times", cs + "");
            } else if (file.exists()) {
                Toast.makeText(context, context.getString(R.string.vlocker_update_install), 2000).show();
                com.vlocker.update.a.a(context, file);
                p.a(MoSecurityApplication.a(), "Vlocker_Click_Ad_SavePower_PPC_RR", "type", "download", "from", y.a().h(), "times", cs + "");
                p.a(MoSecurityApplication.a(), "Vlocker_Install_Ad_SavePower_PPC_RR", "package", "done", "from", y.a().h(), "times", cs + "");
            } else {
                new com.vlocker.e.e(context).a(updateApkParamBean);
                p.a(MoSecurityApplication.a(), "Vlocker_Click_Ad_SavePower_PPC_RR", "type", "download", "from", y.a().h(), "times", cs + "");
            }
        } catch (Exception e) {
        }
    }

    public static Intent c(Context context, String str) {
        Intent intent = new Intent();
        String str2 = "";
        str2 = "";
        try {
            str2 = "http://mobile.moxiu.com/json.php?do=Theme.Show&id=" + a(new JSONObject(str).getJSONObject("theme"), "id", null);
            Bundle bundle = new Bundle();
            Intent intent2 = new Intent();
            intent2.setClass(context, ThemeDetailActivity.class);
            bundle.putString("tag", "push");
            bundle.putString("url", str2);
            bundle.putInt("position", 1);
            intent2.putExtras(bundle);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return intent;
    }

    public static void d(Context context, String str) {
        Intent a = a(context.getPackageName());
        a.putExtra("type", "update");
        a.putExtra("ComplexMsg", str);
        context.startActivity(a);
    }

    public static void e(Context context, String str) {
        com.vlocker.weather.e.j.b(context, str);
    }
}
