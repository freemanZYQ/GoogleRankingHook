package com.vlocker.g;

class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (this.a.j != null && this.a.j.getVisibility() == 0 && this.a.i != null && !this.a.i.a) {
            this.a.a(false, false);
        }
    }
}
