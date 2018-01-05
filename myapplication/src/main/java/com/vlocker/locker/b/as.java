package com.vlocker.locker.b;

import android.os.Handler;
import android.os.Message;
import com.vlocker.m.y;
import com.vlocker.theme.f.c;
import com.vlocker.ui.cover.LockerService;
import com.xinmei365.fontsdk.FontCenter;

class as extends Handler {
    final /* synthetic */ ap a;

    as(ap apVar) {
        this.a = apVar;
    }

    public void handleMessage(Message message) {
        this.a.h.e(y.a);
        this.a.h.d(y.c);
        this.a.h.c(y.b);
        this.a.h.d(y.d);
        this.a.h.R("");
        this.a.h.aj(-1);
        this.a.h.Q("");
        this.a.h.aU(false);
        this.a.h.aV(false);
        String h = c.h(this.a.e, y.c);
        if (h == null) {
            this.a.h.aa(-1);
        } else if ("true".equals(h)) {
            this.a.h.aa(1);
        } else if ("false".equals(h)) {
            this.a.h.aa(0);
        }
        this.a.h.aG(false);
        this.a.h.X(-1);
        this.a.h.aH(false);
        this.a.h.R(false);
        if (ap.f != null) {
            ap.f = null;
        }
        switch (message.what) {
            case 1:
                this.a.h.w(true);
                this.a.h.i(0);
                this.a.h.b(0);
                int g = y.g(FontCenter.context);
                if (g != 0) {
                    this.a.h.aV(true);
                    this.a.h.aj(g);
                }
                this.a.h.e(true);
                this.a.h.d(false);
                this.a.h.E(true);
                LockerService.d(this.a.e);
                break;
            case 3:
                this.a.a(this.a.e, y.c);
                break;
        }
        super.handleMessage(message);
    }
}
