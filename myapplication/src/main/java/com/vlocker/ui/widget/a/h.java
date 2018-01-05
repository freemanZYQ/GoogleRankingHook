package com.vlocker.ui.widget.a;

import android.graphics.Color;

public class h extends d {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e = -1;
    public boolean r = false;
    public int s;
    public int t;
    public int u;
    public int v;

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
        if (str != null) {
            this.e = Color.parseColor(str);
        }
    }

    public void q(String str) {
        if ("true".equals(str)) {
            this.r = true;
        } else {
            this.r = false;
        }
    }

    public void r(String str) {
        if (str != null) {
            this.u = Integer.parseInt(str);
        }
    }

    public void s(String str) {
        if (str != null) {
            this.v = Integer.parseInt(str);
        }
    }

    public void t(String str) {
        if (str != null) {
            this.s = Integer.parseInt(str);
        }
    }

    public void u(String str) {
        if (str != null) {
            this.t = Integer.parseInt(str);
        }
    }
}
