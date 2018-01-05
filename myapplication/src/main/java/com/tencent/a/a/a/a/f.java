package com.tencent.a.a.a.a;

import android.content.Context;

public abstract class f {
    protected Context a = null;

    protected f(Context context) {
        this.a = context;
    }

    public final void a(c cVar) {
        if (cVar != null) {
            String cVar2 = cVar.toString();
            if (a()) {
                a(h.d(cVar2));
            }
        }
    }

    protected abstract void a(String str);

    protected abstract boolean a();

    protected abstract String b();

    public final c c() {
        String c = a() ? h.c(b()) : null;
        return c != null ? c.a(c) : null;
    }
}
