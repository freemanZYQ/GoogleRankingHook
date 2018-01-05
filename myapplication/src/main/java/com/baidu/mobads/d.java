package com.baidu.mobads;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class d extends WebChromeClient {
    final /* synthetic */ a a;
    final /* synthetic */ AppActivity b;

    d(AppActivity appActivity, a aVar) {
        this.b = appActivity;
        this.a = aVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.a != null) {
            this.a.a(i);
            if (i > 50) {
                this.b.i();
                this.a.setVisibility(i >= 100 ? 4 : 0);
            }
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.b.c != null) {
            this.b.c.a(str);
        }
    }
}
