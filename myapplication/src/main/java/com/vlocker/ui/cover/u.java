package com.vlocker.ui.cover;

class u implements ah {
    final /* synthetic */ LockerService a;

    u(LockerService lockerService) {
        this.a = lockerService;
    }

    public void a() {
        this.a.r = true;
        this.a.h();
        try {
            this.a.p.postDelayed(new v(this), 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        this.a.r = false;
        this.a.h();
    }
}
