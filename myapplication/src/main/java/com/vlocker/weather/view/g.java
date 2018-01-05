package com.vlocker.weather.view;

import android.os.Handler;
import android.os.Message;

class g extends Handler {
    final /* synthetic */ OverScrollView a;

    g(OverScrollView overScrollView) {
        this.a = overScrollView;
    }

    public void handleMessage(Message message) {
        if (this.a.E == 1) {
            this.a.b = (float) (5.0d + (15.0d * Math.tan((1.5707963267948966d / ((double) this.a.getMeasuredHeight())) * ((double) (this.a.a + Math.abs(this.a.n))))));
            if (this.a.a > 0.0f) {
                OverScrollView overScrollView = this.a;
                overScrollView.a -= this.a.b;
            } else if (this.a.n < 0.0f) {
                this.a.n = this.a.n + this.a.b;
            }
            if (this.a.a < 0.0f) {
                this.a.a = 0.0f;
                this.a.o.a();
            }
            if (this.a.n > 0.0f) {
                this.a.n = 0.0f;
                this.a.o.a();
            }
        } else if (this.a.E == 2) {
            this.a.w = this.a.w + 1;
            if (this.a.w > 12) {
                this.a.v = this.a.v + 1;
                this.a.x = ((-this.a.v) * this.a.F) / 30;
                if ((-this.a.x) > this.a.F) {
                    this.a.n = 0.0f;
                    this.a.setHeaderTopMargin(-this.a.F);
                    this.a.G.a();
                } else {
                    this.a.setHeaderTopMargin(this.a.x);
                }
            }
        }
        this.a.requestLayout();
    }
}
