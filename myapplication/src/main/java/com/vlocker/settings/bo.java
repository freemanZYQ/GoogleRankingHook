package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class bo implements OnClickListener {
    final /* synthetic */ NotifyAppsSelectActivity a;

    bo(NotifyAppsSelectActivity notifyAppsSelectActivity) {
        this.a = notifyAppsSelectActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
