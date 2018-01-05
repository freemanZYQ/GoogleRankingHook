package com.vlocker.ui.widget;

import com.vlocker.msg.ak;
import com.vlocker.msg.r;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.h;

class g implements r {
    final /* synthetic */ MusicLrcView a;
    private int b;
    private float c = 0.0f;
    private int d;

    g(MusicLrcView musicLrcView) {
        this.a = musicLrcView;
    }

    public void a(float f, ak akVar) {
        this.c += f;
        if (f.e && h.a == 1 && h.b == 1) {
            CoverViewPager k = this.a.w.k();
            if (k.d()) {
                k.b((float) ((int) f));
            }
        }
    }

    public void a(float f, boolean z) {
        if (f.e) {
            CoverViewPager k = this.a.w.k();
            int width = k.getWidth();
            if (f == 0.0f && this.c > 0.0f) {
                this.b = (int) (((float) width) - this.c);
            }
            width = (int) (((float) this.b) * f);
            if (h.a == 1 && h.b == 1) {
                if (k.d()) {
                    k.b((float) (width - this.d));
                }
                if (f == 1.0f) {
                    try {
                        k.e();
                    } catch (Exception e) {
                    }
                    this.b = 0;
                    this.d = 0;
                    this.c = 0.0f;
                    return;
                }
            }
            this.d = width;
        }
    }

    public void a(Runnable runnable, ak akVar) {
        LockerService.a().a(runnable, 2);
    }
}
