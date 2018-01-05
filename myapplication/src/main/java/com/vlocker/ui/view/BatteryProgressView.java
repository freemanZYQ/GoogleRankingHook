package com.vlocker.ui.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;

public class BatteryProgressView extends RelativeLayout {
    private ImageView a;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private LinearLayout f;
    private int g;
    private int h;
    private int i;
    private boolean j;

    public BatteryProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b(boolean z) {
        this.a = (ImageView) findViewById(R.id.iv_battery_view_progress);
        this.b = (ImageView) findViewById(R.id.iv_battery_view_move);
        this.c = (ImageView) findViewById(R.id.iv_battery_view_complete);
        this.d = (TextView) findViewById(R.id.tv_battery_view_progress);
        this.e = (TextView) findViewById(R.id.tv_battery_view_baifenhao);
        this.f = (LinearLayout) findViewById(R.id.layout_battery_view_progress);
        if (z) {
            setPadding(l.a(2.0f), l.a(2.0f), l.a(4.0f), l.a(2.0f));
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.d.setTextSize((this.d.getTextSize() / 3.0f) / displayMetrics.scaledDensity);
            this.e.setTextSize((this.e.getTextSize() / 3.0f) / displayMetrics.scaledDensity);
            c();
        }
    }

    private void c() {
        this.c.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        LayoutParams layoutParams = (LayoutParams) this.c.getLayoutParams();
        layoutParams.width = this.c.getMeasuredWidth() / 3;
        layoutParams.height = this.c.getMeasuredHeight() / 3;
        this.c.requestLayout();
    }

    private void c(boolean z) {
        this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.i = this.b.getMeasuredWidth();
        this.h = l.a(z ? 36.0f : 112.0f);
    }

    private void d() {
        if (this.g < 100) {
            this.f.setVisibility(0);
            this.d.setText(this.g + "");
            this.c.setVisibility(8);
        } else {
            this.f.setVisibility(8);
            this.c.setVisibility(0);
        }
        ((LayoutParams) this.a.getLayoutParams()).width = (int) (((float) this.h) * (((float) this.g) / 100.0f));
        this.a.requestLayout();
    }

    public void a() {
        if (VERSION.SDK_INT < 17) {
            this.b.setVisibility(8);
            return;
        }
        this.j = true;
        this.b.clearAnimation();
        this.b.setTranslationX((float) (-this.i));
        this.b.setAlpha(1.0f);
        this.b.setVisibility(0);
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation((float) (-this.i), (float) ((int) (((float) this.h) * (((float) this.g) / 100.0f))), 0.0f, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration((long) (3000.0f * (((float) this.g) / 100.0f)));
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setAnimationListener(new l(this));
        animationSet.setStartOffset(800);
        this.b.startAnimation(animationSet);
    }

    public void a(boolean z) {
        b(z);
        c(z);
    }

    public void b() {
        this.j = false;
        this.b.animate().cancel();
        this.b.setVisibility(8);
    }

    public void setProgress(float f) {
        this.g = (int) f;
        d();
    }
}
