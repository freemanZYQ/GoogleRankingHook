package com.vlocker.locker.c;

import com.vlocker.b.j;
import com.vlocker.b.p;

class d implements Runnable {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if ("moxiu-launcher".equals(j.p(this.a.a))) {
            p.a(this.a.a, "Vlocker_Automini_Charge_PPC_RR", new String[0]);
        }
        this.a.b(true);
    }
}
