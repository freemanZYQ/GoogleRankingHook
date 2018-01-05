package com.vlocker.locker.b;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.settings.w;
import com.vlocker.ui.cover.i;
import java.util.ArrayList;
import java.util.List;

public class a {
    private static int t = -1;
    protected int a = -1;
    protected int b;
    private View c = null;
    private View d = null;
    private ViewGroup e = null;
    private View f = null;
    private TextView g;
    private ImageView h;
    private Context i = null;
    private int j = 0;
    private int k;
    private boolean l = false;
    private com.vlocker.c.a m;
    private p n;
    private boolean o = false;
    private VelocityTracker p;
    private int q;
    private boolean r = false;
    private OnTouchListener s = new c(this);

    private void a(Context context, boolean z) {
        if ((!"".equals(this.m.bb()) && !z && !"com.intsig.BizCardReader".equals(this.m.bb())) || w.a(context)) {
            String bb = this.m.bb();
            Intent intent = new Intent();
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.addFlags(268435456);
            if (w.a(bb)) {
                intent.setClassName(bb, this.m.bc());
            } else {
                intent.setPackage(bb);
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
            }
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                a(context, true);
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        this.p.addMovement(motionEvent);
    }

    private synchronized void a(boolean z) {
        try {
            if (this.e != null) {
                ViewPropertyAnimator animate = this.e.animate();
                animate.cancel();
                if (z) {
                    animate.translationY((float) (this.j * -3)).setInterpolator(new DecelerateInterpolator()).setDuration(200).start();
                } else {
                    animate.translationY(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(200).start();
                }
            }
        } catch (Exception e) {
        }
    }

    public static boolean a(Context context) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.media.action.STILL_IMAGE_CAMERA"), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            t = 1;
        } else if (w.a(context, new ArrayList()).size() > 0) {
            t = 1;
        } else {
            t = 0;
        }
        return t == 1;
    }

    private void e() {
        if (this.d != null) {
            this.d.setOnTouchListener(this.s);
        }
    }

    private void f() {
        if (this.p != null) {
            this.p.recycle();
            this.p = null;
        }
    }

    private void g() {
        if (this.f != null) {
            ((ImageButton) this.f.findViewById(R.id.cover_back_camera_btn)).setImageResource(R.drawable.l_lockscreen_camera_icon_press);
        }
    }

    private void h() {
        this.h.setVisibility(0);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(4000);
        alphaAnimation.setAnimationListener(new h(this));
        this.h.setVisibility(0);
        this.h.startAnimation(alphaAnimation);
    }

    public void a() {
        this.e.clearAnimation();
        ViewPropertyAnimator animate = this.e.animate();
        animate.cancel();
        animate.setListener(null);
        this.o = true;
        this.f.setVisibility(0);
        g();
        Object iVar = new i();
        iVar.a(new AccelerateDecelerateInterpolator(), 250, false);
        iVar.a(new BounceInterpolator(), 500, true);
        animate.translationY((float) ((-this.e.getHeight()) / 12)).setInterpolator(iVar).setDuration(iVar.a()).start();
        animate.setListener(new b(this, animate));
    }

    public void a(Context context, p pVar, ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3, TextView textView) {
        this.i = context;
        this.m = com.vlocker.c.a.a(this.i);
        this.n = pVar;
        this.e = viewGroup2;
        this.c = viewGroup3;
        this.d = this.c.findViewById(R.id.camera_icon);
        this.h = (ImageView) this.c.findViewById(R.id.slide_camera_icon);
        this.g = textView;
        c();
        if (this.d != null) {
            this.d.setOnTouchListener(this.s);
        }
        this.f = viewGroup;
        this.k = context.getResources().getDisplayMetrics().heightPixels;
        e();
        if (this.f != null) {
            this.f.setVisibility(8);
        }
        this.j = l.a(this.i, 10.0f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        if (viewConfiguration != null) {
            this.b = viewConfiguration.getScaledTouchSlop();
            this.q = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    public View b() {
        return this.d;
    }

    public void c() {
        if (this.d != null) {
            if (this.m.aw() && a(this.i)) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        if (this.h != null) {
            this.h.setVisibility(8);
        }
    }

    public void d() {
        if (!com.vlocker.c.a.a(this.i).V()) {
            com.vlocker.c.a.a(this.i).r(true);
            this.g.setVisibility(0);
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(4000);
            alphaAnimation.setAnimationListener(new g(this));
            this.g.startAnimation(alphaAnimation);
        }
    }
}
