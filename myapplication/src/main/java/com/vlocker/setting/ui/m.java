package com.vlocker.setting.ui;

class m implements Runnable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public void run() {
        if (this.a.b.h.getParent() != null) {
            this.a.b.f.removeViewImmediate(this.a.b.h);
        }
        this.a.b.e = false;
    }
}
