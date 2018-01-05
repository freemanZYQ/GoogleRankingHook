package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.d;

final class aq implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ k b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ am e;

    aq(am amVar, d dVar, k kVar, boolean z, boolean z2) {
        this.e = amVar;
        this.a = dVar;
        this.b = kVar;
        this.c = z;
        this.d = z2;
    }

    public final void run() {
        this.e.b(this.a, this.b, this.c, this.d);
    }
}
