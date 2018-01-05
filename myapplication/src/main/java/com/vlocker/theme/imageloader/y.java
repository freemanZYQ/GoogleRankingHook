package com.vlocker.theme.imageloader;

import com.vlocker.security.MoSecurityApplication;

public class y {
    private static y a;
    private u b;
    private u c;

    private y() {
    }

    public static y a() {
        if (a == null) {
            a = new y();
        }
        return a;
    }

    private void a(u uVar) {
        if (uVar != null) {
            uVar.h();
            uVar.i();
        }
    }

    private u b() {
        u uVar = new u(MoSecurityApplication.a());
        t tVar = new t(MoSecurityApplication.a());
        tVar.a(0.125f);
        uVar.a(tVar);
        return uVar;
    }

    public u a(int i) {
        switch (i) {
            case 1:
                if (this.b == null) {
                    this.b = b();
                }
                return this.b;
            case 2:
                if (this.c == null) {
                    this.c = b();
                }
                return this.c;
            default:
                return null;
        }
    }

    public void b(int i) {
        switch (i) {
            case 1:
                a(this.b);
                this.b = null;
                return;
            case 2:
                a(this.c);
                this.c = null;
                return;
            default:
                return;
        }
    }
}
