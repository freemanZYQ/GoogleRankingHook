package com.tencent.wxop.stat.b;

import android.util.Log;
import com.tencent.wxop.stat.v;

public final class b {
    private String a = "default";
    private boolean b = true;
    private int c = 2;

    public b(String str) {
        this.a = str;
    }

    private String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public final void a() {
        this.b = false;
    }

    public final void a(Object obj) {
        if (this.b && this.c <= 4) {
            String b = b();
            Log.i(this.a, b == null ? obj.toString() : b + " - " + obj);
            v.w();
        }
    }

    public final void a(Throwable th) {
        if (this.c <= 6) {
            Log.e(this.a, "", th);
            v.w();
        }
    }

    public final void b(Object obj) {
        if (this.c <= 5) {
            String b = b();
            Log.w(this.a, b == null ? obj.toString() : b + " - " + obj);
            v.w();
        }
    }

    public final void b(Throwable th) {
        if (this.b) {
            a(th);
        }
    }

    public final void c(Object obj) {
        if (this.b) {
            b(obj);
        }
    }

    public final void d(Object obj) {
        if (this.c <= 6) {
            String b = b();
            Log.e(this.a, b == null ? obj.toString() : b + " - " + obj);
            v.w();
        }
    }

    public final void e(Object obj) {
        if (this.b) {
            d(obj);
        }
    }

    public final void f(Object obj) {
        if (this.c <= 3) {
            String b = b();
            Log.d(this.a, b == null ? obj.toString() : b + " - " + obj);
            v.w();
        }
    }

    public final void g(Object obj) {
        if (this.b) {
            f(obj);
        }
    }
}
