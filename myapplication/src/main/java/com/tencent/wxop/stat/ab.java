package com.tencent.wxop.stat;

import android.content.Context;

final class ab implements Runnable {
    final /* synthetic */ Context a;

    ab(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            new Thread(new ah(this.a), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            x.q.b(th);
            x.a(this.a, th);
        }
    }
}
