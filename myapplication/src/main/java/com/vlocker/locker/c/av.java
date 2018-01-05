package com.vlocker.locker.c;

import android.os.CountDownTimer;
import com.vlocker.c.a;
import com.vlocker.locker.R;

class av extends CountDownTimer {
    final /* synthetic */ au a;

    av(au auVar, long j, long j2) {
        this.a = auVar;
        super(j, j2);
    }

    public void onFinish() {
    }

    public void onTick(long j) {
        if (a.a(this.a.a.a).aM() != -1) {
            this.a.a.k();
        }
        int i = ((int) (j / 1000)) - 1;
        if (i > 0) {
            this.a.a.k.setText(i + this.a.a.a.getString(R.string.gesture_password_unlock_failed_tip_again));
            this.a.a.k.setTextColor(this.a.a.n.j());
            return;
        }
        this.a.a.l();
    }
}
