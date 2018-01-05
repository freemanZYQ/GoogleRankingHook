package com.vlocker.theme.imageloader;

import java.io.FileOutputStream;
import java.io.OutputStream;

public final class n {
    final /* synthetic */ l a;
    private final p b;
    private boolean c;

    private n(l lVar, p pVar) {
        this.a = lVar;
        this.b = pVar;
    }

    public OutputStream a(int i) {
        OutputStream oVar;
        synchronized (this.a) {
            if (this.b.e != this) {
                throw new IllegalStateException();
            }
            oVar = new o(this, new FileOutputStream(this.b.b(i)), null);
        }
        return oVar;
    }

    public void a() {
        if (this.c) {
            this.a.a(this, false);
            this.a.c(this.b.b);
            return;
        }
        this.a.a(this, true);
    }

    public void b() {
        this.a.a(this, false);
    }
}
