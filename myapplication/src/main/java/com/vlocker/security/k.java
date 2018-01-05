package com.vlocker.security;

import android.os.Build.VERSION;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.m.o;
import com.vlocker.msg.an;

public class k {
    public static void a() {
        a a = a.a(MoSecurityApplication.a());
        int b = o.b(MoSecurityApplication.a());
        int N = a.N();
        if (N == 0) {
            a.f(b);
            a.g(0);
            a.Y(true);
            a.H(-1);
            a.I(-1);
        } else if (N != b) {
            if (N == 202 && a.aS()) {
                a.O(false);
            }
            if (N <= 308 && a.aM() != -1) {
                a(a);
            }
            if (b == 306 && !a.bv() && an.a(MoSecurityApplication.a()) && VERSION.SDK_INT >= 18) {
                a.ag(false);
                a.ae(false);
            }
            if (b == 353) {
                j.o();
            }
            a.aq(false);
            a.Y(true);
            a.g(N);
            a.f(b);
            a.H(-1);
            a.I(-1);
            a.a(MoSecurityApplication.a()).M(0);
            a.a(MoSecurityApplication.a()).g(0);
        }
    }

    private static void a(a aVar) {
        switch (aVar.aM()) {
            case 1:
                aVar.o(5);
                return;
            case 2:
                aVar.o(6);
                return;
            case 3:
                aVar.o(7);
                return;
            case 4:
                aVar.o(8);
                return;
            case 5:
                aVar.o(3);
                return;
            case 6:
                aVar.o(1);
                return;
            default:
                return;
        }
    }
}
