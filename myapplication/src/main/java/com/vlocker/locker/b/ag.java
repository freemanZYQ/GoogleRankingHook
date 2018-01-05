package com.vlocker.locker.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import com.vlocker.c.a;
import com.vlocker.l.j;
import com.vlocker.l.z;
import com.vlocker.locker.R;
import com.vlocker.m.l;

public class ag {
    public boolean a = false;
    OnLongClickListener b = new ak(this);
    private p c;
    private Context d;
    private ImageView e;
    private ImageView f;
    private View g;
    private j h;
    private boolean i = false;
    private boolean j = false;
    private int k = l.a(this.d, 10.0f);
    private View l;
    private WindowManager m;
    private a n;
    private OnTouchListener o = new ah(this);
    private z p = new ai(this);

    public ag(Context context, p pVar) {
        this.d = context;
        this.c = pVar;
        this.m = (WindowManager) this.d.getSystemService("window");
        this.n = a.a(this.d);
    }

    public void a() {
        a(false);
        if (this.g != null) {
            if (this.n.av()) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
        if (c()) {
            d();
        }
    }

    public void a(float f) {
        this.c.a(this.m, f);
    }

    public void a(View view, View view2) {
        this.l = view2;
        this.e = (ImageView) view2.findViewById(R.id.tool_box_img);
        this.g = view2.findViewById(R.id.tool_box_btn);
        this.f = (ImageView) view2.findViewById(R.id.lk_toolbox_img_red_point);
        this.h = new j(this.d, this, view);
        this.g.setOnTouchListener(this.o);
        this.h.a(this.p);
        this.g.setOnLongClickListener(this.b);
        a();
    }

    public void a(Runnable runnable, byte b) {
        d();
        this.c.a(5, (int) b, new al(this, runnable));
    }

    public void a(Runnable runnable, String str) {
        this.c.a(runnable, 2, str);
    }

    public void a(boolean z) {
        this.j = z;
    }

    public boolean b() {
        return this.j;
    }

    public boolean c() {
        return this.h != null ? this.h.g() : false;
    }

    public void d() {
        if (this.h != null) {
            this.h.f();
        }
    }
}
