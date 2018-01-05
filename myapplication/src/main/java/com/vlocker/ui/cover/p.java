package com.vlocker.ui.cover;

import java.lang.reflect.Array;

public class p {
    static p[][] c = ((p[][]) Array.newInstance(p.class, new int[]{3, 3}));
    int a;
    int b;

    static {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                c[i][i2] = new p(i, i2);
            }
        }
    }

    private p(int i, int i2) {
        b(i, i2);
        this.a = i;
        this.b = i2;
    }

    public static synchronized p a(int i, int i2) {
        p pVar;
        synchronized (p.class) {
            b(i, i2);
            pVar = c[i][i2];
        }
        return pVar;
    }

    private static void b(int i, int i2) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("row must be in range 0-2");
        } else if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("column must be in range 0-2");
        }
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "(row=" + this.a + ",clmn=" + this.b + ")";
    }
}
