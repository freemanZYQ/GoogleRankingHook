package com.tencent.wxop.stat;

import android.content.Context;

final class af implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ y b = null;

    af(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            x.a(this.a, false, this.b);
        } catch (Throwable th) {
            x.q.b(th);
        }
    }
}
