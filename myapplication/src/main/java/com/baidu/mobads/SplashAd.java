package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.g.a;

public class SplashAd {
    private a a;
    private volatile String b;
    private SplashAdListener c;
    private IOAdEventListener d;

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str) {
        this(context, viewGroup, splashAdListener, str, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z) {
        this.b = "init";
        this.c = new ag(this);
        this.d = new ah(this);
        if (splashAdListener != null) {
            try {
                this.c = splashAdListener;
            } catch (Throwable e) {
                m.a().f().d(e);
                com.baidu.mobads.c.a.a().a("splash ad create failed: " + e.toString());
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.c.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        View aoVar = new ao(context);
        aoVar.a(new aj(this, context, aoVar, str, z));
        aoVar.setLayoutParams(new LayoutParams(-1, -1));
        viewGroup.addView(aoVar);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        m.a().m().setAppId(str);
    }

    public void destroy() {
        if (this.a != null) {
            this.a.l();
        }
    }
}
