package com.vlocker.locker.c;

class j implements Runnable {
    final /* synthetic */ b a;

    j(b bVar) {
        this.a = bVar;
    }

    public void run() {
        this.a.w.setAlpha(1.0f);
        this.a.l().setTranslationX(0.0f);
        this.a.l().setTranslationY(0.0f);
        this.a.l().setAlpha(1.0f);
        if (this.a.y != null) {
            this.a.y.setAlpha(1.0f);
        }
    }
}
