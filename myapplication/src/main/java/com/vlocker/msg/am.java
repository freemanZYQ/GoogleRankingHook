package com.vlocker.msg;

import com.vlocker.j.p;

public class am {
    private static am a;
    private p b = p.a();

    private am() {
    }

    public static am a() {
        if (a == null) {
            synchronized (am.class) {
                if (a == null) {
                    a = new am();
                }
            }
        }
        return a;
    }

    public boolean a(String str) {
        return this.b.a(str);
    }
}
