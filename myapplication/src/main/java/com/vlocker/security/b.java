package com.vlocker.security;

import com.vlocker.setting.a.e;

class b implements e {
    final /* synthetic */ MoSecurityApplication a;

    b(MoSecurityApplication moSecurityApplication) {
        this.a = moSecurityApplication;
    }

    public void onResult(boolean z) {
        MoSecurityApplication.c = z;
    }
}
