package com.tencent.open.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import com.tencent.open.a.j;
import com.tencent.open.d.e;
import com.tencent.open.d.m;
import com.tencent.open.d.u;
import java.util.TimeZone;

class i implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ boolean b;
    final /* synthetic */ g c;

    i(g gVar, Bundle bundle, boolean z) {
        this.c = gVar;
        this.a = bundle;
        this.b = z;
    }

    public void run() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("uin", "1000");
            bundle.putString("imei", c.b(e.a()));
            bundle.putString("imsi", c.c(e.a()));
            bundle.putString("android_id", c.d(e.a()));
            bundle.putString("mac", c.a());
            bundle.putString("platform", "1");
            bundle.putString("os_ver", VERSION.RELEASE);
            bundle.putString("position", u.c(e.a()));
            bundle.putString("network", a.a(e.a()));
            bundle.putString("language", c.b());
            bundle.putString("resolution", c.a(e.a()));
            bundle.putString("apn", a.b(e.a()));
            bundle.putString("model_name", Build.MODEL);
            bundle.putString("timezone", TimeZone.getDefault().getID());
            bundle.putString("sdk_ver", "2.9.4.lite");
            bundle.putString("qz_ver", u.d(e.a(), "com.qzone"));
            bundle.putString("qq_ver", u.c(e.a(), "com.tencent.mobileqq"));
            bundle.putString("qua", u.e(e.a(), e.b()));
            bundle.putString("packagename", e.b());
            bundle.putString("app_ver", u.d(e.a(), e.b()));
            if (this.a != null) {
                bundle.putAll(this.a);
            }
            this.c.d.add(new b(bundle));
            int size = this.c.d.size();
            int a = m.a(e.a(), null).a("Agent_ReportTimeInterval");
            if (a == 0) {
                a = 10000;
            }
            if (this.c.a("report_via", size) || this.b) {
                this.c.e();
                this.c.f.removeMessages(1001);
            } else if (!this.c.f.hasMessages(1001)) {
                Message obtain = Message.obtain();
                obtain.what = 1001;
                this.c.f.sendMessageDelayed(obtain, (long) a);
            }
        } catch (Throwable e) {
            j.a("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
        }
    }
}
