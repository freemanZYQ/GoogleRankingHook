package com.vlocker.settings;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.m.a.b;

class bw implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ PasswordSettingsActivity b;

    bw(PasswordSettingsActivity passwordSettingsActivity, Dialog dialog) {
        this.b = passwordSettingsActivity;
        this.a = dialog;
    }

    public void onClick(View view) {
        p.a(this.b, "Vlock_ToClose_SystemPw_PPC_TF", "location", "password_popup");
        b.a(this.b).a(1);
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
