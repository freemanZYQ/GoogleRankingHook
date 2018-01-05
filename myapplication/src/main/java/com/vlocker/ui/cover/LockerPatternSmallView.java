package com.vlocker.ui.cover;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.locker.b;
import com.vlocker.ui.graphic.LShapeHolder;
import java.util.ArrayList;
import java.util.List;

public class LockerPatternSmallView extends View {
    private static int[] l = new int[]{Color.parseColor("#ffd37e98"), Color.parseColor("#ff88a2c2"), Color.parseColor("#ffa3c035"), Color.parseColor("#ff73ccd3"), Color.parseColor("#ffe9c238"), Color.parseColor("#ffde7757"), Color.parseColor("#ffe8a099"), Color.parseColor("#ffedeaf8"), Color.parseColor("#ffebd1c2")};
    public final ArrayList a;
    boolean b;
    private Paint c;
    private Paint d;
    private float e;
    private final int f;
    private float g;
    private float h;
    private final Path i;
    private final float j;
    private float k;
    private q m;

    public LockerPatternSmallView(Context context) {
        this(context, null);
    }

    public LockerPatternSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Paint();
        this.d = new Paint();
        this.e = 0.0f;
        this.f = 128;
        this.i = new Path();
        this.a = new ArrayList(9);
        this.m = new q();
        this.b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.LockPatternView);
        this.j = obtainStyledAttributes.getDimension(10, 10.0f);
        this.k = this.j;
        this.e = this.j / 3.0f;
        for (int i = 0; i < 9; i++) {
            this.a.add(a(0.0f, 0.0f, 0, 0));
        }
        setColors(j.c(a.a(getContext()).t()));
        setClickable(true);
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setColor(-256);
        this.d.setAlpha(128);
        this.d.setStyle(Style.STROKE);
        this.d.setStrokeJoin(Join.ROUND);
        this.d.setStrokeCap(Cap.ROUND);
        obtainStyledAttributes.recycle();
    }

    private int a(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    private LShapeHolder a(float f, float f2, int i, int i2) {
        Shape ovalShape = new OvalShape();
        ovalShape.resize((float) i, (float) i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        LShapeHolder lShapeHolder = new LShapeHolder(shapeDrawable);
        lShapeHolder.setX(f);
        lShapeHolder.setY(f2);
        lShapeHolder.setmOriginalX(f);
        lShapeHolder.setmOriginalY(f2);
        int i3 = -16777216 | i2;
        lShapeHolder.setColor(i3);
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i3);
        lShapeHolder.setPaint(paint);
        return lShapeHolder;
    }

    private void a(int i) {
        int i2 = 0;
        while (i2 < 9) {
            try {
                LShapeHolder lShapeHolder = (LShapeHolder) this.a.get(i2);
                lShapeHolder.setColor(l[i2]);
                lShapeHolder.setAlpha(1.0f);
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, boolean z, int i3) {
        LShapeHolder lShapeHolder = (LShapeHolder) this.a.get(i3);
        canvas.translate(lShapeHolder.getX(), lShapeHolder.getY());
        lShapeHolder.getShape().draw(canvas);
        canvas.translate(-lShapeHolder.getX(), -lShapeHolder.getY());
    }

    private void a(p pVar) {
        this.m.a(this.a, pVar.a(), pVar.b());
    }

    private void setColors(int i) {
        try {
            int[] iArr = j.e[0];
            for (int i2 = 0; i2 < 9; i2++) {
                l[i2] = 603979776 | iArr[i2];
            }
            a(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.b = false;
        this.m.c();
    }

    protected void onDraw(Canvas canvas) {
        if (this.b) {
            float f = this.g;
            float f2 = this.h;
            this.d.setStrokeWidth(this.e);
            this.i.rewind();
            boolean z = (this.c.getFlags() & 2) != 0;
            this.c.setFilterBitmap(true);
            for (int i = 0; i < this.m.b(); i++) {
                s a = this.m.a(i);
                Path a2 = a.a();
                a2.reset();
                a2.moveTo(a.b(), a.c());
                if (i < this.m.b() - 1) {
                    a2.lineTo(a.d(), a.e());
                }
                if (i < this.m.b() - 1) {
                    this.d.setShader(this.m.a(i).f());
                } else {
                    this.d.setColor(this.m.a(i).g());
                    this.d.setShader(null);
                }
                canvas.drawPath(this.m.a(i).a(), this.d);
            }
            int paddingTop = getPaddingTop();
            int paddingLeft = getPaddingLeft();
            for (int i2 = 0; i2 < 3; i2++) {
                float f3 = ((float) paddingTop) + (((float) i2) * f2);
                for (int i3 = 0; i3 < 3; i3++) {
                    a(canvas, (int) (((float) paddingLeft) + (((float) i3) * f)), (int) f3, true, (i2 * 3) + i3);
                }
            }
            this.c.setFilterBitmap(z);
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i, getSuggestedMinimumWidth()), a(i2, getSuggestedMinimumHeight()));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.g = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.h = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
        float f = this.h > this.g ? this.g : this.h;
        if (this.j <= f) {
            f = this.j;
        }
        this.k = (float) ((int) f);
        for (int i5 = 0; i5 < 3; i5++) {
            for (int i6 = 0; i6 < 3; i6++) {
                float f2 = ((this.g - this.k) / 2.0f) + (((float) i6) * this.g);
                float f3 = ((this.h - this.k) / 2.0f) + (((float) i5) * this.h);
                LShapeHolder lShapeHolder = (LShapeHolder) this.a.get((i5 * 3) + i6);
                lShapeHolder.setX(f2);
                lShapeHolder.setY(f3);
                lShapeHolder.setmOriginalX(f2);
                lShapeHolder.setmOriginalY(f3);
                lShapeHolder.setColor(l[(i5 * 3) + i6]);
                lShapeHolder.setWidth(this.k);
                lShapeHolder.setHeight(this.k);
            }
        }
    }

    public void setPattern(List list) {
        a();
        this.b = true;
        for (int i = 0; i < list.size(); i++) {
            a((p) list.get(i));
        }
        invalidate();
    }
}
