package com.moxiu.sdk.a.a;

public abstract class d {
    protected volatile transient int a = -1;

    public static final void a(d dVar, byte[] bArr, int i, int i2) {
        try {
            a a = a.a(bArr, i, i2);
            dVar.a(a);
            a.b();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] a(d dVar) {
        byte[] bArr = new byte[dVar.b()];
        a(dVar, bArr, 0, bArr.length);
        return bArr;
    }

    public int a() {
        if (this.a < 0) {
            b();
        }
        return this.a;
    }

    public void a(a aVar) {
    }

    public int b() {
        int c = c();
        this.a = c;
        return c;
    }

    protected int c() {
        return 0;
    }

    public /* synthetic */ Object clone() {
        return d();
    }

    public d d() {
        return (d) super.clone();
    }

    public String toString() {
        return e.a(this);
    }
}
