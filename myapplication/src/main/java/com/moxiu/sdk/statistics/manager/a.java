package com.moxiu.sdk.statistics.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.moxiu.sdk.statistics.b.c;
import com.moxiu.sdk.statistics.e.i;

public class a {
    private static a d = null;
    private d a;
    private Context b;
    private c c;

    private a() {
        this.a = new d();
        this.b = null;
        this.c = null;
        this.b = h.a().b();
        this.c = new c(this, this.b);
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private void d() {
        i.a("checkDB");
        int b = this.c.b();
        if (b <= 0) {
            MxPollingManager.a().d();
        } else if (b > 10000) {
            this.c.c();
        }
    }

    public void a(com.moxiu.sdk.statistics.a.a aVar) {
        i.a("addCache");
        MxIntentService.a(this.b, aVar);
    }

    public void b() {
        i.a("uploadCache");
        new Handler(Looper.getMainLooper()).postDelayed(new b(this), 1000);
    }

    protected void b(com.moxiu.sdk.statistics.a.a aVar) {
        i.a("doWriteCache");
        if (aVar == null) {
            i.a("data is null, return");
        } else if (this.c.a(aVar) == -1) {
            d();
        } else {
            MxPollingManager.a().b();
        }
    }

    protected void c() {
        i.a("doPostCache");
        Pair a = this.c.a();
        if (a == null) {
            i.b("get null, return");
            d();
            return;
        }
        boolean z;
        int intValue = ((Integer) a.first).intValue();
        if (c.a((com.moxiu.sdk.statistics.a.a) a.second)) {
            i.a("postSucceed do delete");
            this.a.b();
            this.c.a((long) intValue);
            z = true;
        } else {
            i.a("postFailed");
            z = this.a.c();
        }
        i.a("continueToRead = " + z);
        if (z) {
            b();
        }
    }
}
