package com.vlocker.ui.widget.view;

import android.os.Handler;
import android.os.Message;

class b extends Handler {
    final /* synthetic */ LockNumberCoverView a;

    b(LockNumberCoverView lockNumberCoverView) {
        this.a = lockNumberCoverView;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.t();
                return;
            default:
                return;
        }
    }
}
