package com.vlocker.msg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.provider.CallLog.Calls;
import android.provider.Telephony.MmsSms;
import com.vlocker.security.MoSecurityApplication;

public class f {
    private static f a;
    private Context b = MoSecurityApplication.a().getApplicationContext();
    private Handler c = new Handler();
    private g d;
    private h e;

    private f() {
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    private void d() {
        if (this.d == null) {
            this.d = new g(this, this.c);
            this.b.getContentResolver().registerContentObserver(Calls.CONTENT_URI, false, this.d);
        }
    }

    private void e() {
        if (this.d != null) {
            this.b.getContentResolver().unregisterContentObserver(this.d);
            this.d = null;
        }
    }

    @SuppressLint({"NewApi"})
    private void f() {
        if (this.e == null) {
            this.e = new h(this, this.c);
            this.b.getContentResolver().registerContentObserver(MmsSms.CONTENT_URI, true, this.e);
        }
    }

    private void g() {
        try {
            if (this.e != null) {
                this.b.getContentResolver().unregisterContentObserver(this.e);
                this.e = null;
            }
        } catch (Exception e) {
        }
    }

    public synchronized void b() {
        d();
        f();
    }

    public void c() {
        e();
        g();
    }
}
