package com.tencent.open;

import android.webkit.WebView;
import java.lang.ref.WeakReference;

public class b {
    protected WeakReference a;
    protected long b;
    protected String c;

    public b(WebView webView, long j, String str) {
        this.a = new WeakReference(webView);
        this.b = j;
        this.c = str;
    }

    public void a() {
        WebView webView = (WebView) this.a.get();
        if (webView != null) {
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
        }
    }

    public void a(Object obj) {
        WebView webView = (WebView) this.a.get();
        if (webView != null) {
            String str = "'undefined'";
            if (obj instanceof String) {
                str = "'" + ((String) obj).replace("\\", "\\\\").replace("'", "\\'") + "'";
            } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                str = obj.toString();
            } else if (obj instanceof Boolean) {
                str = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + str + "});");
        }
    }

    public void a(String str) {
        WebView webView = (WebView) this.a.get();
        if (webView != null) {
            webView.loadUrl("javascript:" + str);
        }
    }
}
