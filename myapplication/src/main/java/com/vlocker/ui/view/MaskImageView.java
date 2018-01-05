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
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.vlocker.locker.R;

public class MaskImageView extends View {
    static Handler b = new ad();
    private static int m = 15;
    private static float n = 0.1f;
    public boolean a;
    private Paint c;
    private Bitmap d;
    private Bitmap e;
    private Matrix f;
    private float g = 0.0f;
    private int h = 420;
    private int i;
    private int j;
    private int k = 0;
    private int l = 0;
    private Runnable o = new ac(this);
    private ViewPropertyAnimator p;
    private ViewPropertyAnimator q;
    private Runnable r = new ag(this);
    private Runnable s = new ah(this);

    public MaskImageView(Context context) {
        super(context);
        d();
    }

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public MaskImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }

    private void a(float f, float f2) {
        if (this.d != null && this.e != null) {
            float width = f - ((float) (this.d.getWidth() / 2));
            this.f.reset();
            if (getHeight() > 0) {
                this.f.postScale(((float) getHeight()) / ((float) this.d.getHeight()), ((float) getHeight()) / ((float) this.d.getHeight()));
            }
            this.f.postTranslate(width, 0.0f);
            invalidate();
        }
    }

    private void a(int i) {
        if (!this.a) {
            this.a = true;
            this.l = i;
            if (i == 2) {
                b.removeCallbacks(this.o);
                b.postDelayed(this.o, 1000);
            } else if (i != 3) {
            } else {
                if (this.k == 0) {
                    b.removeCallbacks(this.r);
                    b.postDelayed(this.r, 1000);
                    return;
                }
                b.removeCallbacks(this.s);
                b.postDelayed(this.s, 1000);
            }
        }
    }

    private void d() {
        setLayerType(2, null);
        this.f = new Matrix();
        try {
            this.d = BitmapFactory.decodeResource(getResources(), R.drawable.l_bottom_bar_lock_text_mask);
        } catch (OutOfMemoryError e) {
            Options options;
            try {
                options = new Options();
                options.inSampleSize = 2;
                this.d = BitmapFactory.decodeResource(getResources(), R.drawable.l_bottom_bar_lock_text_mask, options);
            } catch (OutOfMemoryError e2) {
                try {
                    options = new Options();
                    options.inSampleSize = 4;
                    this.d = BitmapFactory.decodeResource(getResources(), R.drawable.l_bottom_bar_lock_text_mask, options);
                } catch (OutOfMemoryError e3) {
                    this.d = null;
                }
            }
        }
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.i = getContext().getResources().getDisplayMetrics().widthPixels;
        if (this.i != 0) {
            this.h = (this.i * 2) / 3;
        }
        n = ((float) this.h) / 1000.0f;
    }

    private void e() {
        this.p = animate();
        this.p.cancel();
        this.p.setListener(new ae(this));
        if (this.j == 1) {
            this.p.setInterpolator(new AccelerateDecelerateInterpolator()).translationX((float) (this.i / 20)).setDuration(1000);
        } else if (this.j == 2) {
            this.p.setInterpolator(new AccelerateDecelerateInterpolator()).translationY((float) (this.i / 20)).setDuration(1000);
        } else if (this.j == 3) {
            this.p.setInterpolator(new AccelerateDecelerateInterpolator()).translationY((float) ((-this.i) / 20)).setDuration(1000);
        }
    }

    private void f() {
        this.q = animate();
        this.q.cancel();
        this.q.setListener(new af(this));
        if (this.j == 1) {
            this.q.setInterpolator(new AccelerateDecelerateInterpolator()).translationX(0.0f).setDuration(1000);
        } else if (this.j == 2) {
            this.q.setInterpolator(new AccelerateDecelerateInterpolator()).translationY(0.0f).setDuration(1000);
        } else if (this.j == 3) {
            this.q.setInterpolator(new AccelerateDecelerateInterpolator()).translationY(0.0f).setDuration(1000);
        }
    }

    public synchronized void a() {
        this.a = false;
        if (this.p != null) {
            this.p.cancel();
        }
        if (this.q != null) {
            this.q.cancel();
        }
        b.removeCallbacks(this.s);
        b.removeCallbacks(this.r);
        b.removeCallbacks(this.o);
    }

    public void a(int i, int i2) {
        if (i != 1) {
            this.j = i2;
            a(i);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.e != null) {
            canvas.drawBitmap(this.e, 0.0f, 0.0f, this.c);
        }
        this.c.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        if (this.d != null && this.l == 2) {
            canvas.drawBitmap(this.d, this.f, this.c);
        }
        this.c.setXfermode(null);
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.e = bitmap;
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = bitmap.getWidth();
            layoutParams.height = bitmap.getHeight();
            requestLayout();
        }
    }

    public void setVisibility(int i) {
        if (i != 0) {
            a();
        }
        super.setVisibility(i);
    }
}
