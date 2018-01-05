package com.vlocker.locker.b;

import android.content.Context;
import com.vlocker.m.y;
import com.vlocker.ui.cover.LockerService;

class at implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ ap c;

    at(ap apVar, Context context, String str) {
        this.c = apVar;
        this.a = context;
        this.b = str;
    }

    public void run() {
        ap.f = null;
        this.c.h.d(true);
        this.c.h.e(0);
        if (ap.j) {
            this.c.h.e(true);
        }
        this.c.h.i(1);
        y.e(this.a, this.b);
        try {
            y.g(this.a, this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LockerService.d(this.a);
        ap.c = false;
    }
}
