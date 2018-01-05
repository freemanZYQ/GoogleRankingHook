package com.vlocker.ui.cover;

class ab implements Runnable {
    final /* synthetic */ LockerService a;

    ab(LockerService lockerService) {
        this.a = lockerService;
    }

    public void run() {
        if (this.a.q != null && this.a.i.cg() && g.a) {
            this.a.q.a(this.a.u.G());
        }
    }
}
