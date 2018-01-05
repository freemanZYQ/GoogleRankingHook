package com.vlocker.weather;

import android.content.Context;
import android.view.View.OnClickListener;
import com.vlocker.c.a;
import com.vlocker.locker.b.ap;
import com.vlocker.locker.b.p;
import com.vlocker.theme.f.e;
import com.vlocker.ui.cover.g;
import com.vlocker.weather.e.j;
import com.vlocker.weather.view.CoverTipsLayout;
import com.vlocker.weather.view.CoverWeatherLayout;

public class z {
    private CoverWeatherLayout a;
    private CoverTipsLayout b;
    private Context c;
    private p d;
    private OnClickListener e = new aa(this);

    public z(Context context, p pVar) {
        this.c = context;
        this.d = pVar;
    }

    public void a() {
        if (this.a != null && this.b != null) {
            try {
                if (ap.a() != null) {
                    this.a.setVisibility(8);
                    this.b.setVisibility(8);
                } else if (this.b.a()) {
                    this.a.setVisibility(8);
                    if (e.c(this.c)) {
                        this.b.setVisibility(0);
                    } else {
                        this.b.setVisibility(8);
                    }
                } else if (j.d(this.c)) {
                    this.a.setVisibility(0);
                    this.b.setVisibility(8);
                    this.a.a();
                } else {
                    this.a.setVisibility(8);
                    this.b.setVisibility(8);
                }
            } catch (Exception e) {
            }
        }
    }

    public void a(int i) {
        if (this.a != null) {
            this.a.setVisibility(i);
        }
    }

    public void a(CoverWeatherLayout coverWeatherLayout, CoverTipsLayout coverTipsLayout) {
        this.a = coverWeatherLayout;
        this.b = coverTipsLayout;
        coverWeatherLayout.setOnClickListener(this.e);
    }

    public void b() {
        if (j.d(this.c) && g.a) {
            this.d.a("weather_page", true);
            a.a(this.c).t(false);
            if (this.a != null) {
                this.a.b();
            }
        }
    }

    public OnClickListener c() {
        return this.e;
    }
}
