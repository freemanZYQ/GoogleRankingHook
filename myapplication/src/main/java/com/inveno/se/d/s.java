package com.inveno.se.d;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class s {
    private AtomicInteger a;
    private Map b;
    private Set c;
    private PriorityBlockingQueue d;
    private PriorityBlockingQueue e;
    private b f;
    private final j g;
    private final w h;
    private k[] i;
    private d j;
    private ThreadPoolExecutor k;

    public s(b bVar, j jVar) {
        this(bVar, jVar, 4);
    }

    public s(b bVar, j jVar, int i) {
        this(bVar, jVar, i, new g(new Handler(Looper.getMainLooper())));
    }

    public s(b bVar, j jVar, int i, w wVar) {
        this.a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue();
        this.e = new PriorityBlockingQueue();
        this.f = bVar;
        this.g = jVar;
        this.i = new k[i];
        this.h = wVar;
        this.k = (ThreadPoolExecutor) Executors.newFixedThreadPool(i);
    }

    public p a(p pVar) {
        pVar.a(this);
        synchronized (this.c) {
            this.c.add(pVar);
        }
        pVar.a(c());
        pVar.a("add-to-queue");
        if (pVar.q()) {
            synchronized (this.b) {
                String c = pVar.c();
                if (this.b.containsKey(c)) {
                    Queue queue = (Queue) this.b.get(c);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(pVar);
                    this.b.put(c, queue);
                    ab.a("Request for cacheKey=%s is in flight, putting on hold.", c);
                } else {
                    this.b.put(c, null);
                    this.d.add(pVar);
                }
            }
        } else {
            this.e.add(pVar);
        }
        return pVar;
    }

    public void a() {
        b();
        this.j = new d(this.d, this.e, this.f, this.h);
        this.k.execute(this.j);
        for (int i = 0; i < this.i.length; i++) {
            Runnable kVar = new k(this.e, this.g, this.f, this.h);
            this.i[i] = kVar;
            this.k.execute(kVar);
        }
    }

    public void b() {
        if (this.j != null) {
            this.j.a();
        }
        for (int i = 0; i < this.i.length; i++) {
            if (this.i[i] != null) {
                this.i[i].a();
            }
        }
    }

    void b(p pVar) {
        synchronized (this.c) {
            if (this.c != null) {
                this.c.remove(pVar);
            }
        }
        if (pVar.q()) {
            synchronized (this.b) {
                String c = pVar.c();
                if (this.b != null) {
                    Queue queue = (Queue) this.b.remove(c);
                    if (queue != null) {
                        ab.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), c);
                        if (this.d != null) {
                            this.d.addAll(queue);
                        }
                    }
                }
            }
        }
    }

    public int c() {
        return this.a.incrementAndGet();
    }
}
