package com.vlocker.ui.view;

import android.os.Handler;
import android.os.Message;

class aq extends Handler {
    final /* synthetic */ WaveAnimView a;

    aq(WaveAnimView waveAnimView) {
        this.a = waveAnimView;
    }

    public void handleMessage(Message message) {
        this.a.l.cancel();
        this.a.l.start();
    }
}
