package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.c;
import com.tencent.wxop.stat.a.f;

final class q implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Throwable b;

    q(Context context, Throwable th) {
        this.a = context;
        this.b = th;
    }

    public final void run() {
        try {
            if (v.c()) {
                new ai(new c(this.a, x.a(this.a, false, null), this.b, f.a)).a();
            }
        } catch (Throwable th) {
            x.q.e("reportSdkSelfException error: " + th);
        }
    }
}
