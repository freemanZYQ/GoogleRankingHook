package com.vlocker.theme.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.vlocker.splash.newa.b;

public class RecyclingImageView extends ImageView {
    public String a = "";
    public u b;
    protected boolean c = false;
    public final float[] d = new float[]{1.0f, 0.0f, 0.0f, 0.0f, -50.0f, 0.0f, 1.0f, 0.0f, 0.0f, -40.0f, 0.0f, 0.0f, 1.0f, 0.0f, -40.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public final float[] e = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int f;
    private r g;
    private l h;
    private String i;
    private boolean j = false;
    private boolean k;
    private boolean l = false;
    private w m;
    private b n;
    private boolean o = false;
    private boolean p;
    private Paint q = new Paint();
    private PaintFlagsDrawFilter r = new PaintFlagsDrawFilter(0, 3);

    public RecyclingImageView(Context context) {
        super(context);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width > height ? height : width;
        return Bitmap.createBitmap(bitmap, width > height ? (width - height) / 2 : 0, width > height ? 0 : (height - width) / 2, i, i, null, false);
    }

    private Bitmap a(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.q.setAntiAlias(true);
        this.q.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        this.q.setColor(-12434878);
        int width = bitmap.getWidth();
        canvas.drawCircle((float) (width / 2), (float) (width / 2), (float) (width / 2), this.q);
        this.q.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, this.q);
        return createBitmap;
    }

    private Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void a() {
        try {
            if (this.f != 0) {
                setImageResource(this.f);
            } else {
                setImageBitmap(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(Drawable drawable, boolean z) {
        if (drawable instanceof z) {
            ((z) drawable).a(z);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                a(layerDrawable.getDrawable(i), z);
            }
        }
    }

    private void a(boolean z) {
        if (this.o && getDrawable() != null) {
            if (z) {
                getDrawable().setColorFilter(new ColorMatrixColorFilter(this.d));
            } else {
                getDrawable().setColorFilter(new ColorMatrixColorFilter(this.e));
            }
        }
    }

    void a(int i, boolean z) {
        Object obj = 1;
        try {
            Object obj2;
            Object obj3;
            int width = getWidth();
            int height = getHeight();
            if (getLayoutParams() != null) {
                obj2 = getLayoutParams().width == -2 ? 1 : null;
                obj3 = getLayoutParams().height == -2 ? 1 : null;
            } else {
                obj3 = null;
                obj2 = null;
            }
            if (obj2 == null || obj3 == null) {
                obj = null;
            }
            if (width == 0 && height == 0 && r1 == null) {
                a();
            }
            if (TextUtils.isEmpty(this.i)) {
                a();
                return;
            }
            if (obj2 != null) {
                if (obj3 == null) {
                }
                if (this.b == null) {
                    this.b = y.a().a(1);
                }
                this.b.a(this.i, this, i, z);
            }
            if (obj3 == null) {
            }
            if (this.b == null) {
                this.b = y.a().a(1);
            }
            this.b.a(this.i, this, i, z);
            if (this.b == null) {
                this.b = y.a().a(1);
            }
            this.b.a(this.i, this, i, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, int i, int i2) {
        Drawable drawable = null;
        this.b = y.a().a(i);
        this.i = str;
        try {
            if (this.b != null) {
                this.c = this.b.c();
                this.b.b();
                this.h = this.b.a();
                this.g = this.b.a;
                drawable = this.g.a(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (drawable != null) {
            setImageDrawable(drawable);
        } else {
            a(i2, true);
        }
    }

    public void b(String str, int i, int i2) {
        Drawable drawable = null;
        this.b = y.a().a(i);
        this.i = str;
        try {
            if (this.b != null) {
                this.c = this.b.c();
                this.b.b();
                this.h = this.b.a();
                this.g = this.b.a;
                drawable = this.g.a(str + i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (drawable != null) {
            setImageDrawable(drawable);
        } else {
            a(i2, true);
        }
    }

    public void c(String str, int i, int i2) {
        this.b = y.a().a(i);
        this.i = str;
        try {
            if (this.b != null) {
                this.c = this.b.c();
                this.b.b();
                this.h = this.b.a();
                this.g = this.b.a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(i2, false);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public String getImageUrl() {
        return this.i;
    }

    public w getTask() {
        return this.m;
    }

    public b getiImageResult() {
        return this.n;
    }

    public boolean getisLoad() {
        return this.j;
    }

    public boolean getisLoadFail() {
        return this.l;
    }

    public boolean getisLoading() {
        return this.k;
    }

    protected void onDetachedFromWindow() {
        setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (!this.p || drawable == null || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                super.onDraw(canvas);
                return;
            }
            Bitmap a = a(drawable);
            if (a.getWidth() != a.getHeight()) {
                a = a(a);
            }
            a = a(a, 14);
            Rect rect = new Rect(0, 0, a.getWidth(), a.getHeight());
            Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
            this.q.reset();
            canvas.setDrawFilter(this.r);
            canvas.drawBitmap(a, rect, rect2, this.q);
        } catch (Exception e) {
        }
    }

    public void setErrorImageResId(int i) {
    }

    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        a(drawable, true);
        a(drawable2, false);
    }

    public void setImageTask(w wVar) {
        this.m = wVar;
    }

    public void setIsCircle(boolean z) {
        this.p = z;
    }

    public void setLoadFail(boolean z) {
        this.l = z;
    }

    public void setPressed(boolean z) {
        a(z);
        super.setPressed(z);
    }

    public void setPressedDark(boolean z) {
        this.o = z;
    }

    public void setiImageResult(b bVar) {
        this.n = bVar;
    }

    public void setisload(boolean z) {
        this.j = z;
    }

    public void setisloading(boolean z) {
        this.k = z;
    }
}
