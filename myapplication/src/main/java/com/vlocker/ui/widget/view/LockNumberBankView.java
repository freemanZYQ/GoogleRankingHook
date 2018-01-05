package com.vlocker.ui.widget.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.a.j;
import com.vlocker.ui.widget.c.d;
import java.lang.reflect.Array;

public class LockNumberBankView extends FrameLayout {
    Drawable a;
    Drawable b;
    public float[][] c;
    public float[][] d;
    public float[][] e;
    public float[][] f;
    public float[][] g;
    private j h;
    private Context i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    public LockNumberBankView(Context context) {
        this(context, null);
        this.i = context;
    }

    public LockNumberBankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = (int) (10.0f * d.a);
        this.l = (int) (60.0f * d.a);
        this.m = 0;
        this.n = 0;
        this.a = null;
        this.b = null;
        this.c = new float[][]{new float[]{0.5f, 0.25333333f}, new float[]{0.76666665f, 0.50666666f}, new float[]{0.5f, 0.76f}, new float[]{0.24666667f, 0.50666666f}};
        this.d = new float[][]{new float[]{0.16666667f, 0.38f}, new float[]{0.5f, 0.38f}, new float[]{0.8333333f, 0.38f}, new float[]{0.68666667f, 0.6666667f}, new float[]{0.34f, 0.6666667f}};
        this.e = new float[][]{new float[]{0.32666665f, 0.23333333f}, new float[]{0.66f, 0.23333333f}, new float[]{0.82666665f, 0.50666666f}, new float[]{0.66f, 0.7733333f}, new float[]{0.32666665f, 0.7733333f}, new float[]{0.16666667f, 0.50666666f}};
        this.f = new float[][]{new float[]{0.5f, 0.19333333f}, new float[]{0.78f, 0.34666666f}, new float[]{0.78f, 0.6533333f}, new float[]{0.5f, 0.81333333f}, new float[]{0.22666667f, 0.64f}, new float[]{0.22666667f, 0.34666666f}, new float[]{0.5f, 0.50666666f}};
        this.g = new float[][]{new float[]{0.50666666f, 0.35333332f}, new float[]{0.74f, 0.20666666f}, new float[]{0.8666667f, 0.41333333f}, new float[]{0.74f, 0.6533333f}, new float[]{0.50666666f, 0.8333333f}, new float[]{0.28f, 0.6533333f}, new float[]{0.14f, 0.41333333f}, new float[]{0.28f, 0.20666666f}};
    }

    private Bitmap a(Bitmap bitmap) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (getItemSize() <= 0.0f || getItemSize() - ((float) this.k) >= ((float) max)) {
            return bitmap;
        }
        float itemSize = (getItemSize() - ((float) this.k)) / ((float) max);
        return a.a(bitmap, itemSize, itemSize);
    }

    private void a(LayoutParams layoutParams, int i) {
        if (this.h != null && this.j != 0) {
            float f;
            if ("1".equals(this.h.c)) {
                f = (((float) this.h.l) * d.a) / ((float) this.j);
                layoutParams.height = (int) f;
                layoutParams.setMargins(0, ((int) f) * i, 0, 0);
            } else if ("0".equals(this.h.c)) {
                f = (((float) this.h.k) * d.a) / ((float) this.j);
                layoutParams.width = (int) f;
                layoutParams.setMargins(((int) f) * i, 0, 0, 0);
            } else if ("2".equals(this.h.c)) {
                int[][] positionArry = getPositionArry();
                if (positionArry != null) {
                    layoutParams.width = (int) ((((double) this.m) * 1.4d) + ((double) (this.k * 2)));
                    layoutParams.height = (int) ((((double) this.n) * 1.4d) + ((double) (this.k * 2)));
                    layoutParams.setMargins(positionArry[i][0] - (layoutParams.width / 2), positionArry[i][1] - (layoutParams.height / 2), 0, 0);
                }
            }
        }
    }

    private void b(boolean z) {
        removeAllViews();
        d();
        for (int i = 0; i < this.j; i++) {
            ViewGroup.LayoutParams layoutParams;
            if (z) {
                layoutParams = new LayoutParams(this.l, this.l);
                layoutParams.setMargins(this.l * i, 0, 0, 0);
            } else {
                LayoutParams layoutParams2 = new LayoutParams(-1, -1);
                a(layoutParams2, i);
            }
            View frameLayout = new FrameLayout(this.i);
            addView(frameLayout, i, layoutParams);
            layoutParams = new LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            frameLayout.addView(new ImageView(this.i), layoutParams);
        }
    }

    private void d() {
        if (this.h != null) {
            Bitmap a;
            if (this.h.a != null) {
                a = a.a(getContext(), this.h.a, 320);
                if (a != null) {
                    if ("1".equals(this.h.c) || "0".equals(this.h.c)) {
                        a = a(a);
                    }
                    this.m = Math.max(a.getWidth(), this.m);
                    this.n = Math.max(a.getHeight(), this.n);
                    this.b = new BitmapDrawable(getContext().getResources(), a);
                }
            }
            if (this.h.b != null) {
                a = a.a(getContext(), this.h.b, 320);
                if (a != null) {
                    if ("1".equals(this.h.c) || "0".equals(this.h.c)) {
                        a = a(a);
                    }
                    this.m = Math.max(a.getWidth(), this.m);
                    this.n = Math.max(a.getHeight(), this.n);
                    this.a = new BitmapDrawable(getContext().getResources(), a);
                }
            }
        }
    }

    private float getItemSize() {
        if (this.h == null || this.j == 0) {
            return 0.0f;
        }
        if ("1".equals(this.h.c)) {
            return Math.min(((float) this.h.k) * d.a, (((float) this.h.l) * d.a) / ((float) this.j));
        } else if (!"0".equals(this.h.c)) {
            return 0.0f;
        } else {
            return Math.min(((float) this.h.l) * d.a, (((float) this.h.k) * d.a) / ((float) this.j));
        }
    }

    private int[][] getPositionArry() {
        float[][] scaleArr = getScaleArr();
        if (scaleArr == null || this.h == null) {
            return (int[][]) null;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.j, 2});
        for (int i = 0; i < this.j; i++) {
            iArr[i][0] = (int) ((scaleArr[i][0] * ((float) this.h.k)) * d.a);
            iArr[i][1] = (int) ((scaleArr[i][1] * ((float) this.h.l)) * d.a);
        }
        return iArr;
    }

    private float[][] getScaleArr() {
        return this.j == 4 ? this.c : this.j == 5 ? this.d : this.j == 6 ? this.e : this.j == 7 ? this.f : this.j == 8 ? this.g : (float[][]) null;
    }

    public LayoutParams a(boolean z) {
        if (z) {
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.setMargins(0, (int) getPaintY(), 0, 0);
            layoutParams.gravity = 1;
            return layoutParams;
        }
        layoutParams = new LayoutParams((int) (((float) this.h.k) * d.a), (int) (((float) this.h.l) * d.a));
        layoutParams.setMargins((int) getPaintX(), (int) getPaintY(), 0, 0);
        return layoutParams;
    }

    public void a() {
        int i = 0;
        if (this.h == null) {
            return;
        }
        if (this.b != null && this.a != null) {
            while (i < this.j) {
                a(b(i), a.a(getContext(), this.a, this.b));
                i++;
            }
        } else if (this.b != null) {
            while (i < this.j) {
                a(b(i), a.a(getContext(), (int) R.drawable.l_point, this.b));
                i++;
            }
        } else if (this.a != null) {
            while (i < this.j) {
                a(b(i), a.a(getContext(), this.a, (int) R.drawable.l_blank));
                i++;
            }
        }
    }

    public void a(int i) {
        if (i == 0) {
            int i2 = 0;
            while (i2 < this.j) {
                try {
                    b(i2).getBackground().clearColorFilter();
                    i2++;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        } else if (i >= this.j) {
            b(i - 1).getBackground().clearColorFilter();
        }
    }

    public void a(int i, Animation animation) {
        View b = b(i);
        if (b != null) {
            b.startAnimation(animation);
        }
    }

    public void a(int i, boolean z) {
        View b = b(i);
        if (b != null) {
            b.setSelected(z);
        }
    }

    public void a(View view, Drawable drawable) {
        if (view != null && drawable != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    public void a(j jVar, int i, boolean z) {
        this.h = jVar;
        this.j = i;
        if (!(this.h == null || this.h.d == null)) {
            setBackgroundDrawable(a.a(this.i, this.h.d, ((float) this.h.k) * d.a, ((float) this.h.l) * d.a));
        }
        b(z);
    }

    public View b(int i) {
        FrameLayout frameLayout = (FrameLayout) getChildAt(i);
        return frameLayout != null ? frameLayout.getChildAt(0) : null;
    }

    public void b() {
        for (int i = 0; i < this.j; i++) {
            View b = b(i);
            if (b != null) {
                b.setSelected(false);
            }
        }
    }

    public Drawable c(int i) {
        View b = b(i);
        return b != null ? b.getBackground() : null;
    }

    public void c() {
        setBackgroundDrawable(null);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View b = b(i);
            if (b != null) {
                b.setBackgroundDrawable(null);
            }
        }
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    public float getH() {
        return this.h == null ? 0.0f : ((float) this.h.l) * d.a;
    }

    public float getPaintX() {
        return this.h == null ? 0.0f : this.h.f * d.a;
    }

    public float getPaintY() {
        return this.h == null ? 0.0f : this.h.g * d.c;
    }

    public float getW() {
        return this.h == null ? 0.0f : ((float) this.h.k) * d.a;
    }
}
