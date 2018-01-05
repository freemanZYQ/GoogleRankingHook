package com.vlocker.settings;

import android.widget.TextView;
import com.vlocker.locker.R;

class cy implements Runnable {
    final /* synthetic */ V2SettingToolboxActivity a;

    cy(V2SettingToolboxActivity v2SettingToolboxActivity) {
        this.a = v2SettingToolboxActivity;
    }

    public void run() {
        this.a.d.setEnabled(false);
        this.a.f.setEnabled(false);
        ((TextView) this.a.findViewById(R.id.camera_open_tv)).setTextColor(this.a.getResources().getColor(R.color.v2_setting_item_title_des));
        ((TextView) this.a.findViewById(R.id.camera_app_select_tv)).setTextColor(this.a.getResources().getColor(R.color.v2_setting_item_title_des));
        this.a.e.setChecked(false);
        this.a.h.z("");
        this.a.h.A("");
        this.a.h.B("");
    }
}
