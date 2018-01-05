package com.vlocker.g;

import android.os.Handler;
import com.vlocker.b.j;
import com.vlocker.m.aj;
import com.vlocker.ui.cover.LockerService;

public class l extends t {
    private Handler c = new Handler();

    public l(a aVar) {
        super(aVar);
    }

    public void a() {
        if (this.b.s != null) {
            b();
        } else {
            b.a().f();
        }
    }

    public void a(int i, Runnable runnable) {
        runnable.run();
        this.c.postDelayed(new o(this, i), 20);
    }

    public void b() {
        super.b();
        Runnable uVar = new u(this.a, this.b, new m(this));
        String str = "com.taobao.taobao";
        if ("taobao".equals(this.b.s.getStringExtra("sub_type")) && j.b(this.a, str) && aj.b(this.a, str) >= 123) {
            LockerService.a().a(uVar, 2);
        } else if ("Webview".equals(this.b.f)) {
            a(5, uVar);
        } else {
            LockerService.a().a(uVar, 2);
        }
    }
}
