package com.vlocker.weather.a;

import com.vlocker.msg.ao;

class ba implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ aw b;

    ba(aw awVar, String str) {
        this.b = awVar;
        this.a = str;
    }

    public void run() {
        ao.a(this.b.a, this.a, "zs");
    }
}
