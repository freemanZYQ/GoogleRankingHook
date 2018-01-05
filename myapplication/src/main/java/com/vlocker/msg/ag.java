package com.vlocker.msg;

class ag implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ ab c;

    ag(ab abVar, String str, int i) {
        this.c = abVar;
        this.a = str;
        this.b = i;
    }

    public void run() {
        synchronized (this.c.o) {
            if (this.c.o.containsKey(this.a)) {
                this.c.o.remove(this.a);
                this.c.f(this.a);
            } else if (this.a.startsWith(this.c.m.getPackageName())) {
                ab.b(this.a, this.b);
            }
        }
    }
}
