package com.tencent.connect.common;

import android.os.Handler;
import android.os.Message;

class a extends Handler {
    final /* synthetic */ AssistActivity a;

    a(AssistActivity assistActivity) {
        this.a = assistActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (!this.a.isFinishing()) {
                    this.a.finish();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
