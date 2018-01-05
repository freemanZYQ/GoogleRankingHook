package com.moxiu.sdk.statistics.d;

import com.moxiu.sdk.a.a.a;
import com.moxiu.sdk.a.a.c;
import com.moxiu.sdk.a.a.d;

public final class e extends d {
    private static volatile e[] d;
    public String b;
    public String c;

    public e() {
        f();
    }

    public static e[] e() {
        if (d == null) {
            synchronized (c.c) {
                if (d == null) {
                    d = new e[0];
                }
            }
        }
        return d;
    }

    public void a(a aVar) {
        if (!this.b.equals("")) {
            aVar.a(1, this.b);
        }
        if (!this.c.equals("")) {
            aVar.a(2, this.c);
        }
        super.a(aVar);
    }

    protected int c() {
        int c = super.c();
        if (!this.b.equals("")) {
            c += a.b(1, this.b);
        }
        return !this.c.equals("") ? c + a.b(2, this.c) : c;
    }

    public e f() {
        this.b = "";
        this.c = "";
        this.a = -1;
        return this;
    }
}
