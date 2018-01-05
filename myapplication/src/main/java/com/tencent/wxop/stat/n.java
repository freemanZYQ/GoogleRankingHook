package com.tencent.wxop.stat;

import java.util.List;

final class n implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ k b;
    final /* synthetic */ l c;

    n(l lVar, List list, k kVar) {
        this.c = lVar;
        this.a = list;
        this.b = kVar;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
