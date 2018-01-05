package com.tencent.wxop.stat;

import java.util.List;

final class ao implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c = true;
    final /* synthetic */ am d;

    ao(am amVar, List list, boolean z) {
        this.d = amVar;
        this.a = list;
        this.b = z;
    }

    public final void run() {
        this.d.c(this.a, this.b);
        if (this.c) {
            this.a.clear();
        }
    }
}
