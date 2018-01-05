package com.vlocker.locker.c;

import android.os.Handler;
import android.os.Message;
import com.vlocker.locker.R;

class at extends Handler {
    final /* synthetic */ ao a;

    at(ao aoVar) {
        this.a = aoVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.k.setTextColor(this.a.n.j());
                this.a.k.setText(R.string.gesture_password_guide_draw_btn);
                return;
            default:
                return;
        }
    }
}
