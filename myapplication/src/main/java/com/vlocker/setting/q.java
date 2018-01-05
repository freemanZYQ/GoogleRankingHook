package com.vlocker.setting;

import com.vlocker.locker.R;

class q implements Runnable {
    final /* synthetic */ RecentShowActivity a;

    q(RecentShowActivity recentShowActivity) {
        this.a = recentShowActivity;
    }

    public void run() {
        if (this.a.a(this.a.getIntent())) {
            if (this.a.g != null) {
                this.a.a(this.a.getApplication());
            } else {
                if (this.a.h == 2) {
                    this.a.c.findViewById(R.id.tip_icon).setVisibility(0);
                    this.a.c.findViewById(R.id.tip_image).setVisibility(8);
                } else {
                    this.a.c.findViewById(R.id.tip_icon).setVisibility(8);
                    this.a.c.findViewById(R.id.tip_image).setVisibility(0);
                }
                this.a.e();
            }
            if (this.a.h == 1) {
                this.a.d();
            }
        }
    }
}
