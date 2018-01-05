package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.open.a.j;
import com.tencent.open.b.g;
import com.tencent.open.c.c;
import com.tencent.open.d.o;
import com.tencent.open.d.u;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class TDialog extends d {
    static final LayoutParams a = new LayoutParams(-1, -1);
    static Toast b = null;
    private static WeakReference d;
    private WeakReference c;
    private String e;
    private OnTimeListener f;
    private b g;
    private FrameLayout h;
    private c i;
    private Handler j;
    private boolean k = false;
    private com.tencent.connect.b.c l = null;

    class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.i.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            j.a("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TDialog.this.f.onError(new d(i, str, str2));
            if (!(TDialog.this.c == null || TDialog.this.c.get() == null)) {
                Toast.makeText((Context) TDialog.this.c.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            j.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(o.a().a((Context) TDialog.this.c.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f.onComplete(u.b(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://cancel")) {
                TDialog.this.f.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (str.startsWith("auth://close")) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            } else if (!str.startsWith("download://")) {
                return str.startsWith("auth://progress");
            } else {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring("download://".length()))));
                intent.addFlags(268435456);
                if (!(TDialog.this.c == null || TDialog.this.c.get() == null)) {
                    ((Context) TDialog.this.c.get()).startActivity(intent);
                }
                return true;
            }
        }
    }

    class JsListener extends c {
        private JsListener() {
        }

        public void onAddShare(String str) {
            j.b("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            j.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.j.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            j.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel("cancel");
        }

        public void onCancelInvite() {
            j.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.j.obtainMessage(1, str).sendToTarget();
            j.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.j.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.j.obtainMessage(3, str).sendToTarget();
        }
    }

    class OnTimeListener implements b {
        private String mAction;
        String mAppid;
        String mUrl;
        private WeakReference mWeakCtx;
        private b mWeakL;

        public OnTimeListener(Context context, String str, String str2, String str3, b bVar) {
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
            j.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            switch (message.what) {
                case 1:
                    this.mL.onComplete((String) message.obj);
                    return;
                case 2:
                    this.mL.onCancel();
                    return;
                case 3:
                    if (TDialog.this.c != null && TDialog.this.c.get() != null) {
                        TDialog.c((Context) TDialog.this.c.get(), (String) message.obj);
                        return;
                    }
                    return;
                case 5:
                    if (TDialog.this.c != null && TDialog.this.c.get() != null) {
                        TDialog.d((Context) TDialog.this.c.get(), (String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public TDialog(Context context, String str, String str2, b bVar, com.tencent.connect.b.c cVar) {
        super(context, 16973840);
        this.c = new WeakReference(context);
        this.e = str2;
        this.f = new OnTimeListener(context, str, str2, cVar.b(), bVar);
        this.j = new THandler(this.f, context.getMainLooper());
        this.g = bVar;
        this.l = cVar;
    }

    private void a() {
        new TextView((Context) this.c.get()).setText("test");
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.i = new c((Context) this.c.get());
        this.i.setLayoutParams(layoutParams);
        this.h = new FrameLayout((Context) this.c.get());
        layoutParams.gravity = 17;
        this.h.setLayoutParams(layoutParams);
        this.h.addView(this.i);
        setContentView(this.h);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.i.setVerticalScrollBarEnabled(false);
        this.i.setHorizontalScrollBarEnabled(false);
        this.i.setWebViewClient(new FbWebViewClient());
        this.i.setWebChromeClient(this.mChromeClient);
        this.i.clearFormData();
        WebSettings settings = this.i.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            if (!(this.c == null || this.c.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(((Context) this.c.get()).getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.jsBridge.a(new JsListener(), "sdk_js_if");
            this.i.loadUrl(this.e);
            this.i.setLayoutParams(a);
            this.i.setVisibility(4);
            this.i.getSettings().setSavePassword(false);
        }
    }

    private static void c(Context context, String str) {
        try {
            JSONObject c = u.c(str);
            int i = c.getInt("type");
            CharSequence string = c.getString(XAdErrorCode.ERROR_CODE_MESSAGE);
            if (i == 0) {
                if (b == null) {
                    b = Toast.makeText(context, string, 0);
                } else {
                    b.setView(b.getView());
                    b.setText(string);
                    b.setDuration(0);
                }
                b.show();
            } else if (i == 1) {
                if (b == null) {
                    b = Toast.makeText(context, string, 1);
                } else {
                    b.setView(b.getView());
                    b.setText(string);
                    b.setDuration(1);
                }
                b.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void d(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject c = u.c(str);
                int i = c.getInt("action");
                CharSequence string = c.getString(XAdErrorCode.ERROR_CODE_MESSAGE);
                if (i == 1) {
                    if (d == null || d.get() == null) {
                        ProgressDialog progressDialog = new ProgressDialog(context);
                        progressDialog.setMessage(string);
                        d = new WeakReference(progressDialog);
                        progressDialog.show();
                        return;
                    }
                    ((ProgressDialog) d.get()).setMessage(string);
                    if (!((ProgressDialog) d.get()).isShowing()) {
                        ((ProgressDialog) d.get()).show();
                    }
                } else if (i == 0 && d != null && d.get() != null && ((ProgressDialog) d.get()).isShowing()) {
                    ((ProgressDialog) d.get()).dismiss();
                    d = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        if (this.f != null) {
            this.f.onCancel();
        }
        super.onBackPressed();
    }

    protected void onConsoleMessage(String str) {
        j.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.jsBridge.a(this.i, str);
        } catch (Exception e) {
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        b();
    }
}
