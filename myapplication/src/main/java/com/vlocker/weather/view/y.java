package com.vlocker.weather.view;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class y extends WebChromeClient {
    final /* synthetic */ v a;

    y(v vVar) {
        this.a = vVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i < 100) {
            this.a.g.setVisibility(0);
            this.a.g.setProgress(i);
        } else if (i == 100) {
            this.a.g.setVisibility(4);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}
