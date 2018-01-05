package com.inveno.se.d;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

class ac {
    private final List a = new ArrayList();
    private boolean b = false;

    ac() {
    }

    private long a() {
        if (this.a.size() == 0) {
            return 0;
        }
        return ((ad) this.a.get(this.a.size() - 1)).c - ((ad) this.a.get(0)).c;
    }

    public synchronized void a(String str) {
        this.b = true;
        if (a() > 0) {
            long j = ((ad) this.a.get(0)).c;
            ab.b("(%-4d ms) %s", Long.valueOf(r2), str);
            long j2 = j;
            for (ad adVar : this.a) {
                ab.b("(+%-4d) [%2d] %s", Long.valueOf(adVar.c - j2), Long.valueOf(adVar.b), adVar.a);
                j2 = adVar.c;
            }
        }
    }

    public synchronized void a(String str, long j) {
        if (this.b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.a.add(new ad(str, j, SystemClock.elapsedRealtime()));
    }

    protected void finalize() {
        if (!this.b) {
            a("Request on the loose");
            ab.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
