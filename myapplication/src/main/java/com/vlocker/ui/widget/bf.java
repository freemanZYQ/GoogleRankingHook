package com.vlocker.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

class bf implements OnClickListener {
    final /* synthetic */ V2SettingHeaderBar a;

    bf(V2SettingHeaderBar v2SettingHeaderBar) {
        this.a = v2SettingHeaderBar;
    }

    public void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.a();
        }
    }
}
