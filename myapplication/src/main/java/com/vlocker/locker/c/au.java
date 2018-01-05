package com.vlocker.locker.c;

class au implements Runnable {
    final /* synthetic */ ao a;

    au(ao aoVar) {
        this.a = aoVar;
    }

    public void run() {
        long currentTimeMillis = 30001 - (System.currentTimeMillis() - this.a.r);
        ao aoVar = this.a;
        if (currentTimeMillis <= 0) {
            currentTimeMillis = 30001;
        }
        aoVar.s = new av(this, currentTimeMillis, 1000).start();
    }
}
