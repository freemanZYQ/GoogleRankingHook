package com.inveno.a;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class am extends Thread {
    private static am b;
    private AtomicInteger a = new AtomicInteger();
    private volatile boolean c = false;
    private final PriorityBlockingQueue d = new PriorityBlockingQueue();

    private am() {
        start();
    }

    static synchronized am a() {
        am amVar;
        synchronized (am.class) {
            if (b == null) {
                b = new am();
            }
            amVar = b;
        }
        return amVar;
    }

    void a(al alVar) {
        alVar.a(b());
        this.d.add(alVar);
    }

    public int b() {
        return this.a.incrementAndGet();
    }

    public void run() {
        while (true) {
            try {
                ((al) this.d.take()).a();
            } catch (InterruptedException e) {
                if (this.c) {
                    return;
                }
            }
        }
    }
}
