package com.vlocker.ui.cover;

import com.vlocker.settings.DismissActivity;

class ak implements Runnable {
    final /* synthetic */ ai a;

    ak(ai aiVar) {
        this.a = aiVar;
    }

    public void run() {
        DismissActivity.a(this.a.a.getApplicationContext());
    }
}
