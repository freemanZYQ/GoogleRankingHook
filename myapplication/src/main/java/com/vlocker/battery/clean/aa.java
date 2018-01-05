package com.vlocker.battery.clean;

import com.vlocker.msg.ak;
import com.vlocker.msg.p;

class aa implements Runnable {
    final /* synthetic */ y a;

    aa(y yVar) {
        this.a = yVar;
    }

    public void run() {
        ak akVar = new ak();
        akVar.C = 10;
        akVar.b = "mx_clean";
        akVar.E = true;
        p.a().a(akVar);
    }
}
