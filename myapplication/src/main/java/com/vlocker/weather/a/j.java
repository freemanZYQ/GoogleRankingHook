package com.vlocker.weather.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.vlocker.locker.R;

public class j extends ag {
    private Context a;
    private View b = LayoutInflater.from(this.a).inflate(R.layout.weather_main, null);
    private TextView c;
    private TextView d;
    private View e;
    private View f;

    public j(Context context, View view) {
        this.a = context;
        d();
    }

    private void d() {
        this.c = (TextView) this.b.findViewById(R.id.button_hours);
        this.d = (TextView) this.b.findViewById(R.id.button_week);
        this.e = this.b.findViewById(R.id.hours_card);
        this.f = this.b.findViewById(R.id.week_card);
        c();
        this.c.setOnClickListener(new k(this));
        this.d.setOnClickListener(new l(this));
    }

    public View a() {
        return this.b;
    }

    public void a(boolean z) {
        if (z) {
            this.c.setSelected(true);
            this.d.setSelected(false);
            this.d.setTextColor(-2080374785);
            this.c.setTextColor(-1);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            return;
        }
        this.c.setSelected(false);
        this.d.setSelected(true);
        this.c.setTextColor(-2080374785);
        this.d.setTextColor(-1);
        this.e.setVisibility(8);
        this.e.findViewById(R.id.hours_scroll).setScrollX(0);
        this.f.setVisibility(0);
    }

    public void b() {
        try {
            c();
        } catch (Exception e) {
            this.b.setVisibility(8);
        }
    }

    public void c() {
        if (this.e.getVisibility() != 0) {
            a(false);
            this.b.findViewById(R.id.weather_button_layout).setVisibility(8);
            return;
        }
        a(true);
        this.b.findViewById(R.id.weather_button_layout).setVisibility(0);
    }
}
