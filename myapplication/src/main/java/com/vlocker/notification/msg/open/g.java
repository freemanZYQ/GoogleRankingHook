package com.vlocker.notification.msg.open;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class g extends WebViewClient {
    final /* synthetic */ FlowWebViewActivity a;

    private g(FlowWebViewActivity flowWebViewActivity) {
        this.a = flowWebViewActivity;
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (!webView.getSettings().getLoadsImagesAutomatically()) {
            webView.getSettings().setLoadsImagesAutomatically(true);
        }
        if (!"about:blank".equals(str)) {
            this.a.o = true;
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            if (e.c(this.a)) {
                super.onPageStarted(webView, str, bitmap);
                return;
            }
            webView.setVisibility(8);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.t_dialogprogress, null);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            ((ProgressBar) inflate.findViewById(R.id.progress_small_title)).setVisibility(8);
            TextView textView = (TextView) inflate.findViewById(R.id.theme_fetch_loading);
            textView.setText("网络不太给力。点击重新加载。。。");
            textView.setTextColor(this.a.getResources().getColor(R.color.black));
            this.a.j.setOnClickListener(new h(this, inflate, webView, str));
            webView.setVisibility(8);
            this.a.j.addView(inflate, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.a.p = true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }
}
