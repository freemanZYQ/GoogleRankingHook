package com.vlocker.k;

import android.app.Notification;
import android.content.Context;
import com.vlocker.msg.p;

class h implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Notification b;
    final /* synthetic */ int c;
    final /* synthetic */ e d;

    h(e eVar, Context context, Notification notification, int i) {
        this.d = eVar;
        this.a = context;
        this.b = notification;
        this.c = i;
    }

    public void run() {
        p.a().a(a.a(this.a).a(this.b, this.c));
    }
}
