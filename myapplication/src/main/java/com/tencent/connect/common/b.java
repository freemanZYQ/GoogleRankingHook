package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.b.c;
import com.tencent.open.d.e;
import com.tencent.open.d.p;
import com.tencent.open.d.u;

public abstract class b {
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static boolean h = false;
    protected com.tencent.connect.b.b c;
    protected c d;

    public b(com.tencent.connect.b.b bVar, c cVar) {
        this.c = bVar;
        this.d = cVar;
    }

    public b(c cVar) {
        this(null, cVar);
    }

    private Intent a(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        return intent2;
    }

    protected Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", "2.9.4.lite");
        bundle.putString("sdkp", "a");
        if (this.d != null && this.d.a()) {
            bundle.putString("access_token", this.d.c());
            bundle.putString("oauth_consumer_key", this.d.b());
            bundle.putString("openid", this.d.d());
            bundle.putString("appid_for_getting_config", this.d.b());
        }
        SharedPreferences sharedPreferences = e.a().getSharedPreferences("pfStore", 0);
        if (h) {
            bundle.putString("pf", "desktop_m_qq-" + f + "-" + "android" + "-" + e + "-" + g);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
        }
        return bundle;
    }

    protected String a(String str) {
        Bundle a = a();
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            a.putString("need_version", str);
        }
        stringBuilder.append("http://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        stringBuilder.append(u.a(a));
        return stringBuilder.toString();
    }

    protected void a(Activity activity, int i, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        activity.startActivityForResult(intent2, i);
    }

    protected void a(Activity activity, Intent intent, int i) {
        intent.putExtra("key_request_code", i);
        activity.startActivityForResult(a(activity, intent), i);
    }

    protected boolean a(Intent intent) {
        return intent != null ? p.a(e.a(), intent) : false;
    }
}
