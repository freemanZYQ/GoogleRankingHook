package com.alimama.ad.mobile.login.inapp.ui;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class b extends WebViewClient {
    final /* synthetic */ DetailWebView a;

    private b(DetailWebView detailWebView) {
        this.a = detailWebView;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.a.a(webView, str) ? true : super.shouldOverrideUrlLoading(webView, str);
    }
}
