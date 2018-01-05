package com.vlocker.setting;

import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.a.e;

class m implements e {
    final /* synthetic */ OneKeySettingActivity a;

    m(OneKeySettingActivity oneKeySettingActivity) {
        this.a = oneKeySettingActivity;
    }

    public void onResult(boolean z) {
        MoSecurityApplication.c = z;
    }
}
