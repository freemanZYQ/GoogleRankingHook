package com.vlocker.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import com.vlocker.locker.R;

public class GuideWebViewActivity extends Activity {
    private static int a = 0;
    private static String b;
    private static String c;
    private WebView d;
    private ProgressDialog e;
    private Handler f = new ap(this);

    public static void a(Context context, int i, String str, String str2) {
        a = i;
        b = str;
        c = str2;
        new Handler().postDelayed(new am(context), 200);
    }

    public void a(WebView webView, String str) {
        this.f.sendEmptyMessage(0);
        try {
            webView.loadUrl(str);
        } catch (Exception e) {
        }
    }

    public void a(String str) {
        this.e = new ProgressDialog(this);
        this.e.setProgressStyle(0);
        this.e.setMessage(getResources().getString(R.string.l_vlocker_loading));
        this.d = (WebView) findViewById(R.id.wv);
        this.d.setWebViewClient(new aq(this));
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.getSettings().setSupportZoom(true);
        this.d.getSettings().setDefaultZoom(ZoomDensity.MEDIUM);
        this.d.setScrollBarStyle(0);
        this.d.setVisibility(0);
        try {
            a(this.d, str);
        } catch (Exception e) {
        }
        this.d.setDownloadListener(new an(this));
        this.d.setWebChromeClient(new ao(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_guid_autolaucher_yindao);
        if (b != null) {
            a(b);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
