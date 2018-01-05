package com.vlocker.notification.msg.open;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class h implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ WebView b;
    final /* synthetic */ String c;
    final /* synthetic */ g d;

    h(g gVar, View view, WebView webView, String str) {
        this.d = gVar;
        this.a = view;
        this.b = webView;
        this.c = str;
    }

    public void onClick(View view) {
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.b.loadUrl(this.c);
    }
}
