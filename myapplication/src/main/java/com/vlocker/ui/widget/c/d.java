package com.vlocker.ui.widget.c;

import android.text.TextUtils;
import com.vlocker.ui.widget.a.h;
import com.vlocker.ui.widget.a.j;
import com.vlocker.ui.widget.a.k;
import com.vlocker.ui.widget.a.n;
import com.vlocker.ui.widget.a.o;
import com.vlocker.ui.widget.a.r;
import java.util.ArrayList;
import java.util.List;

public class d {
    public static float a = 1.0f;
    public static float b = 1.0f;
    public static float c = 1.0f;
    public static int s = 200;
    public static int t = 50;
    public n A;
    public k B;
    private List C;
    private List D;
    String d;
    public String e;
    public String f;
    String g;
    int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public String o;
    public int[] p;
    public String[] q;
    public float r;
    public r u;
    public h v;
    public o w;
    public ArrayList x;
    public ArrayList y;
    public j z;

    public d() {
        this.h = 1;
        this.C = null;
        this.D = new ArrayList();
        this.p = null;
        this.q = null;
        this.r = 1.0f;
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.C = new ArrayList();
    }

    public int a() {
        return this.h;
    }

    public void a(com.vlocker.ui.widget.a.d dVar) {
        this.D.add(dVar);
    }

    public void a(String str) {
        this.e = str;
    }

    public int b() {
        return this.i;
    }

    public void b(com.vlocker.ui.widget.a.d dVar) {
        this.C.add(dVar);
    }

    public void b(String str) {
        this.f = str;
    }

    public int c() {
        return this.j;
    }

    public void c(String str) {
        this.d = str;
    }

    public List d() {
        return this.D;
    }

    public void d(String str) {
        this.g = str;
    }

    public List e() {
        return this.C;
    }

    public void e(String str) {
        if (str != null) {
            this.h = Integer.parseInt(str);
        }
    }

    public int f() {
        return this.k;
    }

    public void f(String str) {
        if (str != null) {
            this.i = Integer.parseInt(str);
        }
    }

    public int g() {
        return this.l;
    }

    public void g(String str) {
        if (str != null) {
            this.j = Integer.parseInt(str);
        }
    }

    public void h(String str) {
        if (str != null) {
            this.l = Integer.parseInt(str);
        }
    }

    public void i(String str) {
        if (str != null) {
            this.k = Integer.parseInt(str);
        }
    }

    public void j(String str) {
        if (str != null) {
            this.m = Float.parseFloat(str);
        }
    }

    public void k(String str) {
        if (str != null) {
            this.n = Float.parseFloat(str);
        }
    }

    public void l(String str) {
        this.o = str;
    }

    public void m(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                this.p = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    this.p[i] = Integer.parseInt(split[i]);
                }
            }
        }
        if (this.p != null && this.p.length == 4) {
            this.m = (float) this.p[0];
            this.n = (float) this.p[1];
            this.i = this.p[2] - this.p[0];
            this.j = this.p[3] - this.p[1];
            s = (int) this.m;
            t = (int) this.n;
        }
    }

    public void n(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                this.q = new String[split.length];
                for (int i = 0; i < split.length; i++) {
                    this.q[i] = split[i];
                }
            }
        }
    }

    public void o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.r = Float.parseFloat(str);
        }
    }
}
