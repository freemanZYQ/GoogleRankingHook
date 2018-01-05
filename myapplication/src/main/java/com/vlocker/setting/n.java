package com.vlocker.setting;

class n implements Runnable {
    final /* synthetic */ RecentShowActivity a;

    n(RecentShowActivity recentShowActivity) {
        this.a = recentShowActivity;
    }

    public void run() {
        this.a.finish();
    }
}
