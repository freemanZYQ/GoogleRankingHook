package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.a;
import com.tencent.wxop.stat.a.b;
import com.tencent.wxop.stat.a.d;

final class s implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ y b = null;
    final /* synthetic */ b c;

    s(Context context, b bVar) {
        this.a = context;
        this.c = bVar;
    }

    public final void run() {
        try {
            d aVar = new a(this.a, x.a(this.a, false, this.b), this.c.a, this.b);
            aVar.a().c = this.c.c;
            new ai(aVar).a();
        } catch (Throwable th) {
            x.q.b(th);
            x.a(this.a, th);
        }
    }
}
