package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebChromeClient;

public abstract class d extends Dialog {
    private static final String TAG = "openSDK_LOG.JsDialog";
    protected a jsBridge;
    @SuppressLint({"NewApi"})
    protected final WebChromeClient mChromeClient = new e(this);

    public d(Context context) {
        super(context);
    }

    public d(Context context, int i) {
        super(context, i);
    }

    protected abstract void onConsoleMessage(String str);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jsBridge = new a();
    }
}
