package com.vlocker.notification.msg.open;

import com.vlocker.weather.e.d;

class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ FlowWebViewActivity c;

    f(FlowWebViewActivity flowWebViewActivity, String str, String str2) {
        this.c = flowWebViewActivity;
        this.a = str;
        this.b = str2;
    }

    public void run() {
        if (this.c.n) {
            this.c.n = false;
            if (!this.c.o || this.c.p) {
                d.a(this.c, this.a, this.b, false);
            } else {
                d.a(this.c, this.a, this.b, true);
            }
        }
    }
}
