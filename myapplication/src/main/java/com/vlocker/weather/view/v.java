package com.vlocker.weather.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.vlocker.locker.R;
import com.vlocker.m.h;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.e;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.view.ObservableWebView;
import com.vlocker.ui.view.al;
import com.vlocker.weather.c.c.b;
import com.vlocker.weather.c.d.c;

public class v implements OnClickListener, al {
    public boolean a;
    public b b;
    private ObservableWebView c;
    private FloatWebViewLayout d;
    private Context e;
    private RelativeLayout f;
    private ProgressBar g;
    private View h;
    private DownloadListener i = new x(this);
    private ViewGroup j;
    private WebChromeClient k = new y(this);

    public v(View view) {
        this.j = (ViewGroup) view;
        this.e = MoSecurityApplication.a();
        c();
    }

    private void c() {
        this.d = (FloatWebViewLayout) View.inflate(this.e, R.layout.weather_float_web_layout, null);
        this.g = (ProgressBar) this.d.findViewById(R.id.loading_process);
        this.c = (ObservableWebView) this.d.findViewById(R.id.wv_weather_float);
        this.f = (RelativeLayout) this.d.findViewById(R.id.layout_weather_float_web_content);
        this.h = this.d.findViewById(R.id.btn_weather_float_back);
        this.h.setOnClickListener(this);
        this.d.findViewById(R.id.btn_weather_float_close).setOnClickListener(this);
        this.c.setOnKeyListener(new w(this));
    }

    private void d() {
        try {
            WebSettings settings = this.c.getSettings();
            this.c.setHorizontalScrollBarEnabled(false);
            this.c.setVerticalScrollBarEnabled(false);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            this.c.setDrawingCacheEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setJavaScriptEnabled(true);
            settings.setTextSize(TextSize.NORMAL);
            settings.setAppCacheEnabled(true);
            settings.setCacheMode(1);
            settings.setDomStorageEnabled(true);
            settings.setPluginState(PluginState.ON);
            settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(RenderPriority.HIGH);
            settings.getUserAgentString();
            this.c.setScrollBarStyle(0);
            if (VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(2);
            }
            this.c.removeJavascriptInterface("searchBoxJavaBredge_");
            this.c.setWebViewClient(new z());
            this.c.setDownloadListener(this.i);
            this.c.setWebChromeClient(this.k);
            this.c.setOnScrollChangedCallback(this);
            this.c.loadUrl(this.b.d());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        if (this.a) {
            if (this.c != null) {
                try {
                    this.c.pauseTimers();
                    this.c.removeAllViews();
                    this.d.removeView(this.c);
                    this.c.setVisibility(8);
                    this.c.destroy();
                    this.c = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.j.removeView(this.d);
            this.a = false;
            c.a().c().c();
            if (g.a()) {
                c.a().c().a();
            }
            System.gc();
        }
    }

    public void a(int i, int i2) {
    }

    public void a(b bVar) {
        if (!this.a) {
            this.a = true;
            this.b = bVar;
            try {
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = VERSION.SDK_INT >= 19 ? h.d(this.e) : 0;
                this.j.addView(this.d, layoutParams);
                this.d.requestFocus();
                this.c.resumeTimers();
            } catch (Exception e) {
                e.printStackTrace();
            }
            d();
            c.a().c().c(bVar);
        }
    }

    public void b() {
        System.gc();
        if (this.c.canGoBack() && e.c(this.e)) {
            this.c.goBack();
        } else {
            a();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_weather_float_back:
                b();
                return;
            case R.id.btn_weather_float_close:
                a();
                return;
            default:
                return;
        }
    }
}
