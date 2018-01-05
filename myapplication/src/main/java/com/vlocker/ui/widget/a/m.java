package com.vlocker.ui.widget.a;

import android.graphics.Color;

public class m extends q {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int r = -1;
    public String s;

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
        if (str != null) {
            try {
                this.r = Color.parseColor(str);
            } catch (Exception e) {
            }
        }
    }

    public void r(String str) {
        this.s = str;
    }
}
