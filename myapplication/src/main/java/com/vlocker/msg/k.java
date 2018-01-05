package com.vlocker.msg;

import android.os.Handler;
import android.os.Message;
import com.vlocker.b.p;
import com.vlocker.ui.cover.g;

class k extends Handler {
    final /* synthetic */ McmPushWidget a;

    k(McmPushWidget mcmPushWidget) {
        this.a = mcmPushWidget;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        ak akVar = (ak) message.obj;
        if (message.what != 8) {
            if (!(akVar == null || akVar.m == null)) {
                p.e(this.a.context, "url|" + akVar.c + "|" + akVar.m.getStringExtra("url"), "yesad".equals(akVar.m.getStringExtra("adtype")) ? "AA_SELFRUN_Y" : "AA_SELFRUN_N", "");
            }
            this.a.shwoNotify(this.a.context, akVar, message.what);
            p.a().a(akVar);
        } else if (!g.a()) {
            p.a().a(akVar);
        }
    }
}
