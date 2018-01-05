package com.tencent.wxop.stat;

final class ar implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ am b;

    ar(am amVar, i iVar) {
        this.b = amVar;
        this.a = iVar;
    }

    public final void run() {
        this.b.b(this.a);
    }
}
