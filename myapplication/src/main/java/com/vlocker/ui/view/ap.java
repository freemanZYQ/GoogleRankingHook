package com.vlocker.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.vlocker.ui.widget.b.b;
import com.vlocker.ui.widget.b.c;
import java.util.ArrayList;

public class ap extends View {
    private ArrayList a;

    public ap(Context context) {
        super(context);
    }

    public void a() {
        if (this.a != null && this.a.size() > 0) {
            for (int i = 0; i < this.a.size(); i++) {
                ((c) this.a.get(i)).a();
            }
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a != null && this.a.size() > 0) {
            for (int i = 0; i < this.a.size(); i++) {
                if (this.a.get(i) instanceof b) {
                    ((b) this.a.get(i)).a(canvas, this.a);
                } else if (!((c) this.a.get(i)).e.q) {
                    ((c) this.a.get(i)).a(canvas);
                }
            }
        }
    }

    public void setDrawVector(ArrayList arrayList) {
        this.a = arrayList;
    }
}
