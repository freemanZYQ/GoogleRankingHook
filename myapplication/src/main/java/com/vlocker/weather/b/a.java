package com.vlocker.weather.b;

public class a {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return (this.d == null || this.d.length() <= 0) ? (this.c == null || this.c.length() <= 0) ? (this.b == null || this.b.length() <= 0) ? (this.a == null || this.a.length() <= 0) ? "" : this.a : this.b : (this.c == null || this.c.indexOf(",") == -1) ? this.c : this.c.substring(0, this.c.indexOf(",")) : this.d;
    }

    public String f() {
        String str = "";
        if (this.d != null && this.d.length() > 0) {
            str = str + this.d + ", ";
        }
        if (this.c != null && this.c.length() > 0) {
            str = str + this.c + ", ";
        }
        return str.endsWith(", ") ? str.substring(0, str.length() - 2) : str;
    }

    public String g() {
        return this.f;
    }
}
