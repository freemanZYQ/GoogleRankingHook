package com.vlocker.settings;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class an implements DownloadListener {
    final /* synthetic */ GuideWebViewActivity a;

    an(GuideWebViewActivity guideWebViewActivity) {
        this.a = guideWebViewActivity;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
        }
    }
}
