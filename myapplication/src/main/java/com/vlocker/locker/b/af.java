package com.vlocker.locker.b;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.ag;
import com.vlocker.m.l;
import com.vlocker.ui.widget.BatteryImageView;

public class af {
    private RelativeLayout a;
    private BatteryImageView b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private Context g;
    private a h = a.a(this.g);
    private boolean i;
    private boolean j;

    public af(Context context) {
        this.g = context;
    }

    private void b(ViewGroup viewGroup) {
        if (!this.j) {
            c();
            a();
        }
        if (!this.i) {
            this.i = true;
            viewGroup.addView(this.a, new LayoutParams(-1, l.a(24.0f)));
        }
    }

    private void c() {
        this.j = true;
        this.a = (RelativeLayout) View.inflate(this.g, R.layout.l_statusbar_layout, null);
        this.b = (BatteryImageView) this.a.findViewById(R.id.battery_meter_img);
        this.d = (ImageView) this.a.findViewById(R.id.battery_meter_charge);
        this.e = (ImageView) this.a.findViewById(R.id.signal_state_img);
        this.f = (ImageView) this.a.findViewById(R.id.signal_strength_img);
        this.c = (TextView) this.a.findViewById(R.id.battery_meter_tx);
        this.c.setTypeface(Typeface.createFromAsset(this.g.getAssets(), "fonts/chineseAndDate.ttf"));
    }

    private void c(ViewGroup viewGroup) {
        if (this.i) {
            this.i = false;
            viewGroup.removeView(this.a);
            d();
        }
    }

    private void d() {
        this.j = false;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        System.gc();
    }

    private void e() {
        if (this.e != null && this.f != null) {
            String a = ag.a(this.g);
            this.e.setAlpha(1.0f);
            if (a.equals("2G")) {
                this.e.setVisibility(0);
                this.e.setImageResource(R.drawable.signal_2g);
                f();
            } else if (a.equals("3G")) {
                this.e.setVisibility(0);
                this.e.setImageResource(R.drawable.signal_3g);
                f();
            } else if (a.equals("4G")) {
                this.e.setVisibility(0);
                this.e.setImageResource(R.drawable.signal_4g);
                f();
            } else {
                this.e.setVisibility(4);
            }
            if (j.h(this.g).booleanValue() || !ag.d(this.g)) {
                this.e.setAlpha(0.5f);
            }
        }
    }

    private void f() {
        try {
            this.f.setVisibility(0);
            switch (com.vlocker.m.af.a(this.g).a()) {
                case 0:
                    this.f.setImageResource(R.drawable.signal_strength_0);
                    return;
                case 1:
                    this.f.setImageResource(R.drawable.signal_strength_1);
                    return;
                case 2:
                    this.f.setImageResource(R.drawable.signal_strength_2);
                    return;
                case 3:
                    this.f.setImageResource(R.drawable.signal_strength_3);
                    return;
                case 4:
                    this.f.setImageResource(R.drawable.signal_strength_4);
                    return;
                default:
                    this.f.setImageResource(R.drawable.signal_strength_0);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f.setImageResource(R.drawable.signal_strength_4);
        }
        e.printStackTrace();
        this.f.setImageResource(R.drawable.signal_strength_4);
    }

    public void a() {
        if (!this.j) {
            return;
        }
        if (ap.a() == null || ap.a().w == null) {
            this.b.a(this.h.j());
            this.c.setTextColor(this.h.j());
            this.d.setColorFilter(this.h.j());
            this.e.setColorFilter(this.h.j());
            this.f.setColorFilter(this.h.j());
        } else if (ap.a().w.J && ap.a().w.t != -1) {
            this.b.a(ap.a().w.t);
            this.c.setTextColor(ap.a().w.t);
            this.d.setColorFilter(ap.a().w.t);
            this.e.setColorFilter(ap.a().w.t);
            this.f.setColorFilter(ap.a().w.t);
        }
    }

    public void a(ViewGroup viewGroup) {
        if (this.h.ai() != 0) {
            b(viewGroup);
        } else {
            c(viewGroup);
        }
    }

    public void b() {
        if (this.j && this.i && this.h.ai() != 0) {
            this.b.a(com.vlocker.battery.saver.a.a, false);
            if (this.h.ak()) {
                this.c.setVisibility(0);
                this.c.setText("" + com.vlocker.battery.saver.a.a + "%");
            } else {
                this.c.setVisibility(8);
            }
            if (com.vlocker.battery.saver.a.b) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            if (!ag.b(this.g) || ag.c(this.g)) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                return;
            }
            e();
        }
    }
}
