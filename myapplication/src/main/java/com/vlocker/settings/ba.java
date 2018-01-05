package com.vlocker.settings;

import android.os.Handler;
import android.os.Message;
import com.vlocker.locker.R;

class ba extends Handler {
    final /* synthetic */ LockerSettingsActivity a;

    ba(LockerSettingsActivity lockerSettingsActivity) {
        this.a = lockerSettingsActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.k.setTextColor(-1);
                this.a.k.setText(R.string.gesture_password_guide_draw_btn);
                return;
            default:
                return;
        }
    }
}
