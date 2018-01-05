package com.vlocker.notification.msg.open;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.vlocker.msg.ao;

class c implements DownloadListener {
    final /* synthetic */ FlowWebViewActivity a;

    c(FlowWebViewActivity flowWebViewActivity) {
        this.a = flowWebViewActivity;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String str5 = null;
        try {
            str5 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str5 == null || str5.isEmpty()) {
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
        }
        ao.a(this.a, str, "1014", str5, str5, "webview_app");
    }
}
