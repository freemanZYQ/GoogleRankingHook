package com.vlocker.ui.widget.view;

import android.os.CountDownTimer;
import com.vlocker.locker.R;
import com.vlocker.ui.cover.f;

class j extends CountDownTimer {
    final /* synthetic */ i a;

    j(i iVar, long j, long j2) {
        this.a = iVar;
        super(j, j2);
    }

    public void onFinish() {
        if (f.i) {
            this.a.a.u();
        }
    }

    public void onTick(long j) {
        this.a.a.setTextColor(this.a.a.v);
        f.i = true;
        int i = ((int) (j / 1000)) - 1;
        if (i <= 0) {
            this.a.a.v.setText(this.a.a.l.getString(R.string.input_password_txt));
            this.a.a.u();
        } else if (i > 60) {
            this.a.a.v.setText((i / 60) + "分" + (i % 60) + this.a.a.l.getString(R.string.gesture_password_unlock_failed_tip_again));
        } else {
            this.a.a.v.setText(i + this.a.a.l.getString(R.string.gesture_password_unlock_failed_tip_again));
        }
    }
}
