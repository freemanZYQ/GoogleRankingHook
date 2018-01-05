package com.vlocker.settings;

import com.vlocker.ui.view.u;

class n implements u {
    final /* synthetic */ CustomWallPaperActivity a;

    n(CustomWallPaperActivity customWallPaperActivity) {
        this.a = customWallPaperActivity;
    }

    public void a() {
        this.a.t.removeCallbacks(this.a.u);
        this.a.t.removeCallbacks(this.a.w);
        if (this.a.v) {
            this.a.g();
        } else {
            this.a.h();
        }
    }
}
