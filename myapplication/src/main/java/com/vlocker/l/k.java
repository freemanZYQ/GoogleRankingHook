package com.vlocker.l;

import android.view.ViewTreeObserver.OnPreDrawListener;

class k implements OnPreDrawListener {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public boolean onPreDraw() {
        this.a.c.setY((float) this.a.d.getHeight());
        this.a.d();
        this.a.c.getViewTreeObserver().removeOnPreDrawListener(this);
        this.a.o = false;
        return true;
    }
}
