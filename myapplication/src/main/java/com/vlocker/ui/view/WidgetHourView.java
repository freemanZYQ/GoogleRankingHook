package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.vlocker.locker.b.ap;
import com.vlocker.m.l;
import com.vlocker.ui.widget.a.d;
import com.vlocker.ui.widget.a.q;
import com.vlocker.ui.widget.b.a;
import com.vlocker.ui.widget.b.b;
import com.vlocker.ui.widget.b.c;
import com.vlocker.ui.widget.b.e;
import com.vlocker.ui.widget.b.f;
import com.vlocker.ui.widget.b.g;
import com.vlocker.ui.widget.b.h;
import com.vlocker.ui.widget.b.i;
import com.vlocker.ui.widget.b.j;
import java.util.ArrayList;
import java.util.List;

public class WidgetHourView extends View {
    private ArrayList a = new ArrayList();
    private ArrayList b = new ArrayList();
    private float[] c;
    private boolean d;
    private float e = -1.0f;
    private int f;
    private int g;

    public WidgetHourView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private c a(d dVar) {
        return dVar.h == (byte) 3 ? new e(getContext(), dVar) : dVar.h == (byte) 4 ? new g(getContext(), dVar) : dVar.h == (byte) 1 ? new f(getContext(), dVar) : dVar.h == (byte) 5 ? new a(getContext(), dVar) : dVar.h == (byte) 6 ? new j(getContext(), dVar) : dVar.h == (byte) 7 ? new com.vlocker.ui.widget.b.d(getContext(), dVar) : dVar.h == (byte) 8 ? new h(getContext(), dVar) : dVar.h == (byte) 2 ? new i(getContext(), dVar) : dVar.h == (byte) 12 ? new f(getContext(), dVar) : null;
    }

    private void e() {
        List d = ap.a().d();
        for (int i = 0; i < d.size(); i++) {
            if (((d) d.get(i)).q) {
                c a = a((d) d.get(i));
                if (a != null) {
                    this.b.add(a);
                }
            } else if (d.get(i) instanceof com.vlocker.ui.widget.a.f) {
                this.a.add(new e(getContext(), (d) d.get(i)));
            } else if (d.get(i) instanceof q) {
                this.a.add(new i(getContext(), (d) d.get(i)));
            } else if (d.get(i) instanceof com.vlocker.ui.widget.a.c) {
                this.a.add(new b(getContext(), (d) d.get(i)));
            }
        }
    }

    private void f() {
        if (this.b.size() > 0) {
            this.c = new float[this.b.size()];
            for (int i = 0; i < this.b.size(); i++) {
                this.c[i] = ((c) this.b.get(i)).e.g;
            }
        }
    }

    private void g() {
        if (this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                d dVar = ((c) this.b.get(i)).e;
                dVar.g -= this.e;
                this.c[i] = ((c) this.b.get(i)).e.g;
            }
        }
    }

    private void getMoveY() {
        for (int i = 0; i < this.a.size(); i++) {
            float c = ((c) this.a.get(i)).c();
            if (this.e == -1.0f || c < this.e) {
                this.e = c;
            }
        }
    }

    private void h() {
        if (this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                ((c) this.b.get(i)).e.g = this.c[i];
            }
        }
    }

    private void i() {
        int i = 0;
        int i2 = -1;
        while (i < this.a.size()) {
            if (i2 == -1 || ((c) this.a.get(i)).b() > i2) {
                i2 = ((c) this.a.get(i)).b();
            }
            i++;
        }
        this.f = (int) (ap.a().m * com.vlocker.ui.widget.c.d.b);
        this.g = (int) ((ap.a().n + this.e) * com.vlocker.ui.widget.c.d.b);
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.height = l.a(10.0f) + i2;
        layoutParams.setMargins(this.f, this.g, 0, 0);
        requestLayout();
    }

    public void a() {
        e();
        getMoveY();
        b();
        i();
        f();
        this.d = true;
    }

    public void b() {
        for (int i = 0; i < this.a.size(); i++) {
            d dVar = ((c) this.a.get(i)).e;
            dVar.g -= this.e;
        }
    }

    public void c() {
        for (int i = 0; i < this.a.size(); i++) {
            ((c) this.a.get(i)).a();
        }
        invalidate();
    }

    public void d() {
        ((LayoutParams) getLayoutParams()).setMargins(this.f, this.g, 0, 0);
        requestLayout();
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            ((c) this.a.get(i2)).a(canvas);
        }
        while (i < this.b.size()) {
            ((c) this.b.get(i)).a(canvas);
            i++;
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            g();
            invalidate();
        } else if (this.d) {
            h();
        }
    }
}
