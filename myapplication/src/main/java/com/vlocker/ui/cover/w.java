package com.vlocker.ui.cover;

import android.graphics.BitmapFactory;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.msg.p;
import com.vlocker.update.a;

class w implements Runnable {
    final /* synthetic */ LockerService a;

    w(LockerService lockerService) {
        this.a = lockerService;
    }

    public void run() {
        ak akVar = new ak();
        akVar.C = 11;
        akVar.b = "mx_update";
        akVar.c = this.a.getString(R.string.update_msg_title);
        akVar.e = this.a.getString(R.string.update_msg_desc);
        akVar.k = BitmapFactory.decodeResource(this.a.getResources(), R.drawable.msg_update_icon);
        p.a().a(akVar);
        a.c();
    }
}
