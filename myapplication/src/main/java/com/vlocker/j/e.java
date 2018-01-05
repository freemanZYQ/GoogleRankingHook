package com.vlocker.j;

class e implements Runnable {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (System.currentTimeMillis() - this.a.w >= 1500) {
            a.a = this.a.d.a();
            this.a.p.removeMessages(4);
            this.a.p.sendEmptyMessage(4);
        }
    }
}
