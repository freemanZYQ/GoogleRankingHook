package com.vlocker.locker.c;

class y implements Runnable {
    final /* synthetic */ b a;

    y(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (this.a.R != null) {
            this.a.R.a();
        }
        if (this.a.M != null && ((double) this.a.M.getAlpha()) >= 0.1d) {
            this.a.M.setAlpha(1.0f);
        }
    }
}
