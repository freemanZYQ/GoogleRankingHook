package com.moxiu.sdk.statistics.d;

import com.moxiu.sdk.a.a.a;
import com.moxiu.sdk.a.a.d;

public final class f extends d {
    public d b;
    public b c;

    public f() {
        e();
    }

    public void a(a aVar) {
        if (this.b != null) {
            aVar.a(1, this.b);
        }
        if (this.c != null) {
            aVar.a(2, this.c);
        }
        super.a(aVar);
    }

    protected int c() {
        int c = super.c();
        if (this.b != null) {
            c += a.b(1, this.b);
        }
        return this.c != null ? c + a.b(2, this.c) : c;
    }

    public f e() {
        this.b = null;
        this.c = null;
        this.a = -1;
        return this;
    }
}
