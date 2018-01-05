package com.inveno.a;

import android.os.Handler;

class d {
    private static d a;
    private Handler b = new Handler();
    private Runnable c = new e(this);

    private d() {
    }

    static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    void b() {
        this.b.postDelayed(this.c, 600000);
    }

    void c() {
        this.b.removeCallbacks(this.c);
        b();
    }
}
