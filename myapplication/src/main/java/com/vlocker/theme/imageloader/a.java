package com.vlocker.theme.imageloader;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a {
    public static final Executor a = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, e, d, new DiscardOldestPolicy());
    public static final Executor b = (aa.b() ? new h() : Executors.newSingleThreadExecutor(d));
    public static final Executor c = Executors.newFixedThreadPool(2, d);
    private static final ThreadFactory d = new b();
    private static final BlockingQueue e = new LinkedBlockingQueue(10);
    private static final g f = new g();
    private static volatile Executor g = b;
    private final k h = new c(this);
    private final FutureTask i = new d(this, this.h);
    private volatile j j = j.PENDING;
    private final AtomicBoolean k = new AtomicBoolean();
    private final AtomicBoolean l = new AtomicBoolean();

    private void c(Object obj) {
        if (!this.l.get()) {
            d(obj);
        }
    }

    private Object d(Object obj) {
        f.obtainMessage(1, new f(this, obj)).sendToTarget();
        return obj;
    }

    private void e(Object obj) {
        if (c()) {
            b(obj);
        } else {
            a(obj);
        }
        this.j = j.FINISHED;
    }

    public final a a(Executor executor, Object... objArr) {
        if (this.j != j.PENDING) {
            switch (e.a[this.j.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.j = j.RUNNING;
        a();
        this.h.b = objArr;
        executor.execute(this.i);
        return this;
    }

    protected abstract Object a(Object... objArr);

    protected void a() {
    }

    protected void a(Object obj) {
    }

    public final boolean a(boolean z) {
        this.k.set(true);
        return this.i.cancel(z);
    }

    protected void b() {
    }

    protected void b(Object obj) {
        b();
    }

    protected void b(Object... objArr) {
    }

    public final a c(Object... objArr) {
        return a(g, objArr);
    }

    public final boolean c() {
        return this.k.get();
    }

    protected final void d(Object... objArr) {
        if (!c()) {
            f.obtainMessage(2, new f(this, objArr)).sendToTarget();
        }
    }
}
