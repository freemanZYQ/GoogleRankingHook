package com.vlocker.weather.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class aa implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ WebView b;
    final /* synthetic */ String c;
    final /* synthetic */ z d;

    aa(z zVar, View view, WebView webView, String str) {
        this.d = zVar;
        this.a = view;
        this.b = webView;
        this.c = str;
    }

    public void onClick(View view) {
        this.a.setVisibility(8);
        this.d.a.g.setVisibility(0);
        this.b.setVisibility(0);
        this.b.loadUrl(this.c);
    }
}
