package com.vlocker.weather.a;

import android.view.View;
import com.moxiu.b.a.a;

class p implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ a b;
    final /* synthetic */ m c;

    p(m mVar, View view, a aVar) {
        this.c = mVar;
        this.a = view;
        this.b = aVar;
    }

    public void run() {
        this.c.b(this.a, this.b);
        com.vlocker.b.p.a(this.c.d, "Vlock_Click_WService_PPC_TF", "service_name", this.b.h());
    }
}
