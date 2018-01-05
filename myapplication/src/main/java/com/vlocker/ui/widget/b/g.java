package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.vlocker.ui.widget.a.d;
import java.util.Date;

public class g extends c {
    int a = 0;
    int b = -1;
    Bitmap c;
    Bitmap g;

    public g(Context context, d dVar) {
        super(context, dVar);
        f();
    }

    public void a() {
        this.a = new Date(System.currentTimeMillis()).getMinutes();
        if (this.b != this.a) {
            this.b = this.a;
            if (this.e != null) {
                g();
            }
        }
    }

    public void a(Canvas canvas) {
        if (this.c != null) {
            float d = d();
            float e = e();
            canvas.drawBitmap(this.c, d, e, null);
            if (this.g != null) {
                canvas.drawBitmap(this.g, d + ((float) this.c.getWidth()), e, null);
            }
        }
    }

    public int b() {
        return 0;
    }

    public float c() {
        return 0.0f;
    }

    public void f() {
        a();
    }

    public void g() {
        if (this.e.j != null) {
            int i = this.a % 10;
            this.c = a(this.e.j + (this.a / 10));
            this.g = a(this.e.j + i);
        }
    }
}
