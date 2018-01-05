package com.alimama.ad.mobile.login.inapp.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alimama.ad.mobile.a.a;
import java.lang.reflect.Method;

public class DetailWebView extends WebView {
    private Object a;
    private Method b;
    private Method c;

    public DetailWebView(Context context) {
        super(context);
        a();
    }

    public DetailWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DetailWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a(WebView webView) {
        if (webView != null) {
            Method a = a.a(this.a, "initSettings", new Class[]{WebView.class});
            a.a(this.a, a, new Object[]{webView});
        }
    }

    private void a(String str) {
        Method method;
        if (this.c != null) {
            method = this.c;
        } else {
            method = a.a(this.a, "refreshLoginState", new Class[]{String.class});
        }
        this.c = method;
        a.a(this.a, this.c, new Object[]{str});
    }

    private boolean a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Method method;
        if (this.b != null) {
            method = this.b;
        } else {
            method = a.a(this.a, "shouldOverrideUrlLoading", new Class[]{WebView.class, String.class});
        }
        this.b = method;
        return a.b(this.a, this.b, new Object[]{webView, str});
    }

    private void b() {
        a.a(this.a, a.a(this.a, "onDestory", null), null);
    }

    protected void a() {
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setAllowFileAccess(true);
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setBuiltInZoomControls(false);
        }
    }

    public void destroy() {
        b();
        super.destroy();
    }

    public void reload() {
        a(getUrl());
        super.reload();
    }

    public void setTaeSupport(Object obj) {
        this.a = obj;
        a((WebView) this);
        setWebViewClient(new b());
    }
}
