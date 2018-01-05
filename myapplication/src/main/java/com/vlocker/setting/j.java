package com.vlocker.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.msg.McmPushWidget;
import com.vlocker.msg.ak;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.a.a.e;
import com.vlocker.setting.a.b;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    public static boolean a() {
        return System.currentTimeMillis() - a.a(MoSecurityApplication.a()).M() < 86400000;
    }

    public static boolean a(Context context) {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        try {
            intent.addFlags(268468224);
            return b.validateIntent(context.getPackageManager(), intent);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean b() {
        return System.currentTimeMillis() - a.a(MoSecurityApplication.a()).cu() > 10800000;
    }

    public static boolean b(Context context) {
        boolean z = true;
        if (VERSION.SDK_INT < 16 || !OneKeySettingActivity.b || com.vlocker.setting.a.a.getInstance().isEmpty() || a.a(MoSecurityApplication.a()).y()) {
            return false;
        }
        if (a(context)) {
            if (!a()) {
                z = c(context);
            } else if (a.a(MoSecurityApplication.a()).bq()) {
                if (b()) {
                    d(context);
                    a.a(MoSecurityApplication.a()).n(System.currentTimeMillis());
                }
            } else if (!a.a(MoSecurityApplication.a()).y() && c()) {
                e(context);
                a.a(MoSecurityApplication.a()).V(new Date().getDate());
            }
            return z;
        }
        z = false;
        return z;
    }

    public static boolean c() {
        return a.a(MoSecurityApplication.a().getApplicationContext()).cv() != new Date().getDate();
    }

    public static boolean c(Context context) {
        if (a.a(MoSecurityApplication.a()).bq()) {
            if (c()) {
                d(context);
                a.a(MoSecurityApplication.a()).V(new Date().getDate());
                return true;
            }
        } else if (!a.a(MoSecurityApplication.a()).y() && c()) {
            e(context);
            a.a(MoSecurityApplication.a()).V(new Date().getDate());
            return true;
        }
        return false;
    }

    public static void d(Context context) {
        ak akVar = new ak();
        akVar.c = "锁屏完整服务未开启";
        akVar.e = "点击或右划均可开启";
        akVar.b = McmPushWidget.getInstance(context).getSpecialPackage(context, -1, 121);
        akVar.C = 11;
        akVar.F = -1;
        Intent intent = new Intent(MoSecurityApplication.a(), OneKeySettingActivity.class);
        intent.putExtra("from", "from_locker");
        akVar.m = intent;
        akVar.k = BitmapFactory.decodeResource(context.getResources(), R.drawable.repaire_msg_icon);
        akVar.g = System.currentTimeMillis();
        akVar.E = false;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("className", "com.vlocker.setting.OneKeySettingActivity");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", "from");
            jSONObject2.put("value", e.ACTION_MAIN);
            jSONObject2.put("type", "String");
            jSONArray.put(jSONObject2);
            jSONObject.put("extras", jSONArray);
            akVar.D = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        McmPushWidget.getInstance(context).sendVlickerNotification(context, akVar, "");
    }

    public static void e(Context context) {
        ak akVar = new ak();
        akVar.c = "手机发现新风险";
        akVar.e = "点击或右划均可开启";
        akVar.b = McmPushWidget.getInstance(context).getSpecialPackage(context, -1, 122);
        akVar.C = 11;
        akVar.F = -1;
        Intent intent = com.vlocker.setting.a.a.getInstance().isFailedTaskAllOpen() ? new Intent(MoSecurityApplication.a(), ManualRepairActivity.class) : new Intent(MoSecurityApplication.a(), OneKeySettingActivity.class);
        intent.putExtra("from", "from_locker");
        akVar.m = intent;
        akVar.k = BitmapFactory.decodeResource(context.getResources(), R.drawable.repaire_msg_icon);
        akVar.g = System.currentTimeMillis();
        akVar.E = false;
        try {
            JSONObject jSONObject = new JSONObject();
            if (com.vlocker.setting.a.a.getInstance().isFailedTaskAllOpen()) {
                jSONObject.put("className", "com.vlocker.setting.OneKeySettingActivity");
            } else {
                jSONObject.put("className", "com.vlocker.setting.ManualRepairActivity");
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", "from");
            jSONObject2.put("value", e.ACTION_MAIN);
            jSONObject2.put("type", "String");
            jSONArray.put(jSONObject2);
            jSONObject.put("extras", jSONArray);
            akVar.D = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        McmPushWidget.getInstance(context).sendVlickerNotification(context, akVar, "");
    }
}
