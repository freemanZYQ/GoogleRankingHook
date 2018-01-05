package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import com.vlocker.ui.widget.a.c;
import com.vlocker.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Date;

public class b extends c {
    private c a;
    private Bitmap b = a(this.a.a);
    private Bitmap c = a(this.a.b);
    private Bitmap g = a(this.a.c);
    private Bitmap h = a(this.a.d);
    private Bitmap i = a(this.a.e);
    private Matrix j = new Matrix();
    private Matrix k = new Matrix();
    private Matrix l = new Matrix();

    public b(Context context, d dVar) {
        super(context, dVar);
        this.a = (c) dVar;
        f();
    }

    private void a(Date date) {
        int hours = date.getHours();
        Matrix matrix = this.l;
        if (hours > 12) {
            hours -= 12;
        }
        matrix.setRotate((((float) hours) + (((float) date.getMinutes()) / 60.0f)) * 30.0f, (float) (this.h.getWidth() / 2), (float) (this.h.getHeight() / 2));
        this.k.setRotate(6.0f * (((float) date.getMinutes()) + (((float) date.getSeconds()) / 60.0f)), (float) (this.g.getWidth() / 2), (float) (this.g.getHeight() / 2));
        this.j.setRotate((float) (date.getSeconds() * 6), (float) (this.c.getWidth() / 2), (float) (this.c.getHeight() / 2));
    }

    private void b(Canvas canvas, ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (((c) arrayList.get(i)).e.q) {
                    ((c) arrayList.get(i)).a(canvas);
                }
            }
        }
    }

    private void f() {
        float d = d();
        float e = e();
        d += (float) ((this.b.getWidth() - this.h.getWidth()) / 2);
        this.l.postTranslate(d, e);
        this.k.postTranslate(d, e);
        this.j.postTranslate(d, e);
    }

    public void a() {
        a(new Date(System.currentTimeMillis()));
        f();
    }

    public void a(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.a != null) {
            float d = d();
            float e = e();
            if (this.b != null) {
                canvas.drawBitmap(this.b, d, e, null);
            }
            if (this.h != null) {
                canvas.drawBitmap(this.h, this.l, null);
            }
            if (this.g != null) {
                canvas.drawBitmap(this.g, this.k, null);
            }
            if (this.c != null) {
                canvas.drawBitmap(this.c, this.j, null);
            }
            if (this.i != null) {
                canvas.drawBitmap(this.i, d, e, null);
            }
        }
    }

    public void a(Canvas canvas, ArrayList arrayList) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.a != null) {
            float d = d();
            float e = e();
            canvas.drawBitmap(this.b, d, e, null);
            b(canvas, arrayList);
            canvas.drawBitmap(this.h, this.l, null);
            canvas.drawBitmap(this.g, this.k, null);
            canvas.drawBitmap(this.c, this.j, null);
            canvas.drawBitmap(this.i, d, e, null);
        }
    }

    public int b() {
        return this.b != null ? (int) (e() + ((float) this.b.getHeight())) : 0;
    }

    public float c() {
        return this.a.g;
    }
}
