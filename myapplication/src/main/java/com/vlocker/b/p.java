package com.vlocker.b;

import android.content.Context;
import android.os.Environment;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.vlocker.n.a;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.weather.a.y;
import java.io.File;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class p {
    public static String a = "AA_GDT";
    public static String b = "AA_MH";
    public static String c = "AA_SELFRUN";
    public static String d = "AA_SELFRUN_N";
    public static String e = "AA_SELFRUN_Y";
    public static String f = "AA_BAIDU";
    private static boolean g = false;
    private static v h;
    private static Runnable i = new r();

    public static String a(int i) {
        return "banner" + (i + 1);
    }

    public static String a(String str, String str2, String str3) {
        return str + "|" + str2 + "|" + str3;
    }

    public static void a() {
        a.a().removeCallbacks(i);
        h = new v(1, "", "", "", "", "", "", "", "");
        a.a().postDelayed(i, 3000);
    }

    public static void a(Context context) {
        a(context, "ad_request", "101000", "101001", "", "", "", "1013", "");
    }

    public static void a(Context context, com.vlocker.c.a aVar) {
        int ai = aVar.ai();
        int aj = aVar.aj();
        if (ai == 1 && aj == 1) {
            a(context, "Vlocker_StatusHideDisableSum_PPC_TF", new String[0]);
        }
        if (ai == 0 && aj == 1) {
            a(context, "Vlocker_StatusDisableSum_PPC_TF", new String[0]);
        }
        if (ai == 1 && aj == 0) {
            a(context, "Vlocker_StatusHideSum_PPC_TF", new String[0]);
        }
    }

    public static void a(Context context, String str) {
        a(context, "ad_request", "", "", "", "", "", str, "");
    }

    public static void a(Context context, String str, String str2) {
        a(context, "ad_click", "102000", "", "", "", str, "1012", str2);
    }

    public static void a(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, "", "", "", "", "");
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        a(context, str, str2, str3, str4, "", "", "", "");
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Thread qVar = new q(context, str, str2, str3, str4, str5, str6, str7, str8);
        qVar.setPriority(3);
        qVar.start();
    }

    public static void a(Context context, String str, String... strArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 1; i < strArr.length; i += 2) {
            linkedHashMap.put(strArr[i - 1], strArr[i]);
        }
        a(str, linkedHashMap);
    }

    public static void a(String str) {
        b("v_browse", str, "", "", "", "", "", "");
    }

    public static void a(String str, String str2) {
        b("v_browse", str, str2, "", "", "", "", "");
    }

    public static synchronized void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        synchronized (p.class) {
            if (!g) {
                g = true;
                a(MoSecurityApplication.a(), str, str2, str3, str4, str5, str6, str7, str8);
            }
        }
    }

    private static void a(String str, LinkedHashMap linkedHashMap) {
        Thread sVar = new s(str, linkedHashMap);
        sVar.setPriority(3);
        sVar.start();
    }

    public static synchronized JSONObject b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        JSONObject jSONObject;
        synchronized (p.class) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(IXAdRequestInfo.ACT, "v_manager");
                jSONObject.put("type", "page");
                jSONObject.put("act_type", str);
                jSONObject.put("channel", str2);
                jSONObject.put("channel_category", str3);
                jSONObject.put("channel_category_small", str4);
                jSONObject.put("th_id", str5);
                jSONObject.put("aa_name", str6);
                jSONObject.put("aa_slot_id", str7);
                jSONObject.put("aa_referer", str8);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public static void b() {
        com.vlocker.weather.a.b = false;
        y.c = false;
        com.vlocker.weather.a.c = false;
        g = true;
        a.a().removeCallbacks(i);
    }

    public static void b(Context context) {
        com.vlocker.c.a a = com.vlocker.c.a.a(context);
        if (((double) (System.currentTimeMillis() - a.b(context.getApplicationContext()).longValue())) > 2.088E7d) {
            a.a(context.getApplicationContext(), Long.valueOf(System.currentTimeMillis()));
            Thread tVar = new t(context);
            tVar.setPriority(3);
            tVar.start();
        }
    }

    public static void b(Context context, String str, String str2) {
        a(context, "ad_show", "102000", "", "", "", str, "1012", str2);
    }

    public static void b(Context context, String str, String str2, String str3) {
        a(context, "ad_click", "102000", str3, "", "", str, "1011", str2);
    }

    public static void b(String str, String str2) {
        a("v_browse", str, str2, "", "", "", "", "");
    }

    public static synchronized void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        synchronized (p.class) {
            a.a().removeCallbacks(i);
            g = false;
            h = new v(0, str, str2, str3, str4, str5, str6, str7, str8);
            a.a().postDelayed(i, 3000);
        }
    }

    public static void c(Context context) {
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/vlocker/log" + "/huoyue");
        if (file.exists() && j.b(context) != o.noNetStatus) {
            Thread uVar = new u(file, context);
            uVar.setPriority(3);
            uVar.start();
        }
    }

    public static void c(Context context, String str, String str2, String str3) {
        a(context, "ad_show", "102000", str3, "", "", str, "1011", str2);
    }

    public static void d(Context context, String str, String str2, String str3) {
        a(context, "v_push_click", "", str3, "", "", str, "1014", str2);
    }

    public static void e(Context context, String str, String str2, String str3) {
        a(context, "v_push_success", "", str3, "", "", str, "1014", str2);
    }

    public static void f(Context context, String str, String str2, String str3) {
        a(context, str, "101000", "101001", "", "", str2, "1013", str3);
    }
}
