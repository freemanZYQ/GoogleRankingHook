package com.vlocker.settings;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.m.a.b;

class ck implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ SettingsActivity b;

    ck(SettingsActivity settingsActivity, Dialog dialog) {
        this.b = settingsActivity;
        this.a = dialog;
    }

    public void onClick(View view) {
        p.a(this.b, "Vlock_ToClose_SystemPw_PPC_TF", "location", "home_popup");
        b.a(this.b).a(1);
        this.b.k = true;
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
