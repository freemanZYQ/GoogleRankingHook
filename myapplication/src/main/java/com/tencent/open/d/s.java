package com.tencent.open.d;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

class s implements Executor {
    final Queue a;
    Runnable b;

    private s() {
        this.a = new LinkedList();
    }

    protected synchronized void a() {
        Runnable runnable = (Runnable) this.a.poll();
        this.b = runnable;
        if (runnable != null) {
            q.a.execute(this.b);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.a.offer(new t(this, runnable));
        if (this.b == null) {
            a();
        }
    }
}
