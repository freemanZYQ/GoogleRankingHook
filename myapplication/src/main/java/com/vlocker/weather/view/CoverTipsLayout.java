package com.vlocker.weather.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.weather.e.j;

public class CoverTipsLayout extends RelativeLayout implements OnClickListener {
    private TextView a;
    private TextView b;
    private View c;
    private Drawable d;
    private boolean e = false;
    private boolean f = true;
    private c g;
    private String h = null;
    private String i = null;

    public CoverTipsLayout(Context context) {
        super(context);
    }

    public CoverTipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoverTipsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void b() {
        if (this.a == null) {
            this.a = (TextView) findViewById(R.id.tips_text);
            this.b = (TextView) findViewById(R.id.tips_button);
            this.c = findViewById(R.id.close_btn);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    private void c() {
        b();
        this.i = getContext().getString(R.string.dialog_weather_setting_expand_title);
        this.h = getContext().getString(R.string.dialog_weather_setting_title);
        this.a.setText(this.i);
        this.b.setText(R.string.button_set);
        this.g = new a(this);
    }

    private void d() {
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.a.setText(this.i);
        this.e = true;
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(false);
        startAnimation(alphaAnimation);
    }

    private void e() {
        if (this.d == null) {
            this.d = getResources().getDrawable(R.drawable.l_lockscreen_goarrow_icon);
        }
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, this.d, null);
        this.a.setText(this.h);
        this.e = false;
        this.f = true;
    }

    private void f() {
        if (this.g != null) {
            this.g.b();
        }
    }

    private void g() {
        if (this.g != null) {
            this.g.a();
        }
    }

    public boolean a() {
        if (!j.d(getContext()) || a.a(getContext()).I() || !a.a(getContext()).H() || a.a(getContext()).Y()) {
            return false;
        }
        c();
        e();
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_btn:
                f();
                return;
            case R.id.cover_tips_layout:
                if (this.e || !this.f) {
                    g();
                    return;
                } else {
                    d();
                    return;
                }
            case R.id.tips_button:
                g();
                return;
            default:
                return;
        }
    }
}
