package com.vlocker.weather.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.widget.AlwaysMarqueeTextView;
import com.vlocker.weather.a;
import java.util.ArrayList;
import java.util.List;

public class ad implements OnClickListener {
    private TextView a;
    private AlwaysMarqueeTextView b;
    private RecyclingImageView c;
    private View d;
    private RelativeLayout e;
    private Context f;
    private List g = new ArrayList();
    private a h;
    private int i;
    private long j;
    private boolean k;

    public ad(Context context, a aVar, View view) {
        this.f = context;
        this.h = aVar;
        this.e = (RelativeLayout) view.findViewById(R.id.weather_ad_text_layout);
        e();
        b();
    }

    private void e() {
        this.a = (TextView) this.e.findViewById(R.id.weather_ad_text_title);
        this.b = (AlwaysMarqueeTextView) this.e.findViewById(R.id.weather_ad_text_desc);
        this.c = (RecyclingImageView) this.e.findViewById(R.id.weather_ad_text_icon);
        this.d = this.e.findViewById(R.id.weather_ad_text_close);
        this.e.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    private void f() {
        this.e.setAlpha(1.0f);
        this.e.setVisibility(0);
        this.a.setText(TextUtils.isEmpty(((com.moxiu.b.a.a) this.g.get(this.i)).h()) ? "" : ((com.moxiu.b.a.a) this.g.get(this.i)).h() + ":");
        this.b.setText(((com.moxiu.b.a.a) this.g.get(this.i)).c());
        this.c.a(((com.moxiu.b.a.a) this.g.get(this.i)).b(), 2, 13);
    }

    private void g() {
        this.g.remove(this.i);
        if (this.i >= this.g.size()) {
            this.i = 0;
        }
        this.e.animate().alpha(0.0f).setDuration(150).setInterpolator(new LinearInterpolator()).setListener(new af(this)).start();
    }

    public void a() {
        if (this.g.size() <= 0) {
            this.k = false;
            return;
        }
        if (!this.k) {
            this.i = this.i >= this.g.size() + -1 ? 0 : this.i + 1;
        }
        this.k = false;
        f();
    }

    public void b() {
        if (System.currentTimeMillis() - this.j >= 10800000) {
            this.j = System.currentTimeMillis();
            this.i = 0;
            this.g.clear();
            this.e.setVisibility(4);
            new com.b.b.a(this.f).a(com.b.d.a.b(this.f, "vweather_text"), 20, new ae(this)).a();
        }
    }

    public void c() {
        if (this.g.size() > 0 && this.i < this.g.size()) {
            this.c.a(((com.moxiu.b.a.a) this.g.get(this.i)).b(), 2, 13);
        }
    }

    public void d() {
        if (this.g.size() > 0 && this.i < this.g.size() && !((com.moxiu.b.a.a) this.g.get(this.i)).J) {
            ((com.moxiu.b.a.a) this.g.get(this.i)).b(this.e);
        }
    }

    public void onClick(View view) {
        if (this.i < this.g.size()) {
            this.k = true;
            switch (view.getId()) {
                case R.id.weather_ad_text_layout:
                    com.vlocker.b.a.a(this.f, (com.moxiu.b.a.a) this.g.get(this.i), this.e, "weather_dianshang", this.h, false, null);
                    try {
                        ((com.moxiu.b.a.a) this.g.get(this.i)).a(this.e);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    g();
                    return;
                case R.id.weather_ad_text_close:
                    g();
                    return;
                default:
                    return;
            }
        }
    }
}
