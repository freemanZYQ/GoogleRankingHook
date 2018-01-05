package com.vlocker.locker.c;

import android.content.Intent;
import com.vlocker.m.t;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.weather.a;
import com.vlocker.weather.a.y;

class ba implements t {
    final /* synthetic */ az a;

    ba(az azVar) {
        this.a = azVar;
    }

    public void a() {
        if (!ax.d(this.a.a)) {
            LockerService.a().b();
            LockerService.a().e();
        }
    }

    public void a(Intent intent) {
    }

    public void a(String str) {
    }

    public void b() {
        LockerService.a().a(5);
        a.b = false;
        y.c = false;
        a.c = false;
    }
}
