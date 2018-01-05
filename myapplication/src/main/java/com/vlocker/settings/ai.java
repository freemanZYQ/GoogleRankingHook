package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class ai implements OnClickListener {
    final /* synthetic */ GuideSettingListActivity a;

    ai(GuideSettingListActivity guideSettingListActivity) {
        this.a = guideSettingListActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back_main:
                this.a.b();
                return;
            default:
                return;
        }
    }
}
