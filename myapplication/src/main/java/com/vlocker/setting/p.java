package com.vlocker.setting;

class p implements Runnable {
    final /* synthetic */ RecentShowActivity a;

    p(RecentShowActivity recentShowActivity) {
        this.a = recentShowActivity;
    }

    public void run() {
        this.a.moveTaskToBack(true);
    }
}
