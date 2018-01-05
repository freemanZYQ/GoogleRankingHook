package com.tencent.open.d;

public class v {
    public String a;
    public long b;
    public long c;

    public v(String str, int i) {
        this.a = str;
        this.b = (long) i;
        if (this.a != null) {
            this.c = (long) this.a.length();
        }
    }
}
