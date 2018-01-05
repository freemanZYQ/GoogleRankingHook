package com.vlocker.locker.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.ui.cover.h;
import com.vlocker.ui.widget.CoverViewPager;

class g implements OnTouchListener {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.X = motionEvent.getRawX() - this.a.V;
        this.a.Y = motionEvent.getRawY() - this.a.W;
        switch (motionEvent.getAction()) {
            case 0:
                CoverViewPager.a = true;
                this.a.X = 0.0f;
                this.a.Y = 0.0f;
                this.a.V = motionEvent.getRawX();
                this.a.W = motionEvent.getRawY();
                this.a.Z = System.currentTimeMillis();
                this.a.x.c();
                this.a.G.removeCallbacks(this.a.ab);
                this.a.G.postDelayed(this.a.ab, 500);
                break;
            case 1:
                this.a.G.removeCallbacks(this.a.ab);
                if (this.a.X == 0.0f && this.a.Y == 0.0f) {
                    if (System.currentTimeMillis() - this.a.Z > 150) {
                        this.a.x.a(false);
                        break;
                    }
                    this.a.x.a();
                    break;
                }
                this.a.x.a(Math.abs(h.a == 1 ? this.a.X : this.a.Y) > 0.0f);
                break;
                break;
            case 2:
                float n = h.a == 1 ? this.a.X : h.a == 1 ? this.a.Y : -this.a.Y;
                if (n > 0.0f) {
                    this.a.x.a(Math.abs((int) this.a.X), Math.abs((int) this.a.Y));
                    break;
                }
                break;
        }
        return true;
    }
}
