package com.vlocker.ui.widget;

import android.animation.ValueAnimator;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import com.vlocker.b.j;
import com.vlocker.battery.saver.b;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.msg.ab;
import com.vlocker.msg.ak;
import com.vlocker.msg.ao;
import com.vlocker.msg.as;
import com.vlocker.msg.b.a;
import com.vlocker.msg.e;
import com.vlocker.msg.p;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.view.BatteryChargeView;
import java.util.ArrayList;
import java.util.List;

public class MsgListView extends ListView {
    public static boolean a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private long j;
    private View k;
    private List l = new ArrayList();
    private boolean m = false;
    private boolean n = false;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t = 150;
    private e u;
    private Context v;
    private boolean w;
    private final long x = 250;

    public MsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = context;
    }

    private View a(ViewGroup viewGroup, MotionEvent motionEvent) {
        Object obj = null;
        View view = null;
        int childCount = viewGroup.getChildCount();
        this.l.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (obj == null && a(childAt, motionEvent)) {
                obj = 1;
            } else {
                this.l.add(childAt);
                childAt = view;
            }
            i++;
            view = childAt;
        }
        return view;
    }

    private void a() {
        this.o = (int) getResources().getDimension(R.dimen.l_msg_delete_img_parent_width);
        this.p = l.a(this.v, 30.0f);
        this.q = l.a(this.v, 500.0f);
        this.r = l.a();
        this.o = this.r / 3;
        this.s = (int) ((((((float) (100 - getResources().getInteger(R.integer.l_msg_music_item_weight))) * 1.0f) / 100.0f) * ((float) this.r)) / 2.0f);
        this.t = 150;
    }

    private void a(float f) {
        if (this.l != null && this.l.size() > 0) {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                ((View) this.l.get(i)).findViewById(R.id.msg_outer_layout).setAlpha(f);
            }
        }
    }

    private void a(View view) {
        if (view != null) {
            String str = null;
            try {
                str = (String) this.k.findViewById(R.id.l_msg_pkg).getTag();
            } catch (Exception e) {
            }
            if (str != null) {
                ak c = p.a().c(str);
                if (c != null && c.r && "moxiu-launcher".equals(j.p(this.v))) {
                    com.vlocker.b.p.a(this.v, "Vlock_Click_PushMsg_PPC_TF", "name", c.c);
                }
                if (str.equals("red_packet_QQ") || str.equals("red_packet") || str.equals("mx_clean")) {
                    if (this.u != null) {
                        a(this.k, false, true);
                        return;
                    }
                } else if (str.equals("mx_ad")) {
                    b.a(this.v).a(com.vlocker.locker.c.b.f ? "Vlock_Charge_Adclick_full_LZS" : "Vlock_Charge_Adclick_part_LZS");
                    if (!com.vlocker.locker.c.b.f) {
                        this.v.sendBroadcast(new Intent("action_battery_tomini"));
                        return;
                    }
                } else if (str.startsWith(this.v.getPackageName() + "|" + 8 + "|")) {
                    c = p.a().c(str);
                    if (c != null) {
                        ao.e(this.v, c.D);
                        ((NotificationManager) this.v.getSystemService("notification")).cancel(as.b(str));
                        ab.e(str);
                        return;
                    }
                } else if (str.startsWith(this.v.getPackageName() + "|-1|12") || str.equals("mx_clean") || str.equals("mx_update")) {
                    this.u.b(str);
                    return;
                } else if ("weather_news".equals(str)) {
                    CoverViewPager.c = false;
                    this.v.sendBroadcast(new Intent("action_weather_open_news_post"));
                    return;
                }
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.s, 0.0f, 0.0f);
                translateAnimation.setDuration(300);
                translateAnimation.setInterpolator(new CycleInterpolator(1.0f));
                view.startAnimation(translateAnimation);
            }
        }
    }

    private void a(View view, float f, boolean z) {
        float f2 = 0.2f;
        view.scrollBy((int) (-f), 0);
        float abs = (((float) this.o) - Math.abs(this.h - this.e)) / ((float) this.o);
        if (abs <= 1.0f && abs >= 0.2f) {
            f2 = abs;
        }
        View findViewById = view.findViewById(R.id.msg_outer_layout);
        if (z) {
            findViewById.setAlpha(1.0f);
            a(f2);
            return;
        }
        findViewById.setAlpha(f2);
    }

    private void a(View view, boolean z, boolean z2) {
        if (view != null) {
            int scrollX = view.getScrollX();
            float alpha = view.getAlpha();
            View findViewById = view.findViewById(R.id.msg_outer_layout);
            int width = (getWidth() + scrollX) * -1;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new d(this, view, scrollX, z, width, z2, findViewById, alpha));
            long abs = (long) ((((float) Math.abs(scrollX)) / ((float) this.r)) * 500.0f);
            if (f.e) {
                abs = 300;
                if (z) {
                    abs = 100;
                }
            }
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(abs);
            ofFloat.start();
        }
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        return (iArr[0] == 0 && i == 0) ? true : motionEvent.getRawY() >= ((float) i) && motionEvent.getRawY() <= ((float) (i + view.getHeight()));
    }

    private void b(View view, boolean z, boolean z2) {
        if (view != null) {
            int scrollX = view.getScrollX();
            int width = view.getWidth();
            int i = z ? width - scrollX : (-width) - scrollX;
            String str = (String) view.findViewById(R.id.l_msg_pkg).getTag();
            View findViewById = view.findViewById(R.id.msg_outer_layout);
            float alpha = findViewById.getAlpha();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new e(this, i, view, scrollX, z, z2, findViewById, alpha, str));
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(250);
            ofFloat.start();
        }
    }

    public View getMsgTouchView() {
        return this.k;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.u == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                CoverViewPager.a = true;
                this.c = 0.0f;
                this.b = 0.0f;
                this.d = motionEvent.getRawX();
                this.f = motionEvent.getRawY();
                this.g = this.d;
                this.e = this.d;
                this.w = false;
                this.k = a((ViewGroup) this, motionEvent);
                this.m = false;
                this.j = System.currentTimeMillis();
                if (this.k == null) {
                    this.n = false;
                    break;
                }
                this.n = true;
                break;
            case 2:
                this.h = motionEvent.getRawX();
                this.i = motionEvent.getRawY();
                this.e = this.h;
                this.g = this.h;
                break;
        }
        return (this.k == null || ((a) this.k.getTag()) == null || !(((a) this.k.getTag()).n == 7 || ((a) this.k.getTag()).n == 9 || ((a) this.k.getTag()).n == 10)) ? true : this.m;
    }

    public void onMeasure(int i, int i2) {
        if (BatteryChargeView.h) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        } else {
            super.onMeasure(i, i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view = null;
        if (this.u == null || p.a) {
            return false;
        }
        this.h = motionEvent.getRawX();
        this.i = motionEvent.getRawY();
        this.b = this.h > 0.0f ? Math.abs(this.h - this.d) : 0.0f;
        this.c = this.i > 0.0f ? Math.abs(this.i - this.f) : 0.0f;
        if (!this.w) {
            if (this.b > this.c && this.n && this.b >= ((float) this.p) && this.k != null) {
                this.w = true;
                this.m = true;
            } else if (this.b >= ((float) this.p) || this.c >= ((float) this.p)) {
                this.w = true;
                this.m = false;
            }
        }
        if (this.w && !this.m && !a) {
            return super.onTouchEvent(motionEvent);
        }
        String str;
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                if (this.k != null) {
                    try {
                        str = (String) this.k.findViewById(R.id.l_msg_pkg).getTag();
                    } catch (Exception e) {
                        str = null;
                    }
                    float f = this.h - this.d;
                    if (f <= 0.0f || !(str.startsWith(this.v.getPackageName() + "|" + 8 + "|") || str.equals("weather_news"))) {
                        ak c = p.a().c(str);
                        if (f.e && f > 0.0f && Math.abs(f) >= ((float) this.o) && !c.y && !str.equals("mx_clean") && !as.a(this.v, c)) {
                            this.u.a(this.h - this.g, str);
                            this.g = this.h;
                            break;
                        }
                        if (this.w) {
                            a(this.k, this.h - this.g, f > 0.0f);
                        }
                        this.g = this.h;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                float f2 = this.h - this.d;
                float abs = Math.abs(f2);
                if (System.currentTimeMillis() - this.j < ((long) this.t) && abs <= 10.0f && ((this.k == null || ((a) this.k.getTag()) == null || ((a) this.k.getTag()).n != 7) && !NotifyRootLayout.a)) {
                    if (this.k != null) {
                        view = this.k.findViewById(R.id.msg_outer_layout);
                    }
                    a(view);
                    break;
                }
                try {
                    str = (String) this.k.findViewById(R.id.l_msg_pkg).getTag();
                } catch (Exception e2) {
                    str = null;
                }
                if (this.k != null) {
                    if (f2 > 0.0f && str.startsWith(this.v.getPackageName() + "|" + 8 + "|")) {
                        a(this.k, true, false);
                        this.l.clear();
                        break;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - this.j;
                    if (currentTimeMillis == 0) {
                        currentTimeMillis++;
                    }
                    if (abs < ((float) this.o)) {
                        a(this.k, true, false);
                    } else if (f2 > 0.0f) {
                        ak c2 = p.a().c(str);
                        if (!c2.y && !"weather_news".equals(c2.b) && !as.a(this.v, c2)) {
                            a(this.k, false, true);
                        } else if (this.u != null) {
                            this.u.b(str);
                        }
                    } else {
                        b(this.k, true, true);
                    }
                }
                a(1.0f);
                this.l.clear();
                break;
                break;
        }
        if (this.w || a) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setMsgTouchListener(e eVar) {
        this.u = eVar;
    }
}
