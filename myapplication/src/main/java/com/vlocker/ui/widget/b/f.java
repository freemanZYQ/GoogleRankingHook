package com.vlocker.ui.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.vlocker.ui.widget.a.d;

public class f extends c {
    Bitmap a;

    public f(Context context, d dVar) {
        super(context, dVar);
        f();
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        if (this.a != null) {
            canvas.drawBitmap(this.a, d(), e(), null);
        }
    }

    public int b() {
        return 0;
    }

    public float c() {
        return 0.0f;
    }

    public void f() {
        if (this.e != null) {
            g();
        }
    }

    public void g() {
        if (this.e.j != null) {
            this.a = a(this.e.j);
        }
    }
}
