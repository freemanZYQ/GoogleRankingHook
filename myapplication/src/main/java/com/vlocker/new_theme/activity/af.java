package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;

class af implements OnClickListener {
    final /* synthetic */ SpecialSingleItemActivity a;

    af(SpecialSingleItemActivity specialSingleItemActivity) {
        this.a = specialSingleItemActivity;
    }

    public void onClick(View view) {
        try {
            if ("banner".equals(this.a.z) || "mcm".equals(this.a.z)) {
                this.a.i();
            }
            this.a.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
