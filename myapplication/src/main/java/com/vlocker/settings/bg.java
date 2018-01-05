package com.vlocker.settings;

import android.os.CountDownTimer;
import com.vlocker.locker.R;

class bg extends CountDownTimer {
    final /* synthetic */ bf a;

    bg(bf bfVar, long j, long j2) {
        this.a = bfVar;
        super(j, j2);
    }

    public void onFinish() {
    }

    public void onTick(long j) {
        this.a.a.k.setTextColor(-1);
        int i = ((int) (j / 1000)) - 1;
        if (i > 0) {
            this.a.a.k.setText(i + this.a.a.getString(R.string.gesture_password_unlock_failed_tip_again));
            return;
        }
        this.a.a.k.setText(R.string.gesture_password_guide_draw_btn);
        this.a.a.k.setTextColor(-1);
        this.a.a.g.setEnabled(true);
        LockerSettingsActivity.b = 0;
        this.a.a.p = false;
    }
}
