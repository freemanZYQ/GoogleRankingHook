package com.vlocker.search;

import android.os.Handler;
import android.os.Message;

class e extends Handler {
    final /* synthetic */ BaiduSearchActivity a;

    e(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                String str = (String) message.obj;
                this.a.e.setVisibility(8);
                this.a.d.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
