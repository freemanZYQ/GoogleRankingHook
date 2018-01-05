package com.vlocker.locker.b;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.baidu.location.LocationClientOption;
import com.vlocker.b.p;

class c implements OnTouchListener {
    final /* synthetic */ a a;
    private int b = 0;
    private boolean c = false;
    private float d = 0.0f;
    private float e = 0.0f;
    private long f = 0;
    private boolean g = false;
    private float h = 0.0f;
    private boolean i;

    c(a aVar) {
        this.a = aVar;
    }

    private void a(long j) {
        p.a(this.a.i, "Vlocker_Open_Camera_PPC_TF", "camera", this.a.m.bb());
        p.a(this.a.i, "v_open", "101000", "101001", "1014");
        p.b("101000", "101001");
        ViewPropertyAnimator animate = this.a.e.animate();
        animate.cancel();
        animate.setListener(new e(this));
        animate.translationY((float) (-this.a.e.getHeight())).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(j).start();
    }

    private void a(long j, int i) {
        p.a(this.a.i, "Vlocker_Click_Camera_PPC_TF", new String[0]);
        ViewPropertyAnimator animate = this.a.e.animate();
        animate.cancel();
        animate.setListener(new d(this));
        if (i == -1) {
            animate.translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300).start();
        } else {
            animate.translationY(0.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        }
    }

    public void a(int i) {
        if (!this.a.r || i <= this.a.j * -3) {
            this.a.e.setY(i > 0 ? 0.0f : (float) i);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.a.m.aw()) {
            return false;
        }
        if (this.a.o) {
            if ((motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) && this.a.r) {
                this.a.r = false;
                this.a.a(false);
            }
            return true;
        }
        this.a.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (!this.c) {
                this.a.g();
            }
            this.a.a = motionEvent.getPointerId(0);
            this.a.l = true;
            this.i = true;
            this.d = motionEvent.getRawY();
            motionEvent.getRawX();
            this.e = motionEvent.getRawY();
            this.h = motionEvent.getRawY();
            this.a.f.setVisibility(0);
            a(0);
            this.c = true;
            this.g = false;
            this.b = 0;
            this.f = System.currentTimeMillis();
        } else if (actionMasked == 1 || actionMasked == 3) {
            VelocityTracker f = this.a.p;
            int i = this.a.a;
            f.computeCurrentVelocity(LocationClientOption.MIN_SCAN_SPAN, (float) this.a.q);
            int xVelocity = (int) f.getXVelocity(i);
            this.a.l = false;
            if (this.c && this.g) {
                long j = motionEvent.getRawY() < ((float) (this.a.k / 3)) ? 150 : motionEvent.getRawY() < ((float) (this.a.k / 2)) ? 250 : 300;
                if (this.b != 1 || Math.abs(xVelocity) <= 250) {
                    this.a.r = false;
                    a(j, this.b);
                } else {
                    this.a.r = false;
                    a(j);
                }
            }
            this.c = false;
            if (!this.g && System.currentTimeMillis() - this.f < 300 && this.i) {
                if (this.a.r) {
                    this.a.r = false;
                    this.a.a(false);
                } else {
                    this.a.a();
                }
            }
            if (this.a.r) {
                this.a.r = false;
                this.a.a(false);
            }
            this.a.f();
        } else if (actionMasked == 2 && this.c) {
            if (this.g || Math.abs(motionEvent.getRawY() - this.e) > ((float) this.a.j)) {
                this.g = true;
                a((int) (motionEvent.getRawY() - this.d));
                if (motionEvent.getRawY() < this.h) {
                    this.b = 1;
                } else if (motionEvent.getRawY() > this.h) {
                    this.b = -1;
                }
                this.h = motionEvent.getRawY();
            } else {
                this.e = this.d;
            }
        }
        return true;
    }
}
