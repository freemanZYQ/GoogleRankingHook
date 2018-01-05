package com.moxiu.sdk.statistics.d;

import com.moxiu.sdk.a.a.a;

public final class d extends com.moxiu.sdk.a.a.d {
    public String b;
    public String c;
    public String d;
    public e[] e;
    public String f;

    public d() {
        e();
    }

    public void a(a aVar) {
        if (!this.b.equals("")) {
            aVar.a(1, this.b);
        }
        if (!this.c.equals("")) {
            aVar.a(2, this.c);
        }
        aVar.a(3, this.d);
        if (this.e != null && this.e.length > 0) {
            for (com.moxiu.sdk.a.a.d dVar : this.e) {
                if (dVar != null) {
                    aVar.a(4, dVar);
                }
            }
        }
        if (!this.f.equals("")) {
            aVar.a(5, this.f);
        }
        super.a(aVar);
    }

    protected int c() {
        int c = super.c();
        if (!this.b.equals("")) {
            c += a.b(1, this.b);
        }
        if (!this.c.equals("")) {
            c += a.b(2, this.c);
        }
        int b = a.b(3, this.d) + c;
        if (this.e != null && this.e.length > 0) {
            for (com.moxiu.sdk.a.a.d dVar : this.e) {
                if (dVar != null) {
                    b += a.b(4, dVar);
                }
            }
        }
        return !this.f.equals("") ? b + a.b(5, this.f) : b;
    }

    public d e() {
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = e.e();
        this.f = "";
        this.a = -1;
        return this;
    }
}
