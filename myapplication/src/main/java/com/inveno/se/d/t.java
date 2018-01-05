package com.inveno.se.d;

public class t {
    public final Object a;
    public final c b;
    public final aa c;
    public boolean d;

    private t(aa aaVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = aaVar;
    }

    private t(Object obj, c cVar) {
        this.d = false;
        this.a = obj;
        this.b = cVar;
        this.c = null;
    }

    public static t a(aa aaVar) {
        return new t(aaVar);
    }

    public static t a(Object obj, c cVar) {
        return new t(obj, cVar);
    }

    public boolean a() {
        return this.c == null;
    }
}
