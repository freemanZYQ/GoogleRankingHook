package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class u implements OnClickListener {
    final /* synthetic */ CustomWallPaperActivity a;

    u(CustomWallPaperActivity customWallPaperActivity) {
        this.a = customWallPaperActivity;
    }

    public void onClick(View view) {
        this.a.b();
        this.a.x.dismiss();
    }
}
