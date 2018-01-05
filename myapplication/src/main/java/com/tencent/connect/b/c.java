package com.tencent.connect.b;

public class c {
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private long e = -1;

    public c(String str) {
        this.a = str;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(String str, String str2) {
        this.b = str;
        this.e = 0;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public boolean a() {
        return this.b != null && System.currentTimeMillis() < this.e;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }
}
