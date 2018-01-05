package com.c.a;

import android.content.Context;
import com.c.a.h.a;
import com.c.a.k.c;
import com.c.a.k.d;

public class b {
    private static volatile b d;
    public a a;
    public c b = c.DOWNLOAD_TAOBAO;
    public a c;

    private b() {
    }

    public static b a() {
        if (d != null) {
            return d;
        }
        synchronized (b.class) {
            if (d == null) {
                d = new b();
            }
        }
        return d;
    }

    private void b() {
        if (this.a == null || c.a(this.a.a)) {
            com.c.a.i.a.a(new com.c.a.j.a(d.a().getApplicationContext(), ""));
        } else {
            com.c.a.i.a.a(new com.c.a.j.a(d.a().getApplicationContext(), this.a.a));
        }
    }

    public b a(a aVar) {
        this.a = aVar;
        b();
        return d;
    }

    public b a(c cVar) {
        this.b = cVar;
        return d;
    }

    public boolean a(Context context, com.c.a.g.c cVar) {
        if (cVar != null && context != null) {
            return com.c.a.d.a.a(context, (com.c.a.g.a) cVar, null);
        }
        throw new com.c.a.e.a(com.c.a.e.b.NULL_POINT);
    }
}
