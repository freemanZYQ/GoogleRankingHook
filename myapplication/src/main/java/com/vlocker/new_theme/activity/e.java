package com.vlocker.new_theme.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class e implements OnClickListener {
    final /* synthetic */ CateSingleItemActivity a;

    e(CateSingleItemActivity cateSingleItemActivity) {
        this.a = cateSingleItemActivity;
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
