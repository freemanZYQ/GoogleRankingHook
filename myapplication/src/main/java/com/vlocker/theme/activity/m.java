package com.vlocker.theme.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.m.aj;
import com.vlocker.security.MoSecurityApplication;

class m implements OnCheckedChangeListener {
    final /* synthetic */ ThemeDetailActivity a;

    m(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (!j.a(this.a, "com.moxiu.launcher") || aj.b(this.a, "com.moxiu.launcher") <= 454 || MoSecurityApplication.a) {
                p.a(this.a, "Vlocker_Click_LauncherGuide_ThemeDetail_PPC_RR", "location", "redPoint");
                this.a.a(false);
                compoundButton.setChecked(false);
            } else if (aj.b(this.a, "com.moxiu.launcher") < 533) {
                p.a(this.a, "Vlocker_Click_LauncherGuide_ThemeDetail_PPC_RR", "location", "redPoint");
                this.a.a(false);
                compoundButton.setChecked(false);
            } else {
                compoundButton.setChecked(true);
            }
        }
        if (this.a.m.isChecked() || this.a.n.isChecked()) {
            this.a.d.setProgress(100);
        } else {
            this.a.d.setProgress(0);
        }
    }
}
