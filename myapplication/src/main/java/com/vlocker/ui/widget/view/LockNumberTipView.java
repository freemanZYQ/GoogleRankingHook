package com.vlocker.ui.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.a.n;
import com.vlocker.ui.widget.c.d;

public class LockNumberTipView extends TextView {
    private n a;
    private Context b;

    public LockNumberTipView(Context context) {
        this(context, null);
        this.b = context;
    }

    public LockNumberTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b() {
        setGravity(17);
        setTextColor(-1);
        setText(this.b.getResources().getText(R.string.input_password_txt));
        setTextSize(16.0f);
        if (!(this.a == null || this.a.a == null)) {
            setBackgroundDrawable(a.a(getContext(), this.a.a, ((float) this.a.k) * d.a, ((float) this.a.l) * d.a));
        }
        a();
    }

    public void a() {
        if (this.a == null || this.a.E == -1) {
            setTextColor(-1);
        } else {
            setTextColor(this.a.E);
        }
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

    public void setTipData(n nVar) {
        this.a = nVar;
        b();
    }
}
