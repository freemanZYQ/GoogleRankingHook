package com.vlocker.locker.c;

import com.vlocker.j.m;
import com.vlocker.msg.p;
import com.vlocker.ui.view.BatteryChargeView;

class k implements m {
    final /* synthetic */ b a;

    k(b bVar) {
        this.a = bVar;
    }

    public void a() {
        this.a.M();
        if (this.a.al != null) {
            this.a.al.b(BatteryChargeView.c);
        }
    }

    public void b() {
        if (BatteryChargeView.c && b.f && !p.a().h()) {
            this.a.b(false);
        }
        if (!p.a().b()) {
            this.a.N();
        }
    }
}
