package com.vlocker.settings;

import android.content.Context;
import android.content.Intent;

final class am implements Runnable {
    final /* synthetic */ Context a;

    am(Context context) {
        this.a = context;
    }

    public void run() {
        Intent intent = new Intent(this.a, GuideWebViewActivity.class);
        intent.setFlags(268435456);
        this.a.startActivity(intent);
    }
}
