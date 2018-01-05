package com.vlocker.weather.view;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class x implements DownloadListener {
    final /* synthetic */ v a;

    x(v vVar) {
        this.a = vVar;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        this.a.e.startActivity(intent);
    }
}
