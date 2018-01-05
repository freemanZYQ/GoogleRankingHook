package com.inveno.a;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.inveno.se.f.a;

public class b {
    private static b a;
    private Context b;
    private ActivityLifecycleCallbacks c;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    private b(Context context) {
        this.b = context;
        c();
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                if (m.c) {
                    a = new b(context);
                } else {
                    a = new b(context.getApplicationContext());
                }
            }
            bVar = a;
        }
        return bVar;
    }

    private void c() {
        if (this.b == null) {
            b();
            a.e("context is null , relase itself !!!");
            return;
        }
        this.c = new c(this);
        if (!m.c) {
            ((Application) this.b).registerActivityLifecycleCallbacks(this.c);
        }
    }

    private void d() {
        if (this.d == 0) {
            a.e("The app is Exit !!! inResumCycleActivityNum: " + this.e);
        } else if (this.e == 0) {
            a.e("The app is background !!! inLifeCycleActivityNum = " + this.d);
            if (!m.c) {
                r.a().d();
            }
            av.a(i.a, l.a().j());
        } else {
            a.e("The app is alive !!!");
        }
    }

    boolean a() {
        return this.f > 0;
    }

    public void b() {
        if (!(this.b == null || this.c == null)) {
            ((Application) this.b).unregisterActivityLifecycleCallbacks(this.c);
        }
        this.b = null;
        a = null;
    }
}
