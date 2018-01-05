package com.vlocker.ui.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.vlocker.ui.widget.a.l;
import com.vlocker.ui.widget.c.d;

public class LockNumberImageView extends ImageView {
    private l a;

    public LockNumberImageView(Context context) {
        this(context, null);
    }

    public LockNumberImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b() {
        if (this.a != null && this.a.i != null) {
            setBackgroundDrawable(a.a(getContext(), this.a.i, ((float) this.a.k) * d.a, ((float) this.a.l) * d.a));
        }
    }

    public void a() {
        setBackgroundDrawable(null);
    }

    public float getH() {
        return this.a == null ? 0.0f : ((float) this.a.l) * d.a;
    }

    public float getPaintX() {
        return this.a == null ? 0.0f : this.a.f * d.a;
    }

    public float getPaintY() {
        return this.a == null ? 0.0f : this.a.g * d.c;
    }

    public float getW() {
        return this.a == null ? 0.0f : ((float) this.a.k) * d.a;
    }

    public LayoutParams getmLayoutParams() {
        LayoutParams layoutParams = new LayoutParams((int) (((float) this.a.k) * d.a), (int) (((float) this.a.l) * d.a));
        layoutParams.setMargins((int) getPaintX(), (int) getPaintY(), 0, 0);
        return layoutParams;
    }

    public void setImageData(l lVar) {
        this.a = lVar;
        b();
    }
}
