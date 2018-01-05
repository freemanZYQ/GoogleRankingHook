package com.vlocker.settings;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class aq extends WebViewClient {
    final /* synthetic */ GuideWebViewActivity a;

    aq(GuideWebViewActivity guideWebViewActivity) {
        this.a = guideWebViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
