package com.baidu.mobads.c;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.vo.a.b;
import java.util.Map;

public class a {
    public static volatile String b = "";
    public static volatile String c = "";
    private static a d = new a();
    private static boolean f = false;
    protected final IXAdLogger a = m.a().f();
    private Context e;

    private a() {
        new Handler(Looper.getMainLooper()).postDelayed(new b(this), 2000);
    }

    public static a a() {
        return d;
    }

    private String a(Context context, String str, Map map) {
        try {
            String encodeURIComponent;
            StringBuilder stringBuilder = new StringBuilder("type=" + str + "&");
            StringBuilder stringBuilder2 = new StringBuilder();
            map.put("ts", System.currentTimeMillis() + "");
            IXAdCommonUtils m = m.a().m();
            for (String encodeURIComponent2 : map.keySet()) {
                String str2 = (String) map.get(encodeURIComponent2);
                if (!(encodeURIComponent2 == null || str2 == null)) {
                    encodeURIComponent2 = m.encodeURIComponent(encodeURIComponent2);
                    str2 = m.encodeURIComponent(str2);
                    stringBuilder.append(encodeURIComponent2);
                    stringBuilder.append("=");
                    stringBuilder.append(str2);
                    stringBuilder.append("&");
                    stringBuilder2.append(str2);
                    stringBuilder2.append(",");
                }
            }
            stringBuilder2.append("mobads,");
            encodeURIComponent2 = m.getMD5(stringBuilder2.toString());
            this.a.d("ExtraQuery.allValue:" + stringBuilder2);
            stringBuilder.append("vd=" + encodeURIComponent2 + "&");
            this.a.d("ExtraQuery.params:" + stringBuilder);
            return "http://mobads-logs.baidu.com/dz.zb" + "?" + stringBuilder.toString();
        } catch (Throwable e) {
            this.a.d(e);
            return "";
        }
    }

    private void a(int i, String str) {
        com.baidu.mobads.openad.e.a aVar = new com.baidu.mobads.openad.e.a();
        d dVar = new d(str, "");
        dVar.e = i;
        aVar.a(dVar, Boolean.valueOf(true));
    }

    private void a(Context context, String str, com.baidu.mobads.command.a aVar) {
        IXAppInfo a = com.baidu.mobads.command.a.a.a(aVar);
        if (a != null) {
            a(context, str, a);
        }
    }

    private void a(Context context, String str, IXAppInfo iXAppInfo) {
        b bVar = new b(context, iXAppInfo);
        bVar.b = iXAppInfo.getAdId();
        b(a(context, str, bVar.c()));
    }

    private void a(String str, String str2, Builder builder) {
        IXAdConstants p = m.a().p();
        IXAdCommonUtils m = m.a().m();
        if (builder == null) {
            builder = new Builder();
        }
        try {
            builder.appendQueryParameter("type", str2).appendQueryParameter(IXAdRequestInfo.P_VER, "8.23").appendQueryParameter("appsid", p.getAppSid()).appendQueryParameter(IXAdRequestInfo.V, "android_" + com.baidu.mobads.a.a.c + "_" + "4.1.30").appendQueryParameter("reason", str).appendQueryParameter(IXAdRequestInfo.OSV, VERSION.RELEASE).appendQueryParameter(IXAdRequestInfo.BDR, "" + VERSION.SDK_INT).appendQueryParameter(IXAdRequestInfo.BRAND, "" + m.getTextEncoder(Build.BRAND)).appendQueryParameter("pack", p.getAppPackageNameOfPublisher());
        } catch (Throwable e) {
            m.a().f().e(e);
        }
        d dVar = new d("http://mobads-logs.baidu.com/brwhis.log", "");
        dVar.a(builder);
        dVar.a(0);
        new com.baidu.mobads.openad.e.a().a(dVar);
    }

    private void b(String str) {
        a(1, str);
    }

    public void a(Context context) {
        if (this.e == null) {
            this.e = context;
        }
    }

    public void a(Context context, com.baidu.mobads.command.a aVar) {
        a(context, "9", aVar);
    }

    public void a(Context context, IXAppInfo iXAppInfo) {
        a(context, "10", iXAppInfo);
    }

    public void a(com.baidu.mobads.command.a aVar) {
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("temp_for_feed_response_html")) {
            a(str, "400", null);
        } else if (!f) {
            a("temp_for_feed_response_html", "405", b + "___" + c);
            f = true;
        }
    }

    public void a(String str, String str2, String str3) {
        Builder appendQueryParameter = new Builder().appendQueryParameter("stacktrace", str2);
        appendQueryParameter.appendQueryParameter("ad", str3);
        a(str, "404", appendQueryParameter);
    }

    public void b(Context context, com.baidu.mobads.command.a aVar) {
        a(context, "11", aVar);
    }
}
