package com.vlocker.k;

import com.vlocker.ui.cover.LockerService;

class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void run() {
        LockerService.a().a(new m(this), 2);
    }
}
