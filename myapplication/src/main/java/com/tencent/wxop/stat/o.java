package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class o implements Runnable {
    final /* synthetic */ Context a;

    o(Context context) {
        this.a = context;
    }

    public final void run() {
        z.a(x.t).h();
        l.a(this.a, true);
        am.a(this.a);
        l.b(this.a);
        x.r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new ag());
        if (v.a() == w.APP_LAUNCH) {
            x.d(this.a);
        }
        if (v.b()) {
            x.q.g("Init MTA StatService success.");
        }
    }
}
