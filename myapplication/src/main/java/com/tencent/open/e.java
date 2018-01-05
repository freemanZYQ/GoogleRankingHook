package com.tencent.open;

import android.os.Build.VERSION;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.a.j;

class e extends WebChromeClient {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void onConsoleMessage(String str, int i, String str2) {
        j.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i + " of " + str2);
        if (VERSION.SDK_INT == 7) {
            this.a.onConsoleMessage(str);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null) {
            return false;
        }
        j.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
        if (VERSION.SDK_INT > 7) {
            this.a.onConsoleMessage(consoleMessage == null ? "" : consoleMessage.message());
        }
        return true;
    }
}
