package com.vlocker.weather;

import com.vlocker.ui.widget.CoverViewPager;

class p implements Runnable {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    public void run() {
        this.a.a.L = true;
        this.a.a.E.q();
        CoverViewPager.c = true;
    }
}
