package com.vlocker.setting;

import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.ui.a;
import com.vlocker.theme.f.b;

class w implements Runnable {
    final /* synthetic */ s a;

    w(s sVar) {
        this.a = sVar;
    }

    public void run() {
        a.b(this.a.i, this.a.f);
        if ((!b.e() && MoSecurityApplication.e) || b.G()) {
            Toast.makeText(MoSecurityApplication.a().getApplicationContext(), R.string.one_key_setting_finish_toast, 1).show();
        }
    }
}
