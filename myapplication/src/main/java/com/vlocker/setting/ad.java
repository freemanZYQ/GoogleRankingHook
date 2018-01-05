package com.vlocker.setting;

import com.vlocker.locker.R;
import com.vlocker.setting.ui.y;

class ad implements y {
    final /* synthetic */ aa a;

    ad(aa aaVar) {
        this.a = aaVar;
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            this.a.D.setText(R.string.one_key_setting_init_title);
            this.a.E.setText(R.string.one_key_setting_init_des);
        } else {
            this.a.D.setText(z2 ? R.string.one_key_setting_success_title : R.string.one_key_setting_failed_title);
            this.a.E.setText(z2 ? R.string.one_key_setting_success_des : R.string.one_key_setting_failed_des);
        }
        this.a.a(this.a.D, true);
        this.a.a(this.a.E, true);
    }
}
