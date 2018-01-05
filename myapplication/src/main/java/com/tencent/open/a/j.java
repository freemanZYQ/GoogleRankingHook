package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.d.e;
import java.io.File;

public class j {
    public static j a = null;
    protected static final b c = new b(b(), c.m, c.g, c.h, c.c, (long) c.i, 10, c.e, c.n);
    private static boolean d = false;
    protected a b = new a(c);

    private j() {
    }

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                    d = true;
                }
            }
        }
        return a;
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(16, str, str2, th);
    }

    protected static File b() {
        Object obj = null;
        String str = c.d;
        g b = f.b();
        if (b != null && b.c() > c.f) {
            obj = 1;
        }
        return obj != null ? new File(Environment.getExternalStorageDirectory(), str) : new File(e.c(), str);
    }

    public static final void b(String str, String str2) {
        a().a(2, str, str2, null);
    }

    public static final void c(String str, String str2) {
        a().a(4, str, str2, null);
    }

    public static final void d(String str, String str2) {
        a().a(8, str, str2, null);
    }

    public static final void e(String str, String str2) {
        a().a(16, str, str2, null);
    }

    protected void a(int i, String str, String str2, Throwable th) {
        if (d) {
            Object b = e.b();
            if (TextUtils.isEmpty(b)) {
                String str3 = "default";
            } else {
                String str4 = b + " SDK_VERSION:" + "2.9.4.lite";
                if (this.b != null) {
                    i.a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str4, null);
                    this.b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str4, null);
                    d = false;
                } else {
                    return;
                }
            }
        }
        i.a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (e.a(c.b, i) && this.b != null) {
            this.b.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
    }
}
