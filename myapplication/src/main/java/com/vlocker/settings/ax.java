package com.vlocker.settings;

import com.vlocker.locker.R;
import com.vlocker.m.aa;

class ax implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ LockNumberActivityNew b;

    ax(LockNumberActivityNew lockNumberActivityNew, boolean z) {
        this.b = lockNumberActivityNew;
        this.a = z;
    }

    public void run() {
        this.b.e.setTextColor(-65536);
        if (this.a) {
            this.b.e.setText(R.string.input_password_txt_toast);
            aa.a(this.b);
            return;
        }
        this.b.e.setText(R.string.lockpattern_need_to_unlock_wrong);
        aa.a(this.b);
    }
}
