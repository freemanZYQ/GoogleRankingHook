package com.vlocker.ui.cover;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.b;
import com.vlocker.ui.graphic.LShapeHolder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LockPatternView extends View {
    private static float B;
    private static float C;
    private static final int[] F = new int[]{Color.parseColor("#ffd37e98"), Color.parseColor("#ff88a2c2"), Color.parseColor("#ffa3c035"), Color.parseColor("#ff73ccd3"), Color.parseColor("#ffe9c238"), Color.parseColor("#ffde7757"), Color.parseColor("#ffe8a099"), Color.parseColor("#ffedeaf8"), Color.parseColor("#ffebd1c2")};
    private static boolean I;
    private final float A;
    private ObjectAnimator[] D;
    private int E;
    private int[] G;
    private q H;
    private Paint J;
    a a;
    public final ArrayList b;
    boolean c;
    private boolean d;
    private Paint e;
    private Paint f;
    private float g;
    private r h;
    private ArrayList i;
    private boolean[][] j;
    private float k;
    private float l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private float r;
    private final int s;
    private float t;
    private float u;
    private float v;
    private final Path w;
    private final Rect x;
    private int y;
    private final float z;

    class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new t();
        private final String a;
        private final int b;
        private final boolean c;
        private final boolean d;
        private final boolean e;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.b = parcel.readInt();
            this.c = ((Boolean) parcel.readValue(null)).booleanValue();
            this.d = ((Boolean) parcel.readValue(null)).booleanValue();
            this.e = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        private SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
            parcel.writeValue(Boolean.valueOf(this.c));
            parcel.writeValue(Boolean.valueOf(this.d));
            parcel.writeValue(Boolean.valueOf(this.e));
        }
    }

    public LockPatternView(Context context) {
        this(context, null);
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.e = new Paint();
        this.f = new Paint();
        this.g = 0.0f;
        this.i = new ArrayList(9);
        this.j = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3});
        this.k = -1.0f;
        this.l = -1.0f;
        this.m = 0;
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = false;
        this.r = 0.08f;
        this.s = 128;
        this.t = 0.6f;
        this.w = new Path();
        this.x = new Rect();
        this.b = new ArrayList(9);
        this.D = new ObjectAnimator[9];
        this.E = 0;
        this.G = new int[]{Color.parseColor("#ffd37e98"), Color.parseColor("#ff88a2c2"), Color.parseColor("#ffa3c035"), Color.parseColor("#ff73ccd3"), Color.parseColor("#ffe9c238"), Color.parseColor("#ffde7757"), Color.parseColor("#ffe8a099"), Color.parseColor("#ffedeaf8"), Color.parseColor("#ffebd1c2")};
        this.H = new q();
        this.J = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.LockPatternView);
        this.E = obtainStyledAttributes.getInt(9, 0);
        this.z = obtainStyledAttributes.getDimension(10, 10.0f);
        this.A = obtainStyledAttributes.getFloat(11, 5.0f);
        B = this.z;
        C = this.A;
        this.g = this.z / 3.0f;
        for (int i = 0; i < 9; i++) {
            this.b.add(a(0.0f, 0.0f, 0, 0));
        }
        this.a = a.a(getContext());
        setColors(j.c(this.a.t()));
        I = this.a.R();
        String string = obtainStyledAttributes.getString(0);
        if ("square".equals(string)) {
            this.y = 0;
        } else if ("lock_width".equals(string)) {
            this.y = 1;
        } else if ("lock_height".equals(string)) {
            this.y = 2;
        } else {
            this.y = 0;
        }
        setClickable(true);
        this.f.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setColor(-256);
        this.f.setAlpha(128);
        this.f.setStyle(Style.STROKE);
        this.f.setStrokeJoin(Join.ROUND);
        this.f.setStrokeCap(Cap.ROUND);
        obtainStyledAttributes.recycle();
        a();
    }

    private int a(float f) {
        float f2 = this.v;
        float f3 = f2 * this.t;
        float paddingTop = ((f2 - f3) / 2.0f) + ((float) getPaddingTop());
        for (int i = 0; i < 3; i++) {
            float f4 = (((float) i) * f2) + paddingTop;
            if (f >= f4 && f <= f4 + f3) {
                return i;
            }
        }
        return -1;
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

    private ObjectAnimator a(LShapeHolder lShapeHolder) {
        ObjectAnimator a = a(false, lShapeHolder, B, C, 300, 1, true);
        if (a != null) {
            a.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        return a;
    }

    private ObjectAnimator a(boolean z, LShapeHolder lShapeHolder, float f, float f2, long j, int i, boolean z2) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("width", new float[]{lShapeHolder.getWidth(), lShapeHolder.getWidth() * f2});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("height", new float[]{lShapeHolder.getHeight(), lShapeHolder.getHeight() * f2});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("x", new float[]{lShapeHolder.getX(), lShapeHolder.getX() - ((f / 2.0f) * (f2 - 1.0f))});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("y", new float[]{lShapeHolder.getY(), lShapeHolder.getY() - ((f / 2.0f) * (f2 - 1.0f))});
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(lShapeHolder, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4}).setDuration(j);
        duration.setRepeatCount(i);
        if (z2) {
            duration.setRepeatMode(2);
        }
        duration.addUpdateListener(new n(this));
        if (z) {
            duration.addListener(new o(this, lShapeHolder));
        }
        return duration;
    }

    private p a(float f, float f2) {
        p b = b(f, f2);
        if (b == null) {
            return null;
        }
        a(b);
        if (!this.p) {
            return b;
        }
        performHapticFeedback(1, 3);
        return b;
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
        setContentDescription(getContext().getString(i));
        sendAccessibilityEvent(4);
        setContentDescription(null);
    }

    private void a(Canvas canvas, int i, int i2, boolean z, int i3) {
        LShapeHolder lShapeHolder = (LShapeHolder) this.b.get(i3);
        canvas.translate(lShapeHolder.getX(), lShapeHolder.getY());
        lShapeHolder.getShape().draw(canvas);
        canvas.translate(-lShapeHolder.getX(), -lShapeHolder.getY());
    }

    private void a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        int i = 0;
        while (i < historySize + 1) {
            float historicalX = i < historySize ? motionEvent.getHistoricalX(i) : motionEvent.getX();
            float historicalY = i < historySize ? motionEvent.getHistoricalY(i) : motionEvent.getY();
            int size = this.i.size();
            p a = a(historicalX, historicalY);
            int size2 = this.i.size();
            if (a != null && size2 == 1) {
                this.q = true;
                g();
            }
            if (Math.abs(historicalX - this.k) + Math.abs(historicalY - this.l) > this.u * 0.01f || a != null) {
                float f = this.k;
                float f2 = this.l;
                this.k = historicalX;
                this.l = historicalY;
                if (!this.q || size2 <= 0) {
                    invalidate();
                } else {
                    float f3;
                    float f4;
                    float f5;
                    ArrayList arrayList = this.i;
                    float f6 = (this.u * this.r) * 0.5f;
                    p pVar = (p) arrayList.get(size2 - 1);
                    float b = b(pVar.b);
                    float c = c(pVar.a);
                    Rect rect = this.x;
                    if (b < historicalX) {
                        f3 = historicalX;
                        f4 = b;
                    } else {
                        f3 = b;
                        f4 = historicalX;
                    }
                    if (c < historicalY) {
                        historicalX = c;
                    } else {
                        historicalX = historicalY;
                        historicalY = c;
                    }
                    rect.set((int) (f4 - f6), (int) (historicalX - f6), (int) (f3 + f6), (int) (historicalY + f6));
                    if (b < f) {
                        historicalY = f;
                    } else {
                        historicalY = b;
                        b = f;
                    }
                    if (c < f2) {
                        f5 = f2;
                        f2 = c;
                        c = f5;
                    }
                    rect.union((int) (b - f6), (int) (f2 - f6), (int) (historicalY + f6), (int) (c + f6));
                    if (a != null) {
                        d((a.a * 3) + a.b);
                        historicalX = b(a.b);
                        historicalY = c(a.a);
                        if (size2 >= 2) {
                            pVar = (p) arrayList.get((size2 - 1) - (size2 - size));
                            f2 = b(pVar.b);
                            c = c(pVar.a);
                            if (historicalX < f2) {
                                f5 = f2;
                                f2 = historicalX;
                                historicalX = f5;
                            }
                            if (historicalY < c) {
                                f5 = historicalX;
                                historicalX = historicalY;
                                historicalY = f5;
                            } else {
                                f5 = historicalY;
                                historicalY = historicalX;
                                historicalX = c;
                                c = f5;
                            }
                        } else {
                            c = historicalY;
                            f2 = historicalX;
                            f5 = historicalY;
                            historicalY = historicalX;
                            historicalX = f5;
                        }
                        f = this.u / 2.0f;
                        b = this.v / 2.0f;
                        rect.set((int) (f2 - f), (int) (historicalX - b), (int) (historicalY + f), (int) (c + b));
                    }
                    invalidate(rect);
                }
            }
            i++;
        }
    }

    private void a(p pVar) {
        this.j[pVar.a()][pVar.b()] = true;
        this.H.a(this.b, pVar.a, pVar.b);
        this.i.add(pVar);
        f();
    }

    private float b(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.u)) + (this.u / 2.0f);
    }

    private int b(float f) {
        float f2 = this.u;
        float f3 = f2 * this.t;
        float paddingLeft = ((f2 - f3) / 2.0f) + ((float) getPaddingLeft());
        for (int i = 0; i < 3; i++) {
            float f4 = (((float) i) * f2) + paddingLeft;
            if (f >= f4 && f <= f4 + f3) {
                return i;
            }
        }
        return -1;
    }

    private ObjectAnimator b(LShapeHolder lShapeHolder) {
        return c(lShapeHolder);
    }

    private p b(float f, float f2) {
        int a = a(f2);
        if (a < 0) {
            return null;
        }
        int b = b(f);
        return (b < 0 || this.j[a][b]) ? null : p.a(a, b);
    }

    private void b(MotionEvent motionEvent) {
        p.b("101000", "101003");
        if (!this.i.isEmpty()) {
            this.q = false;
            h();
            invalidate();
        }
    }

    private float c(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.v)) + (this.v / 2.0f);
    }

    private ObjectAnimator c(LShapeHolder lShapeHolder) {
        ObjectAnimator a = a(true, lShapeHolder, B, C, 300, 1, true);
        if (a != null) {
            a.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        return a;
    }

    private void c(MotionEvent motionEvent) {
        j();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        p a = a(x, y);
        if (a != null) {
            this.q = true;
            this.m = 0;
            g();
        } else {
            this.q = false;
            i();
        }
        if (a != null) {
            float b = b(a.b);
            float c = c(a.a);
            float f = this.u / 2.0f;
            float f2 = this.v / 2.0f;
            d(a.b + (a.a * 3));
            invalidate((int) (b - f), (int) (c - f2), (int) (b + f), (int) (c + f2));
        }
        this.k = x;
        this.l = y;
    }

    private void d(int i) {
        ObjectAnimator objectAnimator = this.D[i];
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    private void e(int i) {
        int i2 = 0;
        while (i2 < 9) {
            try {
                LShapeHolder lShapeHolder = (LShapeHolder) this.b.get(i2);
                lShapeHolder.setColor(this.G[i2]);
                if (i != 0) {
                    lShapeHolder.setAlpha(1.0f);
                } else {
                    lShapeHolder.setAlpha(1.0f);
                }
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void f() {
        if (this.h != null) {
            this.h.b(this.i);
        }
        a((int) R.string.lockscreen_access_pattern_cell_added);
    }

    private void g() {
        if (this.h != null) {
            this.h.a();
        }
        a((int) R.string.lockscreen_access_pattern_start);
    }

    private void h() {
        if (this.h != null) {
            this.h.a(this.i);
        }
        a((int) R.string.lockscreen_access_pattern_detected);
    }

    private void i() {
        if (this.h != null) {
            this.h.b();
        }
        a((int) R.string.lockscreen_access_pattern_cleared);
    }

    private void j() {
        this.i.clear();
        k();
        o();
        n();
        this.H.c();
        this.m = 0;
        invalidate();
    }

    private void k() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.j[i][i2] = false;
            }
        }
    }

    private void l() {
        for (int i = 0; i < 9; i++) {
            if (I) {
                this.D[i] = a((LShapeHolder) this.b.get(i));
            } else if (this.E == 0) {
                this.D[i] = c((LShapeHolder) this.b.get(i));
            } else {
                this.D[i] = b((LShapeHolder) this.b.get(i));
            }
        }
    }

    private void m() {
        if (!this.c) {
            a a = a.a(getContext());
            if (this.E == 0) {
                setColors(j.c(a.t()));
            } else {
                setColors(0);
            }
            this.c = true;
        }
    }

    private void n() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            LShapeHolder lShapeHolder = (LShapeHolder) this.b.get(i);
            lShapeHolder.setX(lShapeHolder.getmOriginalX());
            lShapeHolder.setY(lShapeHolder.getmOriginalY());
            lShapeHolder.setWidth(B);
            lShapeHolder.setHeight(B);
            lShapeHolder.setAlpha(255.0f);
        }
    }

    private void o() {
        for (int i = 0; i < 9; i++) {
            ObjectAnimator objectAnimator = this.D[i];
            if (objectAnimator != null && objectAnimator.isRunning()) {
                objectAnimator.end();
            }
        }
    }

    private void setColors(int i) {
        int i2 = 0;
        if (i < 0 || i > 9) {
            while (i2 < 9) {
                this.G[i2] = F[i2] | -16777216;
                i2++;
            }
        } else {
            try {
                int[] iArr = j.e[i];
                if (i == 0) {
                    while (i2 < 9) {
                        this.G[i2] = 603979776 | iArr[i2];
                        i2++;
                    }
                } else {
                    while (i2 < 9) {
                        this.G[i2] = iArr[i2] | -16777216;
                        i2++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        e(i);
    }

    void a() {
        this.J.setAntiAlias(true);
        this.J.setDither(true);
        this.J.setStyle(Style.STROKE);
        this.J.setStrokeJoin(Join.ROUND);
        this.J.setStrokeCap(Cap.ROUND);
    }

    public void a(int i, List list) {
        this.i.clear();
        this.i.addAll(list);
        k();
        for (p pVar : list) {
            this.j[pVar.a()][pVar.b()] = true;
        }
        setDisplayMode(i);
    }

    public void b() {
        j();
    }

    public void c() {
        this.n = false;
    }

    public void d() {
        this.n = true;
    }

    public void e() {
        this.c = false;
    }

    protected int getSuggestedMinimumHeight() {
        return (int) ((3.0f * B) * C);
    }

    protected int getSuggestedMinimumWidth() {
        return (int) ((3.0f * B) * C);
    }

    protected void onDraw(Canvas canvas) {
        m();
        boolean[][] zArr = this.j;
        float f = this.u;
        float f2 = this.v;
        this.f.setStrokeWidth(this.g);
        this.w.rewind();
        Object obj = (!this.o || this.m == 2) ? 1 : null;
        boolean z = (this.e.getFlags() & 2) != 0;
        this.e.setFilterBitmap(true);
        if (I != this.a.R()) {
            I = this.a.R();
            l();
        }
        if (!(obj == null || I)) {
            for (int i = 0; i < this.H.b(); i++) {
                s a = this.H.a(i);
                Path a2 = a.a();
                a2.reset();
                a2.moveTo(a.b, a.c);
                if (i < this.H.b() - 1) {
                    a2.lineTo(a.d, a.e);
                } else if (this.q) {
                    this.H.a().lineTo(this.k, this.l);
                }
                if (i < this.H.b() - 1) {
                    this.f.setShader(this.H.a(i).f());
                } else {
                    this.f.setColor(this.H.a(i).g());
                    this.f.setShader(null);
                }
                canvas.drawPath(this.H.a(i).a(), this.f);
            }
        }
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < 3; i2++) {
            float f3 = ((float) paddingTop) + (((float) i2) * f2);
            for (int i3 = 0; i3 < 3; i3++) {
                a(canvas, (int) (((float) paddingLeft) + (((float) i3) * f)), (int) f3, zArr[i2][i3], (i2 * 3) + i3);
            }
        }
        this.e.setFilterBitmap(z);
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int a = a(i, suggestedMinimumWidth);
        suggestedMinimumWidth = a(i2, suggestedMinimumHeight);
        switch (this.y) {
            case 0:
                suggestedMinimumWidth = Math.min(a, suggestedMinimumWidth);
                a = suggestedMinimumWidth;
                break;
            case 1:
                suggestedMinimumWidth = Math.min(a, suggestedMinimumWidth);
                break;
            case 2:
                a = Math.min(a, suggestedMinimumWidth);
                break;
        }
        setMeasuredDimension(a, suggestedMinimumWidth);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(0, l.a(savedState.a()));
        this.m = savedState.b();
        this.n = savedState.c();
        this.o = savedState.d();
        this.p = savedState.e();
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), l.a(this.i), this.m, this.n, this.o, this.p);
    }

    public void onScreenStateChanged(int i) {
        if (1 == i) {
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.u = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.v = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
        float f = this.v > this.u ? this.u : this.v;
        B = (float) ((int) (this.z > f ? f : this.z));
        C = this.A > f / B ? f / B : this.A;
        for (int i5 = 0; i5 < 3; i5++) {
            for (int i6 = 0; i6 < 3; i6++) {
                float f2 = ((this.u - B) / 2.0f) + (((float) i6) * this.u);
                float f3 = ((this.v - B) / 2.0f) + (((float) i5) * this.v);
                LShapeHolder lShapeHolder = (LShapeHolder) this.b.get((i5 * 3) + i6);
                lShapeHolder.setX(f2);
                lShapeHolder.setY(f3);
                lShapeHolder.setmOriginalX(f2);
                lShapeHolder.setmOriginalY(f3);
                lShapeHolder.setColor(this.G[(i5 * 3) + i6]);
                lShapeHolder.setWidth(B);
                lShapeHolder.setHeight(B);
                if (I) {
                    this.D[(i5 * 3) + i6] = a((LShapeHolder) this.b.get((i5 * 3) + i6));
                } else if (this.E == 0) {
                    this.D[(i5 * 3) + i6] = c((LShapeHolder) this.b.get((i5 * 3) + i6));
                } else {
                    this.D[(i5 * 3) + i6] = b((LShapeHolder) this.b.get((i5 * 3) + i6));
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (!this.n || !isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                c(motionEvent);
                return true;
            case 1:
            case 3:
                b(motionEvent);
                return true;
            case 2:
                a(motionEvent);
                return true;
            default:
                return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        e();
    }

    public void setDisplayMode(int i) {
        this.m = i;
        if (i == 1) {
            if (this.i.size() == 0) {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
            p pVar = (p) this.i.get(0);
            this.k = b(pVar.b());
            this.l = c(pVar.a());
            k();
        }
        invalidate();
    }

    public void setInStealthMode(boolean z) {
        this.o = z;
    }

    public void setOnPatternListener(r rVar) {
        this.h = rVar;
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.p = z;
    }
}
