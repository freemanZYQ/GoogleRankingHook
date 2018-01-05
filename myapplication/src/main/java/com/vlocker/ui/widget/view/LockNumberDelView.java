package com.vlocker.ui.widget.view;

import android.content.Context;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.ui.widget.a.k;
import com.vlocker.ui.widget.c.d;

public class LockNumberDelView extends TextView {
    public static final DrawFilter b = new PaintFlagsDrawFilter(0, 3);
    public int a;
    private k c;
    private Context d;

    public LockNumberDelView(Context context) {
        this(context, null);
        this.d = context;
    }

    public LockNumberDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b() {
        setGravity(17);
        setBackgroundDrawable(null);
        setText(this.d.getResources().getString(R.string.cancel));
        setTextColor(-1);
        setTextSize((float) l.c(this.d.getResources().getDimension(R.dimen.lk_item_del_txt_size)));
        if (!(this.c == null || this.c.b == null)) {
            setBackgroundDrawable(a.a(getContext(), this.c.b, ((float) this.c.k) * d.a, ((float) this.c.l) * d.a));
        }
        a();
    }

    public LayoutParams a(int i) {
        if (LockNumberCoverView.d > 0) {
            if (i > 0) {
                i = 0;
            }
            LayoutParams layoutParams = new LayoutParams((int) (((float) this.c.k) * d.a), (int) (((float) this.c.l) * d.a));
            layoutParams.setMargins((int) getPaintX(), ((int) getPaintY()) + i, 0, 0);
            return layoutParams;
        }
        if (i > 0) {
            i = 0;
        }
        LayoutParams layoutParams2 = new LayoutParams((int) (((float) this.c.k) * d.a), (int) (((float) this.c.l) * d.a));
        layoutParams2.setMargins((int) getPaintX(), ((int) getPaintY()) + i, 0, 0);
        return layoutParams2;
    }

    public void a() {
        if (this.c == null || this.c.E == -1) {
            setTextColor(-1);
        } else {
            setTextColor(this.c.E);
        }
    }

    public float getH() {
        return this.c == null ? 0.0f : ((float) this.c.l) * d.a;
    }

    public float getPaintX() {
        return this.c == null ? 0.0f : this.c.f * d.a;
    }

    public float getPaintY() {
        return this.c == null ? 0.0f : this.c.g * d.c;
    }

    public float getW() {
        return this.c == null ? 0.0f : ((float) this.c.k) * d.a;
    }

    public void setDelData(k kVar) {
        this.c = kVar;
        b();
    }

    public void setType(int i) {
        this.a = i;
        if (i == 0) {
            setBackgroundDrawable(null);
            if (this.c != null && this.c.b != null) {
                setBackgroundDrawable(a.a(getContext(), this.c.b, ((float) this.c.k) * d.a, ((float) this.c.l) * d.a));
            }
        } else if (i == 1) {
            if (this.c.a != null) {
                setBackgroundDrawable(a.a(this.d, this.c.a, ((float) this.c.k) * d.a, ((float) this.c.l) * d.a));
            } else {
                setBackgroundDrawable(this.d.getResources().getDrawable(R.drawable.l_more_img_bg));
            }
            setText("");
        }
    }
}
