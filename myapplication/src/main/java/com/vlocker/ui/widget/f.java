package com.vlocker.ui.widget;

import android.os.Handler;
import android.os.Message;

class f extends Handler {
    final /* synthetic */ MusicLrcView a;

    f(MusicLrcView musicLrcView) {
        this.a = musicLrcView;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.i.clear();
                this.a.i.addAll(this.a.j);
                this.a.C.notifyDataSetInvalidated();
                this.a.C.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }
}
