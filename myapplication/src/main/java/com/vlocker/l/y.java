package com.vlocker.l;

class y implements Runnable {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    public void run() {
        this.a.c();
        if (this.a.b != null) {
            this.a.b.a();
        }
    }
}
