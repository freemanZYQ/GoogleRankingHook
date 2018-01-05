package com.vlocker.setting.ui;

class ah implements Runnable {
    final /* synthetic */ ag a;

    ah(ag agVar) {
        this.a = agVar;
    }

    public void run() {
        if (this.a.a.l.isRunning()) {
            this.a.a.C = true;
        } else {
            this.a.a.b(true);
        }
    }
}
