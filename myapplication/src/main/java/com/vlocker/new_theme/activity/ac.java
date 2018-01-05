package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class ac implements OnClickListener {
    final /* synthetic */ SpecialSingleItemActivity a;

    ac(SpecialSingleItemActivity specialSingleItemActivity) {
        this.a = specialSingleItemActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zhuanti_back:
                if ("banner".equals(this.a.z) || "mcm".equals(this.a.z)) {
                    this.a.i();
                }
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
