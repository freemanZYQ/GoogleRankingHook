package com.vlocker.weather.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.moxiu.sdk.statistics.a;
import com.vlocker.theme.f.b;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static String a = "AA_SELFRUN";
    private static boolean b = true;
    private static String c = "";

    public static void a(Context context) {
        a(context, "w_browse", "", "", "", "", "");
    }

    public static void a(Context context, String str) {
        a(context, "ad_request", "106000", "", str, "", "");
    }

    public static void a(Context context, String str, String str2) {
        a(context, "w_click", str, str2, "", "", "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        a(context, "ad_download", "106000", "", str, str2, str3);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Thread eVar = new e(context, str, str2, str3, str4, str5, str6);
        eVar.setPriority(3);
        eVar.start();
    }

    public static void a(Context context, String str, String str2, boolean z) {
        b = z;
        a(context, "w_browse", str, str2, "", "", "");
    }

    public static void a(Context context, String str, String... strArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 1; i < strArr.length; i += 2) {
            linkedHashMap.put(strArr[i - 1], strArr[i]);
        }
        a(str, linkedHashMap);
    }

    private static void a(String str, LinkedHashMap linkedHashMap) {
        if (!b.p() || VERSION.SDK_INT <= 18) {
            a.a(str, linkedHashMap);
            return;
        }
        try {
            a.a(str, linkedHashMap);
        } catch (Exception e) {
        }
    }

    public static synchronized JSONObject b(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject;
        synchronized (d.class) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(IXAdRequestInfo.ACT, "wv_manager");
                jSONObject.put("type", "page");
                jSONObject.put("act_type", str);
                jSONObject.put("channel", str2);
                jSONObject.put("channel_category", str3);
                jSONObject.put("aa_slot_id", str4);
                jSONObject.put("aa_name", str5);
                jSONObject.put("aa_referer", str6);
                jSONObject.put("referer", TextUtils.isEmpty(c) ? "vlock" : c);
                jSONObject.put("loading_type", b ? "1" : "0");
                b = true;
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public static void b(Context context, String str, String str2) {
        if (str2 != null && !TextUtils.isEmpty(str)) {
            a(context, str, str2);
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        a(context, "ad_click", "106000", "", str, str2, str3);
    }

    public static void c(Context context, String str, String str2, String str3) {
        a(context, "ad_show", "106000", "", str, str2, str3);
    }
}
