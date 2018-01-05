package com.vlocker.theme.imageloader;

import android.annotation.TargetApi;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

@TargetApi(11)
class h implements Executor {
    final ArrayDeque a;
    Runnable b;

    private h() {
        this.a = new ArrayDeque();
    }

    protected synchronized void a() {
        Runnable runnable = (Runnable) this.a.poll();
        this.b = runnable;
        if (runnable != null) {
            a.a.execute(this.b);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.a.offer(new i(this, runnable));
        if (this.b == null) {
            a();
        }
    }
}
