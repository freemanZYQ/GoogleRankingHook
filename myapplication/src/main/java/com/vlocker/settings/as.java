package com.vlocker.settings;

import android.util.DisplayMetrics;

class as implements Runnable {
    private GuideWindowActivity a;

    public as(GuideWindowActivity guideWindowActivity) {
        this.a = guideWindowActivity;
    }

    public void run() {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        this.a.getWindow().setLayout(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
