package com.tencent.wxop.stat;

import android.content.Context;
import com.baidu.location.LocationClientOption;
import com.tencent.wxop.stat.b.l;
import java.util.Timer;
import java.util.TimerTask;

public class g {
    private static volatile g b = null;
    private Timer a = null;
    private Context c = null;

    private g(Context context) {
        this.c = context.getApplicationContext();
        this.a = new Timer(false);
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g(context);
                }
            }
        }
        return b;
    }

    public final void a() {
        if (v.a() == w.PERIOD) {
            long l = (long) ((v.l() * 60) * LocationClientOption.MIN_SCAN_SPAN);
            if (v.b()) {
                l.c().a("setupPeriodTimer delay:" + l);
            }
            TimerTask hVar = new h(this);
            if (this.a != null) {
                if (v.b()) {
                    l.c().a("setupPeriodTimer schedule delay:" + l);
                }
                this.a.schedule(hVar, l);
            } else if (v.b()) {
                l.c().c("setupPeriodTimer schedule timer == null");
            }
        }
    }
}
