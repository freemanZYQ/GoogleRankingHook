package com.xinmei365.fontsdk.download;

import java.io.Serializable;

class f implements Serializable {
    private final int B;
    private final int C;
    private final int D;
    private final String E;
    private final String F;
    private volatile int G;
    private volatile int H;

    public f(int i, int i2, int i3, int i4, String str, int i5, String str2) {
        this.B = i;
        this.C = i2;
        this.D = i3;
        this.G = i4;
        this.E = str;
        this.H = i5;
        this.F = str2;
    }

    public void a(int i) {
        this.G = i;
    }

    public void b(int i) {
        this.H = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.B == fVar.B && this.E.equals(fVar.E) && this.F.equals(fVar.F);
    }

    public int getStartPosition() {
        return this.C;
    }

    public int getThreadId() {
        return this.B;
    }

    public String getUrl() {
        return this.E;
    }

    public int hashCode() {
        return (((this.B * 31) + this.E.hashCode()) * 31) + this.F.hashCode();
    }

    public int j() {
        return this.D;
    }

    public int k() {
        return this.G;
    }

    public int l() {
        return this.H;
    }

    public String m() {
        return this.F;
    }
}
