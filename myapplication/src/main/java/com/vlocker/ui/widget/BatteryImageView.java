package com.vlocker.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.vlocker.c.a;
import com.vlocker.locker.R;

public class BatteryImageView extends ImageView {
    public static final int[] a = new int[]{R.drawable.l_e_0_9, R.drawable.l_e_10_39, R.drawable.l_e_40_59, R.drawable.l_e_60_90, R.drawable.l_e_90_100};
    private int b;
    private boolean c = false;
    private boolean d = false;
    private a e;
    private int f = -1;

    public BatteryImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            a();
        }
    }

    private void a() {
        this.e = a.a(getContext());
        if (this.e.ai() == 0) {
            setVisibility(8);
            this.c = false;
            return;
        }
        setVisibility(0);
        this.c = true;
    }

    public void a(int i) {
        this.f = i;
        setColorFilter(this.f);
    }

    public void a(int i, boolean z) {
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        if (!z) {
            this.d = false;
        } else if (this.d) {
            this.d = true;
        } else {
            this.d = true;
        }
        this.b = i;
        if (i >= 0 && i < 10) {
            setImageDrawable(getContext().getResources().getDrawable(a[0]));
        } else if (10 <= i && i < 40) {
            setImageDrawable(getContext().getResources().getDrawable(a[1]));
        } else if (40 <= i && i < 60) {
            setImageDrawable(getContext().getResources().getDrawable(a[2]));
        } else if (60 <= i && i < 90) {
            setImageDrawable(getContext().getResources().getDrawable(a[3]));
        } else if (90 <= i && i <= 100) {
            setImageDrawable(getContext().getResources().getDrawable(a[4]));
        }
        setColorFilter(this.f);
    }
}
