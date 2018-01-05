package com.inveno.a;

class y {
    final int a;
    private String b;
    private String c;
    private String d;
    private long e;
    private long f;
    private long g;
    private int h;
    private String i;
    private String j;

    y(String str, String str2, long j, int i) {
        this.b = str;
        this.c = str2;
        this.e = j;
        this.a = i;
    }

    y a(long j) {
        this.f = j;
        return this;
    }

    y a(String str) {
        this.d = str;
        return this;
    }

    z a() {
        return new z(this.b, this.c, this.d, this.e, this.f, this.g, this.a, this.i, this.j);
    }

    aa b() {
        return new aa(this.b, this.c, this.d, this.e, this.h, this.i, this.j);
    }

    y b(String str) {
        this.i = str;
        return this;
    }

    y c(String str) {
        this.j = str;
        return this;
    }
}
