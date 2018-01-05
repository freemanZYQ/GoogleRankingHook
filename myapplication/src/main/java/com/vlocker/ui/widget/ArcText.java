package com.vlocker.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.search.BaiduSearchActivity;
import com.vlocker.search.M_bd_BaiduNewsInfo;
import com.vlocker.search.ap;
import com.vlocker.theme.model.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@SuppressLint({"NewApi"})
public class ArcText extends RelativeLayout {
    float a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    public int j = 0;
    public int k = 0;
    final int l = 1025;
    final int m = 1028;
    final String n = "#ffffff";
    a o;
    boolean p = false;
    public M_bd_BaiduNewsInfo q;
    private TextView r;
    private ArcView s;
    private ArrayList t;

    public ArcText(Context context) {
        super(context);
    }

    public ArcText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArcText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void e() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.a = (float) displayMetrics.widthPixels;
        this.b = (float) displayMetrics.heightPixels;
        this.c = displayMetrics.density;
        this.g = this.a / 2.0f;
        if (((double) this.c) > 3.2d) {
            this.d = 18.0f;
        } else if (((double) this.c) > 2.2d) {
            this.d = 14.0f;
        } else if (((double) this.c) > 1.5d) {
            this.d = 14.0f;
        } else {
            this.d = 14.0f;
        }
        this.e = (this.g / 2.0f) - (this.d / 2.0f);
        this.f = 0.0f;
    }

    private d getLocalHotKey() {
        List j = ap.j(getContext());
        if (j == null || j.size() <= 10) {
            return ap.i(getContext());
        }
        d dVar = new d();
        for (int i = 0; i < j.size(); i++) {
            HashMap hashMap = (HashMap) j.get(i);
            M_bd_BaiduNewsInfo m_bd_BaiduNewsInfo = new M_bd_BaiduNewsInfo();
            m_bd_BaiduNewsInfo.a((String) hashMap.get("title"));
            m_bd_BaiduNewsInfo.b((String) hashMap.get("url"));
            dVar.add(m_bd_BaiduNewsInfo);
        }
        return dVar;
    }

    public void a() {
        this.s.a(0.0f);
        this.j = 0;
        this.k = 0;
        setVisibility(8);
    }

    public void a(float f) {
        if (this.j != 1025) {
            if (getVisibility() == 8) {
                setVisibility(0);
            }
            if (f < 0.0f) {
                this.s.a(0.0f);
            } else {
                this.s.a(f);
            }
            if (this.s.a > this.s.b / 5.0f) {
                b();
                this.j = 1025;
                return;
            }
            if (VERSION.SDK_INT > 10) {
                if (f < this.f) {
                    this.r.setAlpha(0.0f);
                    this.r.setY(this.f);
                } else if (f < this.a / 2.0f) {
                    this.h = (f - this.f) / ((this.a / 2.0f) - this.f);
                    this.r.setAlpha(this.h);
                    this.i = ((f - this.f) * (this.e - this.f)) / ((this.a / 2.0f) - this.f);
                    this.r.setY(this.f + this.i);
                } else {
                    this.r.setAlpha(1.0f);
                    this.r.setY(this.e);
                }
            }
            if (f > 0.0f && this.k == 0) {
                this.k = 1028;
            }
        }
    }

    public void b() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator.ofFloat(this.s, "arcHeight", new float[]{this.s.a, this.b + 100.0f}).setDuration(300);
        ObjectAnimator.ofFloat(this.r, "alpha", new float[]{1.0f, 0.0f}).setDuration(150);
        animatorSet.playTogether(new Animator[]{r1, r2});
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.addListener(new a(this));
        animatorSet.start();
    }

    public void c() {
        try {
            this.o = a.a(getContext());
            d();
            postDelayed(new b(this), 300);
            this.o.aI(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            String str = "moxiusearch://";
            Bundle bundle = new Bundle();
            if (this.t == null) {
                this.t = getLocalHotKey();
            }
            if (this.t != null && this.t.size() > 0) {
                this.q = (M_bd_BaiduNewsInfo) this.t.get(new Random().nextInt(this.t.size()));
            }
            try {
                if (this.q != null) {
                    bundle.putString("HOT_KEY_WORD", this.q.a());
                    bundle.putString("HOT_URL", this.q.b());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.p) {
                bundle.putString("comefrom", "pull_down_guide");
            } else {
                bundle.putString("comefrom", "pull_down");
            }
            Intent intent = new Intent(getContext(), BaiduSearchActivity.class);
            intent.putExtras(bundle);
            intent.setData(Uri.parse(str));
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.addFlags(268435456);
            this.o.aI(true);
            getContext().startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void onFinishInflate() {
        Log.i("ARC TEXT", "ON FINISH INFLATE");
        e();
        this.r = (TextView) findViewById(R.id.arc_tv);
        this.r.setTextSize(this.d);
        if (VERSION.SDK_INT > 10) {
            this.r.setAlpha(0.0f);
        }
        this.r.setText("下拉搜索");
        this.r.setTextColor(Color.parseColor("#ffffff"));
        this.s = (ArcView) findViewById(R.id.arc_view);
        super.onFinishInflate();
    }

    public void setIsGuide(boolean z) {
        this.p = z;
    }
}
