package com.inveno.se.d;

import android.os.Process;
import com.inveno.se.d.a.p;
import com.inveno.se.f.n;
import com.inveno.se.f.o;
import java.util.concurrent.BlockingQueue;

public class d extends Thread {
    private BlockingQueue a;
    private BlockingQueue b;
    private b c;
    private w d;
    private volatile boolean e = false;

    public d(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, b bVar, w wVar) {
        this.a = blockingQueue;
        this.b = blockingQueue2;
        this.c = bVar;
        this.d = wVar;
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    public void run() {
        ab.a("start new dispatcher", new Object[0]);
        Process.setThreadPriority(10);
        if (this.c != null) {
            this.c.a();
        }
        while (true) {
            try {
                p pVar = (p) this.a.take();
                pVar.a("cache-queue-take");
                if (pVar.j()) {
                    pVar.b("cache-discard-canceled");
                } else {
                    c cVar = null;
                    if (this.c != null) {
                        cVar = this.c.a(pVar.c());
                    }
                    if (cVar == null) {
                        pVar.a("cache-miss");
                        this.b.put(pVar);
                    } else if (o.a(n.a).equals(pVar.c()) || (pVar instanceof p) || !cVar.a()) {
                        pVar.a("cache-hit");
                        t a = pVar.a(new m(cVar.a, cVar.f));
                        pVar.a("cache-hit-parsed");
                        if (!cVar.b() || o.a(n.a).equals(pVar.c())) {
                            this.d.a(pVar, a);
                        } else {
                            pVar.a("cache-hit-refresh-needed");
                            pVar.a(cVar);
                            a.d = true;
                            this.d.a(pVar, a, new e(this, pVar));
                        }
                    } else {
                        pVar.a("cache-hit-expired");
                        pVar.a(cVar);
                        this.b.put(pVar);
                    }
                }
            } catch (InterruptedException e) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
