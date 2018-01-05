package com.vlocker.ui.view;

class y implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ long b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ float e;
    final /* synthetic */ float f;
    final /* synthetic */ ImageViewTouchBase g;

    y(ImageViewTouchBase imageViewTouchBase, float f, long j, float f2, float f3, float f4, float f5) {
        this.g = imageViewTouchBase;
        this.a = f;
        this.b = j;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
    }

    public void run() {
        float min = Math.min(this.a, (float) (System.currentTimeMillis() - this.b));
        this.g.b(((float) this.g.b((double) min, 0.0d, (double) this.c, (double) this.a)) + this.d, this.e, this.f);
        if (min < this.a) {
            this.g.n.post(this);
            return;
        }
        this.g.a(this.g.getScale());
        this.g.a(true, true);
    }
}
