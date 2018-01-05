package com.inveno.se.d;

class e implements Runnable {
    final /* synthetic */ p a;
    final /* synthetic */ d b;

    e(d dVar, p pVar) {
        this.b = dVar;
        this.a = pVar;
    }

    public void run() {
        try {
            this.b.b.put(this.a);
        } catch (InterruptedException e) {
        }
    }
}
