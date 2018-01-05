package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class bj implements OnClickListener {
    final /* synthetic */ NotificationLightActivity a;

    bj(NotificationLightActivity notificationLightActivity) {
        this.a = notificationLightActivity;
    }

    public void onClick(View view) {
        this.a.k.dismiss();
    }
}
