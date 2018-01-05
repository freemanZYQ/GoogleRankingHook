package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.h;

final class ad implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ y c;

    ad(Context context, String str, y yVar) {
        this.a = context;
        this.b = str;
        this.c = yVar;
    }

    public final void run() {
        try {
            Long l;
            x.e(this.a);
            synchronized (x.o) {
                l = (Long) x.o.remove(this.b);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String i = x.n;
                if (i != null && i.equals(this.b)) {
                    i = "-";
                }
                d hVar = new h(this.a, i, this.b, x.a(this.a, false, this.c), valueOf, this.c);
                if (!this.b.equals(x.m)) {
                    x.q.b((Object) "Invalid invocation since previous onResume on diff page.");
                }
                new ai(hVar).a();
                x.n = this.b;
                return;
            }
            x.q.e("Starttime for PageID:" + this.b + " not found, lost onResume()?");
        } catch (Throwable th) {
            x.q.b(th);
            x.a(this.a, th);
        }
    }
}
