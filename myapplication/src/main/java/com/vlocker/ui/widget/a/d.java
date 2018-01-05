package com.vlocker.ui.widget.a;

public abstract class d {
    public float f;
    public float g;
    public byte h;
    public String i;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n = 1;
    public int[] o = null;
    public float p = 1.0f;
    public boolean q = false;

    public void a(byte b) {
        this.h = b;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.i = str;
    }

    public void h(String str) {
        if (str != null) {
            this.f = Float.parseFloat(str);
        }
    }

    public void i(String str) {
        if (str != null) {
            this.g = Float.parseFloat(str);
        }
    }

    public void j(String str) {
        if (str != null) {
            this.k = Integer.parseInt(str);
        }
    }

    public void k(String str) {
        if (str != null) {
            this.l = Integer.parseInt(str);
        }
    }

    public void l(String str) {
        if (str == null) {
            return;
        }
        if ("center".equals(str)) {
            this.m = 0;
        } else if ("right".equals(str)) {
            this.m = 1;
        } else if ("left".equals(str)) {
            this.m = 2;
        } else {
            this.m = Integer.parseInt(str);
        }
    }

    public void m(String str) {
        if (str == null) {
            return;
        }
        if ("center".equals(str)) {
            this.n = 0;
        } else if ("top".equals(str)) {
            this.n = 1;
        } else if ("bottom".equals(str)) {
            this.n = 2;
        } else {
            this.n = Integer.parseInt(str);
        }
    }

    public void n(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                this.o = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    this.o[i] = Integer.parseInt(split[i]);
                }
            }
        }
        if (this.o != null && this.o.length == 4) {
            int i2 = this.o[1] - com.vlocker.ui.widget.c.d.t;
            int i3 = this.o[3] - this.o[1];
            this.f = (float) ((this.o[0] - com.vlocker.ui.widget.c.d.s) + ((this.o[2] - this.o[0]) / 2));
            this.g = (float) (i2 + i3);
        }
    }

    public void o(String str) {
        if (str != null) {
            this.p = Float.parseFloat(str);
        }
    }

    public void p(String str) {
        if (str != null) {
            this.q = Boolean.parseBoolean(str);
        }
    }
}
