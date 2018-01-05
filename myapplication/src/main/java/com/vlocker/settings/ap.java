package com.vlocker.settings;

import android.os.Handler;
import android.os.Message;

class ap extends Handler {
    final /* synthetic */ GuideWebViewActivity a;

    ap(GuideWebViewActivity guideWebViewActivity) {
        this.a = guideWebViewActivity;
    }

    public void handleMessage(Message message) {
        if (!Thread.currentThread().isInterrupted()) {
            switch (message.what) {
                case 0:
                    try {
                        this.a.e.show();
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case 1:
                    this.a.e.hide();
                    break;
            }
        }
        super.handleMessage(message);
    }
}
