package com.baidu.mobads;

import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;

class j extends WebViewClient {
    final /* synthetic */ b a;
    final /* synthetic */ AppActivity b;

    j(AppActivity appActivity, b bVar) {
        this.b = appActivity;
        this.a = bVar;
    }

    private void a(String str) {
        if (this.b.q != null) {
            try {
                if (this.a.d) {
                    this.b.A.n = str;
                    if (this.b.A.z == 0) {
                        this.b.A.z = System.currentTimeMillis();
                    }
                    this.b.A.o = this.b.r = this.b.r + 1;
                    if (this.b.curWebview != null) {
                        this.b.A.p = this.b.curWebview.getContentHeight();
                        this.b.A.q = this.b.curWebview.getProgress();
                    }
                    this.b.A.u = System.currentTimeMillis() - this.b.s;
                    this.b.A.v = this.b.v;
                    this.b.A.x = this.b.e;
                    this.a.d = false;
                    return;
                }
                this.b.D.i(AppActivity.o, "App2Activity - not send 37");
            } catch (Exception e) {
                this.b.D.d(AppActivity.o, e.getMessage());
            }
        }
    }

    private void a(String str, int i) {
        if (this.b.q != null) {
            try {
                this.b.A.n = str;
                if (this.b.A.A == 0) {
                    this.b.A.A = System.currentTimeMillis();
                }
                this.b.A.o = this.b.r = this.b.r + 1;
                this.b.A.v = this.b.v;
                this.b.A.x = this.b.e;
                if (this.b.curWebview != null) {
                    this.b.A.p = this.b.curWebview.getContentHeight();
                    this.b.A.q = this.b.curWebview.getProgress();
                }
                this.b.A.u = System.currentTimeMillis() - this.b.s;
                this.a.d = true;
            } catch (Exception e) {
                this.b.D.d(AppActivity.o, e.getMessage());
            }
        }
    }

    public void onLoadResource(WebView webView, String str) {
        try {
            if (!(this.a.c || str.equals(this.a.b) || this.a.a)) {
                this.a.c = true;
                if (this.b.g == -1) {
                    this.b.g = (int) (System.currentTimeMillis() - this.b.s);
                }
                a(this.a.b, 0);
            }
            HitTestResult hitTestResult = webView.getHitTestResult();
            if (hitTestResult != null && hitTestResult.getType() > 0) {
                this.b.a(webView, str, new l(this), null);
            }
        } catch (Exception e) {
            this.b.D.d(AppActivity.o, e.getMessage());
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.a.a && this.a.b.equals(str)) {
            if (this.b.g == -1) {
                this.b.g = (int) (System.currentTimeMillis() - this.b.s);
            }
            if (!this.a.c) {
                this.a.c = true;
                a(this.a.b, 0);
            }
        }
        this.a.a = false;
        this.a.b = "";
        if (this.b.H != null) {
            this.b.H.onPageFinished(webView);
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (!(this.b.curWebview == null || str == null)) {
            this.b.curWebview.a = str;
        }
        this.a.b = str;
        this.a.c = false;
        if (!this.a.a) {
            a(str);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Builder builder = new Builder(this.b);
        builder.setMessage("ssl证书验证失败，是否继续访问该网页？");
        builder.setPositiveButton("继续", new m(this, sslErrorHandler));
        builder.setNegativeButton("取消", new n(this, sslErrorHandler));
        builder.setOnKeyListener(new o(this, sslErrorHandler));
        builder.create().show();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null) {
            try {
                if (!str.equals("about:blank")) {
                    this.b.a(webView, str, null, new k(this, str));
                    HitTestResult hitTestResult = webView.getHitTestResult();
                    if (hitTestResult == null || hitTestResult.getType() != 0) {
                        return true;
                    }
                    this.b.D.d(AppActivity.o, "AppActivity shouldOverrideUrlLoading and hitType==0");
                    this.a.a = true;
                    return true;
                }
            } catch (Exception e) {
                this.b.D.d(AppActivity.o, e.getMessage());
                return true;
            }
        }
        return false;
    }
}
