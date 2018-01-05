package com.vlocker.ui.widget.view;

import com.vlocker.locker.R;

class c implements Runnable {
    final /* synthetic */ LockNumberCoverView a;

    c(LockNumberCoverView lockNumberCoverView) {
        this.a = lockNumberCoverView;
    }

    public void run() {
        this.a.v.setText(R.string.input_password_txt);
    }
}
