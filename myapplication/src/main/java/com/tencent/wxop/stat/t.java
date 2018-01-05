package com.tencent.wxop.stat;

import android.content.Context;

final class t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ y c;

    t(String str, Context context, y yVar) {
        this.a = str;
        this.b = context;
        this.c = yVar;
    }

    public final void run() {
        try {
            synchronized (x.o) {
                if (x.o.size() >= v.m()) {
                    x.q.d("The number of page events exceeds the maximum value " + Integer.toString(v.m()));
                    return;
                }
                x.m = this.a;
                if (x.o.containsKey(x.m)) {
                    x.q.e("Duplicate PageID : " + x.m + ", onResume() repeated?");
                    return;
                }
                x.o.put(x.m, Long.valueOf(System.currentTimeMillis()));
                x.a(this.b, true, this.c);
            }
        } catch (Throwable th) {
            x.q.b(th);
            x.a(this.b, th);
        }
    }
}
