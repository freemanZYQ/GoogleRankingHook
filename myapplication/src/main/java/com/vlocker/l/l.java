package com.vlocker.l;

class l implements Runnable {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public void run() {
        if (!(this.a.c == null || this.a.c.getParent() == null)) {
            this.a.c.setVisibility(4);
            this.a.d.removeView(this.a.c);
            System.gc();
        }
        this.a.q = false;
        this.a.n = false;
    }
}
