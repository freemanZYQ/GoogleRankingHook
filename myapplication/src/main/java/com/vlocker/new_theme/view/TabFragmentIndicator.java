package com.vlocker.new_theme.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.do;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.new_theme.activity.CategoryItemActivity;
import com.vlocker.new_theme.activity.ThemeMainActivity;
import java.util.ArrayList;

public class TabFragmentIndicator extends LinearLayout implements do, OnClickListener {
    h a;
    Context b;
    ViewPager c;
    View d;
    i e;
    private View f;
    private int g;
    private int h = 0;
    private int i = 0;
    private int j;
    private final int k = 1;
    private final int l = 2;
    private float m;
    private float n;
    private boolean o = false;
    private Long p = Long.valueOf(0);
    private Long q = Long.valueOf(0);
    private ArrayList r = new ArrayList();
    private Handler s = new e(this);

    public TabFragmentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
    }

    private void a() {
        int windowWidth = getWindowWidth() / this.g;
        this.m = ((float) getWindowWidth()) / ((float) this.g);
        int dimension = (int) getResources().getDimension(R.dimen.t_cursor_height);
        LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.height = dimension;
        layoutParams.width = windowWidth;
        this.f.setLayoutParams(layoutParams);
    }

    private int getWindowWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.b).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public void a(int i) {
        ((TextView) ((ViewGroup) this.d).getChildAt(this.h)).setTextColor(getResources().getColor(R.color.theme_v3_tab_not_selected));
        ((TextView) ((ViewGroup) this.d).getChildAt(i)).setTextColor(getResources().getColor(R.color.theme_v3_text_blue));
        if (this.p.longValue() < 1) {
            this.p = Long.valueOf(System.currentTimeMillis());
        }
        this.q = Long.valueOf(System.currentTimeMillis());
        if (this.q.longValue() - this.p.longValue() < 3000) {
            this.s.removeMessages(0);
        }
        this.p = this.q;
        this.s.sendEmptyMessageDelayed(0, 3005);
        this.h = i;
        c(i);
        if (this.b instanceof ThemeMainActivity) {
            switch (i) {
                case 0:
                    p.a(this.b, "Vlocker_Click_Classify_Theme_PPC_TF", new String[0]);
                    return;
                case 1:
                    p.a(this.b, "Vlocker_Click_SpecialTopic_Theme_PPC_TF", new String[0]);
                    return;
                case 2:
                    p.a(this.b, "Vlocker_Click_Goods_Theme_PPC_TF", new String[0]);
                    return;
                case 3:
                    p.a(this.b, "Vlocker_Click_Newest_Theme_PPC_TF", new String[0]);
                    return;
                default:
                    return;
            }
        }
    }

    public void a(int i, float f, int i2) {
        if (!this.o && i2 != 0) {
            try {
                if (this.j == 1) {
                    if (this.h == i) {
                        this.f.setTranslationX(this.n + ((float) (i2 / this.g)));
                    } else {
                        this.f.setTranslationX(this.n - (this.m - ((float) (i2 / this.g))));
                    }
                } else if (this.j != 2) {
                } else {
                    if (this.i == i) {
                        this.f.setTranslationX(this.n + ((float) (i2 / this.g)));
                    } else {
                        this.f.setTranslationX(this.n - (this.m - ((float) (i2 / this.g))));
                    }
                }
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        }
    }

    public void a(int i, Fragment fragment) {
        this.r.add(i, fragment);
        if (this.e != null) {
            this.e.c();
        }
    }

    public void b(int i) {
        if (!this.o) {
            this.n = ((float) this.h) * this.m;
            this.j = i;
            this.i = this.h;
        }
    }

    public void c(int i) {
        if (this.b instanceof ThemeMainActivity) {
            switch (i) {
                case 0:
                    ((Fragment) this.r.get(0)).c(true);
                    ((Fragment) this.r.get(1)).c(true);
                    return;
                case 1:
                    ((Fragment) this.r.get(2)).c(true);
                    ((Fragment) this.r.get(1)).c(true);
                    ((Fragment) this.r.get(0)).c(true);
                    return;
                case 2:
                    ((Fragment) this.r.get(1)).c(true);
                    ((Fragment) this.r.get(2)).c(true);
                    ((Fragment) this.r.get(3)).c(true);
                    return;
                case 3:
                    ((Fragment) this.r.get(3)).c(true);
                    ((Fragment) this.r.get(2)).c(true);
                    return;
                default:
                    return;
            }
        } else if (this.b instanceof CategoryItemActivity) {
            switch (i) {
                case 0:
                    ((Fragment) this.r.get(0)).c(true);
                    ((Fragment) this.r.get(1)).c(true);
                    return;
                case 1:
                    ((Fragment) this.r.get(0)).c(true);
                    ((Fragment) this.r.get(1)).c(true);
                    ((Fragment) this.r.get(2)).c(true);
                    return;
                case 2:
                    ((Fragment) this.r.get(2)).c(true);
                    ((Fragment) this.r.get(1)).c(true);
                    return;
                default:
                    return;
            }
        }
    }

    public void d(int i) {
        Animation translateAnimation = new TranslateAnimation(((float) i) * this.m, ((float) i) * this.m, 0.0f, 0.0f);
        translateAnimation.setDuration(100);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        if (this.f != null) {
            this.f.startAnimation(translateAnimation);
        }
        if (this.d != null) {
            ((TextView) ((ViewGroup) this.d).getChildAt(this.h)).setTextColor(getResources().getColor(R.color.theme_v3_tab_not_selected));
            ((TextView) ((ViewGroup) this.d).getChildAt(i)).setTextColor(getResources().getColor(R.color.theme_v3_text_blue));
        }
        translateAnimation.setAnimationListener(new g(this, i));
    }

    public View getIndicatorView() {
        return this.d;
    }

    public int getPage() {
        return this.h;
    }

    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (this.h != intValue) {
            this.o = true;
            try {
                this.f.setTranslationX(0.0f);
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
            Animation translateAnimation = new TranslateAnimation(((float) this.h) * this.m, ((float) intValue) * this.m, 0.0f, 0.0f);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            translateAnimation.setDuration(100);
            translateAnimation.setFillEnabled(true);
            translateAnimation.setFillAfter(true);
            if (this.f != null) {
                this.f.startAnimation(translateAnimation);
            } else {
                this.c.setCurrentItem(intValue);
            }
            translateAnimation.setAnimationListener(new f(this, intValue));
        }
    }

    public void setOnTabClickListener(h hVar) {
        this.a = hVar;
    }

    public void setTabContainerView(int i) {
        int i2 = 0;
        this.d = LayoutInflater.from(this.b).inflate(i, null);
        addView(this.d, 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.height = (int) getResources().getDimension(R.dimen.t_market_maintab_height);
        this.d.setLayoutParams(layoutParams);
        if (this.d instanceof ViewGroup) {
            this.g = ((ViewGroup) this.d).getChildCount();
            while (i2 < this.g) {
                ((ViewGroup) this.d).getChildAt(i2).setTag(Integer.valueOf(i2));
                ((ViewGroup) this.d).getChildAt(i2).setOnClickListener(this);
                i2++;
            }
        }
    }

    public void setTabSliderView(int i) {
        this.f = LayoutInflater.from(this.b).inflate(i, null);
        addView(this.f, 1);
        a();
    }

    public void setViewPager(ViewPager viewPager) {
        this.c = viewPager;
        this.c.setOnPageChangeListener(this);
        this.e = new i(this, ((FragmentActivity) this.b).f());
        this.c.setAdapter(this.e);
    }
}
