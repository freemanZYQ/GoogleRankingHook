package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.g;

public class MaskTextView extends TextView {
    static Handler a = new Handler();
    private static int h = 15;
    private static float i = 0.1f;
    private Paint b;
    private Bitmap c;
    private Matrix d;
    private float e = 0.0f;
    private int f = 420;
    private int g;
    private Runnable j = new ai(this);

    public MaskTextView(Context context) {
        super(context);
        g();
    }

    public MaskTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public MaskTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    private void a(float f, float f2) {
        float width = f - ((float) (this.c.getWidth() / 2));
        this.d.reset();
        this.d.postTranslate(width, 0.0f);
        invalidate();
    }

    private void f() {
        a.removeCallbacks(this.j);
        a.postDelayed(this.j, 1000);
    }

    private void g() {
        setLayerType(2, null);
        this.d = new Matrix();
        try {
            this.c = BitmapFactory.decodeResource(getResources(), R.drawable.l_bottom_bar_lock_text_mask);
        } catch (OutOfMemoryError e) {
            Options options;
            try {
                options = new Options();
                options.inSampleSize = 2;
                this.c = BitmapFactory.decodeResource(getResources(), R.drawable.l_bottom_bar_lock_text_mask, options);
            } catch (OutOfMemoryError e2) {
                try {
                    options = new Options();
                    options.inSampleSize = 4;
                    this.c = BitmapFactory.decodeResource(getResources(), R.drawable.l_bottom_bar_lock_text_mask, options);
                } catch (OutOfMemoryError e3) {
                    this.c = null;
                }
            }
        }
        this.b = new Paint();
        this.b.setAntiAlias(true);
        a();
        this.b.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.g = getContext().getResources().getDisplayMetrics().widthPixels;
        if (this.g != 0) {
            this.f = (this.g * 2) / 3;
        }
        i = ((float) this.f) / 1000.0f;
    }

    public void a() {
        int dn = a.a(getContext()).dn();
        if (dn != -1) {
            setTextColor(dn);
            Drawable a = g.a(getContext().getResources().getDrawable(R.drawable.l_lockscreen_slipright_icon), a.a(getContext()).dn());
            a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
            setCompoundDrawables(a, null, null, null);
            return;
        }
        setTextColor(-3092272);
        a = getContext().getResources().getDrawable(R.drawable.l_lockscreen_slipright_icon);
        a.setColorFilter(-3092272, Mode.SRC_IN);
        a.setBounds(0, 0, a.getMinimumWidth(), a.getMinimumHeight());
        setCompoundDrawables(a, null, null, null);
    }

    public void b() {
        f();
    }

    public synchronized void c() {
        a.removeCallbacks(this.j);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.c != null) {
            canvas.drawBitmap(this.c, this.d, this.b);
        }
    }

    public void setVisibility(int i) {
        if (i != 0) {
            c();
        }
        super.setVisibility(i);
    }
}
