package com.vlocker.weather.view;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.theme.f.e;

class z extends WebViewClient {
    final /* synthetic */ v a;

    private z(v vVar) {
        this.a = vVar;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.a.g != null) {
            this.a.g.setVisibility(4);
        }
        if (!webView.getSettings().getLoadsImagesAutomatically()) {
            webView.getSettings().setLoadsImagesAutomatically(true);
        }
        if (this.a.c.canGoBack()) {
            this.a.h.setVisibility(0);
        } else {
            this.a.h.setVisibility(4);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            if (e.c(this.a.e)) {
                super.onPageStarted(webView, str, bitmap);
                return;
            }
            webView.setVisibility(8);
            View inflate = LayoutInflater.from(this.a.e).inflate(R.layout.t_dialogprogress, null);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14, -1);
            layoutParams.topMargin = l.a(150.0f);
            ((ProgressBar) inflate.findViewById(R.id.progress_small_title)).setVisibility(8);
            TextView textView = (TextView) inflate.findViewById(R.id.theme_fetch_loading);
            textView.setText("网络不太给力\n点击重新加载...");
            textView.setTextColor(this.a.e.getResources().getColor(R.color.gray));
            textView.setTextSize(14.0f);
            inflate.setOnClickListener(new aa(this, inflate, webView, str));
            this.a.f.addView(inflate, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        p.a(this.a.e, "LockerService_Click_Times_UrlInNews_PPC_RR", new String[0]);
        return false;
    }
}
