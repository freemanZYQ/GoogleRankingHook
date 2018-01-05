package com.vlocker.theme.model.a;

import java.util.ArrayList;
import java.util.List;

public class b {
    public static b a = new b();
    private static List c;
    public boolean b = false;
    private int d = 0;

    private b() {
        c();
        b();
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private boolean c() {
        c = new ArrayList();
        return c != null;
    }

    public d a(String str) {
        int i = 0;
        while (i < c.size()) {
            try {
                if (((d) c.get(i)).a(str)) {
                    return (d) c.get(i);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(d dVar) {
        if (c != null) {
            c.add(dVar);
        }
    }

    public void b() {
    }

    public void b(d dVar) {
        if (c != null) {
            c.remove(dVar);
        }
    }
}
