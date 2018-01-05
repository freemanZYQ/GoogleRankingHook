package com.vlocker.setting.ui;

class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public void run() {
        if (this.a.b.g.getParent() != null) {
            this.a.b.f.removeViewImmediate(this.a.b.g);
        }
        this.a.b.d = false;
    }
}
