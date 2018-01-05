package com.baidu.location.h;

import java.util.Locale;

public class i {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    private boolean j;

    public i() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0;
        this.h = -1;
        this.i = '\u0000';
        this.j = false;
        this.g = System.currentTimeMillis();
    }

    public i(int i, int i2, int i3, int i4, int i5, char c) {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0;
        this.h = -1;
        this.i = '\u0000';
        this.j = false;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.h = i5;
        this.i = c;
        this.g = System.currentTimeMillis();
    }

    public i(i iVar) {
        this(iVar.a, iVar.b, iVar.c, iVar.d, iVar.h, iVar.i);
    }

    public int a() {
        return (this.c <= 0 || !c()) ? 2 : (this.c == 460 || this.c == 454 || this.c == 455 || this.c == 466) ? 1 : 0;
    }

    public boolean a(i iVar) {
        return this.a == iVar.a && this.b == iVar.b && this.d == iVar.d && this.c == iVar.c;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.g < 3000;
    }

    public boolean c() {
        return this.a > -1 && this.b > 0;
    }

    public boolean d() {
        return this.a == -1 && this.b == -1 && this.d == -1 && this.c == -1;
    }

    public boolean e() {
        return this.a > -1 && this.b > -1 && this.d == -1 && this.c == -1;
    }

    public boolean f() {
        return this.a > -1 && this.b > -1 && this.d > -1 && this.c > -1;
    }

    public void g() {
        this.j = true;
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.c + 203);
        return stringBuffer.toString();
    }

    public String i() {
        if (!c()) {
            return null;
        }
        return String.format(Locale.CHINA, "<cell-tower>\n<mcc>%d</mcc><mnc>%d</mnc><lac>%d</lac><ci>%d</ci><rssi>%d</rssi></cell-tower>", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.h)});
    }

    public String j() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.h)}));
        if (this.j) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }
}
