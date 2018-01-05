package com.vlocker.e;

class k implements l {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void a(String str) {
        synchronized (j.b) {
            j.b.remove(str);
        }
    }

    public void b(String str) {
        synchronized (j.b) {
            j.b.remove(str);
        }
    }
}
