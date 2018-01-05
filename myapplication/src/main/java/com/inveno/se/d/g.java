package com.inveno.se.d;

import android.os.Handler;
import java.util.concurrent.Executor;

public class g implements w {
    private final Executor a;

    public g(Handler handler) {
        this.a = new h(this, handler);
    }

    public void a(p pVar, aa aaVar) {
        pVar.a("post-error");
        this.a.execute(new i(this, pVar, t.a(aaVar), null));
    }

    public void a(p pVar, t tVar) {
        a(pVar, tVar, null);
    }

    public void a(p pVar, t tVar, Runnable runnable) {
        pVar.t();
        pVar.a("post-response");
        this.a.execute(new i(this, pVar, tVar, runnable));
    }
}
