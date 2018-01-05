package com.inveno.se.d;

import android.os.Handler;
import java.util.concurrent.Executor;

class h implements Executor {
    final /* synthetic */ Handler a;
    final /* synthetic */ g b;

    h(g gVar, Handler handler) {
        this.b = gVar;
        this.a = handler;
    }

    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
