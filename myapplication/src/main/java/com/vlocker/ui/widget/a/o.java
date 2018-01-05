package com.vlocker.ui.widget.a;

import android.graphics.Color;

public class o extends q {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String r;
    public String s;
    public int t = -1;
    public int u = 0;
    public String v;
    public int w = -1;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void q(String str) {
        this.r = str;
    }

    public void r(String str) {
        this.s = str;
    }

    public void s(String str) {
        if (str != null) {
            try {
                this.t = Color.parseColor(str);
            } catch (Exception e) {
            }
        }
    }

    public void t(String str) {
        if (str != null) {
            this.u = Integer.parseInt(str);
        }
    }

    public void u(String str) {
        this.v = str;
    }

    public void v(String str) {
        if (str != null) {
            try {
                this.w = Color.parseColor(str);
            } catch (Exception e) {
            }
        }
    }
}
