package com.tencent.open;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.open.a.j;
import com.tencent.open.b.g;
import com.tencent.open.c.a;
import com.tencent.open.c.b;
import com.tencent.open.c.c;
import com.tencent.open.d.o;
import com.tencent.open.d.u;
import com.tencent.tauth.d;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class PKDialog extends d implements b {
    private static final int MSG_CANCEL = 2;
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_ON_LOAD = 4;
    private static final int MSG_SHOW_PROCESS = 5;
    private static final int MSG_SHOW_TIPS = 3;
    private static final String TAG = "openSDK_LOG.PKDialog";
    private static final int WEBVIEW_HEIGHT = 185;
    static Toast sToast = null;
    private com.tencent.tauth.b listener;
    private a mFlMain;
    private Handler mHandler;
    private OnTimeListener mListener;
    private String mUrl;
    private WeakReference mWeakContext;
    private c mWebView;
    private int mWebviewHeight;

    class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            PKDialog.this.mWebView.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            j.a(PKDialog.TAG, "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            PKDialog.this.mListener.onError(new d(i, str, str2));
            if (!(PKDialog.this.mWeakContext == null || PKDialog.this.mWeakContext.get() == null)) {
                Toast.makeText((Context) PKDialog.this.mWeakContext.get(), "网络连接异常或系统错误", 0).show();
            }
            PKDialog.this.dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            j.a(PKDialog.TAG, "Redirect URL: " + str);
            if (str.startsWith(o.a().a((Context) PKDialog.this.mWeakContext.get(), "auth://tauth.qq.com/"))) {
                PKDialog.this.mListener.onComplete(u.b(str));
                PKDialog.this.dismiss();
                return true;
            } else if (str.startsWith("auth://cancel")) {
                PKDialog.this.mListener.onCancel();
                PKDialog.this.dismiss();
                return true;
            } else if (!str.startsWith("auth://close")) {
                return false;
            } else {
                PKDialog.this.dismiss();
                return true;
            }
        }
    }

    class JsListener extends c {
        private JsListener() {
        }

        public void onCancel(String str) {
            PKDialog.this.mHandler.obtainMessage(2, str).sendToTarget();
            PKDialog.this.dismiss();
        }

        public void onComplete(String str) {
            PKDialog.this.mHandler.obtainMessage(1, str).sendToTarget();
            j.e(PKDialog.TAG, "JsListener onComplete" + str);
            PKDialog.this.dismiss();
        }

        public void onLoad(String str) {
            PKDialog.this.mHandler.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            PKDialog.this.mHandler.obtainMessage(3, str).sendToTarget();
        }
    }

    class OnTimeListener implements com.tencent.tauth.b {
        private String mAction;
        String mAppid;
        String mUrl;
        private WeakReference mWeakCtx;
        private com.tencent.tauth.b mWeakL;

        public OnTimeListener(Context context, String str, String str2, String str3, com.tencent.tauth.b bVar) {
            this.mWeakCtx = new WeakReference(context);
            this.mAction = str;
            this.mUrl = str2;
            this.mAppid = str3;
            this.mWeakL = bVar;
        }

        private void onComplete(String str) {
            try {
                onComplete(u.c(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new d(-4, "服务器返回数据格式有误!", str));
            }
        }

        public void onCancel() {
            if (this.mWeakL != null) {
                this.mWeakL.onCancel();
                this.mWeakL = null;
            }
        }

        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.mAction + "_H5", SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt(KEYS.RET, -6), this.mUrl, false);
            if (this.mWeakL != null) {
                this.mWeakL.onComplete(jSONObject);
                this.mWeakL = null;
            }
        }

        public void onError(d dVar) {
            g.a().a(this.mAction + "_H5", SystemClock.elapsedRealtime(), 0, 0, dVar.a, dVar.b != null ? dVar.b + this.mUrl : this.mUrl, false);
            if (this.mWeakL != null) {
                this.mWeakL.onError(dVar);
                this.mWeakL = null;
            }
        }
    }

    class THandler extends Handler {
        private OnTimeListener mL;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.mL = onTimeListener;
        }

        public void handleMessage(Message message) {
            j.b(PKDialog.TAG, "msg = " + message.what);
            switch (message.what) {
                case 1:
                    this.mL.onComplete((String) message.obj);
                    return;
                case 2:
                    this.mL.onCancel();
                    return;
                case 3:
                    if (PKDialog.this.mWeakContext != null && PKDialog.this.mWeakContext.get() != null) {
                        PKDialog.showTips((Context) PKDialog.this.mWeakContext.get(), (String) message.obj);
                        return;
                    }
                    return;
                case 5:
                    if (PKDialog.this.mWeakContext != null && PKDialog.this.mWeakContext.get() != null) {
                        PKDialog.showProcessDialog((Context) PKDialog.this.mWeakContext.get(), (String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public PKDialog(Context context, String str, String str2, com.tencent.tauth.b bVar, com.tencent.connect.b.c cVar) {
        super(context, 16973840);
        this.mWeakContext = new WeakReference(context);
        this.mUrl = str2;
        this.mListener = new OnTimeListener(context, str, str2, cVar.b(), bVar);
        this.mHandler = new THandler(this.mListener, context.getMainLooper());
        this.listener = bVar;
        this.mWebviewHeight = Math.round(185.0f * context.getResources().getDisplayMetrics().density);
        j.e(TAG, "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.mWebviewHeight);
    }

    private void createViews() {
        this.mFlMain = new a((Context) this.mWeakContext.get());
        this.mFlMain.setBackgroundColor(1711276032);
        this.mFlMain.setLayoutParams(new LayoutParams(-1, -1));
        this.mWebView = new c((Context) this.mWeakContext.get());
        this.mWebView.setBackgroundColor(0);
        this.mWebView.setBackgroundDrawable(null);
        if (VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this.mWebView, new Object[]{Integer.valueOf(1), new Paint()});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, this.mWebviewHeight);
        layoutParams.addRule(13, -1);
        this.mWebView.setLayoutParams(layoutParams);
        this.mFlMain.addView(this.mWebView);
        this.mFlMain.a(this);
        setContentView(this.mFlMain);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initViews() {
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient(new FbWebViewClient());
        this.mWebView.setWebChromeClient(this.mChromeClient);
        this.mWebView.clearFormData();
        WebSettings settings = this.mWebView.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            if (!(this.mWeakContext == null || this.mWeakContext.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(((Context) this.mWeakContext.get()).getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.jsBridge.a(new JsListener(), "sdk_js_if");
            this.mWebView.clearView();
            this.mWebView.loadUrl(this.mUrl);
            this.mWebView.getSettings().setSavePassword(false);
        }
    }

    private void loadUrlWithBrowser(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        if (this.mWeakContext != null && this.mWeakContext.get() != null) {
            ((Context) this.mWeakContext.get()).startActivity(intent);
        }
    }

    private static void showProcessDialog(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject c = u.c(str);
                int i = c.getInt("action");
                c.getString(XAdErrorCode.ERROR_CODE_MESSAGE);
                if (i != 1) {
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showTips(Context context, String str) {
        try {
            JSONObject c = u.c(str);
            int i = c.getInt("type");
            CharSequence string = c.getString(XAdErrorCode.ERROR_CODE_MESSAGE);
            if (i == 0) {
                if (sToast == null) {
                    sToast = Toast.makeText(context, string, 0);
                } else {
                    sToast.setView(sToast.getView());
                    sToast.setText(string);
                    sToast.setDuration(0);
                }
                sToast.show();
            } else if (i == 1) {
                if (sToast == null) {
                    sToast = Toast.makeText(context, string, 1);
                } else {
                    sToast.setView(sToast.getView());
                    sToast.setText(string);
                    sToast.setDuration(1);
                }
                sToast.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void callJs(String str, String str2) {
        this.mWebView.loadUrl("javascript:" + str + "(" + str2 + ")");
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onConsoleMessage(String str) {
        j.b(TAG, "--onConsoleMessage--");
        try {
            this.jsBridge.a(this.mWebView, str);
        } catch (Exception e) {
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        createViews();
        initViews();
    }

    public void onKeyboardHidden() {
        this.mWebView.getLayoutParams().height = this.mWebviewHeight;
        j.e(TAG, "onKeyboardHidden keyboard hide");
    }

    public void onKeyboardShown(int i) {
        if (!(this.mWeakContext == null || this.mWeakContext.get() == null)) {
            if (i >= this.mWebviewHeight || 2 != ((Context) this.mWeakContext.get()).getResources().getConfiguration().orientation) {
                this.mWebView.getLayoutParams().height = this.mWebviewHeight;
            } else {
                this.mWebView.getLayoutParams().height = i;
            }
        }
        j.e(TAG, "onKeyboardShown keyboard show");
    }
}
