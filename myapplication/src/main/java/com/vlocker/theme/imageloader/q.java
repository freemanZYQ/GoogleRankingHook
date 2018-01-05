package com.vlocker.theme.imageloader;

import java.io.Closeable;
import java.io.InputStream;

public final class q implements Closeable {
    final /* synthetic */ l a;
    private final String b;
    private final long c;
    private final InputStream[] d;

    private q(l lVar, String str, long j, InputStream[] inputStreamArr) {
        this.a = lVar;
        this.b = str;
        this.c = j;
        this.d = inputStreamArr;
    }

    public InputStream a(int i) {
        return this.d[i];
    }

    public void close() {
        for (Closeable a : this.d) {
            l.a(a);
        }
    }
}
