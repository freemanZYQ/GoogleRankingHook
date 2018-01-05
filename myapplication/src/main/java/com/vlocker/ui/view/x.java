package com.vlocker.ui.view;

import android.graphics.RectF;

class x implements Runnable {
    double a = 0.0d;
    double b = 0.0d;
    final /* synthetic */ double c;
    final /* synthetic */ long d;
    final /* synthetic */ double e;
    final /* synthetic */ double f;
    final /* synthetic */ ImageViewTouchBase g;

    x(ImageViewTouchBase imageViewTouchBase, double d, long j, double d2, double d3) {
        this.g = imageViewTouchBase;
        this.c = d;
        this.d = j;
        this.e = d2;
        this.f = d3;
    }

    public void run() {
        double min = Math.min(this.c, (double) (System.currentTimeMillis() - this.d));
        double a = this.g.a(min, 0.0d, this.e, this.c);
        double a2 = this.g.a(min, 0.0d, this.f, this.c);
        this.g.a(a - this.a, a2 - this.b);
        this.a = a;
        this.b = a2;
        if (min < this.c) {
            this.g.n.post(this);
            return;
        }
        RectF a3 = this.g.a(this.g.l, true, true);
        if (a3.left != 0.0f || a3.top != 0.0f) {
            this.g.d(a3.left, a3.top);
        }
    }
}
