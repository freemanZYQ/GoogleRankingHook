package com.vlocker.weather.c.c;

import java.util.List;

public abstract class b {
    private int a;
    private boolean b;

    public void a(int i) {
        this.a = i;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract List e();

    public abstract String f();

    public boolean g() {
        return this.b;
    }

    public int h() {
        return this.a;
    }

    public boolean i() {
        return this.a == 4 || this.a == 3;
    }
}
