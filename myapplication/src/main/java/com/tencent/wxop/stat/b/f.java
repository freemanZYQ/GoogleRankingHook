package com.tencent.wxop.stat.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class f {
    ExecutorService a;

    public f() {
        this.a = null;
        this.a = Executors.newSingleThreadExecutor();
    }

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
