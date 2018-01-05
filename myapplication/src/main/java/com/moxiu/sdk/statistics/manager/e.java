package com.moxiu.sdk.statistics.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.moxiu.sdk.statistics.a.a;
import com.moxiu.sdk.statistics.b.c;
import com.moxiu.sdk.statistics.e.i;
import java.util.Date;
import java.util.Random;

public class e {
    private static e c = null;
    private Context a;
    private g b;

    private e() {
        this.a = null;
        this.b = null;
        this.a = h.a().b();
        this.b = new g(this, this.a);
    }

    public static e a() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e();
                }
            }
        }
        return c;
    }

    private long d() {
        return System.currentTimeMillis() + ((long) (new Random().nextDouble() * 2.16E7d));
    }

    private void e() {
        i.a("checkDB");
        int b = this.b.b();
        if (b <= 0) {
            MxPollingManager.a().e();
        } else if (b > 10000) {
            this.b.c();
        }
    }

    public void a(a aVar) {
        i.a("addDealy");
        MxIntentService.b(this.a, aVar);
    }

    public void b() {
        i.a("uploadDelay");
        new Handler(Looper.getMainLooper()).postDelayed(new f(this), 1000);
    }

    protected void b(a aVar) {
        i.a("doWriteDelay");
        if (aVar == null) {
            i.a("data is null, return");
            return;
        }
        long d = d();
        long a = this.b.a(aVar, d);
        i.a("addDelayItem id = " + a + " now = " + new Date() + " delay to = " + new Date(d));
        if (a == -1) {
            e();
        } else {
            MxPollingManager.a().c();
        }
    }

    protected void c() {
        i.a("doDelayPost");
        Pair a = this.b.a();
        if (a == null) {
            i.a("get null, reutrn!");
            e();
            return;
        }
        int intValue = ((Integer) a.first).intValue();
        a aVar = (a) a.second;
        if (c.a(aVar)) {
            i.a("postSucceed");
        } else {
            i.a("postFailed do cache");
            a.a().a(aVar);
        }
        this.b.a((long) intValue);
        b();
    }
}
