package com.mx.http;

import android.os.Handler;
import android.os.Message;

class h extends Handler {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void handleMessage(Message message) {
        i iVar = (i) message.obj;
        switch (message.what) {
            case 1:
                this.a.a(iVar.a());
                return;
            case 2:
                this.a.a(iVar.b(), iVar.c());
                return;
            case 3:
                this.a.a(iVar.e(), iVar.d());
                return;
            case 4:
                this.a.a();
                return;
            case 5:
                this.a.b();
                return;
            case 6:
                this.a.c();
                return;
            default:
                return;
        }
    }
}
