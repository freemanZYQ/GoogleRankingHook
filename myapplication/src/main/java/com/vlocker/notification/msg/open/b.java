package com.vlocker.notification.msg.open;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class b extends WebChromeClient {
    final /* synthetic */ FlowWebViewActivity a;

    b(FlowWebViewActivity flowWebViewActivity) {
        this.a = flowWebViewActivity;
    }

    public void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        callback.invoke(str, true, true);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i == 100) {
            if (this.a.g != null) {
                this.a.g.setVisibility(8);
            }
            if ("weather_webview".equals(this.a.e) && VERSION.SDK_INT >= 11) {
                Animator duration = ObjectAnimator.ofFloat(webView, "alpha", new float[]{0.0f, 1.0f}).setDuration(850);
                Animator duration2 = ObjectAnimator.ofFloat(this.a.c, "alpha", new float[]{0.0f, 1.0f}).setDuration(550);
                Animator duration3 = ObjectAnimator.ofFloat(this.a.l, "alpha", new float[]{0.0f, 1.0f}).setDuration(550);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(duration3).with(duration2).after(duration);
                animatorSet.start();
            }
        } else if (this.a.g != null) {
            if (this.a.g.getVisibility() == 4 && !"weather_webview".equals(this.a.e)) {
                this.a.g.setVisibility(0);
            }
            this.a.g.setProgress(i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}
