package com.vlocker.weather.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.moxiu.b.a.a;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.view.GifImageView;
import com.vlocker.ui.widget.AlwaysMarqueeTextView;
import com.vlocker.weather.e.d;
import java.util.Date;

public class ah implements OnClickListener, OnLongClickListener {
    private static a j;
    private static String k;
    private static String l;
    long a = 0;
    private Context b;
    private View c;
    private GifImageView d;
    private ImageView e;
    private com.vlocker.weather.a f;
    private AlwaysMarqueeTextView g;
    private RecyclingImageView h;
    private RelativeLayout i;
    private com.vlocker.c.a m;
    private boolean n;
    private Handler o;
    private Runnable p;

    public ah(Context context, com.vlocker.weather.a aVar, View view) {
        this.b = context;
        this.c = view;
        this.f = aVar;
        this.m = com.vlocker.c.a.a(context);
        a();
    }

    public static void a(Context context) {
        try {
            if (!(TextUtils.isEmpty(k) || TextUtils.isEmpty(l))) {
                Log.e("weather", "post show");
                d.c(context, "1010", k, l);
            }
            if (j != null && (j instanceof com.b.a.a)) {
                Log.e("weather", "report exposure");
                ((com.b.a.a) j).a(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void f() {
        if (this.d != null && j != null) {
            this.d.setGifUrl(j.d());
            this.d.setVisibility(0);
            this.i.setVisibility(0);
            if (TextUtils.isEmpty(j.c())) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.g.setText(j.c());
                if (TextUtils.isEmpty(j.b())) {
                    this.h.setImageResource(R.drawable.weather_icon_text_bg);
                } else {
                    this.h.a(j.b(), 2, 13);
                }
            }
            Log.e("locker", "icon on exposure————>" + j.d());
        }
    }

    private boolean g() {
        return this.m.dj() < 3 && new Date().getDate() != this.m.dk();
    }

    private void h() {
        this.d.animate().translationX((float) l.a(-14.0f)).setDuration(300).setInterpolator(new DecelerateInterpolator()).setListener(new ak(this)).start();
    }

    private void i() {
        this.i.animate().scaleX(1.1f).setStartDelay(0).scaleY(1.1f).setDuration(250).setInterpolator(new DecelerateInterpolator()).setListener(new am(this)).start();
    }

    private void j() {
        this.n = false;
        this.d.animate().cancel();
        this.i.animate().cancel();
        this.d.setTranslationX((float) l.a(84.0f));
        this.i.setScaleX(0.0f);
        this.i.setScaleY(0.0f);
        this.i.setAlpha(1.0f);
    }

    private void k() {
        this.i.animate().alpha(0.0f).setDuration(200).setStartDelay(2000).setInterpolator(new LinearInterpolator()).setListener(null).start();
    }

    private void l() {
        this.e.animate().alpha(0.0f).setDuration(500).setListener(new aq(this));
    }

    public void a() {
        this.i = (RelativeLayout) this.c.findViewById(R.id.weather_dianshang_text_layout);
        this.i.setPivotX((float) l.a(95.0f));
        this.i.setPivotY((float) l.a(26.0f));
        this.h = (RecyclingImageView) this.c.findViewById(R.id.weather_dianshang_text_bg);
        this.g = (AlwaysMarqueeTextView) this.c.findViewById(R.id.weather_dianshang_text);
        this.d = (GifImageView) this.c.findViewById(R.id.weather_dianshang_gif);
        this.d.setOnClickListener(new ai(this));
        this.d.setOnLongClickListener(this);
        this.e = (ImageView) this.c.findViewById(R.id.weather_dinshang_gif_delete);
        this.e.setOnClickListener(this);
    }

    public void a(boolean z) {
        if (this.d != null && this.g != null && j != null) {
            if (z) {
                this.n = true;
                h();
                return;
            }
            j();
            this.d.b();
            this.g.setEllipsize(null);
        }
    }

    public void b() {
        if (g()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.a > 60000) {
                    this.a = currentTimeMillis;
                    Log.e("locker", "icon load-->" + System.currentTimeMillis());
                    new com.b.b.a(this.b).a(com.b.d.a.b(this.b, "vweather_icon"), 10, new aj(this)).a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(boolean z) {
        if (this.d != null && this.g != null && j != null) {
            if (z) {
                this.d.a();
                this.g.setEllipsize(TruncateAt.MARQUEE);
                return;
            }
            this.d.b();
            this.g.setEllipsize(null);
        }
    }

    public void c() {
        if (j != null && !TextUtils.isEmpty(j.c()) && !TextUtils.isEmpty(j.b())) {
            this.h.a(j.b(), 2, 13);
        }
    }

    public void d() {
        if (this.e != null && this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
            if (this.o != null && this.p != null) {
                this.o.removeCallbacks(this.p);
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.weather_dinshang_gif_delete:
                this.d.animate().alpha(0.0f).setDuration(1000).setListener(new ao(this));
                l();
                this.m.ah(this.m.dj() + 1);
                this.m.ai(new Date().getDate());
                p.a(this.b, "Vlocker_Close_WeatherIcon_PPC_RR", new String[0]);
                return;
            default:
                return;
        }
    }

    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.weather_dianshang_gif:
                if (this.e.getVisibility() == 8 || this.e.getVisibility() == 4) {
                    this.e.setVisibility(0);
                    this.o = new Handler();
                    this.p = new ap(this);
                    this.o.postDelayed(this.p, 2000);
                    break;
                }
        }
        return true;
    }
}
