package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class j implements OnClickListener {
    final /* synthetic */ DigSingleItemActivity a;

    j(DigSingleItemActivity digSingleItemActivity) {
        this.a = digSingleItemActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.moxiu_title_back:
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
