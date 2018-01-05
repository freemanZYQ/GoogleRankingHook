package com.mx.http;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class l {
    public PriorityBlockingQueue a;
    private PriorityBlockingQueue b;
    private ExecutorService c = Executors.newFixedThreadPool(a.a);
    private boolean d;
    private c e;
    private Context f;

    public l(c cVar, Context context) {
        this.f = context;
        this.e = cVar;
        if (this.a == null) {
            this.a = new PriorityBlockingQueue();
        }
        if (this.b == null) {
            this.b = new PriorityBlockingQueue();
        }
    }

    private void b(j jVar, g gVar) {
        this.c.execute(new m(this, gVar));
    }

    public void a(j jVar, g gVar) {
        this.a.put(jVar);
        if (!this.d) {
            b(jVar, gVar);
            this.d = true;
        }
    }
}
