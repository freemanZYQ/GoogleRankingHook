package com.vlocker.theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.j;
import com.vlocker.m.aj;
import com.vlocker.security.MoSecurityApplication;

class p implements OnClickListener {
    final /* synthetic */ ThemeDetailActivity a;

    p(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void onClick(View view) {
        if (!j.a(this.a, "com.moxiu.launcher") || aj.b(this.a, "com.moxiu.launcher") <= 454 || MoSecurityApplication.a) {
            com.vlocker.b.p.a(this.a, "Vlocker_Click_LauncherGuide_ThemeDetail_PPC_RR", "location", "viewPage");
            this.a.a(true);
        } else if (aj.b(this.a, "com.moxiu.launcher") < 533) {
            com.vlocker.b.p.a(this.a, "Vlocker_Click_LauncherGuide_ThemeDetail_PPC_RR", "location", "viewPage");
            this.a.a(true);
        }
    }
}
