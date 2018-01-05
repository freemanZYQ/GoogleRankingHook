package com.vlocker.settings;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.vlocker.locker.R;

class ct extends WebViewClient {
    final /* synthetic */ V2SettingThankActivity a;

    private ct(V2SettingThankActivity v2SettingThankActivity) {
        this.a = v2SettingThankActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.findViewById(R.id.loading_layout).setVisibility(8);
        this.a.c.setVisibility(0);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.a.d.setText(this.a.getString(R.string.l_check_network));
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
