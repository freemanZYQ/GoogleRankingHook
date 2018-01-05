package com.vlocker.k;

import android.app.Notification;
import android.content.Intent;
import com.vlocker.m.t;
import com.vlocker.ui.cover.LockerService;

class c implements t {
    final /* synthetic */ Notification a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ a d;

    c(a aVar, Notification notification, String str, int i) {
        this.d = aVar;
        this.a = notification;
        this.b = str;
        this.c = i;
    }

    public void a() {
        LockerService.a().b();
    }

    public void a(Intent intent) {
        e.a().b();
        LockerService.a().b();
    }

    public void a(String str) {
    }

    public void b() {
        this.d.c(this.a, this.b, this.c);
    }
}
