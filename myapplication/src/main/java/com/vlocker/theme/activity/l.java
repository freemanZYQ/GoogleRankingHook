package com.vlocker.theme.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class l implements OnCheckedChangeListener {
    final /* synthetic */ ThemeDetailActivity a;

    l(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.a.m.isChecked() || this.a.n.isChecked()) {
            this.a.d.setProgress(100);
        } else {
            this.a.d.setProgress(0);
        }
    }
}
