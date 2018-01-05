package com.vlocker.ui.cover;

import com.vlocker.settings.DismissActivity;

class al implements Runnable {
    final /* synthetic */ ai a;

    al(ai aiVar) {
        this.a = aiVar;
    }

    public void run() {
        DismissActivity.b(this.a.a.getApplicationContext());
    }
}
