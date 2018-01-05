package com.tencent.open.b;

import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.LocationClientOption;
import com.tencent.open.d.e;
import com.tencent.open.d.m;

class j implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ long e;
    final /* synthetic */ long f;
    final /* synthetic */ boolean g;
    final /* synthetic */ g h;

    j(g gVar, long j, String str, String str2, int i, long j2, long j3, boolean z) {
        this.h = gVar;
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = j2;
        this.f = j3;
        this.g = z;
    }

    public void run() {
        int i = 1;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
            Bundle bundle = new Bundle();
            String a = a.a(e.a());
            bundle.putString("apn", a);
            bundle.putString("appid", "1000067");
            bundle.putString("commandid", this.b);
            bundle.putString(com.vlocker.setting.a.a.e.ACTION_APPLICATION_DETAILS_SETTINGS, this.c);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("network=").append(a).append('&');
            stringBuilder.append("sdcard=").append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0).append('&');
            stringBuilder.append("wifi=").append(a.e(e.a()));
            bundle.putString("deviceInfo", stringBuilder.toString());
            int a2 = 100 / this.h.a(this.d);
            if (a2 > 0) {
                i = a2 > 100 ? 100 : a2;
            }
            bundle.putString("frequency", i + "");
            bundle.putString("reqSize", this.e + "");
            bundle.putString("resultCode", this.d + "");
            bundle.putString("rspSize", this.f + "");
            bundle.putString("timeCost", elapsedRealtime + "");
            bundle.putString("uin", "1000");
            this.h.c.add(new b(bundle));
            int size = this.h.c.size();
            i = m.a(e.a(), null).a("Agent_ReportTimeInterval");
            if (i == 0) {
                i = 10000;
            }
            if (this.h.a("report_cgi", size) || this.g) {
                this.h.b();
                this.h.f.removeMessages(LocationClientOption.MIN_SCAN_SPAN);
            } else if (!this.h.f.hasMessages(LocationClientOption.MIN_SCAN_SPAN)) {
                Message obtain = Message.obtain();
                obtain.what = LocationClientOption.MIN_SCAN_SPAN;
                this.h.f.sendMessageDelayed(obtain, (long) i);
            }
        } catch (Throwable e) {
            com.tencent.open.a.j.a("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
        }
    }
}
