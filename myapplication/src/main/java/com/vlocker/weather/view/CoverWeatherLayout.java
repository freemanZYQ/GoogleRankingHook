package com.vlocker.weather.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.g;
import com.vlocker.theme.f.e;
import com.vlocker.weather.e.j;

public class CoverWeatherLayout extends LinearLayout {
    private TextView a;
    private ImageView b;
    private ImageView c;

    public CoverWeatherLayout(Context context) {
        super(context);
    }

    public CoverWeatherLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoverWeatherLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void c() {
        this.a = (TextView) findViewById(R.id.curr_temp_textview);
        this.b = (ImageView) findViewById(R.id.weather_icon);
        this.c = (ImageView) findViewById(R.id.weather_dot_icon);
        this.a.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/chineseAndDate.ttf"));
    }

    public void a() {
        Log.e("liu---", "updateTodayWeather");
        String F = a.a(getContext()).F("");
        if (!TextUtils.isEmpty(F)) {
            Drawable a;
            int L = a.a(getContext()).L(0);
            if (L == 0) {
                L = j.a(0, 0, getContext());
                a.a(getContext()).M(L);
            }
            if (this.b == null) {
                c();
            }
            this.a.setText(j.a(F, false));
            Drawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), L));
            int j = a.a(getContext()).j();
            if (j != -1) {
                this.a.setTextColor(j);
                a = g.a(bitmapDrawable, a.a(e.a).j());
            } else {
                bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), L));
                this.a.setTextColor(-1);
                a = bitmapDrawable;
            }
            this.b.setBackgroundDrawable(a);
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            b();
        }
    }

    public void b() {
        int i = j.a(getContext()) ? 1 : 0;
        if (this.c == null) {
            this.c = (ImageView) findViewById(R.id.weather_dot_icon);
        }
        if (i != 0 || a.a(getContext()).ab()) {
            this.c.setVisibility(0);
            this.c.setImageResource(R.drawable.l_lockscreen_dot_icon);
            return;
        }
        this.c.setVisibility(8);
    }

    public float getColorAlpha() {
        return this.a != null ? this.a.getAlpha() : this.b != null ? this.b.getAlpha() : 0.0f;
    }

    public void setColorAlpha(float f) {
        if (this.a != null) {
            this.a.setAlpha(f);
        }
        if (this.b != null) {
            this.b.setAlpha(f);
        }
    }
}
