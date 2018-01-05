package com.tencent.wxop.stat;

final class c implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ am b;

    c(am amVar, int i) {
        this.b = amVar;
        this.a = i;
    }

    public final void run() {
        am.a(this.b, this.a, true);
        am.a(this.b, this.a, false);
    }
}
