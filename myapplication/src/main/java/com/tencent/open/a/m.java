package com.tencent.open.a;

public abstract class m {
    private volatile int a;
    private volatile boolean b;
    private l c;

    public m() {
        this(c.a, true, l.a);
    }

    public m(int i, boolean z, l lVar) {
        this.a = c.a;
        this.b = true;
        this.c = l.a;
        a(i);
        a(z);
        a(lVar);
    }

    public void a(int i) {
        this.a = i;
    }

    protected abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void a(l lVar) {
        this.c = lVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (c() && e.a(this.a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean c() {
        return this.b;
    }

    public l d() {
        return this.c;
    }
}
