package com.tencent.wxop.stat;

import android.content.Context;

final class aa implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b = -1;

    aa(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            x.e(this.a);
            am.a(this.a).a(this.b);
        } catch (Throwable th) {
            x.q.b(th);
            x.a(this.a, th);
        }
    }
}
