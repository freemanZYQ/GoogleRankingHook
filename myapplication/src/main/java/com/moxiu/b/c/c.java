package com.moxiu.b.c;

import android.os.Process;

class c extends k {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
        super();
    }

    public Object call() {
        this.a.l.set(true);
        Process.setThreadPriority(10);
        return this.a.d(this.a.a(this.b));
    }
}
