package com.tencent.open.d;

import android.os.Bundle;

class n extends Thread {
    final /* synthetic */ Bundle a;
    final /* synthetic */ m b;

    n(m mVar, Bundle bundle) {
        this.b = mVar;
        this.a = bundle;
    }

    public void run() {
        try {
            this.b.a(u.c(f.a(this.b.c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.a).a));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b.g = 0;
    }
}
