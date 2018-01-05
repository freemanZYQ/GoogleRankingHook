package com.inveno.se.d;

public class f implements x {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public f() {
        this(3500, 2, 1.0f);
    }

    public f(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    public int a() {
        return this.a;
    }

    public void a(aa aaVar) {
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * this.d));
        if (!c()) {
            throw aaVar;
        }
    }

    public int b() {
        return this.b;
    }

    protected boolean c() {
        return this.b <= this.c;
    }
}
