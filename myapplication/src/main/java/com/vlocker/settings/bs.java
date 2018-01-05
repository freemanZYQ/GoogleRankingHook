package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.c.a;

class bs implements OnClickListener {
    final /* synthetic */ NotifyAppsSelectActivity a;

    bs(NotifyAppsSelectActivity notifyAppsSelectActivity) {
        this.a = notifyAppsSelectActivity;
    }

    public void onClick(View view) {
        if (this.a.q) {
            this.a.p = !a.a(this.a).bh();
            this.a.c();
        }
    }
}
