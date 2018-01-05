package com.vlocker.settings;

import com.vlocker.ui.view.s;

class p implements s {
    final /* synthetic */ CustomWallPaperActivity a;

    p(CustomWallPaperActivity customWallPaperActivity) {
        this.a = customWallPaperActivity;
    }

    public void a() {
        this.a.g();
        this.a.t.removeCallbacks(this.a.u);
        this.a.t.removeCallbacks(this.a.w);
        this.a.t.postDelayed(this.a.w, 500);
    }
}
