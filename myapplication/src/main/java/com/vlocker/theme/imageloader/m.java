package com.vlocker.theme.imageloader;

import java.util.concurrent.Callable;

class m implements Callable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public Void a() {
        synchronized (this.a) {
            if (this.a.i == null) {
            } else {
                this.a.c();
                if (this.a.h()) {
                    this.a.g();
                    this.a.k = 0;
                }
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
