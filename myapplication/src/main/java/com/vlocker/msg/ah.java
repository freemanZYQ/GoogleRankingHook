package com.vlocker.msg;

class ah implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ab b;

    ah(ab abVar, String str) {
        this.b = abVar;
        this.a = str;
    }

    public void run() {
        synchronized (this.b.o) {
            if (this.b.o.containsKey(this.a)) {
                this.b.o.remove(this.a);
            }
        }
    }
}
