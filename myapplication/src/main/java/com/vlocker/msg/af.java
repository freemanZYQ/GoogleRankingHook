package com.vlocker.msg;

class af implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ab b;

    af(ab abVar, String str) {
        this.b = abVar;
        this.a = str;
    }

    public void run() {
        synchronized (this.b.o) {
            if (this.b.o.containsKey(this.a)) {
                this.b.o.remove(this.a);
                this.b.f(this.a);
            } else if (this.a.startsWith(this.b.m.getPackageName())) {
                ab.e(this.a);
            }
        }
    }
}
