package com.vlocker.j;

class l implements Runnable {
    final /* synthetic */ a a;

    l(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (!this.a.r) {
            a.e.e = this.a.i;
            this.a.p.removeMessages(5);
            this.a.p.sendEmptyMessage(5);
        }
    }
}
