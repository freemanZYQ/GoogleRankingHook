package com.vlocker.msg;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.vlocker.setting.a.a.e;
import com.vlocker.ui.cover.g;

class u extends Handler {
    final /* synthetic */ p a;

    u(p pVar) {
        this.a = pVar;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (5 == i) {
            String[] strArr = message.obj != null ? (String[]) message.obj : null;
            if (this.a.g != null && strArr != null) {
                this.a.g.a(strArr);
                return;
            }
            return;
        }
        String str = "";
        if (!(i == 6 || i == 8)) {
            str = message.obj != null ? (String) message.obj : "";
        }
        switch (i) {
            case 1:
                this.a.d(str);
                return;
            case 2:
                this.a.o();
                return;
            case 3:
                if (this.a.g != null) {
                    this.a.g.a(str, message.arg1);
                    return;
                }
                return;
            case 4:
                if (this.a.g != null) {
                    this.a.g.a();
                    return;
                }
                return;
            case 6:
                Log.e("liu---", "HANDLER_OPEN_NOTIFICATION_ACTION pkgName=" + str);
                ak akVar = (ak) message.obj;
                Runnable lVar = new l(this.a.f, akVar, this.a.e, e.ACTION_NOTIFICATION_LISTENER_SETTINGS);
                if (!g.a) {
                    lVar.run();
                    return;
                } else if (this.a.h != null) {
                    this.a.h.a(lVar, akVar);
                    return;
                } else {
                    return;
                }
            case 7:
                if (this.a.g != null) {
                    this.a.g.a((String) message.obj);
                    return;
                }
                return;
            case 8:
                if (this.a.g != null) {
                    this.a.g.a((ak) message.obj);
                    return;
                }
                return;
            case 9:
                if (this.a.g != null) {
                    this.a.g.b();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
