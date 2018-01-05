package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.l;
import java.util.TimerTask;

final class h extends TimerTask {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        if (v.b()) {
            l.c().a((Object) "TimerTask run");
        }
        x.f(this.a.c);
        cancel();
        this.a.a();
    }
}
