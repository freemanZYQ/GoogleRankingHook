package com.vlocker.locker.b;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.ui.view.a.a;
import com.vlocker.ui.view.a.b;

public class i implements OnItemClickListener {
    public n a;
    int b;
    int c;
    private Context d;
    private View e;
    private ViewGroup f;
    private a g;
    private GridView h;
    private SeekBar i;
    private TextView j;
    private int k = -1;
    private boolean l;
    private o m;
    private ObjectAnimator n = null;

    public i(Context context, ViewGroup viewGroup) {
        this.d = context;
        this.f = viewGroup;
    }

    private void a(View view, int i) {
        b(view, i);
        this.k = i;
        int count = this.g.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            if (i2 != i) {
                c(view, i2);
            }
        }
        if (this.a != null) {
            com.vlocker.c.a.a(this.d).b(this.g.a(i));
            com.vlocker.c.a.a(this.d).aj(this.g.a(i));
            this.a.a();
        }
    }

    private void b(int i) {
        this.b = i;
        if (this.b < 10) {
            this.b = 10;
        }
        if (Math.abs(this.c - this.b) > 3) {
            com.vlocker.c.a.a(this.d).c(this.b);
            if (this.a != null) {
                this.a.b();
            }
            this.c = this.b;
        }
    }

    private void b(View view, int i) {
        if (!((b) view.getTag()).b.isShown()) {
            this.g.a().put(i, true);
        }
        this.g.notifyDataSetChanged();
    }

    private void c(View view, int i) {
        this.g.a().put(i, false);
        this.g.notifyDataSetChanged();
    }

    private void e() {
        this.l = true;
        if (this.e == null) {
            this.e = View.inflate(this.d, R.layout.l_lock_color_change_layout, null);
        }
        if (this.g == null) {
            this.g = new a(this.d, 0);
        }
        if (this.h == null) {
            this.h = (GridView) this.e.findViewById(R.id.l_gridViewColors);
        }
        if (this.j == null) {
            this.j = (TextView) this.e.findViewById(R.id.l_vlocker_clear_dialog_title);
        }
        if (this.e != null) {
            this.e.setOnTouchListener(new j(this));
        }
        if (this.i == null) {
            this.i = (SeekBar) this.e.findViewById(R.id.color_brightness_seekbar);
        }
        this.i.setMax(255);
        this.b = com.vlocker.c.a.a(this.d).k();
        if (this.b < 10) {
            this.b = 10;
        }
        this.i.setProgress(this.b);
        this.i.setOnSeekBarChangeListener(new k(this));
        this.h.setAdapter(this.g);
        this.h.setOnItemClickListener(this);
    }

    private void f() {
        this.e.setVisibility(0);
        if (this.e != null && this.e.getParent() == null) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.a(240.0f));
            layoutParams.addRule(3, R.id.cover_weather_super_layout);
            layoutParams.addRule(14, -1);
            layoutParams.setMargins(l.a(18.0f), 0, l.a(18.0f), 0);
            this.f.addView(this.e, layoutParams);
        }
    }

    public void a() {
        try {
            this.b = com.vlocker.c.a.a(this.d).k();
            if (this.b < 10) {
                this.b = 10;
            }
            if (this.i != null) {
                this.i.setProgress(this.b);
            }
            if (this.g != null && this.k != -1 && com.vlocker.c.a.a(this.d).j() != this.g.a(this.k)) {
                this.g.a().put(this.k, false);
                this.g.notifyDataSetChanged();
            }
        } catch (Exception e) {
        }
    }

    public void a(int i) {
        if (this.e != null && this.e.getVisibility() != i) {
            this.e.setVisibility(i);
            if (this.m != null) {
                this.m.a(i);
            }
        }
    }

    public void a(View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.8f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.8f});
        this.n = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3});
        if (this.n != null) {
            this.n.cancel();
        }
        view.setLayerType(2, null);
        this.n.addListener(new l(this, view));
        this.n.setDuration(450);
        this.n.setInterpolator(new DecelerateInterpolator(2.0f));
        this.n.start();
    }

    public void a(n nVar) {
        this.a = nVar;
    }

    public void b() {
        if (d()) {
            a(this.e);
        }
    }

    public void b(View view) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.6f, 1.0f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.6f, 1.0f});
        this.n = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3});
        if (this.n != null) {
            this.n.cancel();
        }
        view.setLayerType(2, null);
        this.n.addListener(new m(this, view));
        this.n.setDuration(450);
        this.n.setInterpolator(new AccelerateDecelerateInterpolator());
        this.n.start();
    }

    public void c() {
        if (!this.l) {
            e();
        }
        a();
        f();
        b(this.e);
    }

    public boolean d() {
        return this.e != null && this.e.getVisibility() == 0;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a(view, i);
    }
}
