package com.vlocker.ui.cover;

import com.vlocker.msg.McmPushWidget;
import com.vlocker.setting.j;

class z implements Runnable {
    final /* synthetic */ LockerService a;

    z(LockerService lockerService) {
        this.a = lockerService;
    }

    public void run() {
        if (!j.b(this.a)) {
            if (!this.a.i.bG() && !this.a.i.bz() && this.a.i.bR()) {
                this.a.i.ag(true);
                McmPushWidget.getInstance(this.a).sendRedPacketMsg();
            } else if (!this.a.i.bT()) {
            }
        }
    }
}
