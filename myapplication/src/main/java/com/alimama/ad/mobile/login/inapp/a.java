package com.alimama.ad.mobile.login.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alimama.ad.mobile.login.inapp.ui.DetailActivity;

public class a {
    private static a a = new a();

    private a() {
    }

    public static a a() {
        return a;
    }

    public void a(com.alimama.ad.mobile.b.a aVar) {
        if (aVar != null) {
            Context context = (Context) aVar.c("appContext");
            Object b = com.alimama.ad.mobile.a.a.b("com.alibaba.sdk.android.AlibabaSDK");
            if (context != null && b != null) {
                com.alimama.ad.mobile.a.a.a(b, com.alimama.ad.mobile.a.a.a(b, "asyncInit", new Class[]{Context.class}), new Object[]{context});
            }
        }
    }

    public void b(com.alimama.ad.mobile.b.a aVar) {
        if (aVar != null) {
            Activity activity = (Activity) aVar.c("appContext");
            String b = aVar.b("url");
            Intent intent = new Intent(activity, DetailActivity.class);
            intent.putExtra("url", b);
            activity.startActivity(intent);
        }
    }
}
