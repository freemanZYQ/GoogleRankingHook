package com.vlocker.k;

import android.app.Notification;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import com.vlocker.m.aa;
import com.vlocker.m.ap;
import com.vlocker.m.t;
import com.vlocker.msg.p;
import com.vlocker.ui.cover.LockerService;

class b implements t {
    final /* synthetic */ Notification a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ a d;

    b(a aVar, Notification notification, String str, int i) {
        this.d = aVar;
        this.a = notification;
        this.b = str;
        this.c = i;
    }

    public void a() {
        LockerService.a().b();
    }

    public void a(Intent intent) {
        if (!"share".equals(intent.getStringExtra("from"))) {
            e.a().b();
            LockerService.a().b();
        } else if (intent.getBooleanExtra("hasPwd", false)) {
            LockerService.a().b();
            k.a().c();
        } else {
            k.a().d();
        }
    }

    public void a(String str) {
        if (!this.d.g && str.contains("com.tencent.mm.plugin.luckymoney.ui.luckymoneydetailui")) {
            this.d.g = true;
            this.d.e.D(this.d.e.bC() + 1);
            k.a().a(true, System.currentTimeMillis() - this.d.b);
        }
    }

    public void b() {
        try {
            this.a.contentIntent.send();
            if (this.d.e.bx()) {
                aa.a(this.d.d);
            }
            if (this.d.e.bw()) {
                ap.a(this.d.d).a("red_packet_voice_" + (this.d.e.by() + 1) + ".mp3");
            }
            p.a().a(this.b);
            LockerService.a().a(2);
            e.a().a(this.a, this.c);
        } catch (CanceledException e) {
            e.printStackTrace();
        }
    }
}
