package com.vlocker.setting;

import android.os.Handler;
import android.os.Message;

class l extends Handler {
    final /* synthetic */ OneKeySettingActivity a;

    l(OneKeySettingActivity oneKeySettingActivity) {
        this.a = oneKeySettingActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.j.c();
                return;
            case 2:
                this.a.j.i();
                this.a.j.d();
                this.a.j.h();
                this.a.j.g();
                return;
            default:
                return;
        }
    }
}
