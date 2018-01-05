package com.vlocker.weather.a;

import com.moxiu.b.b.a;
import com.vlocker.security.MoSecurityApplication;
import java.util.List;

class o implements a {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public void a(int i, String str) {
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        this.a.c.clear();
        this.a.c.addAll(list);
        com.vlocker.c.a.a(MoSecurityApplication.a()).s(System.currentTimeMillis());
        if (this.a.c != null && this.a.c.size() >= 0) {
            this.a.e.setVisibility(0);
            this.a.a(false);
        }
    }
}
