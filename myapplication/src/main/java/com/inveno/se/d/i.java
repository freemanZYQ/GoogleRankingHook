package com.inveno.se.d;

class i implements Runnable {
    final /* synthetic */ g a;
    private final p b;
    private final t c;
    private final Runnable d;

    public i(g gVar, p pVar, t tVar, Runnable runnable) {
        this.a = gVar;
        this.b = pVar;
        this.c = tVar;
        this.d = runnable;
    }

    public void run() {
        if (this.b.j()) {
            this.b.b("canceled-at-delivery");
            return;
        }
        if (this.c.a()) {
            this.b.a(this.c.a);
        } else {
            this.b.b(this.c.c);
        }
        if (this.c.d) {
            this.b.a("intermediate-response");
        } else {
            this.b.b("done");
        }
        if (this.d != null) {
            this.d.run();
        }
    }
}
