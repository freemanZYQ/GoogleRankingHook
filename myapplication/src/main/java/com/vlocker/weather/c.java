package com.vlocker.weather;

class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void run() {
        this.a.H.scrollTo(0, 0);
        this.a.H.c();
        this.a.H.i = true;
        this.a.w.b();
        if (a.d) {
            this.a.E.e();
            this.a.E.b();
        }
        if (this.a.D != null) {
            this.a.D.a(false);
        }
    }
}
