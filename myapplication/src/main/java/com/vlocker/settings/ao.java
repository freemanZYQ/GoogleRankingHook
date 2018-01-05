package com.vlocker.settings;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class ao extends WebChromeClient {
    final /* synthetic */ GuideWebViewActivity a;

    ao(GuideWebViewActivity guideWebViewActivity) {
        this.a = guideWebViewActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i == 100) {
            this.a.f.sendEmptyMessage(1);
        }
        super.onProgressChanged(webView, i);
    }
}
