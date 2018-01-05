package com.vlocker.weather.view;

import android.support.v4.widget.bi;
import android.util.Log;
import android.view.View;

class o extends bi {
    final /* synthetic */ PromotionAppDetailLayout a;

    private o(PromotionAppDetailLayout promotionAppDetailLayout) {
        this.a = promotionAppDetailLayout;
    }

    public int a(View view, int i, int i2) {
        return super.a(view, i, i2);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
    }

    public void a(View view, float f, float f2) {
        if (this.a.g < 0.13f) {
            this.a.b.a(this.a.e.x, this.a.e.y);
        } else {
            this.a.h = true;
            this.a.b.a(0, this.a.getHeight());
        }
        if (f2 > 3000.0f) {
            this.a.h = true;
            this.a.b.a(0, this.a.getHeight());
        }
        this.a.invalidate();
        super.a(view, f, f2);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.a.g = (((float) i2) * 1.0f) / ((float) this.a.f);
        this.a.invalidate();
        if (!this.a.h || i2 < this.a.f) {
            this.a.j.getBackground().setAlpha((int) ((1.0f - this.a.g) * 255.0f));
            return;
        }
        this.a.a.h();
        if (this.a.i != null) {
            this.a.i.a();
        }
    }

    public boolean a(View view, int i) {
        return true;
    }

    public int b(View view) {
        return this.a.f;
    }

    public int b(View view, int i, int i2) {
        if (!this.a.d) {
            return super.b(view, i, i2);
        }
        int paddingTop = this.a.getPaddingTop();
        int height = this.a.getHeight();
        int min = Math.min(Math.max(i, paddingTop), height);
        Log.e("liu---", ";top=" + i + ";topBound=" + paddingTop + ";bottomBound=" + height + ";newTop=" + min);
        return min;
    }

    public void b(int i, int i2) {
        super.b(i, i2);
    }

    public void b(View view, int i) {
        super.b(view, i);
    }
}
