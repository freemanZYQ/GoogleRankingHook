package com.mx.http.download;

class g extends Thread {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void run() {
        this.a.f = true;
        this.a.c();
        this.a.f = false;
    }
}
