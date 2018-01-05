package com.vlocker.j;

import com.vlocker.j.a.b;
import com.vlocker.j.a.e;

class c extends Thread {
    final /* synthetic */ n a;
    final /* synthetic */ a b;

    c(a aVar, n nVar) {
        this.b = aVar;
        this.a = nVar;
    }

    public void run() {
        try {
            String c = b.c(this.a.a, this.b.b(this.a.d));
            if (c != null && !"".equals(c)) {
                this.b.I = b.a(c, e.a(this.a.a));
                if (this.b.I.size() > 0) {
                    this.b.H = 1;
                    this.b.t.a(this.b.I);
                }
            } else if (this.b.H < 3) {
                this.b.p.postDelayed(this.b.J, this.b.H == 1 ? 3000 : 6000);
            } else {
                this.b.H = 1;
                this.b.t.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.b.t.a();
        }
    }
}
