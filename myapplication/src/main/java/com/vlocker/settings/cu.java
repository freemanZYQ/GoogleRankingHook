package com.vlocker.settings;

import com.vlocker.model.b;

class cu implements Runnable {
    final /* synthetic */ V2SettingToolboxActivity a;

    cu(V2SettingToolboxActivity v2SettingToolboxActivity) {
        this.a = v2SettingToolboxActivity;
    }

    public void run() {
        if (b.a(this.a) || b.b(this.a.h.bb())) {
            b.b(this.a);
        }
        this.a.i = this.a.a(this.a);
    }
}
