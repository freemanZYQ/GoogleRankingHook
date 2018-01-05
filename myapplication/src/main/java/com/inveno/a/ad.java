package com.inveno.a;

class ad {
    private String a;
    private long b;
    private long c;

    ad(String str, long j) {
        this.a = str;
        this.b = j;
    }

    ac a() {
        return new ac(this.a, this.b, this.c);
    }

    ad a(long j) {
        this.c = j;
        return this;
    }
}
