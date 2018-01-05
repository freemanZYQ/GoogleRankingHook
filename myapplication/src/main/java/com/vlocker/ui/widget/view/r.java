package com.vlocker.ui.widget.view;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

class r {
    private static r e;
    float a = 0.5f;
    float b = 1.0f;
    q c = new q();
    ObjectAnimator d = new ObjectAnimator();

    private r() {
    }

    static r a() {
        if (e == null) {
            synchronized (r.class) {
                if (e == null) {
                    e = new r();
                }
            }
        }
        return e;
    }

    void a(View view, View view2, boolean z) {
        if (this.d != null && this.d.isRunning()) {
            this.d.cancel();
        }
        if (this.c == null) {
            this.c = new q();
        }
        if (z) {
            this.d = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{this.a, 1.0f});
            this.d.setDuration(100);
            this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        } else {
            this.d = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{this.a, 0.0f});
            this.d.setDuration(250);
            this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        this.d.addUpdateListener(new s(this, view, view2));
        this.d.addListener(new t(this, z, view, view2));
        this.d.start();
    }

    void b() {
        this.a = 0.5f;
        this.b = 1.0f;
    }

    public void c() {
        if (this.d != null) {
            this.d.cancel();
        }
    }
}
