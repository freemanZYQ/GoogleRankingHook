package com.moxiu.sdk.statistics.manager;

import android.content.Context;
import android.text.TextUtils;
import com.moxiu.sdk.statistics.b.c;
import com.moxiu.sdk.statistics.c.a;
import com.moxiu.sdk.statistics.c.b;
import com.moxiu.sdk.statistics.e.e;
import com.moxiu.sdk.statistics.e.f;
import com.moxiu.sdk.statistics.e.i;
import com.moxiu.sdk.statistics.e.k;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;

public class h {
    private static h a = null;
    private Context b = null;

    private h() {
    }

    public static h a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    private boolean c() {
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        long j = 3600000 + timeInMillis;
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis > timeInMillis && currentTimeMillis < j;
    }

    public void a(Context context) {
        this.b = context;
    }

    public void a(b bVar, f fVar) {
        i.a("postModel");
        MxIntentService.a(this.b, bVar, fVar);
    }

    public void a(String str, LinkedHashMap linkedHashMap, f fVar) {
        if (TextUtils.isEmpty(str)) {
            i.b("eventid is null, return");
            return;
        }
        b aVar = new a();
        aVar.a = str;
        aVar.b = linkedHashMap;
        a(aVar, fVar);
    }

    public Context b() {
        return this.b;
    }

    protected void b(b bVar, f fVar) {
        i.a("doPostModel");
        com.moxiu.sdk.statistics.a.a a = com.moxiu.sdk.statistics.a.a.a(bVar, fVar);
        if (a == null) {
            i.b("data is null, return");
        } else if (c()) {
            i.a("server is busy, delay");
            e.a().a(a);
        } else {
            boolean z = false;
            if (k.a(this.b) != e.noNetStatus) {
                try {
                    z = c.a(a);
                } catch (Throwable e) {
                    i.a("postData Exception = ", e);
                }
            }
            if (z) {
                i.a("postSucceed");
                return;
            }
            i.b("no net or postFailed, do cache");
            a.a().a(a);
        }
    }
}
