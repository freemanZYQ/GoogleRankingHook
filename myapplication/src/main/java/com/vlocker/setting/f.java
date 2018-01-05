package com.vlocker.setting;

import com.vlocker.locker.R;
import com.vlocker.setting.ui.y;

class f implements y {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            this.a.f.setText(R.string.one_key_setting_init_title);
            this.a.g.setText(R.string.one_key_setting_init_des);
        } else {
            this.a.f.setText(z2 ? R.string.one_key_setting_success_title : R.string.one_key_setting_failed_title);
            this.a.g.setText(z2 ? R.string.one_key_setting_success_des : R.string.one_key_setting_failed_des);
        }
        this.a.a(this.a.f, true);
        this.a.a(this.a.g, true);
    }
}
