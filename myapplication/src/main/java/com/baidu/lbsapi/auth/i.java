package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class i extends Handler {
    final /* synthetic */ LBSAuthManager a;

    i(LBSAuthManager lBSAuthManager, Looper looper) {
        this.a = lBSAuthManager;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (a.a) {
            a.a("handleMessage !!");
        }
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) LBSAuthManager.g.get(message.getData().getString("listenerKey"));
        if (a.a) {
            a.a("handleMessage listener = " + lBSAuthManagerListener);
        }
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}
