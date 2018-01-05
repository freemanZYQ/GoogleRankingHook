package com.vlocker.ui.widget.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.vlocker.c.a;
import com.vlocker.m.h;
import com.vlocker.ui.widget.a.o;
import com.vlocker.ui.widget.c.d;

public class LockNumberMainView extends FrameLayout {
    private o a;

    public LockNumberMainView(Context context) {
        this(context, null);
    }

    public LockNumberMainView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LayoutParams a(int i) {
        if (i > 0) {
            i = 0;
        }
        LayoutParams layoutParams = new LayoutParams((int) (((float) this.a.k) * d.a), (int) (((float) this.a.l) * d.a));
        layoutParams.setMargins((int) getPaintX(), ((int) getPaintY()) + i, 0, 0);
        return layoutParams;
    }

    public void a() {
        if (this.a != null && this.a.v != null) {
            setBackgroundDrawable(a.a(getContext(), this.a.v, ((float) this.a.k) * d.a, ((float) this.a.l) * d.a));
        }
    }

    public float getH() {
        return this.a == null ? 0.0f : ((float) this.a.l) * d.a;
    }

    public float getPaintX() {
        return this.a == null ? 0.0f : this.a.f * d.a;
    }

    public float getPaintY() {
        float f = 0.0f;
        if (this.a == null) {
            return 0.0f;
        }
        if (VERSION.SDK_INT < 19 && a.a(getContext()).ai() == 0) {
            f = (float) h.d(getContext());
        }
        return (this.a.g * d.c) - f;
    }

    public float getW() {
        return this.a == null ? 0.0f : ((float) this.a.k) * d.a;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setData(o oVar) {
        this.a = oVar;
        a();
    }
}
