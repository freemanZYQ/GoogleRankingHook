package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import com.baidu.mobads.ao.a;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.j.m;

class aj implements a {
    final /* synthetic */ Context a;
    final /* synthetic */ ao b;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;
    final /* synthetic */ SplashAd e;

    aj(SplashAd splashAd, Context context, ao aoVar, String str, boolean z) {
        this.e = splashAd;
        this.a = context;
        this.b = aoVar;
        this.c = str;
        this.d = z;
    }

    @SuppressLint({"MissingSuperCall"})
    public void a() {
        if (this.e.a != null) {
            this.e.a.k();
        }
    }

    public void a(int i) {
        if (this.e.a != null) {
            this.e.a.a(i);
        }
    }

    public void a(int i, int i2) {
        if (this.e.a == null) {
            float screenDensity = m.a().m().getScreenDensity(this.a);
            if (((float) i) < 200.0f * screenDensity || ((float) i2) < screenDensity * 150.0f) {
                m.a().f().e(m.a().q().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                this.e.c.onAdDismissed();
                return;
            }
            this.e.a = new com.baidu.mobads.production.g.a(this.a, this.b, this.c, this.d, i, i2);
            this.e.a.addEventListener("AdUserClick", this.e.d);
            this.e.a.addEventListener(IXAdEvent.AD_LOADED, this.e.d);
            this.e.a.addEventListener(IXAdEvent.AD_STARTED, this.e.d);
            this.e.a.addEventListener(IXAdEvent.AD_STOPPED, this.e.d);
            this.e.a.addEventListener(IXAdEvent.AD_ERROR, this.e.d);
            this.e.a.request();
        }
    }

    public void a(boolean z) {
        if (this.e.a != null) {
            this.e.a.a(z);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public void b() {
        if (this.e.a != null) {
            this.e.a.j();
        }
    }
}
