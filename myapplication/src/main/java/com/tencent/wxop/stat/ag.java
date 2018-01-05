package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.c;
import java.lang.Thread.UncaughtExceptionHandler;

final class ag implements UncaughtExceptionHandler {
    ag() {
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (v.c() && x.t != null) {
            if (v.o()) {
                am.a(x.t).a(new c(x.t, x.a(x.t, false, null), th, thread), null, false, true);
                x.q.f("MTA has caught the following uncaught exception:");
                x.q.a(th);
            }
            x.e(x.t);
            if (x.r != null) {
                x.q.g("Call the original uncaught exception handler.");
                if (!(x.r instanceof ag)) {
                    x.r.uncaughtException(thread, th);
                }
            }
        }
    }
}
