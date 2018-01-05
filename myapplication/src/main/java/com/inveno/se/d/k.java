package com.inveno.se.d;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import com.inveno.se.f.a;
import java.util.concurrent.BlockingQueue;

public class k extends Thread {
    private BlockingQueue a;
    private j b;
    private b c;
    private w d;
    private volatile boolean e = false;

    public k(BlockingQueue blockingQueue, j jVar, b bVar, w wVar) {
        this.a = blockingQueue;
        this.b = jVar;
        this.c = bVar;
        this.d = wVar;
    }

    private void a(p pVar, aa aaVar) {
        this.d.a(pVar, pVar.a(aaVar));
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                p pVar = (p) this.a.take();
                try {
                    pVar.a("network-queue-take");
                    if (pVar.j()) {
                        pVar.b("network-discard-cancelled");
                    } else {
                        if (VERSION.SDK_INT >= 14) {
                            TrafficStats.setThreadStatsTag(pVar.h());
                        }
                        a.b("------------go to performRequest-------");
                        m a = this.b.a(pVar);
                        pVar.a("network-http-complete");
                        if (a.d && pVar.u()) {
                            pVar.b("not-modified");
                        } else {
                            t a2 = pVar.a(a);
                            pVar.a("network-parse-complete");
                            if (!(!pVar.q() || a2.b == null || this.c == null)) {
                                this.c.a(pVar.c(), a2.b);
                                pVar.a("network-cache-written");
                            }
                            pVar.t();
                            this.d.a(pVar, a2);
                        }
                    }
                } catch (aa e) {
                    a(pVar, e);
                } catch (Throwable e2) {
                    ab.a(e2, "Unhandled exception %s", e2.toString());
                    this.d.a(pVar, new aa(e2));
                }
            } catch (InterruptedException e3) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
